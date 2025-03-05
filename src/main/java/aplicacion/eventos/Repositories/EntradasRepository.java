package aplicacion.eventos.Repositories;

import aplicacion.eventos.Models.Entradas;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EntradasRepository extends MongoRepository<Entradas, ObjectId> {
}
