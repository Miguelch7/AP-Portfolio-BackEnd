package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter @Setter
public class TrabajoDTO {

    private Long id;

    @NotEmpty(message = "El puesto de trabajo es obligatorio")
    private String puesto;

    @NotEmpty(message = "La empresa de trabajo es obligatoria")
    private String empresa;

    private String descripcion;

    private String imagen;

    @NotEmpty(message = "La fecha de inicio es obligatoria")
    private String fechaInicio;

    @NotEmpty(message = "La fecha de fin es obligatoria")
    private String fechaFin;
}
