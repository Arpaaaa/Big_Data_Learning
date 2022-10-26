
public class TreeDefine {
    public static void main(String[] args) {

    }
}

class Node{
    private int data;   //节点的数值
    private int size;   //节点的孩子个数
    private Node parent;
    private Node firstChild;    //第一个孩子
    private Node nextSibling;   //下一个孩子

    public boolean isRoot(Node node){
        //if its parent is null then it is root otherwise not
        return parent == null;
    }
    public boolean isLeaf(Node node){
        //leaf has no children,if size == 0 which means number of children is zero
        return node.size == 0;
    }





    //constructor
    public Node(int data, int size,Node parent, Node firstChild, Node nextSibling) {
        this.data = data;
        this.size = size;
        this.parent = parent;
        this.firstChild = firstChild;
        this.nextSibling = nextSibling;
    }
    public Node() {
    }


    /**
     * 获取
     * @return data
     */
    public int getData() {
        return data;
    }

    /**
     * 设置
     * @param data
     */
    public void setData(int data) {
        this.data = data;
    }

    /**
     * 获取
     * @return firstChild
     */
    public Node getFirstChild() {
        return firstChild;
    }

    /**
     * 设置
     * @param firstChild
     */
    public void setFirstChild(Node firstChild) {
        this.firstChild = firstChild;
    }

    /**
     * 获取
     * @return nextSibling
     */
    public Node getNextSibling() {
        return nextSibling;
    }

    /**
     * 设置
     * @param nextSibling
     */
    public void setNextSibling(Node nextSibling) {
        this.nextSibling = nextSibling;
    }

    public String toString() {
        return "Node{data = " + data + ", size = " + size + ", parent = "+ parent + ", firstChild = " + firstChild + ", nextSibling = " + nextSibling + "}";
    }

    /**
     * 获取
     * @return size
     */
    public int getSize() {
        return size;
    }

    /**
     * 设置
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
}