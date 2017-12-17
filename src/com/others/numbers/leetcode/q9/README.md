---
title: "Check if given number is palindrome."
tags: Leetcode, Number, others
---

### Question
Check if given number is a palindrome or not.

### Links
* [Question link](https://leetcode.com/problems/palindrome-number/description/)
* [Code](./PalindromeNumber.java)
* [Official solution](https://leetcode.com/problems/palindrome-number/solution/)
* [Discussion](https://leetcode.com/problems/palindrome-number/discuss/)

### Notes
* Reverse number and compare with original number.
* **My original condition was `while(num > 10)` instead of `while(num >= 10)`.**
* Changed input received to long and processed long to make it work on `-2147483648`.

### Code
```java
public class PalindromeNumber {
    public boolean isPalindrome(int num) {
        int input = num;
        int reverse = 0;
        // With num >= 10, loop becomes simpler.
        while (num >= 10) {
            int unit = num % 10;
            num = num/10;
            reverse = reverse * 10 + unit;
        }
        reverse = reverse * 10 + num;
        return (input == reverse);
    }
}
```

### Solution
#### Official
```C#
public class Solution {
    public bool IsPalindrome(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome, 
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }
        
        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123, 
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }
}
```

#### Discussion
```java
public boolean isPalindrome(int x) {
    if (x<0 || (x!=0 && x%10==0)) return false;
    int rev = 0;
    while (x>rev){
    	rev = rev*10 + x%10;
    	x = x/10;
    }
    return (x==rev || x==rev/10);
}
```