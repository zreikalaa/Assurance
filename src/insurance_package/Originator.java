package insurance_package;

public class Originator {
	private Person state;
	public void setState(Person p){
		state = p;
	}
	public Person getState(){
		return state;
	}
	public Memento saveStateTomemento(){
		return new Memento(state);
	}
	public void getStateFromMemento(Memento m){
		state = m.getState();
	}
	
}
