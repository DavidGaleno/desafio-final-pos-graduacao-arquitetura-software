package galeno.david.repository;

import galeno.david.model.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import io.quarkus.panache.common.Parameters;
import jakarta.enterprise.context.ApplicationScoped;

import java.time.LocalDate;
import java.util.List;

@ApplicationScoped
public class ClienteRepository implements PanacheRepository<Cliente> {

    public List<Cliente> findByName(String nome) {
        return find("nome like ?1", "%" + nome.toLowerCase() + "%").stream().toList();
    }

    public void updateById(String nome, String email, String telefone, LocalDate dataNascimento, String cpf, Long id) {
        update(
                "update Cliente c set " +
                        "c.nome = :nome, " +
                        "c.email = :email, " +
                        "c.telefone = :telefone, " +
                        "c.cpf = :cpf, " +
                        "c.dataNascimento = :dataNascimento " +
                        "where c.id = :id",
                Parameters
                        .with("nome", nome)
                        .and("email", email)
                        .and("telefone", telefone)
                        .and("cpf", cpf)
                        .and("dataNascimento", dataNascimento)
                        .and("id", id)
        );
    }
}