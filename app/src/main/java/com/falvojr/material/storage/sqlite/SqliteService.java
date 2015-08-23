package com.falvojr.material.storage.sqlite;

/**
 * Service for SQLite Databases operations. A singleton pattern variation also implemented.
 *
 * @author falvojr
 * @see <a href="http://developer.android.com/guide/topics/data/data-storage.html">Storage Options</a>
 * @since 8/23/2015
 */
public class SqliteService {

    /**
     * Private constructor. Prevents instantiation from other classes.
     */
    private SqliteService() {
        super();
    }

    /**
     * Get an {@link SqliteService} instance using the Bill Pugh Singleton implementation.
     *
     * @return {@link SqliteService} instance.
     */
    public static SqliteService getInstance() {
        return LazyHolder.INSTANCE;
    }

    /**
     * Initializes singleton.
     * {@link LazyHolder} is loaded on the first execution of {@link SqliteService#getInstance()}
     * or the first access to {@link LazyHolder#INSTANCE}, not before.
     */
    private static class LazyHolder {
        private static final SqliteService INSTANCE = new SqliteService();
    }
}
