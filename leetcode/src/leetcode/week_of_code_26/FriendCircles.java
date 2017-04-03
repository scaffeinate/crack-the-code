package leetcode.week_of_code_26;

import java.util.Scanner;

import datastructures.disjointsets.DisjointSetWithPathCompression;

public class FriendCircles {

  public int findCircleNum(int[][] m) {
    DisjointSetWithPathCompression<Integer> disjointSets = new DisjointSetWithPathCompression<Integer>();

    for (int i = 0; i < m.length; i++) {
      if(m[i][i] == 1) {
        disjointSets.makeSet(i);
      }
    }

    for (int i = 0; i < m.length; i++) {
      for (int j = 0; j < m[0].length; j++) {
        if (m[i][j] == 1) {
          disjointSets.union(i, j);
        }
      }
    }
    
    return disjointSets.getDisjointSets().size();
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int[][] m = new int[][] {new int[]{1,1,0},
                 new int[]{1,1,1},
                 new int[]{0,1,1}};
    FriendCircles friendCircles = new FriendCircles();
    System.out.println(friendCircles.findCircleNum(m));
    in.close();
  }
}