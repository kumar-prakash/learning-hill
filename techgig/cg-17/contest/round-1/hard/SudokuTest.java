package pack;

import java.util.ArrayList;
import java.util.List;

public class SudokuTest {
	static int matrix[][] = null;
    static int size = 0;
    static int sqrt = 0;
    static int elmts = 0;
    static boolean isPossible = false;

    public static void init(int[][] mat) {
	matrix = mat;
	size = matrix.length;
	sqrt = (int) Math.sqrt(size);
	matrix[0][0] = 1;
	isPossible = false;
    }

    private static boolean containsInColumn(int[][] mat, int row, int num) {
	for (int i = 0; i < size; i++) {
	    if (mat[row][i] == num) {
		return true;
	    }
	}
	return false;
    }

    private static boolean containsInRow(int[][] mat, int col, int num) {
	for (int i = 0; i < size; i++) {
	    if (mat[i][col] == num) {
		return true;
	    }
	}
	return false;
    }

    private static boolean containsInSquare(int[][] mat, int i, int j, int num) {
	int minI = (i / sqrt) * sqrt;
	int maxI = minI + sqrt;
	int minJ = (j / sqrt) * sqrt;
	int maxJ = minJ + sqrt;
	for (int x = minI; x < maxI; x++) {
	    for (int y = minJ; y < maxJ; y++) {
		if (mat[x][y] == num) {
		    return true;
		}
	    }
	}
	return false;
    }

    public static List<Integer> findAvailableNumbers(int[][] mat, int i, int j) {
	List<Integer> list = new ArrayList<>();
	for (int x = 1; x <= size; x++) {
	    if (!containsInRow(mat, j, x) && !containsInColumn(mat, i, x) && !containsInSquare(mat, i, j, x)) {
		list.add(x);
	    }
	}
	return list;
    }

    public static int[] getNewLocation(int[][] mat, int i, int j) {
	int newI = (j == size - 1 ? i + 1 : i);
	int newJ = (j == size - 1 ? 0 : j + 1);
	if (newI == size || newJ == size) {
	    return null;
	}
	if (mat[newI][newJ] == 0) {
	    return new int[] { newI, newJ };
	} else {
	    return getNewLocation(mat, newI, newJ);
	}
    }

    public static boolean isAllSet() {
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		if (matrix[i][j] == 0) {
		    return false;
		}
	    }
	}
	return true;
    }

    public static int[][] copyArray(int[][] src) {
	int dest[][] = new int[src.length][src.length];
	for (int i = 0; i < src.length; i++) {
	    for (int j = 0; j < src.length; j++) {
		dest[i][j] = src[i][j];
	    }
	}
	return dest;
    }

    public static void swap(int x1, int y1, int x2, int y2, int[][] mat) {
	int temp = mat[x1][y1];
	mat[x1][y1] = mat[x2][y2];
	mat[x2][y2] = temp;
    }

    public static int[][] swapQuadrant(int startRow, int startCol, boolean isVertically) {
	int dest[][] = copyArray(matrix);
	if (isVertically) {
	    int midRow = startRow + sqrt;
	    for (int i = 0; i < sqrt; i++) {
		for (int j = 0; j < sqrt; j++) {
		    swap(startRow + i, startCol + j, midRow + i, startCol + j, dest);
		}
	    }
	} else {
	    int midCol = startCol + sqrt;
	    for (int i = 0; i < sqrt; i++) {
		for (int j = 0; j < sqrt; j++) {
		    swap(startRow + i, startCol + j, startRow + i, midCol + j, dest);
		}
	    }
	}
	return dest;
    }

    private static boolean hasDuplicateInRow(int row, int[][] mat) {
	for (int x = 1; x <= size; x++) {
	    int count = 0;
	    for (int i = 0; i < size; i++) {
		if (mat[row][i] == x) {
		    count++;
		}
		if (count > 1) {
		    // System.out.println("Duplicate found for number: " + x + "
		    // in row: " + row);
		    return true;
		}
	    }
	}

	return false;
    }

    private static boolean hasDuplicateInCol(int col, int[][] mat) {
	for (int x = 1; x <= size; x++) {
	    int count = 0;
	    for (int i = 0; i < size; i++) {
		if (mat[i][col] == x) {
		    count++;
		}
		if (count > 1) {
		    // System.out.println("Duplicate found for number: " + x + "
		    // in column: " + col);
		    return true;
		}
	    }
	}

	return false;
    }

    public static boolean checkCondition(int[][] mat) {
	for (int i = 0; i < size; i++) {
	    if (hasDuplicateInCol(i, mat)) {
		return false;
	    }
	    if (hasDuplicateInRow(i, mat)) {
		return false;
	    }
	}
	// System.out.println("Duplicate not found ");
	return true;
    }

    public static boolean swapAndCheckCondition(int[][] matrix) {
	int temp[][] = null;
	for (int i = 0; i + sqrt * 2 <= size; i = i + sqrt) {
	    for (int j = 0; j + sqrt * 2 <= size; j = j + sqrt) {
		// System.out.printf("Swaping (%d, %d) vertically\n", i, j);
		temp = swapQuadrant(i, j, true);
		// Util.printMatrixLine(temp);
		if (!checkCondition(temp)) {
		    return false;
		}
		// System.out.printf("Swaping (%d, %d) horizontally\n", i, j);
		temp = swapQuadrant(i, j, false);
		// Util.printMatrixLine(temp);
		if (!checkCondition(temp)) {
		    return false;
		}
	    }
	}
	return true;
    }

    public static boolean constructSquare(int[][] mat, int i, int j) {
	if(isPossible) {
	    return true;
	}
	List<Integer> list = findAvailableNumbers(mat, i, j);
	for (int x = 0; x < list.size(); x++) {
	    mat[i][j] = list.get(x);
	    int[] newLocation = getNewLocation(mat, i, j);
	    if (newLocation == null) {
		boolean result = swapAndCheckCondition(matrix);
		if (result) {
		    System.out.println("Eligible matrix is ");
		    Util.printMatrixLine(mat);
		    isPossible = true;
		    return true;
		}
	    } else {
		if (!constructSquare(mat, newLocation[0], newLocation[1])) {
		    mat[newLocation[0]][newLocation[1]] = 0;
		} 
	    }
	}
	return false;
    }

    public static boolean magicSquare(int[][] mat) {
	if (mat[0][0] > 1) {
	    return false;
	}
	if (mat.length == 1) {
	    return true;
	}
	init(mat);
	int[] newLocation = getNewLocation(mat, 0, 0);
	if(newLocation == null) {
	    isPossible = swapAndCheckCondition(mat);
	} else {
	    constructSquare(mat, newLocation[0], newLocation[1]);
	}
	return isPossible;
    }

    public static int[][] copyMatrix(int[][] mat) {
	int out[][] = new int[size][size];
	for (int i = 0; i < size; i++) {
	    for (int j = 0; j < size; j++) {
		out[i][j] = mat[i][j];
	    }
	}

	return out;
    }
}
