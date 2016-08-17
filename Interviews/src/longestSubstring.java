import java.util.HashSet;

public class longestSubstring {

	public static void main(String[] args) {
		System.out.println(longestStreak("dfklsa jfamdsklfm"));
	}
	
	public static int longestStreak(String str) {
		int longestStreak = 0;
		HashSet<Character> hs = new HashSet<Character>();
		for(int i = 0; i < str.length(); i++) {
			if(hs.contains(str.charAt(i))) {
				if(longestStreak < hs.size())
					longestStreak = hs.size();
				hs.clear();
			} else {
				hs.add(str.charAt(i));
			}
		}
		return longestStreak;
	}

}