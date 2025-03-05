package aplicacion.eventos.Models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "entradas")
public class Entrada {

    @Id
    private ObjectId id;
    private ObjectId eventoId;
    private String compradorEmail;
    private Float precio;
    private boolean anulada = false;
}
