public class ForPatterns {
    static void main() {
        String starPattern = "*";
        System.out.println("STAR Patterns");
        for(int i = 1; i <= 5; i++) {
            starPattern += " *";
            System.out.println(starPattern);
        }

        System.out.println("---------------------");
        System.out.println("NUMBER Patterns");
        int rows = 5;
        for (int i = rows; i >= 1; i--) { //row iterator

//            Printing 2 spaces per missing digit to keep columns aligned
            for (int j = rows; j > i; j--) {
                System.out.print("  ");
            }
//            Print decreasing numbers with 1 space in between
            for (int k = i; k >= 1; k--) { //column iterator
                System.out.printf("%d ", k);
            }
//            Moving to next line/row
            System.out.println();
        }
    }
}
