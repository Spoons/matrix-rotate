package rotate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixTests {

    private final PrintStream systemOut = System.out;
    private ByteArrayOutputStream testOut;

    @Before
    public void setUpOutput() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    private String getOutput() {
        return testOut.toString();
    }

    @After
    public void restoreSystemInputOutput() {
        System.setOut(systemOut);
    }

    @Test
    public void printArray() {
        final String outputCorrect =   "  1  2  3\n  4  5  6\n  7  8  9\n";
        int [][] matrix = Matrix.generateMatrix(3);
        Matrix.printArray(matrix);
        assertEquals(getOutput(),outputCorrect);
    }

    @Test
    public void generateMatrix() {
        int [][] matrixN1 = Matrix.generateMatrix(1);
        final int [][] matrixN1Correct = {{1}};
        assertArrayEquals(matrixN1, matrixN1Correct);

        int [][] matrixN2 = Matrix.generateMatrix(2);
        final int [][] matrixN2Correct = {{1,2},{3,4}};
        assertArrayEquals(matrixN2, matrixN2Correct);
    }

    @Test
    public void turnSquareMatrix() {
        int [][] matrix = Matrix.generateMatrix(3);
        Matrix.turnSquareMatrix(matrix, 1);
        final int [][] matrixCorrect = {{7,4,1},{8,5,2},{9,6,3}};
        assertArrayEquals(matrix, matrixCorrect);
    }
    @Test
    public void turnSquareMatrixBy180() {
        int [][] matrix = Matrix.generateMatrix(3);
        Matrix.turnSquareMatrix(matrix, 2);
        final int [][] matrixCorrect = {{9,8,7},{6,5,4},{3,2,1}};
        assertArrayEquals(matrix, matrixCorrect);
    }
    @Test
    public void turnSquareMatrixBy270() {
        int [][] matrix = Matrix.generateMatrix(3);
        Matrix.turnSquareMatrix(matrix, 3);
        final int [][] matrixCorrect = {{3,6,9},{2,5,8},{1,4,7}};
        assertArrayEquals(matrix, matrixCorrect);
    }
}