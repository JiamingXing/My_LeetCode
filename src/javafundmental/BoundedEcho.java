package javafundmental;

public class BoundedEcho<T extends Integer & Comparable> {
	public T echo(T value) {
		return value;
	}
	
	public BoundedEcho<T> echo(BoundedEcho<T> value) {
		return value;
	}
}
