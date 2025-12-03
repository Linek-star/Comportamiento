package Observer;
import java.util.ArrayList;
import java.util.List;

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