import java.util.Scanner;

public class Binary {

    Scanner sc = new Scanner(System.in);
    double result;

    public void calculateBinary(double a, double b) {
        boolean continueCalculation = true;
        while (true) {
            System.out.println("Оберіть операцію зі списку");
            System.out.println("1. +\n2. -\n3. *\n4. / \n0. Вихід");
            int answer = sc.nextInt();
            switch (answer) {
                case 1:
                    result = a + b;
                    System.out.println("Результат операції " + result);
                    a = result;
                    break;
                case 2:
                    result = a - b;
                    System.out.println("Результат операції " + result);
                    a = result;
                    break;
                case 3:
                    result = a * b;
                    System.out.println("Результат операції " + result);
                    a = result;
                    break;
                case 4:
                    if (b != 0) {
                        result = a / b;
                        System.out.println("Результат операції " + result);
                        a = result;
                    } else {
                        System.out.println("Ділення на нуль неможливе.");
                    }
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    continue;
            }

            System.out.println("Результат операції: " + result);
            Menu menu = new Menu();
            // Питання користувачу про продовження операцій
            System.out.print("Продовжити обчислення з результатом (" + result + ")? (1 - Так, 0 - Вихід): ");
            int continueChoice = sc.nextInt();

            if (continueChoice == 1) {
                a = result;
                menu.Recol(a);
            } else {
                continueCalculation = false;
            }
        }
    }
}
