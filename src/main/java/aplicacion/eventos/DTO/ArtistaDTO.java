package aplicacion.eventos.DTO;



import lombok.Data;

import java.util.Set;

@Data
public class ArtistaDTO {

    private String id;
    private String nombre;
    private String generoMusical;
    private String biografia;
    private Set<String> enlaces;
}
