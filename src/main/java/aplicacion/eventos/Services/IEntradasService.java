package aplicacion.eventos.Services;

import aplicacion.eventos.Models.Entrada;
import org.bson.types.ObjectId;

public interface IEntradasService {
    Entrada createEntrada(Entrada entrada);
    String getNumEntradasPorEvento(ObjectId idEvento);
    String anularEvento(ObjectId idEntrada);
}
