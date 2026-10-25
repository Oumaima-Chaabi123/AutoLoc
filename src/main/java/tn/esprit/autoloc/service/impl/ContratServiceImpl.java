package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Contrat;
import tn.esprit.autoloc.repository.IContrat;
import tn.esprit.autoloc.service.IContratService;

import java.util.List;

@Service
@AllArgsConstructor
public class ContratServiceImpl implements IContratService {

    private final IContrat contratRepository;

    @Override
    public Contrat createContrat(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat getContratById(Long id) {
        return contratRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Contrat introuvable avec l'id : " + id));
    }

    @Override
    public Contrat updateContrat(Contrat contrat) {
        if (contrat.getIdContrat() == null || !contratRepository.existsById(contrat.getIdContrat())) {
            throw new EntityNotFoundException("Contrat introuvable avec l'id : " + contrat.getIdContrat());
        }
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Long id) {
        if (!contratRepository.existsById(id)) {
            throw new EntityNotFoundException("Contrat introuvable avec l'id : " + id);
        }
        contratRepository.deleteById(id);
    }

    @Override
    public List<Contrat> getAllContrats() {
        return contratRepository.findAll();
    }
}
