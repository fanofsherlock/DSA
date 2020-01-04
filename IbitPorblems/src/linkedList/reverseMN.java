package linkedList;

import java.util.Stack;

public class reverseMN {

	class ListNode {
		int data;
		ListNode next;

		public ListNode(int data) {
			this.data = data;
		}

	}

	public ListNode reverseBetween(ListNode A, int B, int C) {
		if (A == null) {
			return null;
		}

		if (B == C) {
			return A;
		}

		ListNode cpHead = A;

		Stack<ListNode> s = new Stack();

		// reaching m-1th Node
		for (int i = 1; i < B - 1; i++) {
			A = A.next;
			if (A == null) {
				return null;
			}
		}

		ListNode prevM = null;
		if (B != 1) {
			prevM = A;
			A = A.next;// reach mth node
		}

		for (int i = 1; i < C - B + 2; i++) {
			if (A == null) {
				return null;
			}
			s.push(A);// pushing all nodes from mth to nth
			A = A.next;// pointing to n+1th node
		}

		ListNode nextN = A;// pushing n+1th node

		if (prevM == null) {
			prevM = s.pop(); // if there was no previous then the first element of reversed list will be
								// first
			cpHead = prevM; // in this case first element of the list will also be this node
		}

		while (!s.isEmpty()) {
			prevM.next = s.pop();
			prevM = prevM.next;
		}

		prevM.next = nextN;

		return cpHead;

	}

	public ListNode reverseBetweenJavaArray(ListNode A, int B, int C) {
		if (A == null)
			return null;
		ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
		dummy.next = A;
		ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
		for (int i = 0; i < B - 1; i++)
			pre = pre.next;

		ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
		ListNode then = start.next; // a pointer to a node that will be reversed

		// 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
		// dummy-> 1 -> 2 -> 3 -> 4 -> 5

		for (int i = 0; i < C - B; i++) {
			start.next = then.next;
			then.next = pre.next;
			pre.next = then;
			then = start.next;
		}

		// first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
		// second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5
		// (finish)

		return dummy.next;

	}

}
