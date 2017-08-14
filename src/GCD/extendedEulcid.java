/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GCD;

/**
 *
 * @author Amman
 */
public class extendedEulcid {
    static int gcd = 1, x = 1, y = 1;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Extended(16, 10);
        
        System.out.println("gcd = " + gcd);
        System.out.println("X = " + x);
        System.out.println("Y = " + y);
    }

    public static void Extended(int a, int b) {
        
        if (b == 0) {
            gcd = a;
            x = 1;
            y = 0;
        } else {
            Extended(b, a % b);
            int temp = x;
            x = y;
            y = temp - (a / b) * y;
        }
    }
}
