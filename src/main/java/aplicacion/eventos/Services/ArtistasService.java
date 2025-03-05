package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Artista;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistasService implements IArtistasService{
    @Override
    public Artista agregarArtista(Artista artista) {
        return null;
    }

    @Override
    public List<Artista> obtenerTodosLosArtistas() {
        return List.of();
    }

    @Override
    public Optional<Artista> buscarPorNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    public List<Artista> buscarPorGenero(String genero) {
        return List.of();
    }

    @Override
    public Artista actualizarArtista(String id, Artista artista) {
        return null;
    }

    @Override
    public void eliminarArtista(String id) {

    }
}
