package argentinaprograma.portfolioweb.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter @Setter
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    private static final Long serialVersionUID = 1L;
    private String recurso;
    private String campo;
    private Long valor;

    public ResourceNotFoundException(String recurso, String campo, Long valor) {
        super(String.format("No se ha encontrado un/a %s con %s = '%s'", recurso, campo, valor));
        this.recurso = recurso;
        this.campo = campo;
        this.valor = valor;
    }
}
