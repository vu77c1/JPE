public class ExpressionValue {
    public static void main(String[] args) {
        // Expression (a)
        double resultA = (101.0 + 0) / 3;
        System.out.println("(101 + 0) / 3 -> " + resultA);

        // Expression (b)
        double resultB = 3.0e-6 * 10000000.1;
        System.out.println("(3.0e-6 * 10000000.1) -> " + resultB);

        // Expression (c)
        boolean resultC = true && true;
        System.out.println("(true && true) -> " + resultC);

        // Expression (d)
        boolean resultD = false && true;
        System.out.println("(false && true) -> " + resultD);

        // Expression (e)
        boolean resultE = (false && false) || (true && true);
        System.out.println("((false && false) || (true && true)) -> " + resultE);

        // Expression (f)
        boolean resultF = (false || false) && (true && true);
        System.out.println("(false || false) && (true && true) -> " + resultF);
    }
}
