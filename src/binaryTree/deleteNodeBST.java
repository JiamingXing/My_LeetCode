package binaryTree;
// search the key node first
//separate into 3 cases
//if this key has no children, make its parent point to nul
//if this key has one child, make its parent point to it's child
//if this key has two children, find z's successor y
//y has either no child or one right child
//delete y and make key's parent point to y.
public class deleteNodeBST {
	public TreeNode deleteNode(TreeNode root, int key) {
		ResultType target = searchKey(root, key);
		if(target.keyNode.left == null && target.keyNode.right == null){
			target.parent.pos = null;
		}
		if(target.keyNode.left == null){
			
		}
		if(target.keyNode.right == null){
			
		}
		
		
	}
	public class ResultType{
		TreeNode keyNode;
		TreeNode parent;
		public ResultType(TreeNode keyNode, TreeNode parent){
			this.keyNode = keyNode;
			this.parent = parent;
		}
	}
	//search a node with key and its parent;
	public ResultType searchKey(TreeNode root, int key){
		if(root.val == key){
			return root;
		}
		if(root.val < key){
			return searchKey(root.right, key);
		}
		if(root.val > key){
			return searchKey(root.left, key);
		}
		return null;
	}

}
