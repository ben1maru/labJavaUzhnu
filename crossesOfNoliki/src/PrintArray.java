public class PrintArray {
    public static void printarr(char[][] arr) {
        //малювання ігрової дошки
        System.out.println("----Game board----");
        for (int i = 0; i < Main.n; i++) {
            for (int j = 0; j < Main.n; j++) {
                System.out.print("| " + arr[i][j] + " | ");
            }
            System.out.println();
        }
        System.out.println("----Game board----");
    }
}