package com.falvojr.material.storage.internal;

/**
 * Service for internal storage operations. A singleton pattern variation also implemented.
 *
 * @author falvojr
 * @see <a href="http://developer.android.com/guide/topics/data/data-storage.html">Storage Options</a>
 * @since 8/23/2015
 */
public class InternalService {

    /**
     * Private constructor. Prevents instantiation from other classes.
     */
    private InternalService() {
        super();
    }

    /**
     * Get an {@link InternalService} instance using the Bill Pugh Singleton implementation.
     *
     * @return {@link InternalService} instance.
     */
    public static InternalService getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * Initializes singleton.
     * {@link LazyHolder} is loaded on the first execution of {@link InternalService#getInstance()}
     * or the first access to {@link LazyHolder#INSTANCE}, not before.
     */
    private static class LazyHolder {
        private static final InternalService INSTANCE = new InternalService();
    }
}
