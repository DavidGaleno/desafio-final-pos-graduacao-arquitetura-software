package galeno.david.controller;

import galeno.david.model.ClienteDTO;
import jakarta.ws.rs.core.Response;

public interface ClientController {

    Response findAll(String name);

    Response findById(Long id);

    Response count();

    Response create(ClienteDTO clienteDTO);

    Response update(ClienteDTO clienteDTO, Long id) ;

    Response delete(Long id);
}
