package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Agence;
import tn.esprit.autoloc.repository.IAgence;
import tn.esprit.autoloc.service.IAgenceService;

import java.util.List;

@Service
@AllArgsConstructor
public class AgenceServiceImpl implements IAgenceService {

    private final IAgence agenceRepository;

    @Override
    public Agence createAgence(Agence agence) {
        return agenceRepository.save(agence);
    }

    @Override
    public Agence getAgenceById(Long id) {
        return agenceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Agence introuvable avec l'id : " + id));
    }

    @Override
    public Agence updateAgence(Agence agence) {
        if (agence.getIdAgence() == null || !agenceRepository.existsById(agence.getIdAgence())) {
            throw new EntityNotFoundException("Agence introuvable avec l'id : " + agence.getIdAgence());
        }
        return agenceRepository.save(agence);
    }

    @Override
    public void deleteAgence(Long id) {
        if (!agenceRepository.existsById(id)) {
            throw new EntityNotFoundException("Agence introuvable avec l'id : " + id);
        }
        agenceRepository.deleteById(id);
    }

    @Override
    public List<Agence> getAllAgences() {
        return agenceRepository.findAll();
    }
}
