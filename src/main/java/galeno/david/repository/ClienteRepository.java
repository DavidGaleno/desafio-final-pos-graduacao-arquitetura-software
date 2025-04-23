package galeno.david.repository;

import galeno.david.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public Cliente findByName(String name) {
        return find("name", name).firstResult();
    }

    public void updateById(String name, String email, Long id) {
        update("update Cliente c set c.name = :name abd c.email = :email where p.id = :id", Parameters.with("name",name).and("email",email).and("id",id));
    }
}