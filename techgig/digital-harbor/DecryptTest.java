package pack;

import java.util.ArrayList;
import java.util.List;

public class DecryptTest {
    static int maxLength = 0;
    static List<Character> alphabetes;
    static Character[] alphabetesArr;
    static int position = 0;
    
    static void init(String []arr) {
	alphabetes = new ArrayList<Character>();
	position = 0;
	for(String temp : arr) {
	    if(temp.length() > maxLength) {
		maxLength = temp.length();
	    }
	}
	extractAlphabetes(arr);
	alphabetesArr = alphabetes.toArray(new Character[alphabetes.size()]);
	sortAlphabets(arr);
    }
    
    public static void extractAlphabetes(String []arr) {
	for(String temp: arr) {
	    char cArr[] = temp.toCharArray();
	    for(int i = 0; i < cArr.length; i++) {
		if(!alphabetes.contains(cArr[i])) {
		    alphabetes.add(cArr[i]);
		}
	    }
	}
    }
    
    public static int findIndex(char c) {
	int index = -1;
	for(int i = 0; i < alphabetesArr.length; i++){
	    if(alphabetesArr[i] == c) {
		index = i;
		break;
	    }
	}
	    
	return index;
    }
    
    public static void swap(int index1, int index2) {
	char temp = alphabetesArr[index1];
	alphabetesArr[index1] = alphabetesArr[index2];
	alphabetesArr[index2] = temp;
    }
    
    public static void process(String str1, String str2, int index) {
	if(index == str1.length() || index == str2.length())
	    return;
	char char1 = str1.charAt(index);
	char char2 = str2.charAt(index);
	if(char1 != char2) {
	    int index1 = findIndex(char1);
	    int index2 = findIndex(char2);
	    if(index1 > index2) {
		swap(index1, index2);
	    }
	} else {
	    process(str1, str2, ++index);
	}
    }
    
    public static void sortAlphabets(String []arr) {
	for(int i = 0; i < arr.length; i++) {
	    for(int j = i; j < arr.length; j++) {
		process(arr[i], arr[j], 0);
	    }
	}
    }
    
    public static int compare(char char1, char char2) {
	int char1Index = findIndex(char1);
	int char2Index = findIndex(char2);
	if(char1Index == char2Index) {
	    return 0;
	}
	return char1Index > char2Index ? 1 : -1;
    }
    
    public static void findPosition(String[] arr, String s, int index) {
	for(int i = index; i < arr.length; i++) {
	    if(index >= arr[i].length() || index >= s.length()) {
		return;
	    }
	    int val = compare(arr[i].charAt(index), s.charAt(index));
	    if(val < 0) {
		position = i;
	    } else {
		findPosition(arr, s, ++index);
	    }
	}
    }
    
    public static int findDecryptPosition(String[] arr, String s) {
	init(arr);
	findPosition(arr, s, 0);
	print(alphabetesArr);
	return position;
    }
    
    public static void main(String[] args) {
	//System.out.println(findDecryptPosition(new String[] {"bbc", "bba", "ab", "ac", "aad"},  "bca"));
	//System.out.println(findDecryptPosition(new String[] {"ab", "ac", "aa"},  "bca"));
	//System.out.println(findDecryptPosition(new String[] {"abcd", "abca", "abcf"},  "bca"));
	//print(alphabetesArr);
	System.out.println(findDecryptPosition(new String[] {"abcd", "aba", "acf"},  "bca"));
    }
    
    static void print(Character [] arr) {
	for(int i = 0; i < arr.length; i++) {
	    System.out.print(arr[i] + ", ");
	}
    }
}
