package tn.esprit.autoloc.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.autoloc.domain.Client;
import tn.esprit.autoloc.repository.IClient;
import tn.esprit.autoloc.service.IClientService;

import java.util.List;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClient clientRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Client introuvable avec l'id : " + id));
    }

    @Override
    public Client updateClient(Client client) {
        if (client.getIdClient() == null || !clientRepository.existsById(client.getIdClient())) {
            throw new EntityNotFoundException("Client introuvable avec l'id : " + client.getIdClient());
        }
        return clientRepository.save(client);
    }

    @Override
    public void deleteClient(Long id) {
        if (!clientRepository.existsById(id)) {
            throw new EntityNotFoundException("Client introuvable avec l'id : " + id);
        }
        clientRepository.deleteById(id);
    }

    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }
}
