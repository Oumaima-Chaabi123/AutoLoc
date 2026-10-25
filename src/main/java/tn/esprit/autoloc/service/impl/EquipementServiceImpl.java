package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Equipement;
import tn.esprit.autoloc.repository.IEquipement;
import tn.esprit.autoloc.service.IEquipementService;

import java.util.List;

@Service
@AllArgsConstructor
public class EquipementServiceImpl implements IEquipementService {

    private final IEquipement equipementRepository;

    @Override
    public Equipement createEquipement(Equipement equipement) {
        return equipementRepository.save(equipement);
    }

    @Override
    public Equipement getEquipementById(Long id) {
        return equipementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Equipement introuvable avec l'id : " + id));
    }

    @Override
    public Equipement updateEquipement(Equipement equipement) {
        if (equipement.getIdEquipement() == null || !equipementRepository.existsById(equipement.getIdEquipement())) {
            throw new EntityNotFoundException("Equipement introuvable avec l'id : " + equipement.getIdEquipement());
        }
        return equipementRepository.save(equipement);
    }

    @Override
    public void deleteEquipement(Long id) {
        if (!equipementRepository.existsById(id)) {
            throw new EntityNotFoundException("Equipement introuvable avec l'id : " + id);
        }
        equipementRepository.deleteById(id);
    }

    @Override
    public List<Equipement> getAllEquipements() {
        return equipementRepository.findAll();
    }
}
