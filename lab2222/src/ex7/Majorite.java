package ex7;


public class Majorite {

    public static int elementMajoritaire(int[] t) {
        if (t == null || t.length == 0) {
            return -1;
        }

        int candidat = 0;
        int compteur = 0;

        for (int x : t) {
            if (compteur == 0) {
                candidat = x;
                compteur = 1;
            } else if (x == candidat) {
                compteur++;
            } else {
                compteur--;
            }
        }

        compteur = 0;

        for (int x : t) {
            if (x == candidat) {
                compteur++;
            }
        }

        if (compteur > t.length / 2) {
            return candidat;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[][] tests = {
            {3, 3, 4, 3, 5},
            {2, 2, 1, 2, 3, 2, 2},
            {1, 1, 1, 1},
            {7},
            {1, 2, 3, 4},
            {1, 2, 2, 3},
            {1, 1, 2, 2},
            {-1, -1, -1, 2, 3},
            {-2, -2, -2, -2, 1, 3},
            {},
            {10}
        };

        for (int[] t : tests) {
            System.out.print("Tableau : [");

            for (int i = 0; i < t.length; i++) {
                System.out.print(t[i]);

                if (i < t.length - 1) {
                    System.out.print(", ");
                }
            }

            System.out.println("]");

            System.out.println(
                "Element majoritaire : " + elementMajoritaire(t)
            );

            System.out.println();
        }
    }
}
