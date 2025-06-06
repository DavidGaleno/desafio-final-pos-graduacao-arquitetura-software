package galeno.david.controller;

import galeno.david.exception.ExceptionHandler;
import galeno.david.model.ClienteDTO;
import galeno.david.service.ClienteServiceImpl;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceException;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.net.URI;
import java.sql.SQLIntegrityConstraintViolationException;

@Path("/clientes")
@Tag(name = "Clientes", description = "Operações relacionadas a clientes")
public class ClienteControllerImpl implements ClientController {

    @Inject
    ClienteServiceImpl clienteServiceImpl;

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Operation(summary = "Listar todos os clientes", description = "Lista todos os clientes encontrados no sistema. É possível filtrar a busca com base no nome do cliente")
    public Response findAll(@QueryParam("nome") String nome) {
        if (nome != null && !nome.isEmpty()) {
            return Response.ok(clienteServiceImpl.findByName(nome)).build();
        }
        return Response.ok(clienteServiceImpl.findAll()).type(MediaType.APPLICATION_JSON + ";charset=UTF-8").build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Operation(summary = "Buscar cliente com base no Id", description = "Busca o cliente no sistema com o Id informado.")
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(clienteServiceImpl.findById(id)).build();
    }

    @GET
    @Path("contar")
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Operation(summary = "Contar clientes", description = "Conta quantos clientes estão registrados no sistema")
    public Response count() {
        return Response.ok(clienteServiceImpl.count()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Operation(summary = "Cadastrar Cliente", description = "Cadastra um novo cliente no sistema")
    public Response create(@RequestBody ClienteDTO clienteDTO) {
        try {
            Long id = clienteServiceImpl.create(clienteDTO);

            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            uriBuilder.path(Long.toString(id)); // Append ID to URI
            URI uri = uriBuilder.build();

            return Response.created(uri).build();
        } catch (PersistenceException exception) {
            return ExceptionHandler.handlePersistenceException(exception);
        }
    }

    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Operation(summary = "Atualizar Cliente", description = "Atualiza dados do cliente no sistema com o Id informado")
    public Response update(@RequestBody ClienteDTO clienteDTO, @PathParam("id") Long id) {
        clienteServiceImpl.update(clienteDTO, id);

        return Response.accepted().build();

    }

    @Path("{id}")
    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
    @Operation(summary = "Deletar Cliente", description = "Delete os dados do cliente no sistema com o Id informado")
    public Response delete(@PathParam("id") Long id) {
        clienteServiceImpl.delete(id);
        return Response.noContent().build();
    }
}
