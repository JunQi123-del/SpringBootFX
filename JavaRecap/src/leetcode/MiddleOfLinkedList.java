package leetcode;



public class MiddleOfLinkedList {
    public ListNode middleNode(ListNode head) {
//    List<ListNode> NodeList = new ArrayList<>();
//    while(head!=null){
//        NodeList.add(head);
//        head = head.next;
//    }
//
//    return NodeList.get(NodeList.size()/2);
    
    //or 
    ListNode middle = head;
    ListNode end = head;

    while(end!=null && end.next!=null){
        middle = middle.next;
        end = end.next.next;
    }
    return middle;
    
}
}


