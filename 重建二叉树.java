package 剑指金钱;

public class 重建二叉树 {

	public static void main(String[] args) {
		
		// 二叉树的先序序列
        int[] pre = { 1, 2, 4, 7, 3, 5, 6, 8 };
        // 二叉树的中序序列
        int[] in = { 4, 7, 2, 1, 5, 3, 8, 6 };
        
        TreeNode root = reConstructBinaryTree(pre, in);
        //后序打印
        printAfter(root);
        

	}
		/*
		 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
		 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
		 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
		 * 
		    思路：
		       先序遍历特点：第一个值是根节点
		       中序遍历特点：根节点左边都是左子树，右边都是右子树
	    	首先根据根节点1将中序遍历划分为两部分，左边为左子树，右边为右子树
	    	在左子树中根据先序中序特点递归，得出左子树
	    	在右子树中根据先序中序特点递归，得出右子树
	    	(先序确认根,中序确定左还是右)
    		最后合成一棵树 :
	 * 						1
	 * 					2		3
	 * 				4		  5    6
	 * 				   7         8
	 */
	 public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
		 if (pre == null || in == null || pre.length == 0 || in.length == 0 || pre.length != in.length) {
	            return null;
	        }
		 
		 //二叉树的根节点
		 TreeNode root = new TreeNode(pre[0]);
		 root.left=null;
		 root.right=null;
		 
		 //左子树的个数
		 int leftNum=0;
		 for (int i = 0; i < in.length; i++) {
			if(root.val==in[i]) {
				break;
			}
			leftNum++;
		}
		 //右子树的个数
		 int rightNum = in.length - 1 - leftNum;
		 
		 //重建左子树
		 if(leftNum>0) {
			 //左子树先序序列
			 int[] leftPre = new int[leftNum];
			 //左子树的中序序列
			 int[] leftIn= new int[leftNum];
			 for (int i = 0; i < leftNum; i++) {
				leftPre[i]=pre[i+1];
				leftIn[i]=in[i];
			}
			 TreeNode leftRoot = reConstructBinaryTree(leftPre, leftIn);//递归重构左子树
			 root.left=leftRoot;//连接
		 }
		 
		 //重建右子树
		 if(rightNum>0) {
			 //右子树先序序列
			 int[] rightPre = new int[rightNum];
			 //右子树的中序序列
			 int[] rightIn= new int[rightNum];
			 for (int i = 0; i < rightNum; i++) {
				rightPre[i]=pre[1+leftNum+i];
				rightIn[i]=in[leftNum+1+i];
			}
			 TreeNode rightRoot = reConstructBinaryTree(rightPre, rightIn);//递归重构右子树
			 root.right=rightRoot;
		 }
		 
		return root;
	        
	    }
	 
	 public static void printAfter(TreeNode root) {
		 if(root!=null) {
			 printAfter(root.left);
			 printAfter(root.right);
			 System.out.print(root.val+" ");
		 }
	 }

}

//Definition for binary tree.
class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
