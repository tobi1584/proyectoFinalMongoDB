package aplicacion.eventos.Repositories;

import aplicacion.eventos.Models.Entrada;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface EntradasRepository extends MongoRepository<Entrada, String> {

    List<Entrada> findAllByEventoId(String eventoId);
}
