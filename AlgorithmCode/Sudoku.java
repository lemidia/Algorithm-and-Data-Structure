import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sudoku {

    private static int sudokuMatrix[][];
    private static boolean skip[][];

    public static boolean isValidPlacement(int row, int col) {
        // Row inspection
        int value = sudokuMatrix[row][col];
        for (int i = 0; i < 9; i++) {
            if (i == col)
                continue;
            else if (sudokuMatrix[row][i] == value) {
                return false;
            }
        }

        // Column inspection
        for (int i = 0; i < 9; i++) {
            if (i == row)
                continue;
            else if (sudokuMatrix[i][col] == value) {
                return false;
            }
        }

        // 3x3 Small Grid inspection
        int baseRow = (row/3)*3;
        int baseCol = (col/3)*3;
        for (int i = baseRow; i < baseRow+3 ; i++) {
            for (int j = baseCol; j < baseCol+3 ; j++) {
                if (i == row && j == col)
                    continue;
                else if (sudokuMatrix[i][j] == value)
                    return false;
            }
        }
        return true;
    }

    public static boolean solve(int row, int col) {
        // Final Goal Case
        if (row == 9)
            return true;
            
        if (skip[row][col]) {
            if (col+1 != 9){
                if (solve(row, col+1))
                    return true;
            }
            else {
                if (solve(row+1, 0))
                    return true;
            }
        } else {
            for (int i = 1; i < 10; i++) {
                sudokuMatrix[row][col] = i;
                if (isValidPlacement(row, col)) {
                    if (col+1 != 9){
                        if (solve(row, col+1))
                            return true;
                    }
                    else {
                        if (solve(row+1, 0))
                            return true;
                    }
                }
            }
            sudokuMatrix[row][col] = 0;
        }

        return false;
    }

    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sudokuMatrix = new int[9][9];
        skip = new boolean[9][9];

        // Sample Input:
        // 3 0 6 5 0 8 4 0 0
        // 5 2 0 0 0 0 0 0 0
        // 0 8 7 0 0 0 0 3 1
        // 0 0 3 0 1 0 0 8 0
        // 9 0 0 8 6 3 0 0 5
        // 0 5 0 0 9 0 6 0 0
        // 1 3 0 0 0 0 2 5 0
        // 0 0 0 0 0 0 0 7 4
        // 0 0 5 2 0 6 3 0 0

        for (int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < 9; j++) {
                sudokuMatrix[i][j] = Integer.parseInt(st.nextToken());
                if (sudokuMatrix[i][j] > 0)
                    skip[i][j] = true;
            }
        }

        // Sample Output:
        // The Sudoku have been solved!
        //
        // 3 1 6 5 7 8 4 9 2
        // 5 2 9 1 3 4 7 6 8
        // 4 8 7 6 2 9 5 3 1
        // 2 6 3 4 1 5 9 8 7
        // 9 7 4 8 6 3 1 2 5
        // 8 5 1 7 9 2 6 4 3
        // 1 3 8 9 4 7 2 5 6
        // 6 9 2 3 5 1 8 7 4
        // 7 4 5 2 8 6 3 1 9

        if (solve(0, 0)){
            System.out.println("The Sudoku have been solved!" + "\n");
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    System.out.print(sudokuMatrix[i][j] + " ");
                }
                System.out.println();
            }
        }else {
            System.out.println("The Sudoku could not be solved!");
        }
    }
}
