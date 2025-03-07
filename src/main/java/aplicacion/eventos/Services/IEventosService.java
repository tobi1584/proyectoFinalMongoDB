package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Artista;
import aplicacion.eventos.Models.Evento;
import org.bson.types.ObjectId;

import java.time.LocalDate;
import java.util.List;

public interface IEventosService {

    Evento createNew(Evento evento);

    List<Evento> findByName(String nombre);

    List<Evento> findByFecha(LocalDate fecha);

    List<Evento> findByArtista(String artista);

    List<Evento> listAll();

    Evento updateEvent(Evento evento);

    void deleteEvent(String id);
}
