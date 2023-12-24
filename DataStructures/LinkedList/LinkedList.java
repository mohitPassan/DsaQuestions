package DataStructures.LinkedList;

public class LinkedList {
    ListNode head;

    public LinkedList() {
        head = null;
    }

    public void addNode(int val) {
        if(head == null) {
            head = new ListNode(val);
            return;
        }

        ListNode n = head;
        while(n.next != null) {
            n = n.next;
        }

        ListNode newNode = new ListNode(val);
        n.next = newNode;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        ListNode n = head;
        while(n.next != null) {
            sb.append(n.val + "->");
            n = n.next;
        }
        sb.append(n.val);

        return sb.toString();
    }
}
