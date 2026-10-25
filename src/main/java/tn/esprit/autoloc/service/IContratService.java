package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Contrat;

import java.util.List;

public interface IContratService {

    Contrat createContrat(Contrat contrat);

    Contrat getContratById(Long id);

    Contrat updateContrat(Contrat contrat);

    void deleteContrat(Long id);

    List<Contrat> getAllContrats();
}