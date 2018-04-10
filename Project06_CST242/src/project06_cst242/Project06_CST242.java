package project06_cst242;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Write a program that takes a whole number input from a user and determines
 * whether it's prime. If the number is not prime, display its unique prime 
 * factors.
 *
 * @author Kemar, Woonnie, Sophia
 */
public class Project06_CST242 {
    
    /**
     * Unique Prime Factorization Algorithm - Using a HashSet to return unique
     * prime factors of non-prime numbers.
     * 
     * @param number number inputted by the user.
     * @return Returns the unique prime factors of a number
     */
    static Set primeFactors(long number) {
        long copy = number, i;
        Set primeFactor = new HashSet<>();
        for (i = 2; i <= copy; i++) {
            if (copy % i == 0) {
                primeFactor.add(i);
                copy /= i;
                i--;
            }
        }
        return primeFactor;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        long n;
        System.out.println("Enter a number: ");
        n = input.nextLong();
        System.out.println("The Prime Factors of " + n + " is: "
        + primeFactors(n));
    }
    
}
