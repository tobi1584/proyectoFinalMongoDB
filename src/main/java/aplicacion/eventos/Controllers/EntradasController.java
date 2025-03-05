package aplicacion.eventos.Controllers;

import aplicacion.eventos.Models.Entrada;
import aplicacion.eventos.Services.IEntradasService;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/entradas")
@AllArgsConstructor
public class EntradasController {

    private final IEntradasService entradasService;

    @PostMapping("/create")
    public ResponseEntity<Entrada> createEntrada(@RequestBody Entrada entrada) {
        Entrada nuevaEntrada = entradasService.createEntrada(entrada);
        return ResponseEntity.ok(nuevaEntrada);
    }

    @GetMapping("/getNumEntradas")
    public ResponseEntity<String> getNumEntradasPorEvento(@RequestParam ObjectId idEvento) {
        String numEntradas = entradasService.getNumEntradasPorEvento(idEvento);
        return ResponseEntity.ok(numEntradas);
    }

    @PutMapping("/anularEvento")
    public ResponseEntity<String> anularEntrada(@RequestParam ObjectId idEntrada) {
        String resultado = entradasService.anularEvento(idEntrada);
        return ResponseEntity.ok(resultado);
    }
}