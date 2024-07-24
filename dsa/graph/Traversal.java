package dsa.graph;

import java.util.*;
import java.util.stream.IntStream;

public class Traversal {
    public void inorder(Node root){
        if(root==null)
            return;
        inorder(root.left);
        System.out.println(root.data+", ");
        inorder(root.right);
    }

    public void preorder(Node root){
        if(root==null)
            return;
        System.out.println(root.data+", ");
        inorder(root.left);
        inorder(root.right);
    }

    public void postorder(Node root){
        if(root==null)
            return;

        inorder(root.left);
        inorder(root.right);
        System.out.println(root.data+", ");
    }

    public Node constructBtreeUsingPreorderInorderTraversal(int inorder[], int preorder[], int iStart, int iEnd, int n){
        if(n<=0)
            return null;
        Node root=new Node(preorder[0]);

        int idx=IntStream.rangeClosed(iStart, iEnd).filter(i -> preorder[0]==inorder[i]).findFirst().getAsInt();

        Set<Integer> set=new HashSet<>();
        IntStream.rangeClosed(iStart, idx).forEach(i -> set.add(inorder[i]));

        int lLevel[]=new int[set.size()];
        int rLevel[]=new int[iEnd-iStart- set.size()];
        int li=0, ri=0;
        for(int i=1;i<n;i++){
            if(set.contains(preorder[i]))
                lLevel[++li]=preorder[i];
            else
                rLevel[++ri]=preorder[i];
        }

        root.left=constructBtreeUsingPreorderInorderTraversal(inorder, lLevel, iStart, idx-1, idx-iStart);
        root.right=constructBtreeUsingPreorderInorderTraversal(inorder, rLevel, idx+1, iEnd, iEnd-idx);

        return root;
    }

    Map<Integer, Integer> levelOrderMap=new HashMap<>();

    public Node constructTree(int inOrder[], int levelOrder[]){
        int start = 0;
        int end = inOrder.length-1;
        constructLevelOrder(levelOrder);
        return constructBtree(inOrder, start, end);
    }
    private void constructLevelOrder(int levelOrder[]){
        IntStream.range(0, levelOrder.length).forEach(i -> levelOrderMap.put(levelOrder[i], i));
    }

    private Node constructBtree(int inorder[], int start, int end){
        if(start>end)
            return  null;

        int min_idx=start;
        for(int i=start+1;i<=end;i++){
            int temp = inorder[i];
            if(levelOrderMap.get(inorder[min_idx]) > levelOrderMap.get(temp))
                min_idx=i;
        }

        Node root = new Node(inorder[min_idx]);

        if(start==end)
            return root;

        root.left=constructBtree(inorder, start, min_idx-1);
        root.right=constructBtree(inorder, min_idx+1, end);

        return root;
    }

    public void print(Node root){
        Queue<Node> queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        int idx =0;
        double noOfElementAtEachLevel=Math.pow(2, level);
        while (!queue.isEmpty()){
            Node current = queue.poll();
            if(current!=null){
                System.out.print(current.data+"   ");
                queue.add(current.left);
                queue.add(current.right);
            }else{
                System.out.print("  ");
            }
            idx++;
            if(idx==noOfElementAtEachLevel){
                level++;
                noOfElementAtEachLevel=Math.pow(2, level);
                idx=0;
                System.out.println();
            }

        }
    }

    public static void main(String[] args) {
        int in[]    = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};
        Traversal tree=new Traversal();
        Node root =tree.constructTree(in, level);
        tree.print(root);
    }
}
