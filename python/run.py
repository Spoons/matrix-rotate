import rotate

print("Original Matrix:")
array = rotate.generate_matrix(4)
rotate.print_matrix(array)
print("Rotated Matrix")
rotate.turn_square_matrix(array, 1)
rotate.print_matrix(array)
