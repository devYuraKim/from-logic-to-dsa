// compile first with `javac CorrectionSimpleRecursion.java`
// then run with `java CorrectionSimpleRecursion`

class CorrectionSimpleRecursion {

    public static void main (String[] args) {

        System.out.println(fib(10));

    }

    public static int fib(int n) {

        if(n == 0 || n == 1) return 1;

        return fib(n-2) + fib(n-1);

    }

}