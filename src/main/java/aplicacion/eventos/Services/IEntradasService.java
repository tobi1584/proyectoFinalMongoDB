package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Entrada;
import org.bson.types.ObjectId;

import java.util.List;

public interface IEntradasService {
    Entrada createEntrada(Entrada entrada);
    String getNumEntradasPorEvento(String idEvento);
    String anularEvento(String idEntrada);

    List<Entrada> getAll();
}
