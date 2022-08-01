package argentinaprograma.portfolioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private String imagen;
    private String link_proyecto;
    private String link_repositorio;
}
