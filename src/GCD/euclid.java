package GCD;

public class euclid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(eulid(6, 19));
    }

    public static int eulid(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return eulid(y, x % y);
        }
    }
}
