package Big_Data_Learning.DataStructure.Trees.src.BinaryTree;
import java.util.Stack;

public class TreeNode {
    //节点的值
    public int data;
    //节点左孩子
    public TreeNode left;
    //节点右孩子
    public TreeNode right;

    public TreeNode(int data){
        this.data = data;
    }

    /**
     * 二叉树的前序遍历递归实现
     */
    public void preOrder(){
        TreeNode p = this;
        System.out.print(p.data +",");
        if (p.left!=null){
            p.left.preOrder();
        }
        if (p.right!=null){
            p.right.preOrder();
        }
    }

    /**
     * 二叉树的中序遍历递归实现
     */
    public void infixOrder(){
        TreeNode p = this;
        if (p.left!=null){
            p.infixOrder();
        }
        System.out.print(p.data + ",");
        if (p.right!=null){
            p.right.infixOrder();
        }
    }

    //二叉树的中序遍历非递归实现
    public void infixOrder_nonrecursive(){
        //定义栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //定义遍历变量
        TreeNode p = this;
        while (p==null||!stack.isEmpty()){
            if (p){
                stack.push(p);
                p = p.left;
            }else {
                System.out.println(stack.pop().data);
                p = p.right;
            }
        }
    }

    /**
     * 二叉树的后序遍历递归实现
     */
    public void postOrder(){
        TreeNode p = this;
        if (p.left!=null){
            p.left.postOrder();
        }
        if (p.right!=null){
            p.right.postOrder();
        }
        System.out.print(p.data + ",");
    }

}




