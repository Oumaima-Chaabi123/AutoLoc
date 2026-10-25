package tn.esprit.autoloc.service;

import tn.esprit.autoloc.domain.Client;

import java.util.List;

public interface IClientService {

    Client createClient(Client client);

    Client getClientById(Long id);

    Client updateClient(Client client);

    void deleteClient(Long id);

    List<Client> getAllClients();
}
