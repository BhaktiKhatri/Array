package Array;

import java.util.HashMap;
import Array.TreeNode;

/**
 * Leetcode 106. Construct Binary Tree from Inorder and Postorder Traversal
 * https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/
 * https://www.youtube.com/watch?v=k2dvEJoHVEM
 * Given inorder and postorder traversal of a tree, construct the binary tree. Note:You may assume that duplicates do not exist in the tree.
 * @author NisuBhakti
 * Time Complexity: O(N); Space Complexity: O(N)
 *
 */
public class ConstructBinaryTreeFromInorderPostorderTraversal {

	public static TreeNode buildTreePostIn(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length)
			return null;
		HashMap<Integer, Integer> hm = new HashMap<Integer,Integer>();	//key-inorder elements, value-index
		for (int i=0;i<inorder.length;++i)
			hm.put(inorder[i], i);
		return buildTreePostIn(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1,hm);
	}

	public static TreeNode buildTreePostIn(int[] inorder, int is, int ie, int[] postorder, int ps, int pe, HashMap<Integer,Integer> hm) {
		if (ps>pe || is>ie) 
			return null;
		TreeNode root = new TreeNode(postorder[pe]);
		int ri = hm.get(postorder[pe]);
		int lpend = ps+ri-is-1;
		int rpstart = ps+ri-is;
		
		TreeNode leftchild = buildTreePostIn(inorder, is, ri-1, postorder, ps, lpend, hm);
		TreeNode rightchild = buildTreePostIn(inorder,ri+1, ie, postorder, rpstart, pe-1, hm);
		root.left = leftchild;
		root.right = rightchild;
		return root;
	}
	
	public static void main(String[] args) {
		int[] inorder = {10, 30, 40, 50, 60, 70, 90};
		int[] postorder = {10, 40, 30, 60, 90, 70, 50};
		TreeNode tnode = buildTreePostIn(inorder, postorder);
		System.out.println("root: "+tnode.val);
		System.out.println("root.left: "+tnode.left.val);
		System.out.println("root.right: "+tnode.right.val);
		System.out.println("root.left.left: "+tnode.left.left.val);
		System.out.println("root.left.right: "+tnode.left.right.val);
		System.out.println("root.right.left: "+tnode.right.left.val);
		System.out.println("root.right.right: "+tnode.right.right.val);
	}

}
