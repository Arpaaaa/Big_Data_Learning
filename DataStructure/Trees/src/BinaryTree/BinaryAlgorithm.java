package BinaryTree;

import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryAlgorithm {

    /**
     * 二叉树的前序遍历递归实现
     * @param T
     */
    public void preOrder(TreeNode T){
        TreeNode p = T;
        System.out.print(p.data +",");
        if (p.left!=null){
            preOrder(p.left);
        }
        if (p.right!=null){
            preOrder(p.right);
        }
    }

    /**
     * 前序遍历非递归实现
     * @param T
     */
    public void preOrder_nonrecursive(TreeNode T){
        Stack<TreeNode> s = new Stack<>();  //初始化栈
        TreeNode p = T;

        while (p!=null || !s.isEmpty()){
            if (p!=null){
                System.out.print(p.data);   //访问节点p
                s.push(p);  //将p入栈
                p=p.left;   //访问左孩子
            }else {
                p = s.pop();    //出栈并访问右孩子
                p = p.right;
            }
        }
    }

    /**
     * 二叉树的中序遍历递归实现
     * @param T
     */
    public void infixOrder(TreeNode T){
        TreeNode p = T;
        if (p.left!=null){
            infixOrder(p.left);     //访问左孩子
        }
        System.out.print(p.data + ",");     //访问p节点
        if (p.right!=null){
            infixOrder(p.right);   //访问右孩子
        }
    }

    /**
     * 二叉树的中序遍历非递归实现
     * @param T
     */
    public void infixOrder_nonrecursive(TreeNode T){
        //定义栈
        Stack<TreeNode> stack = new Stack<TreeNode>();
        //定义遍历变量
        TreeNode p = T;
        while (p!=null||!stack.isEmpty()){
            if (p!=null){
                stack.push(p);
                p = p.left;
            }else {
                p = stack.pop();
                System.out.print(p.data);
                p = p.right;
            }
        }
    }

    /**
     * 二叉树的后序遍历递归实现
     */
    public void postOrder(TreeNode p){
        if (p.left!=null){
            postOrder(p.left);  //如果有左孩子先访问左孩子
        }
        if (p.right!=null){
            postOrder(p.right); //如果有右孩子访问右孩子
        }
        System.out.print(p.data + ","); //如果左右孩子都或访问完就访问节点p
    }

    //后序遍历非递归实现
    //TODO:仍需要完善，解决bug
    public void postOrder_nonrecursive(TreeNode T){
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = T;
        while (p!=null || !s.isEmpty()){
            if (p!=null){
                s.push(p);
                p=p.left;
            }else {
                p = s.pop();
                p = p.right;
            }

        }
    }

    /**
     * 二叉树的层次遍历算法
     * @param p
     */
    public void levelOrder(TreeNode p){
        Queue<TreeNode> queue = new LinkedList<>();     //队列初始化
        queue.add(p);   //节点出队
        while (!queue.isEmpty()){
            TreeNode t = queue.poll();      //队头元素出队 t
            System.out.print(t.data);     //访问队头元素
            if (t.left!=null){queue.add(t.left);}      //将访问元素左孩子入队
            if (t.right!=null){queue.add(t.right);}     //将访问元素右孩子入队
        }
    }

    /**
     * 二叉树逆向层次遍历 从下到上，从右到左
     * @param p
     */
    public void levelOrder_reverse(TreeNode p){
        Queue<TreeNode> queue = new LinkedList<>();     //初始化队列
        Stack<TreeNode> stack = new Stack<>();      //初始化栈
        queue.add(p);       //节点出队
        while (!queue.isEmpty()){       //在队列非空的情况下
            TreeNode t = queue.poll();      //队头元素出队
            stack.push(t);          //将队头元素t压入栈
            if (t.left!=null){
                queue.add(t.left);      //将队头元素左孩子入队
            }
            if (t.right!=null){
                queue.add(t.right);     //将队头元素右孩子入队
            }
        }
        while (!stack.isEmpty()){       //遍历输出栈内节点实现逆向层次遍历
            System.out.print(stack.pop().data);
        }
    }

    /**
     * 计算二叉树的高度算法
     * @param T
     * @return height
     */
    public int postOrder_height(TreeNode T){
        int height = 0;     //初始化树高
        int left,right;     //初始化左子树和右子树高

        if (T ==null){
            return height;  //如果T是null，则直接返回height=0;
        }else {
            left = postOrder_height(T.left);    //计算左子树高度
            right = postOrder_height(T.right);  //计算右子树高度
            height = (left>right)?left:right +1;    //取左右子树高度较高者再+1
        }
        return height;
    }

    /**
     * 非递归实现二叉树高度的计算-层次遍历
     * @param T
     * @return height of binary tree
     */
    public int levelOrder_height(TreeNode T){
        if (T == null){return 0;}
        int front=-1,rear=-1;
        int last=0,level=0;
        TreeNode[] queue = new TreeNode[10];
        queue[++rear]=T;
        TreeNode p;
        while (front<rear){
            p=queue[++front];
            if (p.left!=null){
                queue[++rear]=p.left;   //左孩子入队
            }
            if (p.right!=null){
                queue[++rear]=p.right;  //右孩子入队
            }
            if (front==last){
                level++;    //如果front到每层最后一个元素，则层数++
                last = rear;    //last指向下一层
            }
        }
        return level;
    }
}
