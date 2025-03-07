package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Entrada;
import aplicacion.eventos.Models.Evento;
import aplicacion.eventos.Repositories.EntradasRepository;
import aplicacion.eventos.Repositories.EventosRepository;
import lombok.AllArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class EntradasService implements IEntradasService {

    private final EntradasRepository entradasRepository;
    private final EventosRepository eventosRepository;

    @Override
    public Entrada createEntrada(Entrada entrada) {
        if (eventosRepository.existsById(entrada.getEventoId())) {
            return entradasRepository.save(entrada);
        } else {
            throw new IllegalArgumentException("El evento no existe");
        }
    }

    @Override
    public String getNumEntradasPorEvento(String idEvento) {
        if (eventosRepository.existsById(idEvento)) {
            List<Entrada> entradas = entradasRepository.findAll();
            long num = entradas.stream()
                    .filter(entrada -> entrada.getEventoId().equals(idEvento))
                    .count();
            return "El numero de entradas vendidas para este evento es: " + num;
        } else {
            return "El evento no existe";
        }
    }

    @Override
    public String anularEvento(String idEntrada) {
        Optional<Entrada> entrada = entradasRepository.findById(idEntrada);
        if (entrada.isPresent()) {
            Entrada entradaActualizada = entrada.get();
            if (eventosRepository.existsById(entradaActualizada.getEventoId())) {
                entradaActualizada.setAnulada(true);
                entradasRepository.save(entradaActualizada);
                return "Entrada anulada correctamente";
            } else {
                return "El evento no existe";
            }
        } else {
            return "Entrada no encontrada";
        }
    }

    @Override
    public List<Entrada> getAll() {
        List<Entrada> listaEntradas = entradasRepository.findAll();
        return listaEntradas;
    }
}