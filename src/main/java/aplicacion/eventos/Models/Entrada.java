package aplicacion.eventos.Models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "entradas")
public class Entrada {

    @Id
    private String id;
    private String eventoId;
    private String compradorEmail;
    private Float precio;
    private boolean anulada = false; // Con esto se sabe si se ha tenido que anular la entrada
}
