package Observer;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();

        // Crear observadores
        Observer webBuyer = new WebBuyer();
        Observer storeSeller1 = new StoreSeller("Quito-01");
        Observer storeSeller2 = new StoreSeller("Guayaquil-02");
        Observer provider = new Provider();
        Observer maintenance = new MaintenanceAssistant();

        // Registrarlos en el inventario
        inventory.attach(webBuyer);
        inventory.attach(storeSeller1);
        inventory.attach(storeSeller2);
        inventory.attach(provider);
        inventory.attach(maintenance);

        // Simulación de eventos en el inventario
        inventory.changeInventoryState("Llegaron 30 laptops Dell a Quito-01");
        inventory.changeInventoryState("Producto en reparación: TV Samsung 55\"");
        inventory.changeInventoryState("Producto con falla en garantía: impresora HP");
    }
}