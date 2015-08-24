package com.falvojr.material.storage.shared;

import android.content.Context;

/**
 * Service for shared preferences operations.
 *
 * @author falvojr
 * @see <a href="http://developer.android.com/guide/topics/data/data-storage.html">Storage Options</a>
 * @since 8/23/2015
 */
public enum SharedPreferenceService {
    /**
     * Per the design guidelines, you should show the drawer on launch until the user manually
     * expands it. This shared preference tracks this.
     */
    USER_LEARNED_DRAWER(SharedPreferenceType.BOOLEAN);

    static final String NAME = "material_app_sp";

    private final SharedPreferenceType mSharedPreferenceType;

    SharedPreferenceService(SharedPreferenceType sharedPreferenceType) {
        mSharedPreferenceType = sharedPreferenceType;
    }

    public <T> void put(Context context, T value) {
        mSharedPreferenceType.put(context, this.getKey(), value);
    }

    public <T> T get(Context context, T defaultValue) {
        return mSharedPreferenceType.get(context, this.getKey(), defaultValue);
    }

    public String getKey() {
        return super.name().toLowerCase();
    }
}
