package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Getter @Setter
public class SkillDTO {

    private Long id;

    @NotEmpty(message = "El nombre de la skill no debe ser vacía")
    @Size(min = 2, message = "El nombre de la skill debe tener al menos 2 caracteres")
    private String nombre;

    private String descripcion;

    private String imagen;

    @Min(value = 1, message = "El porcentaje de la skill debe ser mayor a 0")
    @Max(value = 100, message = "El porcentaje de la skill debe ser menor o igual a 100")
    private Integer porcentaje;
}
