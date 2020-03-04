package merge;

public class LC234_PalindromeList {
	static class ListNode {
		public int val;
		public ListNode next;

		public ListNode(int val) {
			this.val = val;
		}
	}

	public boolean isPalindrome(ListNode head) {
		ListNode mid = findMid(head);
		ListNode newHead = reverseList(mid.next);
		ListNode cpNewHead = newHead;

		while (head != null && newHead != null) {
			if (head.val != newHead.val) {
				return false;
			}
		}

		mid.next = reverseList(cpNewHead);
		return true;
	}

	public ListNode findMid(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		return slow;
	}

	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		ListNode current = head;
		ListNode temp = null;

		while (current != null) {
			temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}

		return prev;
	}

	public static void main(String[] args) {
		ListNode l = new ListNode(1);
		l.next = new ListNode(2);
		l.next = new ListNode(1);
		l.next = new ListNode(1);

		LC234_PalindromeList obj = new LC234_PalindromeList();
		System.out.println(obj.isPalindrome(l));
	}

}
