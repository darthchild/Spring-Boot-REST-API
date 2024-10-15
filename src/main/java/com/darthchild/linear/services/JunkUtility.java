package com.darthchild.linear.services;
/*
REST API in Spring Boot

- ***Controllers -*** handle HTTP requests
- ***Services -*** contain business logic
- ***Repositories -*** interact with databases
- ***Entities -*** represent database tables
- ***DTOs -*** act as Response/Request Objects to transfer data between layers (esp. bw controller and service)

 */
public class JunkUtility {
    // This method calculates the sum of two numbers
    // It takes two integers as input parameters
    // The result is the sum of these two integers
    // This method is very simple but adds more lines to the code
    // In a real-world scenario, this wouldn't need so many comments
    public int sum(int a, int b) {
        return a + b; // Return the sum of a and b
    }

    // Method to print a welcome message
    public void printWelcomeMessage() {
        System.out.println("Welcome to this application!");
    }

    // Method to reverse a string
    public String reverseString(String input) {
        StringBuilder reversed = new StringBuilder(input);
        return reversed.reverse().toString();
    }

    // Method to find the maximum of two numbers
    public int findMax(int a, int b) {
        return a > b ? a : b;
    }

    // Method to check if a number is even
    public boolean isEven(int number) {
        return number % 2 == 0;
    }
    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to print a goodbye message
    public void printGoodbyeMessage() {
        System.out.println("Goodbye, thank you for using this application!");
    }

    // Method to find the minimum of two numbers
    public int findMin(int a, int b) {
        return a < b ? a : b;
    }

    // Method to check if a number is odd
    public boolean isOdd(int number) {
        return number % 2 != 0;
    }

    // Method to return the square of a number
    public int square(int number) {
        return number * number;
    }

    // Method to concatenate two strings
    public String concatenateStrings(String str1, String str2) {
        return str1 + str2;
    }

    // Method to calculate the cube of a number
    public int cube(int number) {
        return number * number * number;
    }

    // Method to check if a string is empty
    public boolean isEmptyString(String input) {
        return input == null || input.isEmpty();
    }

    // Method to convert a string to uppercase
    public String toUpperCase(String input) {
        return input.toUpperCase();
    }

    // Method to calculate the factorial of a number
    public int factorial(int number) {
        if (number <= 1) return 1;
        return number * factorial(number - 1);
    }

    // Method to check if a number is positive
    public boolean isPositive(int number) {
        return number > 0;
    }

    // Method to calculate the absolute value of a number
    public int absoluteValue(int number) {
        return number < 0 ? -number : number;
    }

    // Method to greet a user by name
    public void greetUser(String name) {
        System.out.println("Hello, " + name + "!");
    }

    // Method to count the length of a string
    public int stringLength(String input) {
        return input.length();
    }

    // Method to divide two numbers (handling division by zero)
    public double divide(int a, int b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero.");
            return 0;
        }
        return (double) a / b;
    }

    // Method to generate a random number between 1 and 100
    public int generateRandomNumber() {
        return (int) (Math.random() * 100) + 1;
    }

    // Method to check if a string contains a specific substring
    public boolean containsSubstring(String mainString, String substring) {
        return mainString.contains(substring);
    }

    // Method to convert a number to a string
    public String numberToString(int number) {
        return Integer.toString(number);
    }

    // Method to check if a character is a vowel
    public boolean isVowel(char character) {
        character = Character.toLowerCase(character);
        return character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u';
    }

    // Method to calculate the sum of an array of integers
    public int sumArray(int[] numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    // Method to reverse an array of integers
    public int[] reverseArray(int[] numbers) {
        int[] reversed = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            reversed[i] = numbers[numbers.length - 1 - i];
        }
        return reversed;
    }

    // Method to convert a boolean to a string
    public String booleanToString(boolean value) {
        return value ? "true" : "false";
    }

    // Method to calculate the power of a number
    public double power(double base, int exponent) {
        return Math.pow(base, exponent);
    }

    // Method to print a countdown from a given number
    public void countdown(int start) {
        for (int i = start; i >= 0; i--) {
            System.out.println(i);
        }
    }

    // Method to find the average of an array of integers
    public double findAverage(int[] numbers) {
        if (numbers.length == 0) return 0;
        int sum = sumArray(numbers);
        return (double) sum / numbers.length;
    }

    // Method to return a greeting based on the time of day
    public String timeBasedGreeting(int hour) {
        if (hour < 12) {
            return "Good morning!";
        } else if (hour < 18) {
            return "Good afternoon!";
        } else {
            return "Good evening!";
        }
    }

    // Method to check if a number is prime
    public boolean isPrime(int number) {
        if (number <= 1) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    // Method to get the first character of a string
    public char getFirstCharacter(String input) {
        if (input == null || input.isEmpty()) {
            return '\0'; // Null character
        }
        return input.charAt(0);
    }



}
