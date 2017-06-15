import java.util.Scanner;

public class MathChallenge {

    public static void main(String[] args) {

        //Initialize scanner to accept user input
        Scanner scan = new Scanner(System.in);
        int userNum = 0;

        //Ask user to enter an integer (non-integers will cause the program to quit)
        System.out.print("Enter an integer: ");

        //Validate the user input is an integer (i.e. not a long, double, string, etc.)
        if (scan.hasNextInt()) {
            userNum = scan.nextInt();

            //Change any negative entries to positive and inform the user
            /* if (userNum < 0) {
                userNum = - userNum;
                //System.out.printf("%d will be used instead...", userNum);
            } */

            //Use sumOfCubes method to calculate the sum of the cubes of the number's digits
            /* Alternatively could receive a boolean result that feeds following if to trigger proper output */
            int sum = sumOfCubes(userNum);

            //Check if result from sum of cubes equals the number entered by the user --> Output to User: True or False
            /* Alternatively the if would be dependant on (result) */
            if (sum == userNum) {
                System.out.printf("True.%nThe sum of the cubes of the number's digits is equal to the number itself.%n");
            } else {
                System.out.printf("False.%nThe sum of the cubes of the number's digits is not equal to the number itself.%n");
            }

            //Inform user if entry is invalid (i.e. double, long, string, etc.)
        } else {
            System.out.println("Sorry! That is an invalid entry.");
        }

    }

    //sumOfCubes method is used to sum of the cubes of the number's digits
    /* Alternatively this would return boolean sumOfCubes */
    public static int sumOfCubes(int input) {

        //Initialize the variable for the sign of user input
        int sign = 1;

        //Determine if user input a negative integer
        if (input < 0) {
            sign = -1;
            //Temporarily set to positive integer during calculation
            input = - input;
        }

        //Create a string consisting of the digits input by the user to enable looping through character indices
        String number = String.valueOf(input);

        //Initialize the variables needed for the sum of cubes method
        int currentDigit = 0;
        int cubedDigit = 0;
        int exponent = 3;
        int cubedTotal = 0;

        //Loop through each digit (number of loops set by length of integer entered)
        for (int i = 0; i < number.length(); ++i) {

            //Setting currentDigit to the numeric value of the character in base 10
            currentDigit = Character.digit(number.charAt(i), 10);

            //Raising the currentDigit to the power of "exponent" (3 for cubed)
            cubedDigit = (int) Math.pow(currentDigit, exponent);

            //Summing the cubedDigits (Per the intent of the method)
            cubedTotal = cubedTotal + cubedDigit;
        }

        //Reintroduce sign to match user input
        cubedTotal = sign * cubedTotal;

        //Updating the user with the sum of cubes for the integer they entered
        System.out.println("Sum of Cubes: " + cubedTotal);

        //Returning the sum of cubes back to the main method for final sumOfCubes == userNum validation (True/False)
        /* Alternatively if (cubedTotal == input) { } --> return result = True; */
        return cubedTotal;

    }

}