/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

import java.util.Scanner;

/**
 *
 * @author Abdulrahman
 */
public class napsack_problem {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        //initializing the items
        Item[] items = new Item[5];
        items[0] = new Item(0, 0);
        items[1] = new Item(2, 12);
        items[2] = new Item(1, 10);
        items[3] = new Item(3, 20);
        items[4] = new Item(2, 15);

        //The maximum weight allowed
        System.out.print("Enter the maximum Weight? ");
        int k = input.nextInt();

        //the array that carry the values of x: item , y: weight
        int f[][] = new int[items.length][k + 1];

        for (int i = 1; i < f.length; i++) {
            for (int j = 1; j < f[i].length; j++) {
                //check if we could take the element or not
                if (j - items[i].getWeigth() >= 0) {//we can take the element
                    f[i][j] = (int) Math.max(f[i - 1][j], items[i].getValue() + f[i - 1][j - items[i].getWeigth()]);
                } else {//no space for that element
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        System.out.printf("For Weight %d :\n\tthe maximum value to take is: %d$.\n", k, f[items.length - 1][k]);
    }

}

class Item {

    private int weigth;
    private double value;

    public Item(int w, double v) {
        this.weigth = w;
        this.value = v;
    }

    public int getWeigth() {
        return weigth;
    }

    public double getValue() {
        return value;
    }

}
