package DynamicProgramming;

import java.util.Scanner;

public class napsack_memorization {

    static Scanner input = new Scanner(System.in);
    static int F[][];
    static Item[] items;

    public static void main(String[] args) {
        //initializing the items
        items = new Item[5];
        items[0] = new Item(0, 0);
        items[1] = new Item(2, 12);
        items[2] = new Item(1, 10);
        items[3] = new Item(3, 20);
        items[4] = new Item(2, 15);

        //The maximum weight allowed
        System.out.print("Enter the maximum Weight? ");
        int k = input.nextInt();

        //the array that carry the values of x: item , y: weight
        F = new int[items.length][k + 1];

        //initialize F to -1
        for (int i = 1; i < F.length; i++) {
            for (int j = 1; j < F[i].length; j++) {
                F[i][j] = -1;
            }
        }

        System.out.printf("For Weight %d :\n\tthe maximum value to take is: %d$.\n", k, MFKnapsack(items.length - 1, k));
    }

    public static int MFKnapsack(int i, int j) {
        int value = 0;
        if (F[i][j] < 0) {
            if (j < items[i].getWeigth()) {
                value = MFKnapsack(i - 1, j);
            } else {
                value = Math.max(MFKnapsack(i - 1, j), (int) items[i].getValue() + MFKnapsack(i - 1, j - items[i].getWeigth()));
            }
        }else{
            value = F[i][j];   
        }
        F[i][j] = value;
        return F[i][j];
    }

}
