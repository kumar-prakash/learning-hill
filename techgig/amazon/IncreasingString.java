package pack;

public class IncreasingString {
    private static String out = "";
    
    public static String compare(String s1, String s2) {
	if(s1.length() > s2.length()) 
	    return s1;
	if(s1.length() == s2.length()) {
	    return s1.compareTo(s2) > 0 ? s2 : s1; 
	}
	return s2;
    }
    
    public static void findSubSequence(String input, int index, String seq) {
	out = compare(out, seq);
	for(int i = index + 1; i < input.length(); i++) {
	    if(input.charAt(i) >= seq.charAt(seq.length() - 1)) {
		findSubSequence(input, i, seq + input.charAt(i));
	    }
	}
    }
    
    public static String findLongestSubstring(String s) {
	if(s == null || s.isEmpty()) {
	    return s;
	}
	out = "";
	for(int i = 0; i < s.length(); i++) {
	    findSubSequence(s, i, String.valueOf(s.charAt(i)));
	}
	return out;
    }
    
    public static void main(String[] args) {
	System.out.println(findLongestSubstring("abcbcbcd"));
	/*System.out.println(findLongestSubstring("edcbaf"));
	System.out.println(findLongestSubstring("edcbfa"));
	System.out.println(findLongestSubstring("fedcbafedcb"));
	System.out.println(findLongestSubstring("abcdefghijklmnopqrstuvwxyz"));*/
    }
}
