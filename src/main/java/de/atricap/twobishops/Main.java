package de.atricap.twobishops;

import java.util.Scanner;


public class Main {

    private final Scanner scan;

    public Main(Scanner scan) {
        this.scan = scan;
    }

    public static void main(String[] args) {
        try (Scanner scan = new Scanner(System.in)) {
            Main mainObj = new Main(scan);
            mainObj.main2();
        }
    }

    void main2() {
        int tests = scan.nextInt();
        scan.nextLine();  // Consume newline left-over


        for (int i = 0; i < tests; i++) {
            char[] line = scan.nextLine().replaceAll("\\s+", "").toCharArray();
            Point fB = new Point(line[0] - 65, line[1] - 48); //fB = first Bishop
            Point sB = new Point(line[2] - 65, line[3] - 48); //sB = second Bishop

            // same point
            if (fB.x == sB.x && fB.y == sB.y) {

                systemOutPrintln(0 + " " + (char) ('A' + fB.x) + " " + fB.y);

                // calculating the slope (y2-y1)/(x2-x1). It has to be written like that because division by zero can occur!
            } else if (Math.abs(fB.x - sB.x) == Math.abs(fB.y - sB.y)) {

                systemOutPrintln(1 + " " + (char) ('A' + fB.x) + " " + fB.y + " "+ (char) ('A' + sB.x) + " " + sB.y);

                // are they the same color?
            } else if ((Math.abs(fB.x + fB.y) % 2) != (Math.abs(sB.x + sB.y) % 2)) {

                systemOutPrintln("Impossible");

            } else {
                //negative slope for attacker
                int x = ((fB.y + fB.x) - (sB.y - sB.x)) / 2;
                int y = x + (sB.y - sB.x);

                //x or y are out of bounds, to avoid it, we get a positive slope for the attacker
                if (x < 1 || x > 8 || y < 1 || y > 8) {
                    x = ((sB.y + sB.x) - (fB.y - fB.x)) / 2;
                    y = x + (fB.y - fB.x);
                }

                systemOutPrintln(2 + " " + (char) ('A' + fB.x) + " " + fB.y + " " +
                        (char) ('A' + x) + " " + y + " " + (char) ('A' + sB.x) + " " + sB.y);
            }

        }
        //because I do clean Java!
        scan.close();
    }

    protected void systemOutPrintln(String s) {
        System.out.println(s);
    }
}
