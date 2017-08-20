/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Coin_problems;

/**
 *
 * @author Abdulrahman
 */
public class CoinProblems {

    /**
     * @param args the command line arguments
     */
    //this is the input for geting max money for not adjacent C.
    static int[] C = {0, 5, 1, 2, 10, 6, 2};
    //the input for changeMaking
    static int[] changes = {0, 1, 3, 4};
    //this is the input for getting maximum value if move right and down only.
    static int[][] board = {};

    public static void main(String[] args) {
        //Geting max money for not adjacent C
//        System.out.println(MaxMoneyNotAdjacent());
        System.out.println(ChangeMaking(6));


    }

    public static int MaxMoneyNotAdjacent() {
        //initially all are zeros.
        int F[] = new int[7];
        //the first one has it is value only no previous one.
        //F[0] = 0 (no need in java)
        F[1] = C[1];
        for (int i = 2; i < F.length; i++) {
            //we take the value of the previous sum F[i-1] or the value of current coin C[i] plus the one before previous F[i-2].
            F[i] = Math.max(F[i - 1], C[i] + F[i - 2]);
        }

        return F[F.length - 1];
        //time complexity is O(n)
    }

    public static int ChangeMaking(int n) {
        //n is the amount fo find it minimum change
        int F[] = new int[n + 1];
        //F[0] = 0 because if the amount is zero we don't need any change

        //traverse all the coins
        for (int i = 1; i < n + 1; i++) {
            int temp = Integer.MAX_VALUE;
            int j = 1;
            //if j within the coins and the coin to add less or equal the amount
            while (j <= changes.length - 1 && changes[j] <= i) {
                temp = Math.min(temp, F[i - changes[j]]);
                j++;
            }
            F[i] = temp + 1;
        }
        return F[n];
        //time complexity is O(nm)
    }

}
