/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 * Both lists are already sorted in non-descending order.. so 1, 2, 4, etc
 *
 * // So first idea.. concat two lists together and sort? - nope can't, they're objects and not arrays - duh
 * // second idea - we're splicing 2 nodes together.. start with one, compare values and move up each list.next until one list is null
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // So we'll need a node to hold onto the previous head and a pointer to the last examined node
        ListNode prevHead = new ListNode(0);
        ListNode lastNode = prevHead;

        // While both lists have nodes in them we need to splice
        while(list1 != null && list2 != null) {
            // if the first node's value is greater than the second's..
            if(list1.val > list2.val) {
                // then we assign the last node we looked at to list2
                lastNode.next = list2;
                // and push list2 up to it's next node
                list2 = list2.next;
            } else {
                // this triggers if list2's node has a greater value so..
                // we do the same as above, assign the last node and push list1 to it's next node
                lastNode.next = list1;
                list1 = list1.next;
            }

            // we're done the comparison so time to push up here as well
            lastNode = lastNode.next;
        }
        // Ternary check to correctly finish off the list and return it fully spliced
        lastNode.next = list1 == null ? list2 : list1;
        return prevHead.next;
    }
}