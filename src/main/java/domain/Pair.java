package domain;

public class Pair<T, G> {
	
	T first;
	G second;	
	
	public void setFirst(T first) {
		this.first = first;
	}

	public void setSecond(G second) {
		this.second = second;
	}

	public T getFirst() {return first;}
	
	public G getSecond() {return second;}
}
