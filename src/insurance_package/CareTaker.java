package insurance_package;


import java.util.ArrayList;

public class CareTaker {
	private ArrayList<Memento> mementoList = new ArrayList<Memento>();
	
	public void add(Memento state){
		mementoList.add(state);
	}
	public Memento get(int index){
		return mementoList.get(index);
	}
	public int getSize(){
		return mementoList.size();
	}
}
