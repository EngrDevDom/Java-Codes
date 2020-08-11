package _402_Minimal_Tree;

import chapters.common.BinaryTreeNode;

public class MinimalTree {


     public static BinaryTreeNode createBST(int[] array){

         if(array == null) {
             return null;
         }

         return createBST(array, 0, array.length - 1);

     }

     private static BinaryTreeNode createBST(int[] array, int start, int end){

         if(start > end){
             return null;
         }

         int middle = (start + end)/2;
         BinaryTreeNode root = new BinaryTreeNode(array[middle]);
         root.left = createBST(array, start, middle - 1);
         root.right = createBST(array, middle + 1, end);
         return root;

     }
}
