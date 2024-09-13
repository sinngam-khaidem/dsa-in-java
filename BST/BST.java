import java.util.*;

public class BST {
    static class TreeNode{
        TreeNode left, right;
        int data;
        TreeNode(int data){
            this.left = this.right = null;
            this.data = data;
        }
        TreeNode(TreeNode left, int data, TreeNode right){
            this.left = left;
            this.right = right;
            this.data = data;
        }
    }
    static TreeNode createTree(){
        ArrayDeque<TreeNode> q = new ArrayDeque<TreeNode>();
        TreeNode root, p;
        int x;
        root = new TreeNode(0);
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter root value: ");
        root.data = sc.nextInt();
        q.add(root);
        while(!q.isEmpty()){
            p = q.remove();
            // System.out.println("Enter left child of "+p.data);
            x = sc.nextInt();
            if (x != -1){
                p.left = new TreeNode(x);
                q.add(p.left);
            }
            else{
                p.left = null;
            }
            // System.out.println("Enter right child of "+p.data);
            x = sc.nextInt();
            if (x != -1){
                p.right = new TreeNode(x);
                q.add(p.right);
            }
            else{
                p.right = null;
            }
        }
        sc.close();
        return root;
    }

    static void InOrder(TreeNode p){
        if(p != null){
            InOrder(p.left);
            System.out.print(p.data + " ");
            InOrder(p.right);
        }
    }

    static void LevelOrder(TreeNode root){
        TreeNode p;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(!q.isEmpty()){
            p = q.remove();
            System.out.print(p.data+" ");
            if(p.left != null){
                q.add(p.left);
            }
            if(p.right != null){
                q.add(p.right);
            }
        }
    }

    // Height of a Binary tree
    static int Height(TreeNode p){
        if(p == null){
            return -1;
        }
        int l = Height(p.left);
        int r = Height(p.right);
        return Math.max(l, r) + 1;
    }

    // Recursive Search
    static TreeNode RecursiveSearch(TreeNode p, int key){
        if(p==null){
            return null;
        }
        if(p.data < key)
            p = RecursiveSearch(p.right, key);
        else if(p.data > key)
            p = RecursiveSearch(p.left, key);
        return p;
    }

    // Non Recursive Search
    static TreeNode NonRecursiveSearch(TreeNode p, int key){
        return null;
    }
    
    // Find Min
    static TreeNode FindMin(TreeNode p){
        if(p==null)
            return null;
        if(p.left != null)
            return FindMin(p.left);
        return p;
    }

    // Find Max
    static TreeNode FindMax(TreeNode p){
        if(p==null)
            return null;
        if(p.right != null)
            return FindMax(p.right);
        return p;
    }

    // Inorder Predecessor
    static TreeNode InPre(TreeNode p){
        while(p!=null && p.right!=null)
            p = p.right;
        return p;
    }

    // Inorder Successor
    static TreeNode InSucc(TreeNode p){
        while(p!=null && p.left!=null)
            p = p.left;
        return p;
    }

    // LCA of a BST
    // TC: O(n) SC: O(n)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        if(root==p || root==q)
            return root;
        if(Math.max(p.data, q.data) < root.data)
            return lowestCommonAncestor(root.left, p, q);
        else if(Math.min(p.data, q.data) > root.data)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
    public static void main(String[] args){
        TreeNode root = createTree();
        System.out.print(InSucc(root.right).data);
        System.out.print("\n");
    }    
}
