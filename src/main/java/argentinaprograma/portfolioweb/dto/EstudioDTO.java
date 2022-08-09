package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class EstudioDTO {

    private Long id;

    @NotEmpty(message = "El titulo es obligatorio")
    private String titulo;

    @NotEmpty(message = "La institución es obligatoria")
    private String institucion;

    private String descripcion;

    private String imagen;

    @NotEmpty(message = "La fecha de inicio es obligatoria")
    private String fechaInicio;

    @NotEmpty(message = "La fecha de fin es obligatoria")
    private String fechaFin;
}

