/*
 * Code to find the maximum depth of a tree.
 * Author : Komal Soham Wadekar
 */


public class MaxTreeDepth {
	
	public int findDepth(TreeNode root){
		int ldepth = 0;
		int rdepth = 0;
		if(root==null){
			return 0;
		}else{
			ldepth = findDepth(root.left);
			rdepth = findDepth(root.right);
			
			if(ldepth>rdepth)
				return ldepth + 1;
			else
				return rdepth + 1;
		}
	}
	
	public static void main(String args[]){
		Tree tree = new Tree();
		tree.root = new TreeNode(1); 
        tree.root.left = new TreeNode(2); 
        tree.root.right = new TreeNode(3); 
        tree.root.left.left = new TreeNode(4); 
        tree.root.left.right = new TreeNode(5);
        tree.root.left.right.right = new TreeNode(8);
        
        MaxTreeDepth depth = new MaxTreeDepth();
        int tree_depth = depth.findDepth(tree.root);
		System.out.println("Depth of given tree is: "+tree_depth);
		
	}
	
}


class Tree{
	TreeNode root;
}

class TreeNode{
	int data;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int data){
		this.data = data;
		this.left = null;
		this.right = null;
	}
}
