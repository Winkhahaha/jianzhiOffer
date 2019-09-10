package 剑指金钱;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 从尾到头打印链表 {

	public static void main(String[] args) {
			ListNode listnode1 =  new ListNode(1);
			ListNode listnode2 = new ListNode(2);
			ListNode listnode3 = new ListNode(3);
			listnode1.next=listnode2;
			listnode2.next=listnode3;
			System.out.println(printListFromTailToHead(listnode1));
			
	}

	/*
	 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList.
	 */
public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
	ArrayList<Integer> list = new ArrayList<>();
	Stack<Integer> stack = new Stack<>();
	while(listNode!=null) {
		stack.push(listNode.val);
		listNode=listNode.next;
	}
	while(!stack.isEmpty()) {
		list.add(stack.pop());
	}
	
	return list;
        
    }
}

 class ListNode {
       int val;
       ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
