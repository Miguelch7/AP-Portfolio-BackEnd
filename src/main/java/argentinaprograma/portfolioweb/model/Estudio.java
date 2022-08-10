package argentinaprograma.portfolioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "estudios")
public class Estudio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo", length = 100, nullable = false)
    private String titulo;

    @Column(name = "institucion", length = 100, nullable = false)
    private String institucion;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "fecha_inicio", length = 50, nullable = false)
    private String fechaInicio;

    @Column(name = "fecha_fin", length = 50, nullable = false)
    private String fechaFin;
}
