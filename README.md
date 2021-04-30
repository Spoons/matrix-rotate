# Rotation

The purpose of this software is to provide a method which can efficiently rotate
a 4X4 matrix.

## Usage
### Overview
`rotate.py` module and `rotate.Matrix` class provides three methods. They are as
follows:<br>
- Python: generate_matrix(N: int) -> list<br>
  Java: public static int[][] generateMatrix(int N)<br>
  - Returns a matrix with incrementing values along the rows and columns.
      Argument N defines the dimension of the matrix.
- Python: print_matrix(array: list)<br>
  Java:  public static int[][] generateMatrix(int N)<br>
    - Provides a pretty print of the matrix with the cell values right aligned.
- Python: turn_square_matrix(array: list, rotations: int) -> None<br>
  Java: public static void turnSquareMatrix(int [][] matrix, int rotations)<br>
    - Rotates the matrix clockwise in ninety degree increments. The number of
        rotations is specified by the rotations argument.

### Python
Activate the virtual environment and run the run.py module with `python3
run.py`<br>

Run the tests with `pytest`<br>
Test coverage with `coverage run -m pytest && coverage report`<br>


### Java
It is recommended to use your preferred Java IDE to build and run testing.
However, the example can be built with `javac rotate/Matrix.java
rotate/Run.java` and executed with `java rotate.Run` from within the `java/src`
directory.<br>

## Installation Requirements
### Python
1. Enter the `python` directory.
2. Create a Python3 virtual environment with `python3 -m venv venv/`
3. Activate virtual environment `source venv/bin/activate`
4. Install dependencies `pip install -r requirements.txt`

### Java
1. Ensure that you are running jdk8 and that junit4 is in your class path.

## Design

The turnSquareMatrix method performs an in-place transformation onto the
matrix passed to it as an argument. The turnSquareMatrix method works by performing a
four way element swap along perimeter shells of the matrix, stepping inward, until
the center is reached. If the N dimension of the matrix is odd then the central
element is not rotated.

The algorithm starts by swapping the four corners of the outer shell and moves
towards the opposing corners. This sequence is illustrated below:

```
Original Matrix:
1   2   3   4
5   6   7   8
9   10  11  12
13  14  15  16

Single Swap
13  2   3   1
5   6   7   8
9   10  11  12
16  14  15  4

Second Swap
13  9   3   1
5   6   7   2
15  10  11  12
16  14  8   4

...
...
...

Rotated Matrix
13  9   5   1
14  10  6   2
15  11  7   3
16  12  8   4
```

A single rotation is performed in O(N^2) time. The worst case performance occurs
during a 270 degree rotation, a rotation value of 3, and has an time complexity
of O(3N^2). This mathematically simplifies to O(N^2) complexity but will
effectively take triple the execution time.

An in-place transformation was chosen for two reasons. The first reason is that
Java is pass by value and Python is pass by reference. Both languages do not allow pointer
arithmetic similar to C. Thus, if an additional matrix is created in memory
during the runtime of the method, those values would need to be copied back to
matrix passed in as an argument. Additionally, you cannot perform the
transformation in less than O(N^2) complexity despite having additional memory space.


## Future Improvements

This method could be improved to have a worst case runtime of O(2N^2). This
would be done by detecting a 270 degree rotation, a rotation value of three, and
performing the four way rotations counterclockwise along the shell instead of
performing three sequential clockwise rotations.


## Alternative Solutions

Two other solutions were evaluated:<br>
1. A clockwise rotation can be performed by first transposing the matrix and
   then reversing each column. I choose to perform the in place rotation over
   this method because this requires two passes along the matrix.
2. You can iterate over the source matrix and copying the values into the
   destination matrix by swapping the row and column iterators and walking from
   the outside. `dest[y][x]=src[N-x-1][y]` Had the goal been to return a new
   matrix, this is the solution I would have taken.
