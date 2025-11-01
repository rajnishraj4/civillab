package com.tech.adira.app.management.civillab.utils;

import de.huxhorn.sulky.ulid.ULID;

public final class UlidUtils {
    private static final ULID ULID_GENERATOR = new ULID();

    public static String nextId() {
        return ULID_GENERATOR.nextValue().toString();
    }
}
