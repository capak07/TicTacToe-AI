package tictactoe;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final String[][] grid = {
            {" ", " ", " "},
            {" ", " ", " "},
            {" ", " ", " "}
    };

    public static void check(String[][] grid) {
        if ((grid[0][0].equals(grid[0][1]) && grid[0][0].equals(grid[0][2])) && !grid[0][0].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[0][0] + " wins");
            System.exit(0);
        } else if ((grid[1][0].equals(grid[1][1]) && grid[1][0].equals(grid[1][2])) && !grid[1][0].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[1][0] + " wins");
            System.exit(0);
        } else if ((grid[2][0].equals(grid[2][1]) && grid[2][0].equals(grid[2][2])) && !grid[2][0].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[2][0] + " wins");
            System.exit(0);
        } else if ((grid[0][0].equals(grid[1][0]) && grid[0][0].equals(grid[2][0])) && !grid[0][0].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[0][0] + " wins");
            System.exit(0);
        } else if ((grid[0][1].equals(grid[1][1]) && grid[0][1].equals(grid[2][1])) && !grid[0][1].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[0][1] + " wins");
            System.exit(0);
        } else if ((grid[0][2].equals(grid[1][2]) && grid[0][2].equals(grid[2][2])) && !grid[0][2].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[0][2] + " wins");
            System.exit(0);
        } else if ((grid[0][0].equals(grid[1][1]) && grid[0][0].equals(grid[2][2])) && !grid[0][0].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[0][0] + " wins");
            System.exit(0);
        } else if ((grid[0][2].equals(grid[1][1]) && grid[0][2].equals(grid[2][0])) && !grid[0][2].equals(" ")) {
            displayGrid(grid);
            System.out.println(grid[0][2] + " wins");
            System.exit(0);
        } else if (!grid[0][0].equals(" ") && !grid[0][1].equals(" ") && !grid[0][2].equals(" ") && !grid[1][0].equals(" ") && !grid[1][1].equals(" ") && !grid[1][2].equals(" ") && !grid[2][0].equals(" ") && !grid[2][1].equals(" ") && !grid[2][2].equals(" ")) {
            displayGrid(grid);
            System.out.println("Draw");
            System.exit(0);
        }
    }

    static final String[] stateOne = new String[]{"X", "X", " "};
    static final String[] stateTwo = new String[]{" ", "X", "X"};
    static final String[] stateThree = new String[]{"X", " ","X"};
    static final String[] AIStateOne = new String[]{"O","O"," "};
    static final String[] AIStateTwo = new String[]{" ","O","O"};
    static final String[] AIStateThree = new String[]{"O"," ","O"};

    public static String[] getRow(String[][] array,int rowNumber){
        String[] row = new String[3];
        int j = 0;
        while (j<array.length){
            row[j] = array[rowNumber][j];
            j++;
        }
        return row;
    }
    public static String[] getColumn(String[][] array,int columnNumber){
        String[] column = new String[3];
        for (int i=0;i<array.length;i++){
            column[i] = array[i][columnNumber];
        }
        return column;
    }

    public static String[] getFirstDiagonal(String[][] array){
        String[] diagonal = new String[3];
        diagonal[0] = array[0][0];
        diagonal[1] = array[1][1];
        diagonal[2] = array[2][2];

        return diagonal;
    }

    public static String[] getSecondDiagonal(String[][] array){
        String[] diagonal = new String[3];
        diagonal[0] = array[0][2];
        diagonal[1] = array[1][1];
        diagonal[2] = array[2][0];

        return diagonal;
    }

    public static void displayGrid(String[][] grid) {
        System.out.println("_________");
        System.out.println("| " + Main.grid[0][0] + " " + Main.grid[0][1] + " " + Main.grid[0][2] + " |");
        System.out.println("| " + Main.grid[1][0] + " " + Main.grid[1][1] + " " + Main.grid[1][2] + " |");
        System.out.println("| " + Main.grid[2][0] + " " + Main.grid[2][1] + " " + Main.grid[2][2] + " |");
        System.out.println("_________");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Input command: >");
            String userInput = scanner.nextLine();

            switch (userInput) {
                case "start easy easy":
                    while (true) {
                        displayGrid(grid);
                        AIFirstMove();
                        displayGrid(grid);
                        AINextMove();
                    }
                case "start user easy":
                    while (true) {
                        displayGrid(grid);
                        makeMove();
                        displayGrid(grid);
                        System.out.println("Making move level \"easy\" ");
                        AINextMove();
                    }
                case "start easy user":
                    while (true) {
                        displayGrid(grid);
                        AIFirstMove();
                        displayGrid(grid);
                        makeNextMove();
                    }
                case "start user user":
                    while (true) {
                        displayGrid(grid);
                        makeMove();
                        displayGrid(grid);
                        makeNextMove();
                    }
                case "start user medium":
                    while (true) {
                        displayGrid(grid);
                        makeMove();
                        displayGrid(grid);
                        MediumAINextMove();
                        displayGrid(grid);
                    }
                case "start medium user":
                    while (true) {
                        displayGrid(grid);
                        MediumAIMakeMove();
                        displayGrid(grid);
                        makeNextMove();
                        displayGrid(grid);
                    }
                case "exit":
                    System.exit(0);

                case "start user hard":
                    while (true){
                        displayGrid(grid);
                        makeMove();
                        displayGrid(grid);
                        AIHardNextMove();
                    }

                case "start hard user":
                    while (true){
                        displayGrid(grid);
                        AIHardMakeMove();
                        displayGrid(grid);
                        makeNextMove();
                        displayGrid(grid);
                    }
                default:
                    System.out.println("Bad parameters!");
                    break;
            }
        }
    }

    public static void AINextMove(){
        while (true){
            Random random = new Random();
            final int nextMoveX = random.nextInt(3);
            final int nextMoveY = random.nextInt(3);
            if (grid[nextMoveX][nextMoveY].equals(" ")){
                grid[nextMoveX][nextMoveY] = "O";
                check(grid);
                break;
            }
        }
    }
    public static void makeNextMove(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (grid[x-1][y-1].equals(" ")){
                grid[x-1][y-1] = "O";
                check(grid);
                break;
            }
            else {
                System.out.println("Cell is occupied!");
            }
        }
    }

    public static void makeMove(){
        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the coordinates:");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            if (grid[x-1][y-1].equals(" ")){
                grid[x-1][y-1] = "X";
                check(grid);
                break;
            }
            else {
                System.out.println("Cell is occupied!");
            }
        }
    }

    public static void AIFirstMove(){
        while (true){
            Random random = new Random();
            final int nextMoveX = random.nextInt(3);
            final int nextMoveY = random.nextInt(3);
            if (grid[nextMoveX][nextMoveY].equals(" ")){
                grid[nextMoveX][nextMoveY] = "X";
                check(grid);
                break;
            }
        }
    }

    public static void MediumAINextMove() {
        System.out.println("Making move level \"medium\"");
        int flag = 0;
        for (int i=0;i<3;i++){
            if (Arrays.deepEquals(getRow(grid, i),stateOne)) {
                if (grid[i][2].equals(" ")){
                    grid[i][2] = "O";
                    flag =1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getRow(grid, i),stateTwo)) {
                if (grid[i][0].equals(" ")){
                    grid[i][0] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getRow(grid, i), stateThree)) {
                if (grid[i][1].equals(" ")) {
                    grid[i][1] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getColumn(grid, i),stateOne)) {
                if (grid[1][i].equals(" ")){
                    grid[1][i] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getColumn(grid, i),stateTwo)) {
                if (grid[0][i].equals(" ")){
                    grid[0][i] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getColumn(grid, i),stateThree)) {
                if (grid[1][i].equals(" ")){
                    grid[1][i] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getFirstDiagonal(grid),stateOne)) {
                if (grid[2][2].equals(" ")){
                    grid[2][2] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getFirstDiagonal(grid),stateTwo)) {
                if (grid[0][0].equals(" ")){
                    grid[0][0] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getFirstDiagonal(grid),stateThree)) {
                if (grid[1][1].equals(" ")){
                    grid[1][1] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getSecondDiagonal(grid),stateOne)) {
                if (grid[2][0].equals(" ")){
                    grid[2][0] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getSecondDiagonal(grid),stateTwo)) {
                if (grid[0][2].equals(" ")){
                    grid[0][2] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getSecondDiagonal(grid),stateThree)) {
                if (grid[1][1].equals(" ")){
                    grid[1][1] = "O";
                    flag = 1;
                    check(grid);
                    break;
                }
            }
        }
        if (flag == 0){
            AINextMove();
        }
    }
    public static void MediumAIMakeMove(){
        System.out.println("Making move level \"medium\"");
        int flag = 0;
        for (int i=0;i<3;i++){
            if (Arrays.deepEquals(getRow(grid, i),AIStateOne)) {
                if (grid[i][2].equals(" ")){
                    grid[i][2] = "X";
                    flag =1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getRow(grid, i),AIStateTwo)) {
                if (grid[i][0].equals(" ")){
                    grid[i][0] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getRow(grid, i),AIStateThree)) {
                if (grid[i][1].equals(" ")) {
                    grid[i][1] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getColumn(grid, i),AIStateOne)) {
                if (grid[1][i].equals(" ")){
                    grid[1][i] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getColumn(grid, i),AIStateTwo)) {
                if (grid[0][i].equals(" ")){
                    grid[0][i] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getColumn(grid, i),AIStateThree)) {
                if (grid[1][i].equals(" ")){
                    grid[1][i] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getFirstDiagonal(grid),AIStateOne)) {
                if (grid[2][2].equals(" ")){
                    grid[2][2] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getFirstDiagonal(grid),AIStateTwo)) {
                if (grid[0][0].equals(" ")){
                    grid[0][0] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getFirstDiagonal(grid),AIStateThree)) {
                if (grid[1][1].equals(" ")){
                    grid[1][1] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getSecondDiagonal(grid),AIStateOne)) {
                if (grid[2][0].equals(" ")){
                    grid[2][0] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getSecondDiagonal(grid),AIStateTwo)) {
                if (grid[0][2].equals(" ")){
                    grid[0][2] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            } else if (Arrays.deepEquals(getSecondDiagonal(grid),AIStateThree)) {
                if (grid[1][1].equals(" ")){
                    grid[1][1] = "X";
                    flag = 1;
                    check(grid);
                    break;
                }
            }
        }
        if (flag == 0){
            AIFirstMove();
        }
    }

    public static Boolean isMovesLeft()
    {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (grid[i][j].equals(" "))
                    return true;
        return false;
    }


    public static int evaluate()
    {
        for (int row = 0; row < 3; row++)
        {
            if (grid[row][0].equals(grid[row][1]) &&
                    grid[row][1].equals(grid[row][2]))
            {
                if (grid[row][0].equals("X"))
                    return +10;
                else if (grid[row][0].equals("O"))
                    return -10;
            }
        }

        for (int col = 0; col < 3; col++)
        {
            if (grid[0][col].equals(grid[1][col]) &&
                    grid[1][col].equals(grid[2][col]))
            {
                if (grid[0][col].equals("X"))
                    return +10;

                else if (grid[0][col].equals("O"))
                    return -10;
            }
        }

        if (grid[0][0].equals(grid[1][1]) && grid[1][1].equals(grid[2][2]))
        {
            if (grid[0][0].equals("X"))
                return +10;
            else if (grid[0][0].equals("O"))
                return -10;
        }

        if (grid[0][2].equals(grid[1][1]) && grid[1][1].equals(grid[2][0]))
        {
            if (grid[0][2].equals("X"))
                return +10;
            else if (grid[0][2].equals("O"))
                return -10;
        }

        return 0;
    }
    


    public static void AIHardMakeMove(){
        System.out.println("Making move level \"hard\"");
        int x=0;
        int y=0;
        int score = 1000;
        for (int i=0;i<3;i++){
            for (int j=0;j<3;j++){
                if (grid[i][j].equals(" ")){
                    grid[i][j] = "O";
                    int bestScore = minimax(grid,0,true);
                    grid[i][j] = " ";
                    if (score>bestScore){
                        score = bestScore;
                        x=i;
                        y=j;
                    }
                }
            }
        }

        grid[x][y] = "X";
        check(grid);
    }

}