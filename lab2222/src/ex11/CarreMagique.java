package ex11;

public class CarreMagique {

    public static boolean estCarreMagique(int[][] m) {
        if (m == null || m.length != 3) {
            return false;
        }

        for (int i = 0; i < 3; i++) {
            if (m[i] == null || m[i].length != 3) {
                return false;
            }
        }

        int ref = m[0][0] + m[0][1] + m[0][2];

        for (int i = 0; i < 3; i++) {
            int sommeLigne = 0;
            int sommeColonne = 0;

            for (int j = 0; j < 3; j++) {
                sommeLigne += m[i][j];
                sommeColonne += m[j][i];
            }

            if (sommeLigne != ref || sommeColonne != ref) {
                return false;
            }
        }

        int diagonalePrincipale = m[0][0] + m[1][1] + m[2][2];
        int diagonaleSecondaire = m[0][2] + m[1][1] + m[2][0];

        return diagonalePrincipale == ref
                && diagonaleSecondaire == ref;
    }

    public static void main(String[] args) {
        int[][] m1 = {
            {8, 1, 6},
            {3, 5, 7},
            {4, 9, 2}
        };

        int[][] m2 = {
            {2, 7, 6},
            {9, 5, 1},
            {4, 3, 7}
        };

        int[][] m3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] m4 = {
            {-1, 2, 0},
            {0, 0, 1},
            {2, -1, -2}
        };

        int[][][] tests = {m1, m2, m3, m4};

        for (int i = 0; i < tests.length; i++) {
            System.out.println("Test " + (i + 1) + " : "
                    + (estCarreMagique(tests[i])
                    ? "Carre magique"
                    : "Pas un carre magique"));
        }
    }
}
