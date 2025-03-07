package aplicacion.eventos.Controllers;

import aplicacion.eventos.Models.Artista;
import aplicacion.eventos.Models.Evento;
import aplicacion.eventos.Services.ArtistasService;
import aplicacion.eventos.Services.EventosService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/artistas")
@AllArgsConstructor
public class ArtistasController {

    // Autowired de el servicio
    private final ArtistasService artistasService;

    private final EventosService eventosService;

    @PostMapping("/create")
    public ResponseEntity<Artista> agregarArtista(@RequestBody Artista artista) {
        Artista nuevoArtista = artistasService.agregarArtista(artista);
        return ResponseEntity.ok(nuevoArtista);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Artista>> obtenerTodosLosArtistas() {
        List<Artista> artistas = artistasService.obtenerTodosLosArtistas();
        return ResponseEntity.ok(artistas);
    }

    @GetMapping("/getOne")
    public ResponseEntity<Artista> buscarPorNombre(@RequestParam String nombre) {
        Artista artista = artistasService.buscarPorNombre(nombre);
        return ResponseEntity.ok(artista);
    }

    @GetMapping("/genero")
    public ResponseEntity<List<Artista>> buscarPorGenero(@RequestParam String genero) {
        List<Artista> artistas = artistasService.buscarPorGenero(genero);
        return ResponseEntity.ok(artistas);
    }

    @PutMapping("/update")
    public ResponseEntity<Artista> actualizarArtista(@RequestParam String id, @RequestBody Artista artista) {
        Artista artistaActualizado = artistasService.actualizarArtista(id, artista);

        return ResponseEntity.ok(artistaActualizado);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<Void> eliminarArtista(@RequestParam String id) {
        artistasService.eliminarArtista(id);
        return ResponseEntity.noContent().build();
    }
}