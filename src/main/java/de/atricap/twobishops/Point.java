package de.atricap.twobishops;

class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Point other) {
            return this.x == other.x && this.y == other.y;
        }
        return false;
    }

    @Override
    public String toString() {
        return "%s %d".formatted((char) ('A' + x), y);
    }

    static Point fromReadable(char xChar, char yChar) {
        return new Point(fromReadableX(xChar), fromReadableY(yChar));
    }

    static int fromReadableX(char xChar) {
        return xChar - 'A';
    }

    static int fromReadableY(char yChar) {
        return yChar - '0';
    }

    static boolean outOfBounds(int x, int y) {
        return x < 1 || x > 8 || y < 1 || y > 8;
    }
}