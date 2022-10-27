package BinaryTree;

public class AlgoTest {
    /* 二叉树算法的测试类 */
    public static void main(String[] args) {
        //创建树节点
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);

        //创建二叉树
        t1.left=t2;
        t1.right=t3;
        t2.left=t4;
        t2.right=t5;
        t3.left=t6;
        t3.right=t7;

        System.out.println("--------Test--------");
        BinaryAlgorithm ba = new BinaryAlgorithm();

        //测试二叉树的后序非递归遍历算法
        ba.postOrder_nonrecursive(t1);

        //测试二叉树层次遍历

        //ba.levelOrder(t1);
        System.out.println();
        //测试二叉树逆向层次遍历
        //ba.levelOrder_reverse(t1);

        //测试二叉树的高度计算
        System.out.println(ba.levelOrder_height(t1));
    }
}
