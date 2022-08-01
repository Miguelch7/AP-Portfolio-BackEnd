package argentinaprograma.portfolioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String institucion;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private String imagen;
    private String fecha_inicio;
    private String fecha_fin;
}
