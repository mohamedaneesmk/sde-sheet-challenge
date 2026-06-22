import java.util.Stack;

public class ReverseLinkedList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode reversed = reverse(head);

        while (reversed != null) {
            System.out.println(reversed.val + " ");
            reversed = reversed.next;
        }
    }

    private static ReverseLinkedList.ListNode reverse(ReverseLinkedList.ListNode head) {

        Stack<ListNode> stack = new Stack<>();
        ListNode temp = head;

        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }

        head = stack.pop();
        temp = head;

        while (!stack.isEmpty()) {
            temp.next = stack.pop();
            temp = temp.next;
        }

        temp.next = null;

        return head;
    }
}
