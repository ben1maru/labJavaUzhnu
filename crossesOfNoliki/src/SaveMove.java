import java.util.Scanner;

public class SaveMove {
    public static int savemove(char[][] arr, int move, char movergamer, char movercomp, int[] movs, int countmovs, int countgame) {
        Scanner sc = new Scanner(System.in);

        // Обробник виключення у вигляді зайнятості хода
        for (int i = 0; i < Main.nmov; i++) {
            if (move == movs[i]) {
                System.out.println("The cell is busy, enter a new one!");
                move = sc.nextInt();
                i = -1;
            }
        }

        // Лічильник
        int c = countmovs;

        // Зберігання хода ігрока
        int row = (move - 1) / 3;
        int col = (move - 1) % 3;
        arr[row][col] = movergamer;
        movs[c] = move;
        c++;

        // Перевірка чи останній ход (потрібно для нічиї)
        if (countgame == 1) {
            return 0;
        }

        // Виклик мінімакс алгоритму для визначення ходу комп'ютера
        int compMove = minimax(arr, movercomp, movergamer);

        // Затримка перед ходом комп'ютера (наприклад, 1000 мілісекунд)
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Зберігання хода комп'ютера
        row = (compMove - 1) / 3;
        col = (compMove - 1) % 3;
        arr[row][col] = movercomp;
        movs[c] = compMove;
        c++;

        return c;
    }

    // Функція оцінки стану гри
    prvate static int evaluate(char[][] arr, char movergamer, char movercomp) {
        for (int row = 0; row < 3; row++) {
            if (arr[row][0] == movercomp && arr[row][1] == movercomp && arr[row][2] == movercomp) {
                return 10;
            }
            if (arr[row][0] == movergamer && arr[row][1] == movergamer && arr[row][2] == movergamer) {
                return -10;
            }
        }
        for (int col = 0; col < 3; col++) {
            if (arr[0][col] == movercomp && arr[1][col] == movercomp && arr[2][col] == movercomp) {
                return 10;
            }
            if (arr[0][col] == movergamer && arr[1][col] == movergamer && arr[2][col] == movergamer) {
                return -10;
            }
        }
        if (arr[0][0] == movercomp && arr[1][1] == movercomp && arr[2][2] == movercomp) {
            return 10;
        }
        if (arr[0][0] == movergamer && arr[1][1] == movergamer && arr[2][2] == movergamer) {
            return -10;
        }
        if (arr[0][2] == movercomp && arr[1][1] == movercomp && arr[2][0] == movercomp) {
            return 10;
        }
        if (arr[0][2] == movergamer && arr[1][1] == movergamer && arr[2][0] == movergamer) {
            return -10;
        }
        return 0; // Нічия
    }

    // Мінімакс алгоритм
    private static int minimax(char[][] arr, char movercomp, char movergamer) {
        int bestMove = -1;
        int bestScore = Integer.MIN_VALUE;

        for (int i = 1; i <= 9; i++) {
            int row = (i - 1) / 3;
            int col = (i - 1) % 3;

            if (arr[row][col] == ' ') {
                arr[row][col] = movercomp;
                int score = minimaxHelper(arr, movergamer, false);
                arr[row][col] = ' ';

                if (score > bestScore) {
                    bestScore = score;
                    bestMove = i;
                }
            }
        }

        return bestMove;
    }

    private static int minimaxHelper(char[][] arr, char movergamer, boolean isMaximizing) {
        int score = evaluate(arr, movergamer, (movergamer == 'X') ? 'O' : 'X');

        if (score != 0) {
            return score;
        }

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 1; i <= 9; i++) {
                int row = (i - 1) / 3;
                int col = (i - 1) % 3;

                if (arr[row][col] == ' ') {
                    arr[row][col] = movergamer;
                    int currentScore = minimaxHelper(arr, movergamer, false);
                    arr[row][col] = ' ';
                    bestScore = Math.max(bestScore, currentScore);
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 1; i <= 9; i++) {
                int row = (i - 1) / 3;
                int col = (i - 1) % 3;

                if (arr[row][col] == ' ') {
                    arr[row][col] = (movergamer == 'X') ? 'O' : 'X';
                    int currentScore = minimaxHelper(arr, movergamer, true);
                    arr[row][col] = ' ';
                    bestScore = Math.min(bestScore, currentScore);
                }
            }
            return bestScore;
        }
    }

}
