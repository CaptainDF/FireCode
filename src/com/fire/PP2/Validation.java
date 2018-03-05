package com.fire.PP2;

import org.junit.Test;

public class Validation {


  // Return true if the card number is valid, otherwise returns false, this method is already implemented
  public boolean aValidNumber(String n) {

	long number = Long.parseLong(n);
	return  (numLength(number) >= 13) && (numLength(number) <= 16) &&
        (prefixCheck(number, 4) || prefixCheck(number, 5) ||
        prefixCheck(number, 6) || prefixCheck(number, 37)) &&
        (totalEevenNumbers(number) + totalOddNumbers(number)) % 10 == 0;
  }// end of aValidNumber method

  //get the sum of even places numbers, Starting from the second digit from right
  private int totalEevenNumbers(long number) {
      int length = 1;
      int sum = 0;
      while(number>0){
          if(length%2==0){
              sum += number%10;
          }
          length++;
          number = number/10;
      }
      return sum;
  }// end of totalEevenNumbers method

    @Test
    public void testSingleDigit(){
        System.out.println(singleDigit(1234567));
    }

  // Return the same number if it is a single digit, otherwise, return the sum of
  // the two digits in this number
  private int singleDigit(int number) {
    int sum = 0;
    while(number>0){
        sum+=number%10;
        number = number/10;
    }
      return sum;
  } // end of singleDigit method


    @Test
    public void testTotalOddNumbers(){
        System.out.println(totalEevenNumbers(121212121));
    }

  // Return the sum of odd place digits in number
  private int totalOddNumbers(long number) {
    int length = 1;
    int sum = 0;
    while(number>0){
        if(length%2!=0){
            sum += number%10;
        }
        length++;
        number = number/10;
    }
    return sum;
  }// end of totalOddNumbers method

  // Return true if the digit d is a prefix for number
  private boolean prefixCheck(long number, int d) {
      while(number!=d&&number>0){
          number = number/10;
          if(number==d) return true;
      }
	 return false;
  }// end of prefixCheck method

    @Test
    public void testPrefixCheck(){
        System.out.println(prefixCheck(237348,233));
    }

    @Test
    public void testNumLength(){
        int leng = numLength(12111111L);
        System.out.println(leng);
    }
    // Return the number of digits in this number parameter

  private int numLength(long number) {
      int length = 0;
      long f =number;
      while(f>=1){
          f = f/10;
          length++;
      }
    return length;
  }// end of numLength method

  // Return the first k number of digits from number, which is either a first digit or first two digits
  // Depending on the card type
  private long numPrefix(long number, int k) {
      int length = numLength(number);
      return (long)Math.floor(number/Math.pow(10,length-k));
  }// end of numPrefix method

}// end of the class
