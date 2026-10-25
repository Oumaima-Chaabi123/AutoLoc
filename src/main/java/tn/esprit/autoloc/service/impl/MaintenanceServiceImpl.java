package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Maintenance;
import tn.esprit.autoloc.repository.IMaintenance;
import tn.esprit.autoloc.service.IMaintenanceService;

import java.util.List;

@Service
@AllArgsConstructor
public class MaintenanceServiceImpl implements IMaintenanceService {

    private final IMaintenance maintenanceRepository;

    @Override
    public Maintenance createMaintenance(Maintenance maintenance) {
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public Maintenance getMaintenanceById(Long id) {
        return maintenanceRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Maintenance introuvable avec l'id : " + id));
    }

    @Override
    public Maintenance updateMaintenance(Maintenance maintenance) {
        if (maintenance.getIdMaintenance() == null || !maintenanceRepository.existsById(maintenance.getIdMaintenance())) {
            throw new EntityNotFoundException("Maintenance introuvable avec l'id : " + maintenance.getIdMaintenance());
        }
        return maintenanceRepository.save(maintenance);
    }

    @Override
    public void deleteMaintenance(Long id) {
        if (!maintenanceRepository.existsById(id)) {
            throw new EntityNotFoundException("Maintenance introuvable avec l'id : " + id);
        }
        maintenanceRepository.deleteById(id);
    }

    @Override
    public List<Maintenance> getAllMaintenances() {
        return maintenanceRepository.findAll();
    }
}
