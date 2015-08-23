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
    USER_LEARNED_DRAWER(SharedPreferenceType.BOOLEAN);

    static final String NAME = "material_app_sp";

    private final SharedPreferenceType mSharedPreferenceType;

    SharedPreferenceService(SharedPreferenceType sharedPreferenceType) {
        mSharedPreferenceType = sharedPreferenceType;
    }

    public <T> void put(Context context, T value) {
        mSharedPreferenceType.put(context, this.getSharedPreferenceKey(), value);
    }

    public <T> T get(Context context, T defaultValue) {
        return mSharedPreferenceType.get(context, this.getSharedPreferenceKey(), defaultValue);
    }

    private String getSharedPreferenceKey() {
        return super.name().toLowerCase();
    }
}
