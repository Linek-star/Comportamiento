package ChainOfResponsibility;

public class Tecnico extends BaseManejador {

    @Override
    public boolean manejarSolicitud(SolicitudCambioProducto request) {
        System.out.println("Técnico: Verificando tipo de falla...");

        if (!request.isTipoFallaCubierta()) {
            System.out.println("Solicitud rechazada: Falla no cubierta por la garantía.");
            return false;
        }

        return manejarSiguiente(request);
    }
}