import java.util.*;

public class Week3 {
    public static void main(String[] args) {
        int[] ar = createArr();
        printArr(ar);

        int index_min;
        index_min = getIndexMin(ar);
        System.out.println("the index of the min value is " + index_min);

        int ind_min_from = getIndexMinFrom(ar, 5);
        System.out.println("The index of min value from position 5 is " + ind_min_from);

        ar = exchangeMinFrom(ar, 3);
        printArr(ar);

        ar = sortBySelection(ar);
        printArr(ar);

        ticTacToe();
    }

    public static void printArr(int[] arr) {
        for (int i =0; i<arr.length; i++) {
            System.out.printf("%3d", arr[i]);
        }
        System.out.println();
    }

    public static int[] createArr() {
        // ask the users to enter a number
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int N = sc.nextInt();
        // create an array with length N
        int[] arr = new int[N];
        // random assign value for each item in the array
        for (int i = 0; i<N; i++) {
            arr[i] = (int)(Math.random()*(N+1));
        }
        // return the result
       return arr;
    }

    public static int getIndexMin(int[] arr) {
        int index_min;

        // sentinel technique
        index_min = 0;
        for (int i = 0; i<arr.length; i++) {
            if (arr[i] < arr[index_min]) {
                index_min = i;
            }
        }
        return index_min;
    }

    public static int getIndexMinFrom(int[] arr, int pos) {
        int ind_min;
        ind_min = pos;
        for (int i=pos; i<arr.length; i++) {
            if (arr[i] < arr[ind_min]) {
                ind_min = i;
            }
        }
        return ind_min;
    }

    public static int[] exchangeMinFrom(int[] arr, int pos) {
        // get the index of the min value from position
        int ind_min_from = getIndexMinFrom(arr, pos);

        // exchange two values: arr[pos] and arr[ind_min_from]
        int temp;
        temp = arr[pos];
        arr[pos] = arr[ind_min_from];
        arr[ind_min_from] = temp;

        return arr;

    }

    public static int[] sortBySelection(int[] array) {
        // create a loop with an i increased i.e i++
        for (int i = 0; i< array.length; i++) {
            exchangeMinFrom(array, i); // call the exchangeMinFrom to sort the array as i increases
        }
        // return the sorted array
        return array;
    }

    // tic tac toe game but it's unfinished
    // cre: https://www.youtube.com/watch?v=gQb3dE-y1S4 (Alex Lee)
    static ArrayList<Integer> playerPosition = new ArrayList<Integer>();
    static ArrayList<Integer> cpuPosition = new ArrayList<Integer>();

    public static void ticTacToe() {
        char[][] game = {{' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '}};

        printGame(game);
        while (true) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Enter a position (1-9): ");
            int playerPos = scan.nextInt();
            while (playerPosition.contains(playerPos) || cpuPosition.contains(playerPos)) {
                System.out.println("Position taken");
                playerPos = scan.nextInt();
            }

            placePieces(game, playerPos, "player");

            String result = checkWinner();
            System.out.println(result);
            if (result.length() > 0) {
                System.out.println(result);
                break;
            }

            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPosition.contains(cpuPos) || cpuPosition.contains(cpuPos)) {
                cpuPos = random.nextInt(9) + 1;
            }
            placePieces(game, cpuPos, "cpu");

            printGame(game);
            result = checkWinner();
            if (result.length() > 0){
                System.out.println(result);
                break;
            }
        }
    }

    public static void printGame(char[][] game) {
        for (char[] row : game) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePieces(char[][] game, int pos, String user) {
        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPosition.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPosition.add(pos);
        }

        switch (pos) {
            case 1 -> game[0][0] = symbol;
            case 2 -> game[0][2] = symbol;
            case 3 -> game[0][4] = symbol;
            case 4 -> game[2][0] = symbol;
            case 5 -> game[2][2] = symbol;
            case 6 -> game[2][4] = symbol;
            case 7 -> game[4][0] = symbol;
            case 8 -> game[4][2] = symbol;
            case 9 -> game[4][4] = symbol;
        }
    }

    public static String checkWinner() {
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 8);
        List rightCol = Arrays.asList(3, 6, 9);
        List cross1 = Arrays.asList(1, 5, 9);
        List cross2 = Arrays.asList(3, 5, 7);

        List<List> winning = new ArrayList<List>();
        winning.add(topRow);
        winning.add(midRow);
        winning.add(botRow);
        winning.add(leftCol);
        winning.add(midCol);
        winning.add(rightCol);
        winning.add(cross1);
        winning.add(cross2);

        for (List l : winning) {
            if (playerPosition.containsAll(l)) {
                return "Congrats you've won!!";
            } else if (cpuPosition.containsAll(l)) {
                return "CPU won sorry :(";
            } else if (playerPosition.size() + cpuPosition.size() == 9) {
                return "CAT";
            }
        }
        return " ";
    }
}

