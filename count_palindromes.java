import java.util.*;
public class count_palindromes {
	
	public static void main(String[] args) { 
	      System.out.println(count_palindromes("helloelle"));
	   }

      public static int count_palindromes(String S) {
           if(S.equals("")) {
               return 0;
           }
           int count = 0;
           for(int start = 0; start < S.length(); start++) {
               for(int end = S.length(); end > start; end--) {
                  if(isPalindrome(S.substring(start, end))) {
                     count++;
                  }
               }
           }
            return count;
       }
   
       public static boolean isPalindrome(String s) {
           char[] charArray = s.toCharArray();
           StringBuilder sb = new StringBuilder(charArray.length);
           for(int i = charArray.length - 1; i >= 0; i--) {
               sb.append(charArray[i]);
           }
           return s.equals(sb.toString());
       }

   
}