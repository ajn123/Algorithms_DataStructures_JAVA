public class Stack<T> {

	private T[] array;
	private int size;
	private int length;

	public Stack() {
		this.length = 10;
		this.array = (T[]) new Object[length];
		this.size = 0;
	}

	public void push(T element) {
		if (this.size >= this.length) {
			formatArray();
		}
		array[this.size] = element;
		this.size++;

	}

	public T peek() {
		if (this.size >= 1)
			return this.array[this.size - 1];
		else
			throw new IllegalStateException("the size is 0");

	}

	public T pop() {
		if (this.size >= 1) {
			this.size--;
			return this.array[size];

		} else {
			throw new IllegalStateException("the size is 0");
		}
	}
	
	
	public int size(){
		return this.size;
	}

	private void formatArray() {
		T[] newArray = (T[]) new Object[this.length * 2];

		for (int i = 0; i < length; i++) {
			newArray[i] = this.array[i];
		}

		this.array = newArray;
		this.length *= 2;

	}

}
