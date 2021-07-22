import java.util.Scanner;

public class Week1 {
    public static void main(String[] args) {
        ex1();
        ex2();
        ex3();
        ex4();
        ex5();
    }
    static void ex1() {
        // Create input obj
        Scanner sc = new Scanner(System.in);

        // Print out questions
        System.out.println("Your general information: ");

        // Read the input information
        String info = sc.nextLine();

        // Print out the pattern and the input information
        System.out.println("********************************");
        System.out.println("*                              *");
        System.out.println("**** " + info + " ****");
        System.out.println("*                              *");
        System.out.println("********************************");
    }

    static void ex2() {
        // Identify types for x and y
        int x, y;
        x = 40;
        y = 20;

        // Print out the result
        System.out.println("Before swapping: x = " + x + ", y = " + y);
        System.out.println("After swapping: x = " + y + ", y = " + x);

        /* another solution
        int x, y;
        Scanner input = new Scanner(System.in);

        System.out.println("Input value for x: ");
        x = input.nextInt();

        System.out.println("Input value for y: ");
        y = input.nextInt();

        System.out.println("int x = " + y);
        System.out.println("int y = " + x);
         */
    }

    static void ex3() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The current seconds since midnight is: ");

        // calculate the hour, minute and seconds
        int time = sc.nextInt();
        int second = time % 60;
        int hour = time / 3600;
        int minute = (time / 3600) /60;

        // print the result
        System.out.println(hour + ":" + minute + ":" +second);
    }

    static void ex4() {
        // create point obj
        Scanner sc = new Scanner(System.in);

        // ask user to input x and y
        System.out.println("xA: ");
        int xA = sc.nextInt();

        System.out.println("yA: ");
        int yA = sc.nextInt();

        System.out.println("xB: ");
        int xB = sc.nextInt();

        System.out.println("yB: ");
        int yB = sc.nextInt();

        // calculate AB, thus C and S of the square
        double AB = Math.sqrt(Math.pow((xB-xA), 2) + Math.pow((yB-yA), 2));
        double circumference = AB * 4;
        double area = AB * AB;

        // print the result
        System.out.println("The circumference: " + circumference);
        System.out.println("The area: " + area);
    }

    static void ex5() {
        Scanner sc = new Scanner(System.in);

        System.out.println("input x and y coordinates: ");
        int x = sc.nextInt();
        int y = sc.nextInt();

        System.out.println("input radius: ");
        int r = sc.nextInt();

        System.out.println("input x1 and y1 coordinates: ");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();

        System.out.println("input the second radius: ");
        int r1 = sc.nextInt();

        double distance = Math.sqrt(Math.pow((x1-x), 2) + Math.pow((y1-y), 2));

        if (r1-r<distance && distance<r1+r) {
            System.out.println("Two circles intersect.");
        }
        else {
            System.out.println("Two circles do not intersect");
        }
    }
}
