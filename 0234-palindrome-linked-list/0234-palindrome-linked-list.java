/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    // Helper function to find the middle of the linked list using slow and fast pointers
    ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Helper function to reverse a linked list starting from a given head
    ListNode reverseLL (ListNode head){
        ListNode curr = head;
        ListNode prev = null;

        while(curr != null){
            ListNode nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        // Why we return 'prev' instead of 'curr':
        // When the while loop finishes, 'curr' has moved past the last node and become 'null'.
        // Meanwhile, 'prev' has successfully stopped at the last node of the original list, 
        // which is now the NEW HEAD (starting point) of our reversed linked list.
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // Step 1: Find the middle node of the linked list
        ListNode mid = findMiddle(head);
        
        // Step 2: Reverse the second half and get its new head
        ListNode head2 = reverseLL(mid);

        // Step 3: Initialize pointers for the first half and the reversed second half
        ListNode right = head; 
        ListNode left = head2;  

        // Step 4: Compare values node by node
        while(left != null){ // Using left != null ensures we don't go out of bounds on odd-length lists
            if(left.val != right.val){
                return false; // Mismatch found, not a palindrome
            }
            left = left.next;
            right = right.next;
        }
        
        return true; // All values matched, it is a palindrome
    }
}