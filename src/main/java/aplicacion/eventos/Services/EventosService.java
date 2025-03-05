package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Artista;
import aplicacion.eventos.Models.Evento;
import aplicacion.eventos.Repositories.ArtistasRepository;
import aplicacion.eventos.Repositories.EventosRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventosService implements IEventosService {

    private EventosRepository eventosRepository;
    private ArtistasRepository artistasRepository;

    @Override
    public Evento createNew(Evento evento) {
        verificarArtistas(evento.getArtistas());
        return eventosRepository.save(evento);
    }

    @Override
    public List<Evento> findByName(String nombre) {
        return List.of(eventosRepository.findAllByNombre(nombre));
    }

    @Override
    public List<Evento> findByFecha(LocalDate fecha) {
        return List.of(eventosRepository.findAllByFecha(fecha));
    }

    @Override
    public List<Evento> findByArtista(String artista) {
        List<Evento> todosEventos = eventosRepository.findAll();
        return todosEventos.stream()
                .filter(evento -> evento.getArtistas().stream()
                        .anyMatch(a -> a.equals(artista)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Evento> listAll() {
        return eventosRepository.findAll();
    }

    @Override
    public Evento updateEvent(Evento evento) {
        verificarArtistas(evento.getArtistas());
        Optional<Evento> evento1 = eventosRepository.findById(evento.getId());
        if (evento1.isPresent()) {
            Evento updatedEvento = evento1.get();
            updatedEvento.setNombre(evento.getNombre());
            updatedEvento.setFecha(evento.getFecha());
            updatedEvento.setHora(evento.getHora());
            updatedEvento.setUbicacion(evento.getUbicacion());
            updatedEvento.setCapacidad(evento.getCapacidad());
            updatedEvento.setArtistas(evento.getArtistas());
            updatedEvento.setPrecioEntrada(evento.getPrecioEntrada());
            return eventosRepository.save(updatedEvento);
        } else {
            throw new RuntimeException("Evento no encontrado");
        }
    }

    @Override
    public void deleteEvent(ObjectId id) {
        eventosRepository.deleteById(id);
    }

    private void verificarArtistas(Set<String> artistas) {
        for (String artista : artistas) {
            if (!artistasRepository.existsByNombre(artista)) {
                throw new RuntimeException("Artista no encontrado");
            }
        }
    }
}