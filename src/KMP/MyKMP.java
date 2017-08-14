/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package KMP;

import java.util.ArrayList;

/**
 *
 * @author Amman
 */
public class MyKMP {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int [] arr = Prefix("abcab");
        for(int i: arr){
            System.out.print(i+" ");
        }
        System.out.println("");
    }

    //here we find the prefixes of the pattern and save them to array
    static int[] Prefix(String pat) {
        int arr[] = new int[pat.length()];
        int j = 0;//this is to check the first and then move according to KMP algorithm
        for (int i = 1; i < pat.length(); i++) {
            char c = pat.charAt(i);
            while (j > 0 && c != pat.charAt(j)) {//this while to check if we got mismatch then we check the predeccesor
                j = arr[j - 1];
            }
            if (c == pat.charAt(j)) {
                j++;
            }
            arr[i] = j;
        }
        return arr;
    }

    static int IndexOf(String text, String pat) {
        int arr[] = Prefix(pat);
        int res = -1;
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            while (j > 0 && c != pat.charAt(j)) {
                j = arr[j - 1];
            }
            if (c == pat.charAt(j)) {
                j++;
            }
            //this is the only addition on KMP algorithm
            if (j == pat.length()) {
                res = i - j + 1;
                j = arr[j - 1];
            }

        }
        return res;
    }

    //we use this implementation if we have more than one match of pattern inside the TEXT
    static ArrayList<Integer> AllIndexOf(String text, String pat) {
        int arr[] = Prefix(pat);
        ArrayList<Integer> res = new ArrayList();
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            while (j > 0 && c != pat.charAt(j)) {
                j = arr[j - 1];
            }
            if (c == pat.charAt(j)) {
                j++;
            }
            //this is the only addition on KMP algorithm
            if (j == pat.length()) {
                res.add(i - j + 1);
                j = arr[j - 1];
            }

        }
        return res;
    }

}
