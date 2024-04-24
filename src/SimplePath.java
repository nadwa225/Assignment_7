import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SimplePath {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of vertices
        System.out.print("Enter the number of vertices: ");
        int numVertices = scanner.nextInt();


        int[][] adjacenctMatrix = new int[numVertices][numVertices];
        System.out.println("Enter the matrix:");
        for (int i = 0; i < numVertices; i++) {
            for (int j = 0; j < numVertices; j++) {
                adjacenctMatrix[i][j] = scanner.nextInt();
            }
        }
        // Input the starting and ending vertices
        System.out.print("Enter the starting vertex (u): ");
        int u = scanner.nextInt();
        System.out.print("Enter the ending vertex (w): ");
        int w = scanner.nextInt();

        List<List<Integer>> paths = findSimplePaths(adjacenctMatrix, u, w, 5);
        System.out.println("Simple paths from " + u + " to " + w + " with length 5:");
        for (List<Integer> path : paths) {
            System.out.println(path);
        }

    }
    // to find all the simple paths from u to w when given the length
    public static List<List<Integer>> findSimplePaths(int[][] graph, int u, int w, int length) {
        List<List<Integer>> paths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        currentPath.add(u);
        findSimplePathsHelper(graph, u, w, length - 1, currentPath, paths);
        return paths;
    }
    private static void findSimplePathsHelper(int[][] graph, int u, int w, int length, List<Integer> currentPath, List<List<Integer>> paths) {
        if (length == 0 && u == w) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }
        if (length <= 0) {
            return;
        }
        for (int v = 0; v < graph.length; v++) {
            if (graph[u][v] != 0 && !currentPath.contains(v)) {
                currentPath.add(v);
                findSimplePathsHelper(graph, v, w, length - 1, currentPath, paths);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }


}
