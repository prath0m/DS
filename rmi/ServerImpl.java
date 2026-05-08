package rmi;

import java.rmi.*;
import java.rmi.server.*;

public class ServerImpl extends UnicastRemoteObject implements ServerIntf {

    public ServerImpl() throws RemoteException {
    }

    public int addition(int a, int b) throws RemoteException {
        return a + b;
    }

    public int substraction(int a, int b) throws RemoteException {
        return a - b;
    }

    public int division(int a, int b) throws RemoteException {
        return a / b;
    }

    public int multiplication(int a, int b) throws RemoteException {
        return a * b;
    }

    public int square(int a) throws RemoteException {
        return a * a;
    }

    public int squareroot(int a) throws RemoteException {
        return (int) (Math.sqrt(a));
    }

    public void palindrome(String str) throws RemoteException {
        StringBuilder sb = new StringBuilder(str);
        sb.reverse();

        if (str.equals(sb.toString()))
            System.out.println("String is Palindrome!");
        else
            System.out.println("String is Not Palindrome!");

    }

    public void isequalstring(String str1, String str2) throws RemoteException {
        if (str1.equals(str2))
            System.out.println("String is equal!");
        else
            System.out.println("String is not equal!");
    }

    public double celsiusToFahrenheit(double celsius) throws RemoteException {
        return (celsius * 9/5) + 32;
    }

    public double milesToKilometer(double miles) throws RemoteException {
        return miles * 1.60934;
    }

    public int vowelsInWord(String word) throws RemoteException {
        int count = 0;
        String vowels = "aeiouAEIOU";
        for (char c : word.toCharArray()) {
            if (vowels.indexOf(c) != -1) {
                count++;
            }
        }
        System.out.println("Number of vowels in \"" + word + "\": " + count);
        return count;
    }

    public long factorial(int n) throws RemoteException {
        if (n < 0) {
            System.out.println("Factorial is not defined for negative numbers");
            return -1;
        }
        if (n == 0 || n == 1) {
            return 1;
        }
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        System.out.println("Factorial of " + n + " is: " + result);
        return result;
    }

}
