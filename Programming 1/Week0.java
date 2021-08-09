import java.util.Scanner;
public class Week0 {
    public static void main(String[] args) {
        ex0();
        ex1();
        ex2();
        ex3();
        q1();
        q2();
        q3();
        q4();
    }

    static void ex0() {
        Scanner numbers = new Scanner(System.in);

        System.out.println("Input two numbers:");

        int firstNum = numbers.nextInt();
        int secondNum = numbers.nextInt();

        if (firstNum > secondNum) {
            System.out.println(firstNum);
        }
        else if (firstNum < secondNum) {
            System.out.println(secondNum);
        }
        else {
            System.out.println("The numbers are equal!");
        }
    }

    static void ex1() {
        Scanner grades = new Scanner(System.in);

        System.out.println("Input your grade: ");

        double studentGrade = grades.nextDouble();

        if (studentGrade >= 80) {
            System.out.println("HD");
        }
        else if (studentGrade >= 70) {
            System.out.println("DI");
        }
        else if (studentGrade >= 60) {
            System.out.println("CR");
        }
        else if (studentGrade >= 50){
            System.out.println("PA");
        }
        else {
            System.out.println("NN");
        }
    }

    static void ex2() {
        Scanner value = new Scanner(System.in);

        System.out.println("Input three values: ");

        int a = value.nextInt();
        int b = value.nextInt();
        int c = value.nextInt();

        if (a+b>c && a+c>b && b+c>a) {
            System.out.println("Valid values of a triangle");
        }
        else {
            System.out.println("Invalid values");
        }
    }

    static void ex3() {
        Scanner letters = new Scanner(System.in);

        System.out.println("Input a character: ");

        char letter = letters.next().charAt(0);

        if (letter == 'm') {
            System.out.println("Monday");
        }
        else if (letter == 't') {
            System.out.println("Tuesday");
        }
        else if (letter == 'h') {
            System.out.println("Thursday");
        }
        else if (letter == 's') {
            System.out.println("Sunday");
        }
        else if (letter == 'a') {
            System.out.println("Saturday");
        }
        else {
            System.out.println("Invalid");
        }
    }

    static void q1() {
        for (int i = 0; i<10; i++) {
            System.out.println(i+1);
        }
    }

    static void q2() {
        int i = 1;
        int sum = 0;
        while (i <= 10) {
            sum += i;
            i++;
        }
        System.out.println(sum);
    }

    static void q3() {
        Scanner num = new Scanner(System.in);
        System.out.println("Which positive integer do you want to know the multiplication table?");

        int a = num.nextInt();
        for (int i = 0; i<=10; i++) {
            System.out.println(a + "*" + i + "=" + a*i);
        }
    }

    static void q4() {
        Scanner num = new Scanner(System.in);
        System.out.println("Input a number to know its factorial value: ");

        int a = num.nextInt();
        int i = 1;
        int factorial = 1;

        while (i<=a){
            factorial *= i;
            i++;
            System.out.println(factorial);
        }
    }
}
