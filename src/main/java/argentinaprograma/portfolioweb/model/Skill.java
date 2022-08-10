package argentinaprograma.portfolioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "porcentaje", nullable = false)
    private Integer porcentaje;
}
