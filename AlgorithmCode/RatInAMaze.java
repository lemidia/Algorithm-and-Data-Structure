public class RatInAMaze {

    public static boolean canMove(int r, int c, int n, int maze[][]) {
        return 0 <= r && r <= n-1 && 0 <= c && c <= n-1 && maze[r][c] != 0;
    }

    public static boolean solve(int r, int c, int n, int maze[][], int path[][]) {
        path[r][c] = 1;

        if (r == n-1 && c == n-1)
            return true;
        // Move to right
        if (canMove(r, c+1, n, maze)) {
            if (solve(r, c+1, n, maze, path)) {
                return true;
            }
        }

        // Move to Down
        if (canMove(r+1, c, n, maze)) {
            if (solve(r+1, c, n, maze, path)) {
                return true;
            }
        }

        path[r][c] = 0;
        return false;
    }

    public static void main(String[] args) {

        // Maze (n x n)
        // 1 : Can move
        // 0 : Wall(Can't move)
        // Start Point [0, 0]
        // Goal Point [n-1, n-1]


        int maze1[][] = {
                {1, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 0},
                {1, 1, 1, 0, 1, 1},
        };

        // Path indicates Available Path of Maze
        int path[][] = new int[maze1.length][maze1.length];

        if (solve(0, 0, maze1.length, maze1, path)) {
            System.out.println("Solved!" + "\n");
            System.out.println("Available Path is follow" + "\n");
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path[i].length; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Not Solved!" + "\n");
        }

        System.out.println("\n*****************\n");

        // Output:
        // Solved!
        //
        // Available Path is follow
        //
        // 1 1 0 0 0 0
        // 0 1 0 0 0 0
        // 0 1 0 0 0 0
        // 0 1 1 1 1 0
        // 0 0 0 0 1 0
        // 0 0 0 0 1 1

        int maze2[][] = {
                {1, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {1, 1, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1, 0},
                {1, 1, 1, 1, 0, 0},
        };

        // Path indicates Available Path of Maze
        path = new int[maze2.length][maze2.length];

        if (solve(0, 0, maze2.length, maze2, path)) {
            System.out.println("Solved!" + "\n");
            System.out.println("Available Path is follow" + "\n");
            for (int i = 0; i < path.length; i++) {
                for (int j = 0; j < path[i].length; j++) {
                    System.out.print(path[i][j] + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("Not Solved!" + "\n");
        }

        // Output:
        // Not Solved!
    }
}
