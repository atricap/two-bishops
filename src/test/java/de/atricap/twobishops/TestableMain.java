package de.atricap.twobishops;

import java.util.Scanner;

public class TestableMain extends Main {

    public StringBuilder sb = new StringBuilder();

    public TestableMain(Scanner scan) {
        super(scan);
    }

    @Override
    protected void systemOutPrintln(String s) {
        sb.append(s);
    }
}
