package argentinaprograma.portfolioweb.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
public class Trabajo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String puesto;
    private String empresa;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private String imagen;
    private String fecha_inicio;
    private String fecha_fin;
}
