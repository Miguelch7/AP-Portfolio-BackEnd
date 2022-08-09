package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class ProyectoDTO {

    private Long id;

    @NotEmpty(message = "El nombre del proyecto es obligatorio")
    private String nombre;

    @NotEmpty(message = "La descripción del proyecto es obligatoria")
    private String descripcion;

    private String imagen;

    private String linkProyecto;

    private String linkRepositorio;
}
