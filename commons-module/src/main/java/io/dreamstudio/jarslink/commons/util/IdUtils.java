package io.dreamstudio.jarslink.commons.util;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Ricky Fung
 */
public abstract class IdUtils {
    private static final AtomicLong COUNTER = new AtomicLong(1);

    public static long nextId() {
        return COUNTER.getAndIncrement();
    }
}
