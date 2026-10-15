package ex8;


public class NombresAbsents {

    public static void afficherElementsManquants(int[] t) {
        if (t == null) {
            System.out.println("Tableau invalide.");
            return;
        }

        int n = t.length;
        boolean[] vu = new boolean[n + 1];

        for (int x : t) {
            if (x >= 1 && x <= n) {
                vu[x] = true;
            }
        }

        boolean trouve = false;

        System.out.print("Elements manquants : ");

        for (int k = 1; k <= n; k++) {
            if (!vu[k]) {
                System.out.print(k + " ");
                trouve = true;
            }
        }

        if (!trouve) {
            System.out.print("Aucun element manquant");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        int[][] tests = {
            {1, 3, 3, 5},
            {1, 2, 3, 4},
            {3, 3, 3},
            {1, 1, 1, 1},
            {4, 2, 2, 1, 5},
            {1},
            {1, 2, 3, 6}
        };

        for (int[] t : tests) {
            System.out.print("Tableau : ");

            for (int x : t) {
                System.out.print(x + " ");
            }

            System.out.println();
            afficherElementsManquants(t);
            System.out.println();
        }
    }
}
