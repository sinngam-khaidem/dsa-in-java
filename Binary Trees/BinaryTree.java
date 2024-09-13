import java.util.*;

public class BinaryTree {
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

    public static void PreOrder(TreeNode p){
        if(p != null){
            System.out.print(p.data + " ");
            PreOrder(p.left);
            PreOrder(p.right);
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

    // FindMax
    static int FindMax(TreeNode p){
        if(p==null)
            return Integer.MIN_VALUE;
        int l = FindMax(p.left);
        int r = FindMax(p.right);
        int max = Math.max(l, r);
        if(p.data > max)
            return p.data;
        else
            return max;
    }

    // Find an element in a binary tree
    static boolean FindInBinaryTree(TreeNode p, int key){
        boolean l, r;
        if(p != null){
            l = FindInBinaryTree(p.left, key);
            r = FindInBinaryTree(p.right, key);
            if(l || r || p.data == key)
                return true;
            else
                return false;
        }
        return false;
    }

    // Diameter of a Binary Tree - O(n)
    public static int dfs(TreeNode p, int[] max){
        if(p==null)
            return -1;
        int l,r;
        l = dfs(p.left, max);
        r = dfs(p.right, max);
        max[0] = Math.max(l+r+2, max[0]);
        return 1 + Math.max(l,r);
    }
    public static int diameterOfBinaryTree(TreeNode root) {
        int[] res = new int[1];
        res[0] = 0;
        dfs(root, res);
        return res[0];
    }

    // Invert a binary tree
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        TreeNode p;
        p = root.left;
        root.left = root.right;
        root.right = p;
        return root;
    }
    // Is Same Tree?
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null){
            return true;
        }
        if(p==null && q!=null || p!=null && q==null){
            return false;
        }
        boolean l,r;
        l = isSameTree(p.left, q.left);
        r = isSameTree(p.right, q.right);
        if(l && r && p.data == q.data)
            return true;
        else
            return false;
    }

    public static void main(String[] args){
        TreeNode root = createTree();
        System.out.print(FindInBinaryTree(root, 100));
        System.out.print("\n");
    }    
}
