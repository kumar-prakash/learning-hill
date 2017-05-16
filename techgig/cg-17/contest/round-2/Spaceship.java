package pack;

import java.util.*;
public class Spaceship {
    static int[][] safetyArea;
    static int[][] hubArr;
    static List<Integer[]> validSections;
    static int minPerimeter = 0;

    public static void init(int[][] posArr, int rows, int cols) {
	validSections = new ArrayList<Integer[]>();
	safetyArea = new int[rows][cols];
	minPerimeter = Integer.MAX_VALUE;

	int x = 0;
	int uniqueLength = 0;
	for (int i[] : posArr) {
	    if (safetyArea[i[1] - 1][i[0] - 1] == 0)
		uniqueLength++;
	    safetyArea[i[1] - 1][i[0] - 1]++;
	}

	hubArr = new int[uniqueLength][2];
	for (int i = 0; i < safetyArea.length; i++) {
	    for (int j = 0; j < safetyArea[i].length; j++) {
		if (safetyArea[i][j] > 0) {
		    hubArr[x] = new int[] { i, j };
		    x++;
		}
	    }
	}
	// System.out.println("****" + uniqueLength);
	// printMat(hubArr);
    }

    public static int calculatePerimeter(int x1, int y1, int x2, int y2) {
	return ((x2 - x1 + 1) + (y2 - y1 + 1)) * 2;
    }

    public static int findNoOfHubsInSection(int x1, int y1, int x2, int y2) {
	int count = 0;
	for (int i = x1; i <= x2; i++) {
	    for (int j = y1; j <= y2; j++) {
		count += safetyArea[i][j];
	    }
	}
	return count;
    }

    public static boolean isOverlapping(Integer[] cord1, Integer[] cord2) {
	printArr(cord1);
	System.out.println("");
	printArr(cord2);
	System.out.println("");
	for(int i = cord1[0]; i <= cord1[2]; i++) {
	    for(int j = cord1[1]; j <= cord1[3]; j++) {
		if(i >= cord2[0] && i <= cord2[2] && j >= cord2[1] && j <=cord2[3]) {
		    System.out.println("found common for(" + i + ", " + j + ")");
		    return true;
		}
	    }
	}
	return false;
    }

    public static boolean isValidSetction(List<Integer[]> list, int k) {
	int minX = Integer.MAX_VALUE;
	int minY = Integer.MAX_VALUE;
	int maxX = Integer.MIN_VALUE;
	int maxY = Integer.MIN_VALUE;

	int totalHub = 0;
	for (Integer[] cord : list) {
	    totalHub += safetyArea[cord[0]][cord[1]];

	    if (minX > cord[0]) {
		minX = cord[0];
	    }
	    if (maxX < cord[0]) {
		maxX = cord[0];
	    }

	    if (minY > cord[1]) {
		minY = cord[1];
	    }
	    if (maxY < cord[1]) {
		maxY = cord[1];
	    }
	}
	if (totalHub != k)
	    return false;
	if (findNoOfHubsInSection(minX, minY, maxX, maxY) != k) {
	    return false;
	}

	validSections.add(new Integer[] { minX, minY, maxX, maxY });
	return true;
    }

    public static void findValidArea(List<Integer[]> list, int r, int index, ArrayList<Integer[]> cords, int count) {
	if (count == r) {
	    Integer[] cord1 = cords.get(0);
	    Integer[] cord2 = cords.get(1);
	    if (!isOverlapping(cord1, cord2)) {
		int perimeter = calculatePerimeter(cord1[0], cord1[1], cord1[2], cord1[3])
			+ calculatePerimeter(cord2[0], cord2[1], cord2[2], cord2[3]);
		if (perimeter < minPerimeter) {
		    minPerimeter = perimeter;
		}
	    }

	}
	for (int i = index; i < list.size(); i++) {
	    findValidArea(list, r, i + 1, copyList(cords, list.get(i)), count + 1);
	}
    }

    public static void findSubset(int[][] arr, int r, int index, ArrayList<Integer[]> cords) {
	if (isValidSetction(cords, r)) {
	    //printList(cords);
	}
	for (int i = index; i < arr.length; i++) {
	    findSubset(arr, r, i + 1, copyList(cords, arr[i]));
	}
    }

    public static ArrayList<Integer[]> copyList(ArrayList<Integer[]> cords, int[] cord) {
	ArrayList<Integer[]> newList = new ArrayList<Integer[]>();
	newList.addAll(cords);
	newList.add(new Integer[] { cord[0], cord[1] });
	return newList;
    }

    public static ArrayList<Integer[]> copyList(ArrayList<Integer[]> cords, Integer[] cord) {
	ArrayList<Integer[]> newList = new ArrayList<Integer[]>();
	newList.addAll(cords);
	newList.add(new Integer[] { cord[0], cord[1], cord[2], cord[3] });
	return newList;
    }

    public static void printMat(int[][] mat) {
	for (int i = 0; i < mat.length; i++) {
	    printArr(mat[i]);
	    System.out.println("");
	}
    }

    public static void printArr(int[] arr) {
	for (int j = 0; j < arr.length; j++) {
	    System.out.print(arr[j] + ", ");
	}
    }

    public static void printArr(Integer[] arr) {
	for (int j = 0; j < arr.length; j++) {
	    System.out.print(arr[j] + ", ");
	}
    }

    public static void printList(List<Integer[]> list) {
	for (Integer[] arr : list) {
	    printArr(arr);
	}
	System.out.println("");
    }

    public static int homesteadThatDefinesANewLivingPlanet(int length, int width, int n, int k, int[][] posArr) {
	init(posArr, width, length);
	//printMat(safetyArea);
	findSubset(hubArr, k, 0, new ArrayList<Integer[]>());
	findValidArea(validSections, 2, 0, new ArrayList<Integer[]>(), 0);

	return minPerimeter;
    }

    public static void main(String[] args) {
	System.out.println(homesteadThatDefinesANewLivingPlanet(6, 5, 7, 3,
		new int[][] { { 1, 1 }, { 3, 1 }, { 6, 1 }, { 3, 3 }, { 3, 4 }, { 5, 5 }, { 5, 5 } }));
	
	System.out.println(homesteadThatDefinesANewLivingPlanet(6, 5, 7, 3,
		new int[][] { { 1, 1 }, { 1, 1 }, { 1, 1 }, { 3, 3 }, { 3, 3 }, { 3, 3 }, { 5, 5 } }));
	
	System.out.println(homesteadThatDefinesANewLivingPlanet(6, 5, 6, 3,
		new int[][] { { 2,3}, { 2, 4 }, { 3,3 }, { 3, 4 }, { 3, 2 }, { 4, 2 }}));
    }
}
