package de.atricap.twobishops;

import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @TestFactory
    public Stream<DynamicTest> characterizeMainMultiple() {
        return Stream.of(
                        new Triplet<String>("T001", "1\nA1 A1", "0 A 1"),
                        new Triplet<String>("T002", "1\nA1 B2", "1 A 1 B 2"),
                        new Triplet<String>("T003", "1\nA1 C3", "1 A 1 C 3"),
                        new Triplet<String>("T004", "1\nA1 B4", "2 A 1 C 3 B 4"),
                        new Triplet<String>("T005", "1\nA1 B1", "Impossible"),
                        new Triplet<String>("T006", "1\nA1 A2", "Impossible"),
                        new Triplet<String>("T007", "2\nA1 A2\nB1 B8", "ImpossibleImpossible"))
                .map(t -> DynamicTest.dynamicTest(t.a(), () -> {
                    try (Scanner scan = new Scanner(t.b())) {
                        TestableMain mainObj = new TestableMain(scan);

                        mainObj.main2();

                        assertEquals(t.c(), mainObj.sb.toString());
                    }
                }));

    }

    static record Triplet<E>(E a, E b, E c) {
    }

}
