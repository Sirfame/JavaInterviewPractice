
public class DealingNumbers {
	
	static final String valid = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	public static String randomString(int length) {
		StringBuilder sb = new StringBuilder(length);
	    for( int i = 0; i < length; i++ ) 
	    	sb.append( valid.charAt((int)(Math.random()*valid.length())));
	    return sb.toString();
	} // randomString (length); 
	
	public static int randomNumber(int start, int end) {
		if (start < end) {
			return ((int)(Math.random() * (end - start + 1) + start));
		} else {
			return ((int)(Math.random() * (start - end + 1) + end));
		}
	} // randomNumber (start, end)
	
//	Given a list of non negative integers, arrange them such that they form the largest number.
//	For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330. (Note: The result 
//	may be very large, so you need to return a string instead of an integer.)

	public static String largest (int [] integers) {
		for(int i = 0; i < intLength(integers) - 1; i++) {
			int x = integers[i];
			int y = integers[i + 1];
			StringBuilder sb1 = new StringBuilder(256);
			StringBuilder sb2 = new StringBuilder(256);
			int first = atoi(sb1.append(x).append(y).toString());
			int second = atoi(sb2.append(y).append(x).toString());
//			System.out.println("first: " + first);
//			System.out.println("second: " + second);
			if(first < second) {
				int placeHolder = integers[i];
				integers[i] = integers[i+1];
				integers[i+1] = placeHolder;
				i = -1;
			}			
		}
		StringBuilder sb = new StringBuilder(intLength(integers));
		for(int i = 0; i < intLength(integers); i++) {
			sb.append(integers[i]);
		}
		return sb.toString();
	}
	
	
//	Given an integer, this function returns a reversed integer of the input.  i.e. input = 123, output = 321
//	Hint: consider the range of the valid integer.	
		
	public static int reverseInteger (int integers) {
		int answer = 0;
		while(integers > 0) {
			int temp = integers % 10;
			answer *= 10;
			answer += temp;
			integers /= 10;			
		}		
		return answer;
	}
	
//	Convert string to integer

//	 Parses an input interpreting its content as an integral number, which is returned as a value of type int.
//
//	 The function first discards as many whitespace characters as necessary until the first non-whitespace 
//	 character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many 
//	 base-10 digits as possible, and interprets them as a numerical value.
//
//	 The string can contain additional characters after those that form the integral number, which are ignored and have no 
//	 effect on the behavior of this function.
//
//	 If the first sequence of non-whitespace characters in string is not a valid integral number, or if no such sequence exists 
//	 because either string is empty or it contains only whitespace characters, no conversion is performed and zero is returned.	
	
	
	public static int atoi (String string) {
		int i            = 0;
		boolean negative = false;
		char charArray[] = string.toCharArray();
		int index        = 0;
		while(charArray[index] == 32) {
			index++;
		}
		if(charArray[index] == 45) {
			negative = true;
			index++;
		}
		if(charArray[index] < 48 || charArray[index] > 57) {
			System.out.println("here");
			return 0;
		}
		while(index != length(charArray) && charArray[index] >= 48 && charArray[index] <=57) {
			i *= 10;
			i += charArray[index] - '0';
			index++;
		}
		if(negative)
			return -i;
		return i;
	};	
	
//	Write a function that takes a string of binary number and returns an equivalent decimal number.
	
	public static int length(char[] array) {
		int count = 0;
		for(char c : array) {
			count++;
		}
		return count;
	}
	
	public static int intLength(int[] array) {
		int count = 0;
		for(int c : array) {
			count++;
		}
		return count;
	}
	
	public static int twoToThePowerOf(int exponent) {
		if(exponent == 0)
			return 1;
		int sum = 1;
		for(int i = 1; i <= exponent; i++) 
			sum *= 2;
		return sum;
	}
	
	public static int toDecimal(String binary) {
		char binaryArray[] = binary.toCharArray();
		int sum = 0;
		int count = 0;
		for(int i = length(binaryArray) - 1; i >= 0; i--) {
			if(binaryArray[i] != 48) {
				sum += twoToThePowerOf(count);
			}
			count++;
		}
		return sum;
	}
	
	
	
	public static String toBinary(int decimal) {
		StringBuilder sb = new StringBuilder(256);
		return toBinary(sb, decimal).toString();
	}
	
	public static StringBuilder toBinary(StringBuilder sb, int decimal) {
		if(decimal < 2) {
			return sb.append(decimal);
		} else {
			return sb.append(toBinary(decimal / 2) + decimal % 2);
		}
	}
	
//	//convert int decimal to hex string
//	public static String decimalToHex(int decimal) {
//		StringBuilder sb = new StringBuilder(256);
//		while(decimal > 0) {
//			int hexDigit = decimal % 16;
//			if(hexDigit <= 9) {
//				sb.append(hexDigit);
//			} else if(hexDigit == 10) {
//				sb.append('A');
//			} else if(hexDigit == 11) {
//				sb.append('B');
//			} else if(hexDigit == 12) {
//				sb.append('C');
//			} else if(hexDigit == 13) {
//				sb.append('D');
//			} else if(hexDigit == 14) {
//				sb.append('E');
//			} else if(hexDigit == 15) {
//				sb.append('F');
//			}
//			decimal /= 16;
//		}
//		return reverseWithStringBuilder(sb.toString());
//	}
	
	  static String reverseWithStringBuilder (String string) {
		  char charArray[] = string.toCharArray();
		  StringBuilder backward = new StringBuilder(length(charArray));
		  for(int i = length(charArray) - 1; i >= 0; i--) {
			  backward.append(charArray[i]);
		  }
		  return backward.toString();
	  }
	
	public static String decimalToHex(int decimal) {
		StringBuilder sb = new StringBuilder(256);
		return decimalToHex(sb, decimal).toString();
	}
	
	public static StringBuilder decimalToHex(StringBuilder sb, int decimal) {
		int hexDigit = decimal % 16;
		if(decimal == 0) {
			return sb;
		} else if(hexDigit <= 9) {
			return sb.append(decimalToHex(decimal / 16) + hexDigit);
		} else if(hexDigit == 10) {				
			return sb.append(decimalToHex(decimal / 16) + 'A');
		} else if(hexDigit == 11) {
			return sb.append(decimalToHex(decimal / 16) + 'B');
		} else if(hexDigit == 12) {
			return sb.append(decimalToHex(decimal / 16) + 'C');
		} else if(hexDigit == 13) {
			return sb.append(decimalToHex(decimal / 16) + 'D');
		} else if(hexDigit == 14) {
			return sb.append(decimalToHex(decimal / 16) + 'E');
		} else {
			return sb.append(decimalToHex(decimal / 16) + 'F');
		}
	}
	
	//convert string hex to int decimal
	public static boolean checkHex(String hex) {
		hex = hex.toUpperCase();
		char charArray[] = hex.toCharArray();
		char c;
		for(int i = 0; i < length(charArray); i++ ) {
			c = charArray[i];			
			if(!(c >= 0 && c <= 9) || (c >= 'A' && c <= 'F')) {
				return false;
			}
		}
		return false;
	}
	
	public static void hexToDecimal(String hex) {
		hex = hex.toUpperCase();
		if(checkHex(hex)) {
			System.out.println("This is not a valid Hexadecimal");
		} else {
			int answer = 0;
			int power = 0;
			char charArray[] = hex.toCharArray();
			for(int i = length(charArray) - 1; i >= 0; i--) {
				char currentDigit = charArray[i];
				if(currentDigit - '0' < 9) {
					answer += (currentDigit - '0') * power(16,power);
				} else {				
					answer += (currentDigit - 'A' + 10) * power(16,power);
				}
				power++;
			}
			System.out.println(answer);
		}
	}
	
	public static int power(int base, int exponent) {
		int answer = base;
		if(exponent == 0) {
			return 1;
		} else {
			while(exponent > 1) {
				answer *= base;
				exponent--;
			}
		}
		return answer;
	}
	
	public static int GCD(int firstNumber, int secondNumber) {
		int GCD;
		if(firstNumber == secondNumber)
			return firstNumber;
		else if(firstNumber > secondNumber)
			GCD = secondNumber;
		else
			GCD = firstNumber;
		
		while(firstNumber % GCD != 0 || secondNumber % GCD != 0) {
			GCD--;
		}
		return GCD;
	}
	
	public static int GCD2(int smallerNumber, int largerNumber) {
		if(smallerNumber == largerNumber)
			return smallerNumber;
		else if(smallerNumber > largerNumber) {
			int temp = smallerNumber;
			smallerNumber = largerNumber;
			largerNumber = temp;
		}
		while(largerNumber != 0 && smallerNumber != 0) {
			largerNumber = largerNumber % smallerNumber;
			if(largerNumber != 0)
				smallerNumber = smallerNumber % largerNumber; 
		}
		if(smallerNumber == 0)
			return largerNumber;
		else
			return smallerNumber;
	}
	
//	public static int LCM(int firstNumber, int secondNumber) {
//		int LCM;
//		if(firstNumber == secondNumber)
//			return firstNumber;
//		else if(firstNumber > secondNumber)
//			LCM = firstNumber;
//		else
//			LCM = secondNumber;
//		
//		while(LCM % firstNumber != 0 || LCM % secondNumber != 0) {
//			LCM++;
//		}
//		return LCM;
//	}
	
	public static int LCM(int firstNumber, int secondNumber) {
		return (firstNumber * secondNumber) / GCD(firstNumber, secondNumber);
	}
	
	// atoi() in Java
	// reverse an integer 
	public static void main(String[] args) {
		System.out.println("Answer: " + toDecimal("110101"));
		System.out.println("D2B: " + toBinary(18));
		System.out.println("atoi: " + atoi("   -134214"));
		System.out.println("atoi: " + atoi("134214"));
		System.out.println("atoi: " + atoi("   +-134214"));
		System.out.println("atoi: " + atoi("   --134214"));
		System.out.println("atoi: " + atoi("   --134214"));
		System.out.println("atoi: " + atoi("   1d34214   "));
		System.out.println("atoi: " + atoi("  +134214")); // failed on this test case
		System.out.println("atoi: " + atoi("  1111122149")); 
		int array[] = new int[randomNumber(1, 6)];
		for(int i = 0; i < intLength(array); i++) {
			int num = randomNumber(1, 100);
			System.out.print(num + " ");
			array[i] = num;
		}
		System.out.println();
		System.out.println(largest(array));
		int random = randomNumber(0, 1000000);
		System.out.println("Original: " + random);
		System.out.println("Reverse: " + reverseInteger(random));
		
		System.out.println(random + " to hex: " +decimalToHex(3452345));
		String hex = "113A";
		System.out.print(hex + " to dec: "); hexToDecimal(hex);
		int firstNumber = randomNumber(0, 100);
		int secondNumber = randomNumber(0, 100);
		
		System.out.println("GCD of " + firstNumber + " and " + secondNumber + ": " + GCD(firstNumber, secondNumber));
		System.out.println("GCD2 of " + firstNumber + " and " + secondNumber + ": " + GCD2(firstNumber, secondNumber));
		System.out.println("LCM of " + firstNumber + " and " + secondNumber + ": " + LCM(firstNumber, secondNumber));
		
		//"GCD of " + firstNumber + " and " + secondNumber + ": " + 
	}
}
