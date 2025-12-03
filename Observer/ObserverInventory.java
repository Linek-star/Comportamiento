package Observer;
import java.util.ArrayList;
import java.util.List;

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

interface Observer {
        void update(String message);
    }

    
    class Inventory {

        private List<Observer> observers = new ArrayList<>();
        private String lastEvent;

        public void attach(Observer observer) {
            observers.add(observer);
        }

        public void detach(Observer observer) {
            observers.remove(observer);
        }

        public void notifyObservers() {
            for (Observer observer : observers) {
                observer.update(lastEvent);
            }
        }

        // Método cuando cambia algo en el inventario
        public void changeInventoryState(String eventDescription) {
            this.lastEvent = eventDescription;
            notifyObservers();
        }
    }

    class WebBuyer implements Observer {
        @Override
        public void update(String message) {
            System.out.println("[WebBuyer] Productos disponibles actualizados: " + message);
        }
    }

    class StoreSeller implements Observer {
        private String storeId;

        public StoreSeller(String storeId) {
            this.storeId = storeId;
        }

        @Override
        public void update(String message) {
            System.out.println("[StoreSeller - Tienda " + storeId + "] Nuevas unidades en tu tienda: " + message);
        }
    }

    class Provider implements Observer {
        @Override
        public void update(String message) {
            if (message.contains("falla") || message.contains("garantía")) {
                System.out.println("[Provider] Productos con fallas detectados: " + message);
            }
        }
    }

    class MaintenanceAssistant implements Observer {
        @Override
        public void update(String message) {
            if (message.contains("reparación")) {
                System.out.println("[MaintenanceAssistant] Nuevo equipo para reparar: " + message);
            }
        }
    }