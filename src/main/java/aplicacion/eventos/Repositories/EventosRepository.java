package aplicacion.eventos.Repositories;

import aplicacion.eventos.Models.Eventos;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EventosRepository extends MongoRepository<Eventos, ObjectId> {

}
