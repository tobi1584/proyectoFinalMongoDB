package aplicacion.eventos.Models;

import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

@Data
@Document(collection = "eventos")
public class Evento {

    @Id
    private ObjectId id;
    private String nombre;
    private LocalDate fecha;
    private LocalTime hora;
    private String ubicacion;
    private Integer capacidad;
    private Set<String> artistas;
    private Float precioEntrada;
}
