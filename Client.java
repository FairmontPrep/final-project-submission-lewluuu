import java.util.ArrayList;
import java.util.Arrays;

public class Client{
    static ArrayList<ArrayList<Integer>> A = new ArrayList<>(Arrays.asList(
        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1 )),
        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1 )),
        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1)),
        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1 )),
        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1 )),
        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1 )),
        new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0, 1 )),
        new ArrayList<>(Arrays.asList(0, 1, 1, 1, 1, 1, 1, 1, 1 ))
    ));

    public static void main(String[] args) {
        ArrayList<String> path = findPath();
        System.out.println(path);
        printPathMap(path);
    }

    public static ArrayList<String> findPath() {
        int rows = A.size();
        int cols = A.get(0).size();
        boolean[][] visited = new boolean[rows][cols];
        ArrayList<String> path = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A.get(i).get(j) == 1 && dfs(i, j, visited, path)) {
                    return path;
                }
            }
        }
        return path;
    }

    private static boolean dfs(int i, int j, boolean[][] visited, ArrayList<String> path) {
        if (i < 0 || i >= A.size() || j < 0 || j >= A.get(0).size()) return false;
        if (visited[i][j] || A.get(i).get(j) != 1) return false;

        visited[i][j] = true;
        path.add("A[" + i + "][" + j + "]");

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];
            if (dfs(ni, nj, visited, path)) return true;
        }
        return true;
    }

    public static void printPathMap(ArrayList<String> path) {
        for (int i = 0; i < A.size(); i++) {
            for (int j = 0; j < A.get(0).size(); j++) {
                if (path.contains("A[" + i + "][" + j + "]")) {
                    System.out.printf("%2s", "1");
                } else {
                    System.out.printf("%2s", " ");
                }
            }
            System.out.println();
        }
    }
}