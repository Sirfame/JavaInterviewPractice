import java.util.*;

public class DealingStrings {


  static final String valid = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  public static String randomString(int length){
    StringBuilder sb = new StringBuilder(length);
    for( int i = 0; i < length; i++ ) 
      sb.append( valid.charAt((int)(Math.random()*valid.length())));
    System.out.println(sb.toString());
    //System.out.println(myLength(sb.toString().toCharArray()));
    return sb.toString();
  }  
  
  static int myLength (char[] charArray) {
	  int index = 0;
	  for(char c : charArray) {
		  index++;
	  }
	  return index;
  }
  
  static int stringArrayLength (String[] stringArray) {
	  int index = 0;
	  for(String c : stringArray) {
		  index++;
	  }
	  return index;
  }
  
  static boolean hasDuplicate (String string) {
	  char[] charArray = string.toCharArray();
	  for(int i = 0; i < myLength(charArray); i++) {
		  for(int j = 0; j < myLength(charArray); j++) {
			  if(i != j && charArray[i] == charArray[j]) {
				  return true;
			  }
		  }
	  }
	  return false;
  } // hasDuplicate

  static String removeDuplicates (String string) {
	  if(hasDuplicate(string)) {
			boolean seen[] = new boolean[256];
			char charArray[] = string.toCharArray();
			StringBuilder sb = new StringBuilder(seen.length);
			
			for (int i = 0; i < myLength(charArray); i++) {
			    char ch = charArray[i];
			    if (!seen[ch]) {
			        seen[ch] = true;
			        sb.append(ch);
			    }
			}
			System.out.println("Removed: " + sb.toString());
			return sb.toString();

	  } else {
		  System.out.println("No duplicates: " + string);
		  return string;
	  }
	  
  }
  
  static boolean hasCharacter(String string, char c) {
	  char charArray[] = string.toCharArray();
	  for(char ch : charArray) {
		  if(ch == c) {
			  return true;
		  }
	  }
	  return false;
  }
  
  static String removeCharacter (String string, char c) {
	  if(hasCharacter(string, c)) {
		  char charArray[] = string.toCharArray();
		  StringBuilder sb = new StringBuilder(myLength(charArray));
		  for (int i = 0; i < myLength(charArray); i++) {
			    char ch = charArray[i];
			    if (ch != c) {
			    	sb.append(ch);
			    }
			}
			System.out.println("Character(" + c + ") removed: " + sb.toString());
			return sb.toString();
	  }
	  System.out.println("Did not contain that char: " + string);
	  return string;
  } // removeCharacter
  
  static boolean stringEquals (String first, String second) {
	  char firstArray[] = first.toCharArray();
	  char secondArray[] = second.toCharArray();
	  for(int i = 0; i < myLength(firstArray); i++) {
		  if(firstArray[i] != secondArray[i]) {
			  return false;
		  }
	  }
	  return true;
  } // isPalindrome

  static boolean isPalindrome (String string) {
	  char charArray[] = string.toCharArray();
	  StringBuilder backward = new StringBuilder(myLength(charArray));
	  for(int i = myLength(charArray) - 1; i >= 0; i--) {
		  backward.append(charArray[i]);
	  }
	  return stringEquals(string, backward.toString());
  } // isPalindrome

  static boolean isPalindromeString(String string) {
	  char charArray[] = string.toCharArray();
	  int end = myLength(charArray) - 1;
	  for(int i = 0; i < myLength(charArray) / 2; i++) {
		  if(charArray[i] != charArray[end]) {
			  return false;
		  }
		  end--;
	  }
	  return true;
  }
  
  static String reverseWithStringBuilder (String string) {
	  char charArray[] = string.toCharArray();
	  StringBuilder backward = new StringBuilder(myLength(charArray));
	  for(int i = myLength(charArray) - 1; i >= 0; i--) {
		  backward.append(charArray[i]);
	  }
	  return backward.toString();
  } // reverse 


  static String[] splitOnSpace(String string) {
	  char charArray[] = string.toCharArray();
	  int words = 1;
	  for(int i = 0; i < myLength(charArray); i++) {
		  if(charArray[i] == ' ') {
			  words++;
		  }
	  }
	  String stringArray[] = new String[words];
	  int stringArrayIndex = 0;
	  StringBuilder word = new StringBuilder(myLength(charArray));
	  for(int i = 0; i < myLength(charArray); i++) {
		  if(charArray[i] != ' ') {
			  word.append(charArray[i]);
		  } else if(charArray[i] == ' ') {
			  stringArray[stringArrayIndex] = word.toString();
			  stringArrayIndex++;
			  word = new StringBuilder(myLength(charArray));
		  }
		  if(i == myLength(charArray) - 1) {
			  stringArray[stringArrayIndex] = word.toString();
		  }
	  }
	  return stringArray;
  }

  public static String reverseWords(String string) {
	  String stringArray[] = splitOnSpace(string);
	  StringBuilder inOrder = new StringBuilder(stringArrayLength(stringArray));
	  for(int i = stringArrayLength(stringArray) - 1; i >= 0; i--) {
		  inOrder.append(stringArray[i]);
		  if(i != 0) {
			  inOrder.append(" ");
		  }		  
	  }
	  System.out.println(inOrder.toString());
	  return inOrder.toString();
 }

 public static String reverseWordByWord(String string){
	  String stringArray[] = splitOnSpace(string);
	  for(int i = 0; i < stringArrayLength(stringArray); i++) {
		  char charArray[] = stringArray[i].toCharArray();
		  StringBuilder sb = new StringBuilder(myLength(charArray));
		  for(int j = myLength(charArray) - 1; j >= 0; j--) {
			  sb.append(charArray[j]);
		  }
		  stringArray[i] = sb.toString();
	  }
	  StringBuilder word = new StringBuilder(stringArrayLength(stringArray));
	  for(int i = 0; i < stringArrayLength(stringArray); i++) {
		  word.append(stringArray[i]);
		  if(i != stringArrayLength(stringArray) - 1) {
			  word.append(" ");
		  }	
	  }
	  System.out.println(word.toString());
	 return word.toString();
  }  
  
  
  public static void main(String[] args) {
	  String random = randomString(20);
	  System.out.println(hasDuplicate(random));
	  String removed = removeDuplicates(random);
	  removeCharacter(removed, 'c');
	  String racecar = "racecar";
	  String not = "not";
	  String abba = "abba";
	  String abcd = "abcd";
	  System.out.println("Is " + racecar + " a palindrome: " + isPalindrome(racecar));
	  System.out.println("Is " + not + " a palindrome: " + isPalindrome(not));
	  System.out.println("Is " + abba + " a palindrome: " + isPalindrome(abba));
	  System.out.println("Is " + abcd + " a palindrome: " + isPalindrome(abcd));
	  System.out.println("Is " + racecar + " a palindrome: " + isPalindromeString(racecar));
	  System.out.println("Is " + not + " a palindrome: " + isPalindromeString(not));
	  System.out.println("Is " + abba + " a palindrome: " + isPalindromeString(abba));
	  System.out.println("Is " + abcd + " a palindrome: " + isPalindromeString(abcd));
	  
	  String t = "this is a test.";
	  System.out.println("String = " + t);

	  reverseWords("today is hot");
	  reverseWordByWord("today is hot");

 }
}