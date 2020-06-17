牛牛很喜欢玩二叉树。这天牛能送给了他一个以1为根结点的{n}n个结点的二叉树，他想对这个二叉树进行一些加工。

牛牛刚刚学会转圈圈，所以很喜欢旋转。现在他想对这颗二叉树进行m次旋转。

每次旋转牛牛会指定一个结点，并让以这个结点为根的子树中的所有结点的左右儿子互换。

多次操作之后，牛牛希望以中序遍历的方式输出操作完之后的二叉树。

import java.util.*;


public class Solution {
    /**
     * 魔力转圈圈
     * @param n int整型 
     * @param m int整型 
     * @param l int整型一维数组 
     * @param r int整型一维数组 
     * @param k int整型一维数组 
     * @return int整型一维数组
     */
    public int[] solve (int n, int m, int[] l, int[] r, int[] k) {
        // write code here
        int[] times=new int[n+1];
        for(int i:k){
            times[i]++;
        }
        int[] ret=new int[n];
        swap(l,r,times,ret);
        return ret;
    }
    
    public void swap(int[] l,int[] r,int[]times,int[] ret){
        Stack<Integer> stack=new Stack<>();
        stack.push(1);
        while(!stack.isEmpty()){
            int i=stack.pop()-1;
            if(l[i]>0){
                times[l[i]]+=times[i+1];
                stack.push(l[i]);
            }
            if(r[i]>0){
                times[r[i]]+=times[i+1];
                stack.push(r[i]);
            }
            
            if((times[i+1]&1)==1){
                int tmp=l[i];
                l[i]=r[i];
                r[i]=tmp;
            }
        }
        
         boolean[] v=new boolean[l.length+1];
        stack.push(1);
        int j=0;
        int root=1;
        while(!stack.isEmpty()){
            root = stack.peek();
            if(!v[root] && l[root-1] > 0) {
                stack.push(l[root-1]);
                v[root] = true;
                continue;
            }
            stack.pop();
            ret[j++]=root;
            if (r[root-1] > 0) {
                stack.push(r[root-1]);
            }
        }
    }
}

