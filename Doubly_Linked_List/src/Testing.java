
public class Testing {

	
	
	
	public static void main(String args[])
	{
		
		
		Doubly_Linked_List<Integer> list = new Doubly_Linked_List<Integer>();
		
		Node<Integer> node1 = new Node<Integer>(5);
		Node<Integer> node2 = new Node<Integer>(12);
		Node<Integer> node3 = new Node<Integer>(11);
		list.insert(node1);
		list.insert(node3);
		list.insert(node2);
		
		list.insertFirst(node2);
		
	}
}
