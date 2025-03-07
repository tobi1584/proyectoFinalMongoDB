package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Artista;
import aplicacion.eventos.Models.Evento;
import aplicacion.eventos.Repositories.ArtistasRepository;
import aplicacion.eventos.Repositories.EventosRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ArtistasService implements IArtistasService {

    // Repositorio de artistas
    private ArtistasRepository artistasRepository;

    // Servicio de los eventos
    private EventosService eventosService;

    private EventosRepository eventosRepository;

    // Método para agregar un nuevo artista
    @Override
    public Artista agregarArtista(Artista artista) {
        return artistasRepository.save(artista);
    }

    // Método para obtener todos los artistas
    @Override
    public List<Artista> obtenerTodosLosArtistas() {
        List<Artista> artistas = artistasRepository.findAll();
        return artistas;
    }

    // Método para buscar un artista por su nombre
    @Override
    public Artista buscarPorNombre(String nombre) {
        return artistasRepository.findByNombre(nombre);
    }

    // Método para buscar artistas por su género musical
    @Override
    public List<Artista> buscarPorGenero(String genero) {
        List<Artista> artistas = artistasRepository.findAllByGeneroMusical(genero);
        return artistas;
    }

    // Método para actualizar un artista existente
    @Override
    public Artista actualizarArtista(String id, Artista artista) {
        Optional<Artista> artista1 = artistasRepository.findById(id);
        if (artista1.isPresent()) {
            Artista artista2 = artista1.get();
            String nombreAntiguo = artista2.getNombre();

            // Actualizar los datos del artista
            artista2.setNombre(artista.getNombre());
            artista2.setGeneroMusical(artista.getGeneroMusical());
            artista2.setBiografia(artista.getBiografia());
            artista2.setEnlaces(artista.getEnlaces());
            Artista artistaActualizado = artistasRepository.save(artista2);

            // Actualizar el nombre del artista en todos los eventos
            List<Evento> eventos = eventosService.listAll();
            for (Evento evento : eventos) {
                if (evento.getArtistas().contains(nombreAntiguo)) {
                    evento.getArtistas().remove(nombreAntiguo);
                    evento.getArtistas().add(artistaActualizado.getNombre());
                    eventosRepository.save(evento);
                }
            }

            return artistaActualizado;
        } else {
            throw new RuntimeException("Artista no encontrado");
        }
    }

    // Método para eliminar un artista por su ID
    @Override
    public void eliminarArtista(String id) {
        Optional<Artista> artistaOptional = artistasRepository.findById(id);
        if (artistaOptional.isPresent()) {
            String nombreArtista = artistaOptional.get().getNombre();
            artistasRepository.deleteById(id);

            // Eliminar el artista de todos los eventos
            List<Evento> eventos = eventosService.listAll();
            for (Evento evento : eventos) {
                if (evento.getArtistas().contains(nombreArtista)) {
                    evento.getArtistas().remove(nombreArtista);
                    eventosRepository.save(evento);
                }
            }
        } else {
            throw new RuntimeException("Artista no encontrado");
        }
    }
}