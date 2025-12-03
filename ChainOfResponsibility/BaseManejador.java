package ChainOfResponsibility;

public abstract class BaseManejador implements Handler {

    protected Handler siguienteManejador;

    @Override
    public Handler setSiguiente(Handler handler) {
        this.siguienteManejador = handler;
        return handler;
    }

    protected boolean manejarSiguiente(SolicitudCambioProducto request) {
        if (siguienteManejador != null) {
            return siguienteManejador.manejarSolicitud(request);
        }
        return true;
    }
}