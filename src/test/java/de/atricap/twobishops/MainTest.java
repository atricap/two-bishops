package de.atricap.twobishops;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainTest {

    @Test
    public void main2ShouldExecute() {
        Scanner scan = new Scanner("1\nA1 A1");
        TestableMain mainObj = new TestableMain(scan);

        mainObj.main2();

        assertTrue(true);
    }
}
