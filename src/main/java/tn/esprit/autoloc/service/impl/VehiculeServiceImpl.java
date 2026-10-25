package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Vehicule;
import tn.esprit.autoloc.repository.IVehiculeRepository;
import tn.esprit.autoloc.service.IVehiculeService;

import java.util.List;

@Service
@AllArgsConstructor
public class VehiculeServiceImpl implements IVehiculeService {

    private final IVehiculeRepository vehiculeRepository;

    @Override
    public Vehicule createVehicule(Vehicule vehicule) {
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public Vehicule getVehiculeById(Long id) {
        return vehiculeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicule introuvable avec l'id : " + id));
    }

    @Override
    public Vehicule updateVehicule(Vehicule vehicule) {
        if (vehicule.getIdVehicule() == null || !vehiculeRepository.existsById(vehicule.getIdVehicule())) {
            throw new EntityNotFoundException("Vehicule introuvable avec l'id : " + vehicule.getIdVehicule());
        }
        return vehiculeRepository.save(vehicule);
    }

    @Override
    public void deleteVehicule(Long id) {
        if (!vehiculeRepository.existsById(id)) {
            throw new EntityNotFoundException("Vehicule introuvable avec l'id : " + id);
        }
        vehiculeRepository.deleteById(id);
    }

    @Override
    public List<Vehicule> getAllVehicules() {
        return vehiculeRepository.findAll();
    }
}
