package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Employe;
import tn.esprit.autoloc.repository.IEmploye;
import tn.esprit.autoloc.service.IEmployeService;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeServiceImpl implements IEmployeService {

    private final IEmploye employeRepository;

    @Override
    public Employe createEmploye(Employe employe) {
        return employeRepository.save(employe);
    }

    @Override
    public Employe getEmployeById(Long id) {
        return employeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Employe introuvable avec l'id : " + id));
    }

    @Override
    public Employe updateEmploye(Employe employe) {
        if (employe.getIdEmploye() == null || !employeRepository.existsById(employe.getIdEmploye())) {
            throw new EntityNotFoundException("Employe introuvable avec l'id : " + employe.getIdEmploye());
        }
        return employeRepository.save(employe);
    }

    @Override
    public void deleteEmploye(Long id) {
        if (!employeRepository.existsById(id)) {
            throw new EntityNotFoundException("Employe introuvable avec l'id : " + id);
        }
        employeRepository.deleteById(id);
    }

    @Override
    public List<Employe> getAllEmployes() {
        return employeRepository.findAll();
    }
}
