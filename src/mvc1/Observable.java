package mvc1;


import java.util.ArrayList;
import java.util.List;

public abstract class Observable{
    private List<Observer> observerList;
    public Observable() {
        observerList = new ArrayList<>();
    }
    public void notifyObservers(){
        for (Observer observer: observerList) {
            observer.update();
        }
    }

    public void addObserver(Observer observer) {
        observerList.add(observer);
    }

    public void removeObserver(Observer observer) {
        observerList.remove(observer);
    }
}
