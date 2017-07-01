package binaryTree;

public class ConstructStringFromBT {
	public String tree2str(TreeNode t) {
		if (t == null) {
			return "";
		}
		StringBuilder sb = new StringBuilder();
		helper(t, sb);
		return sb.toString();
	}
	private void helper(TreeNode root, StringBuilder sb) {
		if (root == null) {
			return;
		}
		sb.append(root.val);
		if (root.left != null) {
			sb.append("(");
			helper(root.left, sb);
			sb.append(")");
			if (root.right != null) {
				sb.append("(");
				helper(root.right, sb);
				sb.append(")");
			}
		} else {
			if (root.right != null) {
				sb.append("(");
				sb.append(")");
				sb.append("(");
				helper(root.right, sb);
				sb.append(")");
			} else {
				return;
			}
		}
	}
}
//简化版
/*
public class Solution {
    public String tree2str(TreeNode t) {
        if (t == null) return "";
        
        String result = t.val + "";
        
        String left = tree2str(t.left);
        String right = tree2str(t.right);
        
        if (left == "" && right == "") return result;
        if (left == "") return result + "()" + "(" + right + ")";
        if (right == "") return result + "(" + left + ")";
        return result + "(" + left + ")" + "(" + right + ")";
    }
}
*/
