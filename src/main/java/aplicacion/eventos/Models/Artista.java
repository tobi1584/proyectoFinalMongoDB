package aplicacion.eventos.Models;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Document(collection = "artistas")
public class Artista {

    @Id
    private ObjectId id;
    private String nombre;
    private String generoMusical;
    private String biografia;
    private Set<String> enlaces;
}
