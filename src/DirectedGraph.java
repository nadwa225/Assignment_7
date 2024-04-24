import java.util.Scanner;
public class DirectedGraph {
        public static void main(String[] args) {
            Scanner scan = new Scanner(System.in); // scanner class for user input
            System.out.println("enter matrix of size n: ");
            int n = scan.nextInt();

            int[][] matrix = new int[n][n];

            System.out.println("enter the elements: ");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = scan.nextInt();
                }
            }
            if (isDirectedGraph(matrix)) {
                System.out.println("is a directed graph");
            } else {
                System.out.println("is Not a directed graph");

            }
        }

        public static boolean isDirectedGraph(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < i; j++) {
                    if (matrix[i][j] != 0 && matrix[j][i] == 0) {
                        return false;

                    }
                }
            }
            return true;
        
        }
    }

