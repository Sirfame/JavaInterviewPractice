import java.util.*;
public class test {

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
       
       public static boolean validBrackets(String input) {
         Stack<Character> stack = new Stack<Character>();
         char[] charArray = input.toCharArray();
         for(int i = 0; i < charArray.length; i++) {
            if(charArray[i] == '(' || charArray[i] == '[' || charArray[i] == '{') {
               stack.push(charArray[i]);
            } else {
               if(stack.isEmpty())
                  return false;
               else if(charArray[i] == ')' && stack.peek() != '(')
                  return false;
               else if(charArray[i] == ']' && stack.peek() != '[')
                  return false;
               else if(charArray[i] == '}' && stack.peek() != '{')
                  return false;
               else
                  stack.pop();               
            }
         }
         return true;
       }

   public static void main(String[] args) { 
       System.out.println(validBrackets("()()()"));
       System.out.println(validBrackets("({[({[]})]})"));
       System.out.println(validBrackets("())())"));
       System.out.println(validBrackets("{}{}{{{}}}{}{}[]()"));

   }
}