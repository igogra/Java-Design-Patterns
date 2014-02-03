package behavioral.observer;

import java.util.ArrayList;
import java.util.List;

interface Observer {
	public void update();
}

class User implements Observer {
	private String name;

	public User(String name) {
		this.name = name;
	}

	@Override
	public void update() {
		System.out.println(name + " got notified");
	}
}

interface Subject {
	public void registerObserver(Observer observer);

	public void removeObserver(Observer observer);

	public void notifyAllObservers();
}

class Blog implements Subject {
	private List<Observer> usersList;

	public Blog() {
		this.usersList = new ArrayList<Observer>();
	}

	@Override
	public void registerObserver(Observer observer) {
		usersList.add(observer);
	}

	@Override
	public void removeObserver(Observer observer) {
		usersList.remove(observer);
	}

	@Override
	public void notifyAllObservers() {
		for (Observer observer : usersList) {
			observer.update();
		}
	}

	public void postNewArticle() {
		System.out.println("New post on the blog");
		notifyAllObservers();
	}
}

public class DemoObserver {
	public static void main(String[] args) {
		Blog blog = new Blog();
		blog.registerObserver(new User("John"));
		blog.registerObserver(new User("Anna"));
		blog.registerObserver(new User("Peter"));

		blog.postNewArticle();
	}
}
