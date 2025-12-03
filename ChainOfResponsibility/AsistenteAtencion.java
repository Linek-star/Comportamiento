package ChainOfResponsibility;

public class AsistenteAtencion extends BaseManejador {

    @Override
    public boolean manejarSolicitud(SolicitudCambioProducto request) {
        System.out.println("Asistente de Atención: Verificando garantía...");

        if (!request.isEnGarantia()) {
            System.out.println("Solicitud rechazada: Producto fuera de garantía.");
            return false;
        }

        return manejarSiguiente(request);
    }
}