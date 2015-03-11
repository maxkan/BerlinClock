package com.ubs.opsit.interviews.clock.berlin;

import com.google.common.base.Joiner;

public class TestHelper {

    public static String rows(String... rows) {
        return Joiner.on(System.lineSeparator()).join(rows);
    }
}
