package argentinaprograma.portfolioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@Table(name = "proyectos")
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @Column(name = "descripcion", columnDefinition = "TEXT", nullable = false)
    private String descripcion;

    @Column(name = "imagen")
    private String imagen;

    @Column(name = "link_proyecto")
    private String linkProyecto;

    @Column(name = "link_repositorio")
    private String linkRepositorio;
}
