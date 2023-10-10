import java.util.Scanner;

public class Unary {
    Scanner sc = new Scanner(System.in);
    double result;


    public void calculateUnary(double a) {
        boolean continueCalculation = true;
        Menu menu = new Menu();

        while (continueCalculation) {
            System.out.println("Оберіть операцію зі списку");
            System.out.println("1. cos\n2. sin\n3. Корінь квадратний\n4. Піднесення до квадрату\n5. tg\n6. ctg\n7. Факторіал числа\n0. Вихід");
            int answer = sc.nextInt();


            switch (answer) {
                case 1:
                    result = Math.cos(a);
                    break;
                case 2:
                    result = Math.sin(a);
                    break;
                case 3:
                    if(a<=0) {
                        menu.Menu();
                        System.out.println("Введене вами число є відємним і з нього не можна отримати корінь");
                    }
                    result = Math.sqrt(a);
                    break;
                case 4:
                    result = Math.pow(a, 2);
                    break;
                case 5:
                    result = Math.tan(a);
                    break;
                case 6:
                    result = 1 / Math.tan(a);
                    break;
                case 7:
                    result = factorial(a);
                    break;
                case 0:
                    System.exit(0);
                    continueCalculation = false;
                    break;
                default:
                    System.out.println("Неправильний вибір. Спробуйте ще раз.");
                    continue;
            }

            System.out.println("Результат операції: " + result);
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

    public static double factorial(double a) {

        if (a == 0) {
                  return 1;
              } else {

                  return (a * factorial(a - 1));
              }
    }
}
