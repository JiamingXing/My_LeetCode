package linkedList;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

//有三种方法可以用 
//这个自己写comparator是什么？
public class MergeKSortedList {
//	private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
//        public int compare(ListNode left, ListNode right) {
//            return left.val - right.val;
//        }
//    };
//	public ListNode mergeKLists(ListNode[] lists) {
//		if (lists == null || lists.length == 0) {
//            return null;
//        }
//        
//        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, ListNodeComparator);
//        for (int i = 0; i < lists.length; i++) {
//            if (lists[i] != null) {
//                heap.add(lists[i]);
//            }
//        }
//        
//        ListNode dummy = new ListNode(0);
//        ListNode tail = dummy;
//        while (!heap.isEmpty()) {
//            ListNode head = heap.poll();
//            tail.next = head;
//            tail = head;
//            if (head.next != null) {
//                heap.add(head.next);
//            }
//        }
//        return dummy.next;
//
//	}
	//我们如果用PQ时间复杂度如何分析呢？
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
            return null;
        }
        //PQ始终维持lists size的大小
        PriorityQueue<ListNode> Q = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode n1, ListNode n2) {
                return n1.val - n2.val;
            }
        });
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                Q.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!Q.isEmpty()) {
            ListNode node = Q.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                Q.add(node.next);
            }
        }
        return dummy.next;
    }
}


/*
//自己写的divide conquer的做法
//这道题的时间复杂度怎么分析？ O(nlogk) k is the total number of lists n is total number of nodes
public class MergeKSortedList {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists == null || lists.length == 0) {
          return null;
      }
      int n = lists.length;
      return helper(lists, 0, n-1);
	}
	private ListNode helper(ListNode[] Lists, int start, int end) {
      if (start == end) {
          return Lists[start];
      }
      int mid = start + (end - start) / 2;
      ListNode left = helper(Lists, start, mid);
      ListNode right = helper(Lists, mid + 1, end);
      return merge(left, right);
  }
  private ListNode merge(ListNode l1, ListNode l2) {
      if (l1 == null) {
          return l2;
      }
      if (l2 == null) {
          return l1;
      }
      ListNode dummy = new ListNode(0);
      ListNode cur = dummy;
      while (l1 != null || l2 != null) {
          int val1 = l1 == null ? Integer.MAX_VALUE : l1.val;
          int val2 = l2 == null ? Integer.MAX_VALUE : l2.val;
          if (val1 < val2) {
              cur.next = l1;
              l1 = l1.next;
          } else {
              cur.next = l2;
              l2 = l2.next;
          }
          cur = cur.next;
      }
      return dummy.next;
  }
}
*/
