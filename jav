import java.util.Stack;

public class MaxRectangle {

    static class Rectangle {
        int top;
        int left;
        int bottom;
        int right;
        int area;
    }

    public static Rectangle trouverMaxRectangle(int[][] m) {

        Rectangle meilleur = new Rectangle();

        if (m.length == 0) {
            meilleur.area = 0;
            return meilleur;
        }

        int R = m.length;
        int C = m[0].length;

        int[] hauteur = new int[C];

        meilleur.area = 0;

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {

                if (m[i][j] == 1) {
                    hauteur[j]++;
                } else {
                    hauteur[j] = 0;
                }
            }

            Stack<Integer> pile = new Stack<>();

            for (int j = 0; j <= C; j++) {

                int h;

                if (j == C) {
                    h = 0;
                } else {
                    h = hauteur[j];
                }

                while (!pile.isEmpty() && h < hauteur[pile.peek()]) {

                    int index = pile.pop();

                    int height = hauteur[index];

                    int right = j - 1;

                    int left;

                    if (pile.isEmpty()) {
                        left = 0;
                    } else {
                        left = pile.peek() + 1;
                    }

                    int width = right - left + 1;
                    int area = height * width;

                    if (area > meilleur.area) {

                        meilleur.area = area;
                        meilleur.bottom = i;
                        meilleur.top = i - height + 1;
                        meilleur.left = left;
                        meilleur.right = right;
                    }
                }

                pile.push(j);
            }
        }

        return meilleur;
    }

    public static void main(String[] args) {

        int[][] m = {
            {0, 1, 1, 0, 1},
            {1, 1, 1, 1, 0},
            {1, 1, 1, 1, 0},
            {1, 1, 0, 0, 1}
        };

        Rectangle r = trouverMaxRectangle(m);

        System.out.println("Aire maximale = " + r.area);
        System.out.println("top = " + r.top);
        System.out.println("left = " + r.left);
        System.out.println("bottom = " + r.bottom);
        System.out.println("right = " + r.right);
    }
}