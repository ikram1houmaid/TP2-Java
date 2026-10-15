package ex9;


public class Diagonales {

    public static int differenceDiagonales(int[][] m) {
        if (m == null || m.length == 0) {
            throw new IllegalArgumentException("Matrice invalide");
        }

        int n = m.length;
        int sommePrincipale = 0;
        int sommeSecondaire = 0;

        for (int i = 0; i < n; i++) {
            if (m[i] == null || m[i].length != n) {
                throw new IllegalArgumentException("La matrice doit etre carree");
            }

            sommePrincipale += m[i][i];
            sommeSecondaire += m[i][n - 1 - i];
        }

        int difference = Math.abs(sommePrincipale - sommeSecondaire);

        System.out.println("Somme diagonale principale : " + sommePrincipale);
        System.out.println("Somme diagonale secondaire : " + sommeSecondaire);
        System.out.println("Difference absolue : " + difference);

        return difference;
    }

    public static void main(String[] args) {
        int[][] m1 = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        int[][] m2 = {
            {1, 3, 5},
            {2, 4, 6},
            {7, 8, 9}
        };

        int[][] m3 = {
            {5}
        };

        int[][] m4 = {
            {-1, 2},
            {3, -4}
        };

        System.out.println("Test 1 :");
        differenceDiagonales(m1);

        System.out.println("\nTest 2 :");
        differenceDiagonales(m2);

        System.out.println("\nTest 3 :");
        differenceDiagonales(m3);

        System.out.println("\nTest 4 :");
        differenceDiagonales(m4);
    }
}
