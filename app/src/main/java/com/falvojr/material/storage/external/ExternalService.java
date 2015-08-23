package com.falvojr.material.storage.external;

/**
 * Service for external storage operations. A singleton pattern variation also implemented.
 *
 * @author falvojr
 * @see <a href="http://developer.android.com/guide/topics/data/data-storage.html">Storage Options</a>
 * @since 8/23/2015
 */
public class ExternalService {

    /**
     * Private constructor. Prevents instantiation from other classes.
     */
    private ExternalService() {
        super();
    }

    /**
     * Get an {@link ExternalService} instance using the Bill Pugh Singleton implementation.
     *
     * @return {@link ExternalService} instance.
     */
    public static ExternalService getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * Initializes singleton.
     * {@link LazyHolder} is loaded on the first execution of {@link ExternalService#getInstance()}
     * or the first access to {@link LazyHolder#INSTANCE}, not before.
     */
    private static class LazyHolder {
        private static final ExternalService INSTANCE = new ExternalService();
    }
}
