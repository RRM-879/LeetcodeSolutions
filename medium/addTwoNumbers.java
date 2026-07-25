/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 *
 *
 *
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // overthinking and overengineering solutions - don't do it

        // still need the head of the result list and the last node we've touched
        ListNode resultListHead = new ListNode();
        ListNode resultListLastNode = resultListHead;
        int carry = 0;

        // while we have still have nodes to look through and our carry value isn't 0
        while(l1 != null || l2 != null || carry != 0) {
            // our new sum for this digit of the list begins with the carry value
            int sum = carry;

            // if we have a value to process..
            if(l1 != null) {
                // add it to our current digit's sum and traverse the list
                sum += l1.val;
                l1 = l1.next;
            }
            // #same as above
            if(l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            // grab our new carry value
            carry = sum / 10;

            // create our new listnode with the modulus' value, so it's stripped the leading digit
            resultListLastNode.next = new ListNode(sum % 10);
            resultListLastNode = resultListLastNode.next;
        }

        return resultListHead.next;
    }
}