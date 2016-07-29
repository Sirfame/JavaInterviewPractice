import java.util.*;
public class ValidateParens {

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