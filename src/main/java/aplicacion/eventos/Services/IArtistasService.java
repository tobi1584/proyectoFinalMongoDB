package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Artista;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Optional;

public interface IArtistasService {

    Artista agregarArtista(Artista artista);

    List<Artista> obtenerTodosLosArtistas();

    Artista buscarPorNombre(String nombre);

    List<Artista> buscarPorGenero(String genero);

    Artista actualizarArtista(String id, Artista artista);

    void eliminarArtista(String id);
}