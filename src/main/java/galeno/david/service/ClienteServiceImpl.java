package galeno.david.service;


import galeno.david.model.Cliente;
import galeno.david.model.ClienteDTO;
import galeno.david.repository.ClienteRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class ClienteServiceImpl implements ClientService {
    @Inject
    private ClienteRepository clienteRepository;


    public List<Cliente> findAll() {
        return clienteRepository.findAll().stream().toList();
    }

    public Cliente findById(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente findByName(String nome) {
        return clienteRepository.findByName(nome);
    }

    public Long count() {
        return clienteRepository.count();
    }


    @Transactional
    public Long create(ClienteDTO clienteDTO) {
        Cliente cliente = clienteDTO.toCliente();

        clienteRepository.persist(cliente);

        return cliente.getId();
    }

    @Transactional
    public void update(ClienteDTO clienteDTO, Long id) {
        clienteRepository.updateById(clienteDTO.getNome(), clienteDTO.getEmail(), clienteDTO.getTelefone(), clienteDTO.getDataNascimento(), clienteDTO.getCpf(), id);
    }

    @Transactional
    public void delete(Long id) {
        clienteRepository.deleteById(id);
    }
}
