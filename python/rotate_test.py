import rotate


class TestMatrixRotation:
    def test_generate_matrix(self):
        assert rotate.generate_matrix(0) == []
        assert rotate.generate_matrix(1) == [[1]]
        assert rotate.generate_matrix(2) == [[1, 2], [3, 4]]
        assert rotate.generate_matrix(3) == [[1, 2, 3], [4, 5, 6], [7, 8, 9]]

    def test_print_matrix(self, capsys):
        arr = rotate.generate_matrix(2)
        rotate.print_matrix(arr)
        captured = capsys.readouterr()
        assert captured.out == "  1   2\n  3   4\n\n"

    def test_turn_square_matrix_N_0(self):
        arr = rotate.generate_matrix(0)
        rotate.turn_square_matrix(arr, 0)
        assert arr == []

    def test_turn_square_matrix_N_1(self):
        arr = rotate.generate_matrix(1)
        rotate.turn_square_matrix(arr, 1)
        assert arr == [[1]]

    def test_turn_square_matrix_N_2(self):
        arr = rotate.generate_matrix(2)
        rotate.turn_square_matrix(arr, 1)
        assert arr == [[3, 1], [4, 2]]

    def test_turn_square_matrix_N_3(self):
        arr = rotate.generate_matrix(3)
        rotate.turn_square_matrix(arr, 1)
        assert arr == [[7, 4, 1], [8, 5, 2], [9, 6, 3]]

    def test_turn_square_matrix_N_3_rotate_180(self):
        arr = rotate.generate_matrix(3)
        rotate.turn_square_matrix(arr, 2)
        assert arr == [[9, 8, 7], [6, 5, 4], [3, 2, 1]]

    def test_turn_square_matrix_N_3_rotate_270(self):
        arr = rotate.generate_matrix(3)
        rotate.turn_square_matrix(arr, 3)
        assert arr == [[3, 6, 9], [2, 5, 8], [1, 4, 7]]
