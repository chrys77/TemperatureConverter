import java.util.InputMismatchException;
import java.util.Scanner;

public class TemperatureConverter {

    static Scanner scText = new Scanner(System.in);
    static Scanner scDouble = new Scanner(System.in);

    public static void main(String[] args) {

        String unitConvert;
        String unitGet;
        double tempDegrees;

        System.out.println("\n *** Welcome to Temperature Converter ***");

        while (true) {
            System.out.println("\n\t c = Celsius" +
                    "\n\t f = Fahrenheit" +
                    "\n\t k = Kelvin");

            while (true) {
                System.out.print("> Enter the temperature unit you want to convert: ");
                unitConvert = scText.nextLine().toUpperCase();
                if (checkUnits(unitConvert)) {
                    continue;
                }
                break;
            }

            while (true) {
                System.out.print("> Enter the temperature unit you want to get: ");
                unitGet = scText.nextLine().toUpperCase();
                if (checkUnits(unitGet)) {
                    continue;
                }
                break;
            }

            while (true) {
                try {
                    System.out.print("> Enter the temperature in degrees " + unitConvert + ": ");
                    tempDegrees = scDouble.nextDouble();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid option. You must enter a number of degrees.");
                    scDouble.nextLine();
                    continue;
                }
                break;
            }

            double degreesResult = convertTemperature(unitConvert, unitGet, tempDegrees);
            System.out.println("\n> Your result: " + tempDegrees + " " + unitConvert + " = " + degreesResult + " " + unitGet);

            if (!playAgain()) {
                System.out.println("\n\t*** See you soon! ***");
                break;
            }
        }
    }

    //Check degrees units
    private static boolean checkUnits(String unit) {
        if (!unit.equalsIgnoreCase("c") && !unit.equalsIgnoreCase("f") && !unit.equalsIgnoreCase("k")) {
            System.out.println("Invalid option. You have to choose c, f or k.");
            return true;
        }
        return false;
    }

    //Convert temperature degrees
    private static double convertTemperature(String unitConvert, String unitGet, double tempDegrees) {
        if (unitConvert.equalsIgnoreCase("c") && unitGet.equalsIgnoreCase("f")) {
            return 1.80 * tempDegrees + 32;
        } else if (unitConvert.equalsIgnoreCase("f") && unitGet.equalsIgnoreCase("c")) {
            return (tempDegrees - 32) / 1.8;
        } else if (unitConvert.equalsIgnoreCase("c") && unitGet.equalsIgnoreCase("k")) {
            return tempDegrees + 273.15;
        } else if (unitConvert.equalsIgnoreCase("k") && unitGet.equalsIgnoreCase("c")) {
            return tempDegrees - 273.15;
        } else if (unitConvert.equalsIgnoreCase("f") && unitGet.equalsIgnoreCase("k")) {
            return 0.55 * (tempDegrees - 32) + 273.15;
        } else if (unitConvert.equalsIgnoreCase("k") && unitGet.equalsIgnoreCase("f")) {
            return 1.8 * (tempDegrees - 273.15) + 32;
        } else {
            return tempDegrees;
        }
    }

    //Restart or exit app
    private static boolean playAgain() {
        while (true) {
            System.out.print("\n> Do you want another conversion? (yes or no): ");
            String answer = scText.nextLine();
            if (answer.equalsIgnoreCase("yes")) {
                return true;
            } else if (answer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Invalid input.");
            }
        }
    }

}