package rotate;

import static rotate.Matrix.*;

public class Run {
    public static void main(String[] args) {
        int [][] matrix = generateMatrix(4);
        System.out.println("Original: ");
        printArray(matrix);
        System.out.println("Rotated: ");
        turnSquareMatrix(matrix,1);
        printArray(matrix);
    }

}
