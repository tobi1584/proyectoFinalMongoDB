package aplicacion.eventos.Repositories;

import aplicacion.eventos.Models.Artista;
import aplicacion.eventos.Models.Evento;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.Set;

public interface EventosRepository extends MongoRepository<Evento, ObjectId> {

    Evento findAllByNombre(String nombre);

    Evento findAllByFecha(LocalDate fecha);

    Evento findAllByArtistas(Set<Artista> artistas);
}
