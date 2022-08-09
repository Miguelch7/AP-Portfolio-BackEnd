package argentinaprograma.portfolioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "trabajos")
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "puesto", length = 100, nullable = false)
    private String puesto;

    @Column(name = "empresa", length = 100, nullable = false)
    private String empresa;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "fecha_inicio", length = 50, nullable = false)
    private String fechaInicio;

    @Column(name = "fecha_fin", length = 50, nullable = false)
    private String fechaFin;
}
