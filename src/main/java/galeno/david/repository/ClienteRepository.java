package galeno.david.repository;

import galeno.david.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public Cliente findByName(String nome) {
        return find("nome", nome).firstResult();
    }

    public void updateById(String nome, String email, Long id) {
        update("update Cliente c set c.nome = :nome, c.email = :email where c.id = :id", Parameters.with("nome",nome).and("email",email).and("id",id));
    }
}