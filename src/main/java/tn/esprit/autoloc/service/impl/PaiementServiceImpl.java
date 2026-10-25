package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Paiement;
import tn.esprit.autoloc.repository.IPaiement;
import tn.esprit.autoloc.service.IPaiementService;

import java.util.List;

@Service
@AllArgsConstructor
public class PaiementServiceImpl implements IPaiementService {

    private final IPaiement paiementRepository;

    @Override
    public Paiement createPaiement(Paiement paiement) {
        return paiementRepository.save(paiement);
    }

    @Override
    public Paiement getPaiementById(Long id) {
        return paiementRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Paiement introuvable avec l'id : " + id));
    }

    @Override
    public Paiement updatePaiement(Paiement paiement) {
        if (paiement.getIdPaiement() == null || !paiementRepository.existsById(paiement.getIdPaiement())) {
            throw new EntityNotFoundException("Paiement introuvable avec l'id : " + paiement.getIdPaiement());
        }
        return paiementRepository.save(paiement);
    }

    @Override
    public void deletePaiement(Long id) {
        if (!paiementRepository.existsById(id)) {
            throw new EntityNotFoundException("Paiement introuvable avec l'id : " + id);
        }
        paiementRepository.deleteById(id);
    }

    @Override
    public List<Paiement> getAllPaiements() {
        return paiementRepository.findAll();
    }
}
