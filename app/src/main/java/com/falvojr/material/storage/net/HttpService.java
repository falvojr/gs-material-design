package com.falvojr.material.storage.net;

/**
 * Service for network connection operations. A singleton pattern variation also implemented.
 *
 * @author falvojr
 * @see <a href="http://developer.android.com/guide/topics/data/data-storage.html">Storage Options</a>
 * @since 8/23/2015
 */
public class HttpService {

    /**
     * Private constructor. Prevents instantiation from other classes.
     */
    private HttpService() {
        super();
    }

    /**
     * Get an {@link HttpService} instance using the Bill Pugh Singleton implementation.
     *
     * @return {@link HttpService} instance.
     */
    public static HttpService getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * Initializes singleton.
     * {@link LazyHolder} is loaded on the first execution of {@link HttpService#getInstance()}
     * or the first access to {@link LazyHolder#INSTANCE}, not before.
     */
    private static class LazyHolder {
        private static final HttpService INSTANCE = new HttpService();
    }
}
