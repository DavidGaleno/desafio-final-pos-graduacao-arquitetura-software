package galeno.david.service;

import galeno.david.model.Cliente;
import galeno.david.model.ClienteDTO;

import java.util.List;

public interface ClientService {

    List<Cliente> findAll();

    Cliente findById(Long id);

    List<Cliente> findByName(String nome);

    Long count();

    Long create(ClienteDTO clienteDTO);

    void update(ClienteDTO clienteDTO, Long id) ;

    void delete(Long id);

}
