package com.example;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({MathTest.class, LogicTest.class})
public class AllTests {
    // No code needed inside
}
