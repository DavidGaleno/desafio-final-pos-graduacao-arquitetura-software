package galeno.david.controller;

import galeno.david.model.Cliente;
import galeno.david.service.ClienteService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.net.URI;

@Path("/clientes")
public class ClienteController {

    @Inject
    ClienteService clienteService;

    @Context
    UriInfo uriInfo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll() {
        return Response.ok(clienteService.findAll()).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findById(@PathParam("id") Long id) {
        return Response.ok(clienteService.findById(id)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findByName(@PathParam("name") String name) {
        return Response.ok(clienteService.findByName(name)).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response count() {
        return Response.ok(clienteService.count()).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(Cliente cliente) {
        clienteService.create(cliente);

        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        uriBuilder.path(Long.toString(cliente.getId())); // Append ID to URI
        URI uri = uriBuilder.build();

        return Response.created(uri).build();
    }
    @PATCH
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(Cliente cliente, @PathParam("id") Long id) {
        clienteService.update(cliente,id);
        return  Response.accepted().build();

    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        clienteService.delete(id);
        return  Response.noContent().build();
    }
}
