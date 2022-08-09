package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class ErrorDetallesDTO {

    private Date time;
    private String message;
    private String info;

    public ErrorDetallesDTO(Date time, String message, String info) {
        this.time = time;
        this.message = message;
        this.info = info;
    }
}
