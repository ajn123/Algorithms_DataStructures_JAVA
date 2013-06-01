public class Doubly_Linked_List<T> {

	private Node head;
	private Node tail;
	private int size;

	public Doubly_Linked_List() {
		this.head = new Node();
		this.tail = new Node();
		this.head.Next(tail);
		this.tail.Prev(head);
		this.size = 0;
	}

	/**
	 * Insert at the end of the list.
	 * 
	 * @param node
	 *            to insert.
	 */
	public void insert(Node node) {

		node.Prev(this.tail.getPrev());
		this.tail.getPrev().Next(node);
		node.Next(tail);
		this.tail.Prev(node);

		this.size++;
	}

	public void insertFirst(Node node) {
		node.Next(this.head.getNext());
		node.getNext().Prev(node);
		node.Prev(this.head);
		this.head.Next(node);

		this.size++;
	}

	/**
	 * Removes the first occurrence of the specified element from this list, if
	 * it is present.
	 * 
	 * @param element
	 *            you want to delete.
	 */
	public void delete(T element) {

		Node<T> current = this.head.getNext();

		while (current.element() != null) {

			if (current.element().equals(element)) {
				current.getPrev().Next(current.getNext());
				current.getNext().Prev(current.getPrev());
				this.size--;
			}
			current = current.getNext();
		}

	}

	public int Size() {
		return this.size;
	}

}