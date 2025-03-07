package aplicacion.eventos.Controllers;

import aplicacion.eventos.Models.Evento;
import aplicacion.eventos.Services.EventosService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventos")
@AllArgsConstructor
public class EventosController {

    private EventosService eventosService;

    @PostMapping("/create")
    public ResponseEntity<Evento> createNew(@RequestBody Evento evento) {
        Evento nuevoEvento = eventosService.createNew(evento);
        return ResponseEntity.ok(nuevoEvento);
    }

    @GetMapping("/getOne")
    public ResponseEntity<List<Evento>> findByName(@RequestParam String nombre) {
        List<Evento> eventos = eventosService.findByName(nombre);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/getByDate")
    public ResponseEntity<List<Evento>> findByFecha(@RequestParam LocalDate fecha) {
        List<Evento> eventos = eventosService.findByFecha(fecha);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/getByArtist")
    public ResponseEntity<List<Evento>> findByArtista(@RequestParam String nombreArtista) {
        List<Evento> eventos = eventosService.findByArtista(nombreArtista);
        return ResponseEntity.ok(eventos);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Evento>> listAll() {
        List<Evento> eventos = eventosService.listAll();
        return ResponseEntity.ok(eventos);
    }

    @PutMapping("/updateEvento")
    public ResponseEntity<Evento> updateEvent(@RequestParam String id, @RequestBody Evento evento) {
        evento.setId(id);
        Evento updatedEvento = eventosService.updateEvent(evento);
        return ResponseEntity.ok(updatedEvento);
    }

    @DeleteMapping("/deleteEvento")
    public ResponseEntity<Void> deleteEvent(@RequestParam String id) {
        eventosService.deleteEvent(id);
        return ResponseEntity.noContent().build();
    }
}