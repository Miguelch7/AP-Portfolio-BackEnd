package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class LoginDTO {


    @NotEmpty(message = "El email es obligatorio")
    private String email;

    @NotEmpty(message = "La contraseña es obligatoria")
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;
}
