import java.util.Scanner;

public class Week2 {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
    }
    static void ex1() {
        System.out.println("Enter the length of a square' side: ");
        Scanner input = new Scanner(System.in);
        int length = input.nextInt();

        for (int i = 0; length >= i; i++) {
            for (int j = 0; length >= j; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void ex2() {
        System.out.println("Enter length: ");
        Scanner input = new Scanner(System.in);
        int n;
        n = input.nextInt();

        // print a square with n stars
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // draw * on the first and last line
                if (i == 0 || i == n-1) {
                    System.out.print("*");
                } else if (j == 0 || j == n-1) { // draw * on the first and last column in other line
                    System.out.print("*");
                } else { // draw space on other places
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void ex3() {
        System.out.println("Enter a positive integer: ");
        double n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextDouble();

        // Calculate the sqrt of n
        double min, max, avg;
        min = 1;
        max = n;

        do {
            avg = (min + max) / 2;
            if (avg * avg > n) {
                max = avg;
            }
            else {
                if (avg * avg < n) {
                    min = avg;
                } else {
                    break;
                }
            }
        } while (Math.abs(avg*avg-n) > 0.00000001);

        System.out.println("Square root of " +n + " is " + avg);
    }

    static void ex4() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the amount of money: ");
        double S;
        S = sc.nextDouble();

        // times the money with 100
        int s = (int) (S*100);
        int money = s / 3;
        int remainder = s % 3;

        if (remainder == 0) {
            System.out.printf("Each person has to pay %.2f", money/100.0);
        }
        else {
            System.out.printf("You have to pay %.2f and your friends pay %.2f", money/100.0, (money+1)/100.0);
        }
    }

    static void ex5() {
        // identify points and counts
        int counts = 0;
        int points = 1000000;

        // create a loop to calculate the points over and over again
        for (int i = 0; i < points; i++) {
            double x = Math.random() * 2 - 1;
            double y = Math.random() * 2 - 1;

            if (x * x + y * y <= 1) {
                counts++;
            }
        }
        System.out.printf("The approximate value of Pi is %f", counts*4.0/points);
    }
}
