import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    Unary unary = new Unary();
    Binary binary = new Binary();
    public void Menu(){


        String userInput1;
        String userInput2;

        System.out.print("Введіть перше число: ");
        while (true) {

            userInput1 = scanner.nextLine();

            if (!userInput1.isEmpty() && isNumeric(userInput1)) {
                break; // Вихід з циклу, якщо користувач ввів числове значення
            } else {
                System.out.println("Введіть коректне перше число.");
            }
        }

        System.out.print("Введіть друге число: ");
        userInput2 = scanner.nextLine();

        if ((!userInput1.isEmpty()&&isNumeric(userInput1)) && (!userInput2.isEmpty()&&isNumeric(userInput2))) {
            double number1 = Double.parseDouble(userInput1);
            double number2 = Double.parseDouble(userInput2);
            binary.calculateBinary(number1,number2);

        }else if (!userInput1.isEmpty() && isNumeric(userInput1)) {
            double number = Double.parseDouble(userInput1);
            unary.calculateUnary(number);


        }

        scanner.close();
    }

    public void Recol(double a){
        String userInput2;


        System.out.println("Перший оперант: "+a);
        System.out.print("Введіть друге число: ");
        userInput2 = scanner.nextLine();
        String resut = String.valueOf(a);
        if ((!resut.isEmpty()&&isNumeric(resut)) && (!userInput2.isEmpty()&&isNumeric(userInput2))) {
            double number1 = Double.parseDouble(resut);
            double number2 = Double.parseDouble(userInput2);
            binary.calculateBinary(number1,number2);

        }else if (!resut.isEmpty() && isNumeric(resut)) {
            double number = Double.parseDouble(resut);
            unary.calculateUnary(number);


        }

        scanner.close();
    }
    // Метод для перевірки, чи рядок може бути числом
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

