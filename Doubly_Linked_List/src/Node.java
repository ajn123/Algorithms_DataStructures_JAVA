
public class Node<T> {
	
	
	private T element;
	private Node prev;
	private Node next;
	
	
	public Node()
	{
		element = null;
		this.prev = null;
		this.next = null;
	}
	
	public T element()
	{
		return this.element;
	}
	
	public Node(T element)
	{
		this.element = element;
	}
	
	public void Next(Node next)
	{
		this.next = next;
	}
	
	public void Prev(Node prev)
	{
		this.prev = prev;
	}
	
    public Node getNext()
    {
    	return this.next;
    }
    
    public Node getPrev()
    {
    	return this.prev;
    }
	

}
