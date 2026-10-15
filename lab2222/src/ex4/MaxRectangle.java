package ex4;


import java.util.Stack;

public class MaxRectangle {

    static class Rectangle {
        int top;
        int left;
        int bottom;
        int right;
        int area;

        Rectangle(int top, int left, int bottom, int right, int area) {
            this.top = top;
            this.left = left;
            this.bottom = bottom;
            this.right = right;
            this.area = area;
        }
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {
        if (m == null || m.length == 0 || m[0].length == 0) {
            return new Rectangle(-1, -1, -1, -1, 0);
        }

        int R = m.length;
        int C = m[0].length;
        int[] hauteurs = new int[C];
        Rectangle meilleur = new Rectangle(-1, -1, -1, -1, 0);

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (m[i][j] == 1) {
                    hauteurs[j]++;
                } else {
                    hauteurs[j] = 0;
                }
            }

            Stack<Integer> pile = new Stack<>();
            int j = 0;

            while (j < C) {
                if (pile.isEmpty() || hauteurs[pile.peek()] <= hauteurs[j]) {
                    pile.push(j++);
                } else {
                    int indice = pile.pop();
                    int hauteur = hauteurs[indice];
                    int largeur = pile.isEmpty() ? j : j - pile.peek() - 1;
                    int aire = hauteur * largeur;

                    if (aire > meilleur.area) {
                        int left = pile.isEmpty() ? 0 : pile.peek() + 1;
                        int right = j - 1;
                        int top = i - hauteur + 1;

                        meilleur = new Rectangle(top, left, i, right, aire);
                    }
                }
            }

            while (!pile.isEmpty()) {
                int indice = pile.pop();
                int hauteur = hauteurs[indice];
                int largeur = pile.isEmpty() ? j : j - pile.peek() - 1;
                int aire = hauteur * largeur;

                if (aire > meilleur.area) {
                    int left = pile.isEmpty() ? 0 : pile.peek() + 1;
                    int right = j - 1;
                    int top = i - hauteur + 1;

                    meilleur = new Rectangle(top, left, i, right, aire);
                }
            }
        }

        return meilleur;
    }

    public static int maxRectangle(int[][] m) {
        return trouverMaxRectangle(m).area;
    }

    public static void afficherResultat(int[][] m) {
        Rectangle r = trouverMaxRectangle(m);

        System.out.println("Aire maximale : " + r.area);

        if (r.area > 0) {
            System.out.println("Top : " + r.top);
            System.out.println("Left : " + r.left);
            System.out.println("Bottom : " + r.bottom);
            System.out.println("Right : " + r.right);
        } else {
            System.out.println("Aucun rectangle de 1.");
        }
    }

    public static void main(String[] args) {
        int[][] m1 = {
            {0, 1, 1, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 0, 0, 1}
        };

        int[][] m2 = {
            {0, 0, 0, 0},
            {0, 1, 1, 0},
            {0, 1, 1, 0},
            {0, 0, 0, 0}
        };

        int[][] m3 = {
            {1, 1, 1},
            {1, 1, 1},
            {1, 1, 1}
        };

        int[][] m4 = {
            {0, 0, 0},
            {0, 0, 0},
            {0, 0, 0}
        };

        System.out.println("Matrice 1 :");
        afficherResultat(m1);

        System.out.println("\nMatrice 2 :");
        afficherResultat(m2);

        System.out.println("\nMatrice 3 :");
        afficherResultat(m3);

        System.out.println("\nMatrice 4 :");
        afficherResultat(m4);
    }
}
