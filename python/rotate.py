#!/bin/env python3


def generate_matrix(N: int) -> list:
    """ Returns a 2D matrix with incrementing values along the rows and columns respectively """
    return [[i + (j * N) + 1 for i in range(N)] for j in range(N)]


def print_matrix(matrix: list) -> None:
    """ Prints a 2D matrix with column alignment to three digits """
    for row in matrix:
        print(" ".join("%03s" % i for i in row))
    print()


def turn_square_matrix(matrix: list, rotations: int) -> None:
    """ Rotates a 2D square matrix clockwise N times as specified by rotations """
    rotations = rotations % 4  # Avoids performing unnecessary rotations
    matrix_size = len(
        matrix
    )  # Get length of matrix. We are assuming the matrix is square
    for n in range(rotations):  # Perform N rotations
        for i in range(int(matrix_size / 2)):  # iterate over the number of shells
            # store matrix coordinates for readability
            top = i
            bottom = matrix_size - i - 1
            left = i
            right = matrix_size - i - 1

            # find the length of the perimeter shell walk
            shell_size = matrix_size - i * 2 - 1

            # iterate over the perimeter shell, performing 4 way swaps
            for j in range(int(shell_size)):
                temp = matrix[bottom - j][left]
                matrix[bottom - j][left] = matrix[bottom][right - j]
                matrix[bottom][right - j] = matrix[top + j][right]
                matrix[top + j][right] = matrix[top][left + j]
                matrix[top][left + j] = temp
