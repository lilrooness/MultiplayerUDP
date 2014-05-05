package game;

import java.util.ArrayList;

public abstract class Subject {
	
	private ArrayList<Observer> observers;

	public Subject() {
		observers = new ArrayList<Observer>();
	}
	
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void notifyObservers(Event event) {
		for(Observer observer : observers) {
			observer.onNotify(event);
		}
	}
	
}
