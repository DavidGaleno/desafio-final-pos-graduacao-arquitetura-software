package galeno.david.model;


import galeno.david.annotations.MinDate;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@Setter
public class ClienteDTO {
    @Schema(description = "Nome do Cliente", defaultValue = "David Galeno")
    @NotNull(message = "O nome não pode ser nulo")
    @NotBlank(message = "O nome não pode ser vazio")
    String nome;

    @Schema(description = "Telefone do Cliente", defaultValue = "61940028922")
    @NotNull(message = "O telefone não pode ser nulo")
    @NotBlank(message = "O telefone não pode ser vazio")
    @Size(max = 11, message = "O telefone deve ter no máximo 11 caracteres")
    @Pattern(regexp = "^\\d+$", message = "O telefone somente pode ter digitos numéricos")
    private String telefone;

    @Schema(description = "Email do Cliente", defaultValue = "david.galeno@email.com")
    @NotNull(message = "O email não pode ser nulo")
    @NotBlank(message = "O email não pode ser vazio")
    @Email(message = "O email deve ser válido")
    private String email;

    @Schema(description = "CPF do Cliente", defaultValue = "40028922400")
    @NotNull(message = "O cpf não pode ser nulo")
    @NotBlank(message = "O cpf não pode ser vazio")
    @Size(max = 11, min = 11, message = "O cpf deve ter 11 caracteres")
    @Pattern(regexp = "^\\d+$", message = "O cpf somente pode ter digitos numéricos")
    private String cpf;

    @Schema(description = "Data de Nascimento do Cliente", defaultValue = "2020-12-12")
    @NotNull(message = "A data de nascimento não pode ser nula")
    @PastOrPresent(message = "A data de nascimento deve ser igual ou menor à data de hoje")
    @MinDate(value = "1900-01-01", message = "A data deve ser a partir de 01/01/1900")
    private LocalDate dataNascimento;


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
