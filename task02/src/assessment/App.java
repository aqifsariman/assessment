package assessment;

import java.util.Arrays;
import java.util.Scanner;

public final class App {

    public static void main(String[] args) {
        String[] operandsArray;
        String request = "", response;
        Float results, lastValue;
        Calculator calculator = new Calculator();

        System.out.println("Welcome.");
        Scanner scanner = new Scanner(System.in);
        while (!request.equalsIgnoreCase("exit")) {
            System.out.print("> ");
            request = scanner.nextLine();
            if (request.contains("$last")) {
                request = request.replace("$last", String.valueOf(calculator.getResults()));
            }
            operandsArray = request.split(" ");
            if (request.contains("+")) {
                results = calculator.addition(Float.valueOf(operandsArray[0]),
                        Float.valueOf(operandsArray[2]));
                response = String.format("%s + %s = %.2f", operandsArray[0], operandsArray[2], results);
                calculator.setResults(results);
                System.out.println(response);

            } else if (request.contains("-")) {
                results = calculator.subtraction(Float.valueOf(operandsArray[0]),
                        Float.valueOf(operandsArray[2]));
                response = String.format("%s - %s = %.2f", operandsArray[0], operandsArray[2], results);
                calculator.setResults(results);
                System.out.println(response);

            } else if (request.contains("*")) {
                results = calculator.multiplication(Float.valueOf(operandsArray[0]),
                        Float.valueOf(operandsArray[2]));
                response = String.format("%s * %s = %.2f", operandsArray[0], operandsArray[2], results);
                calculator.setResults(results);
                System.out.println(response);

            } else if (request.contains("/")) {
                results = calculator.division(Float.valueOf(operandsArray[0]),
                        Float.valueOf(operandsArray[2]));
                response = String.format("%s / %s = %.2f", operandsArray[0], operandsArray[2], results);
                calculator.setResults(results);
                System.out.println(response);
            }

            else if (request.equalsIgnoreCase("exit")) {
                System.out.println("Bye bye");
                System.exit(0);
            }
        }
    }
}
