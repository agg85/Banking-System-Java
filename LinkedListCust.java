/**
 * 
 * @author ARYAN GUPTA
 *
 */
public class LinkedListCust {
	private Node head = new Node();
	private Node tail = new Node();
	public Node getHead() {
		return head;
	}
	public Node getTail() {
		return tail;
	}
	
	public static class Node {
		public Node next;
		public Node prev;
		public Object data;
	}
	
	public int remove(Node rem) {
		Node n = new Node();
		n = rem;
		
		if(n.prev!=null && n.next!=null) {
			n.prev.next = n.next;
			n.next.prev = n.prev;
		}
		else if(n.prev!=null)
		{
			n.prev.next = null;
			tail = n.prev;
		}
		else if(n.next!=null)
		{
			n.next.prev = null;
			head = n.next;
		}
		else
		{
			head = null;
			tail = null;
		}
		return 0;
	}
	
	public void add(Object data) {
		Node n = new Node();
		n.data = data;
		if(head!=null)
		{
			n.next = head;
			head.prev = n;
		}
		if(tail==null)
			tail = n;
		head = n;
	}

	public int containsInteger(Integer x) {
		Node n = this.head;
		int ans=0;
		while(n.next!=null) {
			if(n.data.equals(x))
				ans++;
			n=n.next;
		}
		return ans;
	}
}