
package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Equipement;

import java.util.List;

public interface IEquipementService {

    Equipement createEquipement(Equipement equipement);

    Equipement getEquipementById(Long id);

    Equipement updateEquipement(Equipement equipement);

    void deleteEquipement(Long id);

    List<Equipement> getAllEquipements();
}