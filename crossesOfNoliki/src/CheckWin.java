public class CheckWin {
    //перевірка на виграш X
    public static int provwinX(char[][] arr) {
        //1-2-3
        if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2] && arr[0][0] == 'X') {
            return 1;
        }
        //4-5-6
        else if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2] && arr[1][0] == 'X') {
            return 1;
        }
        //7-8-9
        else if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2] && arr[2][0] == 'X') {
            return 1;
        }
        //1-4-7
        else if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0] && arr[0][0] == 'X') {
            return 1;
        }
        //2-5-8
        else if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] && arr[0][1] == 'X') {
            return 1;
        }
        //3-6-9
        else if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] && arr[0][2] == 'X') {
            return 1;
        }
        //1-5-9
        else if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] == 'X') {
            return 1;
        }
        //3-5-7
        else if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] == 'X') {
            return 1;
        }
        return 0;
    }

    //перевірка на виграш O
    public static int provwinO(char[][] arr) {
        //1-2-3
        if (arr[0][0] == arr[0][1] && arr[0][1] == arr[0][2] && arr[0][0] == 'O') {
            return 2;
        }
        //4-5-6
        else if (arr[1][0] == arr[1][1] && arr[1][1] == arr[1][2] && arr[1][0] == 'O') {
            return 2;
        }
        //7-8-9
        else if (arr[2][0] == arr[2][1] && arr[2][1] == arr[2][2] && arr[2][0] == 'O') {
            return 2;
        }
        //1-4-7
        else if (arr[0][0] == arr[1][0] && arr[1][0] == arr[2][0] && arr[0][0] == 'O') {
            return 2;
        }
        //2-5-8
        else if (arr[0][1] == arr[1][1] && arr[1][1] == arr[2][1] && arr[0][1] == 'O') {
            return 2;
        }
        //3-6-9
        else if (arr[0][2] == arr[1][2] && arr[1][2] == arr[2][2] && arr[0][2] == 'O') {
            return 2;
        }
        //1-5-9
        else if (arr[0][0] == arr[1][1] && arr[1][1] == arr[2][2] && arr[0][0] == 'O') {
            return 2;
        }
        //3-5-7
        else if (arr[0][2] == arr[1][1] && arr[1][1] == arr[2][0] && arr[0][2] == 'O') {
            return 2;
        }
        return 0;
    }
}