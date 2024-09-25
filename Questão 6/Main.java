import java.util.ArrayList;
import java.util.List;

// Interface Observer
interface Observer {
    void update(String state);
}

class Subject {
    private List<Observer> observers = new ArrayList<>();
    private String state;

    // Método para adicionar observadores
    public void attach(Observer observer) {
        observers.add(observer);
    }

    // Este método serve para notificar observadores sobre mudanças
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(state);
        }
    }

    // Esse outro método serve para mudar o estado e notificar observadores
    public void setState(String newState) {
        this.state = newState;
        notifyObservers();
    }
}

// Implementação de um Observer
class ConcreteObserver implements Observer {
    private String observerState;

    @Override
    public void update(String state) {
        this.observerState = state;
        System.out.println("Estado atualizado para: " + observerState);
    }
}

// Classe Principal
public class Main {
    public static void main(String[] args) {
        Subject subject = new Subject();
        ConcreteObserver observer1 = new ConcreteObserver();
        ConcreteObserver observer2 = new ConcreteObserver();

        subject.attach(observer1);
        subject.attach(observer2);

        // Altera o estado e notificar observadores
        subject.setState("Novo Estado");
    }
}
