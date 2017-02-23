package insurance_package;

public class Memento {
	private Person state;
	public Memento(Person state){
		this.state = state;
	}
	public Person getState(){
		return state;
	}
}
