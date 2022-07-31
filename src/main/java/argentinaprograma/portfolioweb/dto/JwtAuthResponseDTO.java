package argentinaprograma.portfolioweb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class JwtAuthResponseDTO {

    private String token;
    private String tipoToken = "Bearer";

    public JwtAuthResponseDTO(String token) {
        this.token = token;
    }
}
