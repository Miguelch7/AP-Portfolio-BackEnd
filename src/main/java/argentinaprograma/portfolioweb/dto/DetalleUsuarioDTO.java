package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class DetalleUsuarioDTO {

    private Long id;
    @NotEmpty(message = "El nombre es obligatorio")
    @Size(min = 3, message = "El nombre debe tener al menos 3 caracteres")
    private String nombre;

    @NotEmpty(message = "El apellido es obligatorio")
    @Size(min = 3, message = "El apellido debe tener al menos 3 caracteres")
    private String apellido;

    @NotEmpty(message = "La profesion es obligatoria")
    @Size(min = 3, message = "La profesion debe tener al menos 3 caracteres")
    private String profesion;

    @NotEmpty(message = "La descripcion es obligatoria")
    @Size(min = 10, message = "La descripcion debe tener al menos 10 caracteres")
    private String descripcion;

    private String imagen;

    @NotEmpty(message = "La dirección es obligatoria")
    @Size(min = 5, message = "La direccion debe tener al menos 5 caracteres")
    private String direccion;

    private String linkCv;
}

