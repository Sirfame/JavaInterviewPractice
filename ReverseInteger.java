public class ReverseInteger {

   public static int reverseInteger(int number) {
      int answer = 0;
      while(number > 0) {
         int temp = number % 10;
         answer *= 10;
         answer += temp;
         number /= 10;
      }
      return answer;
   }
   
   public static boolean isPrime(int number) {
      int dividedBy = number / 2;
      while(dividedBy > 1) {
         if(number % dividedBy == 0)
            return false;
         dividedBy--;
      }
      return true;
   }

   public static void main(String[] args) { 
       System.out.println(reverseInteger(14302429));
       System.out.println(isPrime(257));
   }
}