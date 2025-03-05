package aplicacion.eventos.Repositories;

import aplicacion.eventos.Models.Artista;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ArtistasRepository extends MongoRepository<Artista, ObjectId> {

}
