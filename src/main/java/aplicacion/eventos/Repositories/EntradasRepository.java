package aplicacion.eventos.Repositories;

import aplicacion.eventos.Models.Entrada;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntradasRepository extends MongoRepository<Entrada, ObjectId> {
}
