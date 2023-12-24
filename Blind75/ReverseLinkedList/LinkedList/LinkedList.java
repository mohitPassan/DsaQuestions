package Blind75.ReverseLinkedList.LinkedList;

public class LinkedList {
    public ListNode head;

    public LinkedList() {
        head = null;
    }

    public void addNode(int val) {
        if (head == null) {
            head = new ListNode(val);
            return;
        }

        ListNode n = head;
        while (n.next != null) {
            n = n.next;
        }

        ListNode newNode = new ListNode(val);
        n.next = newNode;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        ListNode n = head;

        if (n == null) {
            sb.append("[]");
        } else {
            sb.append("[ ");
            while (n.next != null) {
                sb.append(n.val + " -> ");
                n = n.next;
            }
            sb.append(n.val + " ]");
        }

        return sb.toString();
    }
}
