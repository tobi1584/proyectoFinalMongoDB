package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Artista;
import aplicacion.eventos.Repositories.ArtistasRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class ArtistasService implements IArtistasService{

    private ArtistasRepository artistasRepository;

    @Override
    public Artista agregarArtista(Artista artista) {
        return artistasRepository.save(artista);
    }

    @Override
    public List<Artista> obtenerTodosLosArtistas() {
        List<Artista> artistas = artistasRepository.findAll();
        return artistas;
    }

    @Override
    public Artista buscarPorNombre(String nombre) {
        return artistasRepository.findByNombre(nombre);
    }

    @Override
    public List<Artista> buscarPorGenero(String genero) {
        List<Artista> artistas = artistasRepository.findAllByGeneroMusical(genero);
        return artistas;
    }

    @Override
    public Artista actualizarArtista(ObjectId id, Artista artista) {
        Optional<Artista> artista1 = artistasRepository.findById(id);
        if (artista1.isPresent()) {
            Artista artista2 = artista1.get();
            artista2.setNombre(artista.getNombre());
            artista2.setGeneroMusical(artista.getGeneroMusical());
            artista2.setBiografia(artista.getBiografia());
            artista2.setEnlaces(artista.getEnlaces());
            return artistasRepository.save(artista2);
        } else {
            throw new RuntimeException("Artista no encontrado");
        }
    }

    @Override
    public void eliminarArtista(ObjectId id) {
        artistasRepository.deleteById(id);
    }
}
