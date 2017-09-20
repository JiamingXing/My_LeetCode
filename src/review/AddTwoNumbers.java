package review;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int sum = (l1 == null? 0 : l1.val) + (l2 == null? 0 : l2.val) + carry;
			carry = sum / 10;
			sum = sum % 10;
			cur.next = new ListNode(sum);
			cur = cur.next;
			l1 = (l1 == null) ? l1 : l1.next;
			l2 = (l2 == null) ? l2 : l2.next;
		}
		return dummy.next;
	}

	public boolean PredictTheWinner(int[] nums) {
	    if (nums == null) { return true; }
	    int n = nums.length;
	    if ((n & 1) == 0) { return true; } // Improved with hot13399's comment.
	    int[] dp = new int[n];
	    for (int i = n - 1; i >= 0; i--) {
	        for (int j = i; j < n; j++) {
	            if (i == j) {
	                dp[i] = nums[i];
	            } else {
	                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
	            }
	        }
	    }
	    return dp[n - 1] >= 0;
	}
}
