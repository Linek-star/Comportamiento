package ChainOfResponsibility;

public class SolicitudCambioProducto {

    private boolean enGarantia;
    private boolean tipoFallaCubierta;
    private boolean stockDisponible;
    private double precio;

    public SolicitudCambioProducto(boolean enGarantia, boolean tipoFallaCubierta,
                                   boolean stockDisponible, double precio) {
        this.enGarantia = enGarantia;
        this.tipoFallaCubierta = tipoFallaCubierta;
        this.stockDisponible = stockDisponible;
        this.precio = precio;
    }

    public boolean isEnGarantia() {
        return enGarantia;
    }

    public boolean isTipoFallaCubierta() {
        return tipoFallaCubierta;
    }

    public boolean isStockDisponible() {
        return stockDisponible;
    }

    public double getPrecio() {
        return precio;
    }
}
