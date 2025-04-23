package galeno.david.service;


import galeno.david.model.Cliente;
import galeno.david.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class ClienteService {
    @Inject
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll() {
        return clienteRepository.findAll().stream().toList();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente findByName(String name) {
        return clienteRepository.findByName(name);
    }

    public Long count() {
        return clienteRepository.count();
    }


    public void create(Cliente cliente) {
        clienteRepository.persist(cliente);
    }

    public void update(Cliente cliente,Long id) {
        clienteRepository.updateById(cliente.getName(),cliente.getEmail(),id);
    }


    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
