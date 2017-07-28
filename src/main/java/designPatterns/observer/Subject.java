package designPatterns.observer;

public interface Subject {

    void registerObserver(Observer observer);

    void notifyObservers(String tweet);
}
