public class Node<T> {

	private Node<T> right;
	private Node<T> left;

	private int element;

	public Node(int element) {
		this.setElement(element);
		this.setLeft(null);
		this.setRight(null);
	}

	public Node(int element, Node<T> right, Node<T> left) {
		this.setElement(element);
		this.setLeft(null);
		this.setRight(null);

	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public int getElement() {
		if (this == null) {
			return (Integer) null;
		} else {
			return element;
		}

	}

	public void setElement(int element) {
		this.element = element;
	}

}
