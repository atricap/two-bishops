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
        int tests = readTestCount();

        for (int i = 0; i < tests; i++) {
            char[] line = readLine();
            Point fB = Point.fromReadable(line[0], line[1]); //fB = first Bishop
            Point sB = Point.fromReadable(line[2], line[3]); //sB = second Bishop

            if (fB.equals(sB)) {

                systemOutPrintln("0 %s".formatted(fB));

            } else if (isSameSlope(fB, sB)) {

                systemOutPrintln("1 %s %s".formatted(fB, sB));

            } else if (isSameColor(fB, sB)) {

                systemOutPrintln("Impossible");

            } else {
                // negative slope for attacker
                int x = getSlopeX(fB, sB);
                int y = getSlopeY(x, sB);

                //x or y are out of bounds, to avoid it, we get a positive slope for the attacker
                if (Point.outOfBounds(x, y)) {
                    x = getSlopeX(sB, fB);
                    y = getSlopeY(x, fB);
                }

                systemOutPrintln("2 %s %s %d %s".formatted(fB, (char) ('A' + x), y, sB));
            }
        }
    }

    private int readTestCount() {
        int tests = scan.nextInt();
        scan.nextLine();  // Consume newline left-over
        return tests;
    }

    private char[] readLine() {
        return scan.nextLine().replaceAll("\\s+", "").toCharArray();
    }

    /**
     * calculating the slope (y2-y1)/(x2-x1). It has to be written like that because division by zero can occur!
     */
    private static boolean isSameSlope(Point fB, Point sB) {
        return Math.abs(fB.x - sB.x) == Math.abs(fB.y - sB.y);
    }

    private static boolean isSameColor(Point fB, Point sB) {
        return (Math.abs(fB.x + fB.y) % 2) != (Math.abs(sB.x + sB.y) % 2);
    }

    private static int getSlopeX(Point fB, Point sB) {
        return ((fB.y + fB.x) - (sB.y - sB.x)) / 2;
    }

    private static int getSlopeY(int x, Point sB) {
        return x + (sB.y - sB.x);
    }

    protected void systemOutPrintln(String s) {
        System.out.println(s);
    }
}
