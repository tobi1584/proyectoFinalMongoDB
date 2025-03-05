package aplicacion.eventos.Repositories;

import aplicacion.eventos.Models.Artista;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ArtistasRepository extends MongoRepository<Artista, ObjectId> {

    Artista findByNombre(String nombre);

    List<Artista> findAllByGeneroMusical(String generoMusical);

    boolean existsByNombre(String nombre);
}
