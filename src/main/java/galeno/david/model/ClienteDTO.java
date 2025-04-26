package galeno.david.model;

import lombok.Getter;

@Getter
public class ClienteDTO {
    String name;
    String email;

    public Cliente toCliente() {
        return Cliente
                .builder()
                .name(name)
                .email(email)
                .build();
    }
}
