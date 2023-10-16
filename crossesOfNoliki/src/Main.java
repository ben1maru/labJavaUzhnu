import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.util.InputMismatchException;
public class Main {
    //файл для запису результатів
    public static File file = new File("Results Gaming");
    //змінні-константи для роботи циклів
    public static int nmov = 9, n = 3;

    public static void main(String[] args) throws FileNotFoundException {
        //метод для записування в файл
        PrintWriter pw = new PrintWriter(file);
        //метод для читання
        Scanner sc = new Scanner(System.in);
        //задання основних змінних
        int move = 0, count = 49, countgame = 5, countmovs = 0;
        int[] movs = new int[nmov];
        //лістинг ходів
        for (int i = 0; i < nmov; i++) {
            movs[i] = 10;
        }
        //ініціалізація масива цифрами для орієнтування на полях
        char[][] arr = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = (char) count;
                count++;
            }
        }
        PrintArray.printarr(arr);
        //ініціалізація массива пустими символами
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = ' ';
            }
        }
        //символьні змінні для роботи програми
        char movergamer, movercomp, symb, prodolzhenie = 'Y';
        //основна частина гри
        while (prodolzhenie == 'Y') {
            System.out.println("Choose which one you want to play: X or O!");
            movergamer = sc.next().charAt(0);
            //присвоєння символу за яким грає гравець та компютер
            while (movergamer != 'X' && movergamer != 'O') {
                System.out.println("Please write valiede symbol!");
                movergamer = sc.next().charAt(0);
            }
            if (movergamer == 'X') {
                movercomp = 'O';
            }
            else {
                movercomp = 'X';
            }
            System.out.println("Saved!\nWrite your move(1-9):");
            while (countgame > 0) {
                //відловлення помилки вводу невірного ходу
                try {
                    move = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Please write valiede move!");
                    System.exit(0);
                }
                //виклик методу внесання хода
                countmovs = SaveMove.savemove(arr, move, movergamer, movercomp, movs, countmovs, countgame);
                //перевірка чи виграв гравець
                if (movergamer == 'X' && CheckWin.provwinX(arr) == 1 || movergamer == 'O' && CheckWin.provwinO(arr) == 2) {
                    PrintArray.printarr(arr);
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Congratulations! Gamer win!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    //записування даних до файлу
                    pw.println(1);
                    break;
                }
                //перевірка чи виграв компютер
                else if (movercomp == 'X' && CheckWin.provwinX(arr) == 1 || movercomp == 'O' && CheckWin.provwinO(arr) == 2) {
                    PrintArray.printarr(arr);
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("Oh shit! Computer win!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    //записування даних до файлу
                    pw.println(2);
                    break;
                }
                PrintArray.printarr(arr);
                //перевірка чи можливе продовження гри
                if (countgame != 1) {
                    System.out.println("Saved!\nWrite your move(1-9):");
                } else {
                    //повідолмення про нічию
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("The game ended in a draw!");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    break;
                }
                countgame--;
            }
            //обнулення лічильників
            countgame = 5;
            countmovs = 0;
            //ініціалізація массива пустими символами
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    arr[i][j] = ' ';
                }
            }
            //очситка масиву зайнятих ходів
            for (int i = 0; i < nmov; i++) {
                movs[i] = 10;
            }
            //запит чи хоче користувач грати далі
            System.out.println("Do you want to continue this game? Y / N");
            prodolzhenie = sc.next().charAt(0);
            while (prodolzhenie != 'Y' && prodolzhenie != 'N') {
                System.out.println("Please write valiede symbol!");
                prodolzhenie = sc.next().charAt(0);
            }
        }
        //закриття файлу у звязку з закінченням роботи з ним
        pw.close();
        //запит чи хоче користувач подивитись таблицю чемпіонів
        System.out.println("Do you want to check campions? Y / N");
        symb = sc.next().charAt(0);
        while (symb != 'Y' && symb != 'N') {
            System.out.println("Please write valiede symbol!");
            symb = sc.next().charAt(0);
        }
        //вивід таблиці у разі бажання користувача
        if (symb == 'Y') {
            new CheckChampion();
            System.out.println("Gamer points: " + CheckChampion.gamer);
            System.out.println("Computer points: " + CheckChampion.comp);
            if (CheckChampion.gamer == CheckChampion.comp) {
                System.out.println("Friendship won!");
            }
            else if (CheckChampion.gamer > CheckChampion.comp) {
                System.out.println("GAMER CHAMPION!");
            } else {
                System.out.println("COMPUTER CHAMPION!");
            }
        } else {
            System.exit(0);
        }
    }
}