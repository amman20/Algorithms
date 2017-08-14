/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DynamicProgramming;

/**
 *
 * @author Abdulrahman
 *
 */
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
