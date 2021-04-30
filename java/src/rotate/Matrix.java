package rotate;

/**
 * The matrix class contains turnSquareMatrix method and supporting methods.
 **/

class Matrix {
  /**
   * Prints the matrix with aligned columns.
   * @param array The matrix that is to be printed.
   * @return void
   */
  public static void printArray(int[][] array) {
    for (int[] x : array) {
      for (int y : x) {
        System.out.format("%3d", y);
      }
      System.out.println();
    }
  }

  /**
   * Generates a matrix that increments along the columns and rows.
   * @param N the width and height of the matrix to be generated
   * @return The generated matrix of NxN size
   */
  public static int[][] generateMatrix(int N) {
    int [][] array = new int[N][N];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < N; j++) {
        array[i][j] = (i*N)+j+1;
      }
    }
    return array;
  }

  /**
   * Takes an input matrix and rotates it in 90 degree increments clockwise. Can perform multiple rotations.
   * @param matrix The input matrix which will be modified.
   * @param rotations Number of times to perform the rotation.
   */
  public static void turnSquareMatrix(int [][] matrix, int rotations) {
    rotations = rotations % 4; //Avoid performing unnecessary rotations
    int matrix_size = matrix.length;

    for (int n = 0; n < rotations; n++) { //number of rotations to perform
      for (int i = 0; i < matrix_size/2; i++) { //iterates over the total number of shell (N/2)
        //store matrix coordinates for convenience
        int top = i;
        int bottom = matrix_size - i - 1;
        int left = i;
        int right = matrix_size -i - 1;

        // calculate shell length
        int shell_size = matrix_size - i * 2 - 1;

        // iterate over the legth of the shell
        for (int j = 0; j < shell_size; j++) {
          // perform a four way element swap
          int temp = matrix[bottom-j][left];
          matrix[bottom-j][left] = matrix[bottom][right-j];
          matrix[bottom][right-j] = matrix[top+j][right];
          matrix[top+j][right] = matrix[top][left+j];
          matrix[top][left + j] = temp;
        }
      }
    }
  }
}
