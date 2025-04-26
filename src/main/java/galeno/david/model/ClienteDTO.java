package galeno.david.model;

import galeno.david.annotations.MinDate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@AllArgsConstructor
@Setter
public class ClienteDTO {
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser vazio")
    String nome;
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode ser vazio")
    @Size(max = 11, message = "O telefone deve ter no máximo 11 caracteres")
    private String telefone;
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "O email deve ser válido")
    private String email;
    @NotNull(message = "O cpf não pode ser nulo")
    @NotBlank(message = "O cpf não pode ser vazio")
    @Size(max = 11, min = 11, message = "O cpf deve ter 11 caracteres")
    private String cpf;
    @NotNull(message = "A data de nascimento não pode ser nula")
    @PastOrPresent(message = "A data de nascimento deve ser igual ou menor à data de hoje")
    @MinDate(value = "1900-01-01", message = "A data deve ser a partir de 01/01/1900")
    private Date dataNascimento;


    public Cliente toCliente() {
        return Cliente
                .builder()
                .nome(nome)
                .email(email)
                .cpf(cpf)
                .telefone(telefone)
                .dataNascimento(dataNascimento)
                .build();
    }

}
