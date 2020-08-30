package cars24;

public class CycleInaLinkedList {
 
	static class Node{
		int val;
		Node next;
		public Node(int val) {
			this.val=val;
		}
	}
	
	public static boolean findCycle(Node n) {
		if(n==null) {
			return false;
		}
		
	    Node fast = n;
	    Node slow = n;
	    
	    while(fast.next!=null && fast.next.next!=null) {
	    	fast=fast.next.next;
	    	slow=slow.next;
	    	
	    	if(slow==fast) {
	    		return true;
	    	}
	    }
		
		return false;
		
	}
	
	public static void main(String[] args) {
		Node root = new Node(1);
		root.next = new Node(2);
		root.next.next = new Node(3);
		root.next.next.next = root;
		
		System.out.println(findCycle(root));
		
	}
	
}
