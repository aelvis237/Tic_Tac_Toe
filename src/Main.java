import java.util.*;
public class Main {


    private static char aktuellerSpieler = 'X';

    public static void main(String[] args) {
        char[][] feld = {
                {'-', '-', '-'},
                {'-', '-', '-'},
                {'-', '-', '-'}
                         };
            int a,b;
        Scanner scanner = new Scanner(System.in);
         int zahl=9;
        while (true) {
            printArray2(feld);
            System.out.println("Spieler " + aktuellerSpieler + ", Bitte Koordinat 1 eingeben: ");
            a = scanner.nextInt();
            System.out.println("Spieler " + aktuellerSpieler + ", Bitte Koordinat 2 eingeben: ");
            b = scanner.nextInt();
            validerZug(feld,  a, b);
            zahl--;
            if (gewonnen(feld) || spielUnentschieden(feld)) {
                printArray2(feld);
                System.out.println(" Spieler"+" "+aktuellerSpieler+" "+"hat gewonnen!");
                break;
            }
            else if (zahl==0) {
                System.out.println("unentschieden");
                break;
            }
            spielerWechseln();
        }
        }


    private static void printArray2(char[][]array) {
        System.out.println("  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static boolean validerZug(char[][] array, int a, int b) {

        if (a >= 0 && a < 3 && b >= 0 && b < 3 && array[a][b] == '-') {
            array[a][b] = aktuellerSpieler;

        } else {
            System.out.println("Ungültiger Zug. Bitte "+" "+aktuellerSpieler +" "+"erneut versuchen.");
        }
        return false;
    }


   private static char spielerWechseln() {
        if (aktuellerSpieler=='X'){
            aktuellerSpieler='0';
            return aktuellerSpieler;
        }else {
            aktuellerSpieler='X';
            return aktuellerSpieler;
        }


    }

    private static boolean gewonnen(char[][] array) {
        return (pruefeZeilen(array) || pruefeSpalten(array) || pruefeDiagonalen(array));
    }

    private static boolean pruefeZeilen(char[][] array) {
        for (int i = 0; i < 3; i++) {
            if (array[i][0] != '-' && array[i][0] == array[i][1] && array[i][1] == array[i][2]) {
                return true;
            }
        }
        return false;
    }

    private static boolean pruefeSpalten(char[][] array) {
        for (int i = 0; i < 3; i++) {
            if (array[0][i] != '-' && array[0][i] == array[1][i] && array[1][i] == array[2][i]) {
                return true;
            }
        }
        return false;
    }

    private static boolean pruefeDiagonalen(char[][] array) {
        return (array[0][0] != '-' && array[0][0] == array[1][1] && array[1][1] == array[2][2]) ||
                (array[0][2] != '-' && array[0][2] == array[1][1] && array[1][1] == array[2][0]);
    }
    private static boolean spielUnentschieden(char[][]array) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((array[i][j] == '-')||(!pruefeZeilen(array)||!pruefeSpalten(array)||!pruefeDiagonalen(array))) {
                    return false;
                }
            }
        }
        return true;
    }

}