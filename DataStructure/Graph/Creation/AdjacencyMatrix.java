package Graph.Creation;

public class AdjacencyMatrix {
    public static void main(String[] args) {

    }

    public Graph createGraph(){
        //创建节点
        Vertex v1 = new Vertex('0');
        Vertex v2 = new Vertex('1');
        Vertex v3 = new Vertex('2');
        Vertex v4 = new Vertex('3');

        //创建边
        Edge e1 = new Edge(1);
        Edge e2 = new Edge(0);
        Edge e3 = new Edge(0);
        Edge e4 = new Edge(1);

        //创建图
        Graph graph = new Graph();
        graph.numVertexes = 4;
        graph.numEdges = 4;

        graph.vexs = new Vertex[]{v1, v2, v3, v4};
        graph.arc = new Edge[graph.numVertexes][graph.numVertexes];

        //手动创建矩阵
        graph.arc[0][1] = e1;
        graph.arc[1][0] = graph.arc[0][1];

        graph.arc[1][2] = e2;
        graph.arc[2][3] = e3;
        graph.arc[3][4] = e4;

        return graph;
    }

}

class Vertex{
    public char num;    //节点的序号
    public Vertex(){}
    public Vertex(char data){
        this.num = data;
    }
}

class Edge{
    public int pow;     //路径的权
    public Edge(){}
    public Edge(int pow){
        this.pow = pow;
    }
}

class Graph{
    private static final int MAXVEX=100;      //图中最大节点数
    private static final int INFINITY = 65535;    //无穷大小

    public int getMaxvex(){
        return MAXVEX;
    }
    public int getInfinity(){
        return INFINITY;
    }
    Vertex vexs[] = new Vertex[getMaxvex()];    //节点
    Edge arc[][] = new Edge[getMaxvex()][getMaxvex()];      //矩阵
    int numVertexes,numEdges;       //图中节点和边的个数

}