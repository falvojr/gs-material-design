package com.falvojr.material.storage.shared;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Useful enum for the specificities of shared preference types.
 *
 * @author falvojr
 * @since 8/23/2015.
 */
enum SharedPreferenceType {
    BOOLEAN(new SharedPreferenceTypeListener<Boolean>() {
        @Override
        public void put(Context context, String key, Boolean value) {
            SharedPreferenceType.getSharedPreferences(context).edit().putBoolean(key, value).apply();
        }

        @Override
        public Boolean get(Context context, String key, Boolean defaultValue) {
            return SharedPreferenceType.getSharedPreferences(context).getBoolean(key, defaultValue);
        }
    }),
    FLOAT(new SharedPreferenceTypeListener<Float>() {
        @Override
        public void put(Context context, String key, Float value) {
            SharedPreferenceType.getSharedPreferences(context).edit().putFloat(key, value).apply();
        }

        @Override
        public Float get(Context context, String key, Float defaultValue) {
            return SharedPreferenceType.getSharedPreferences(context).getFloat(key, defaultValue);
        }
    }),
    INT(new SharedPreferenceTypeListener<Integer>() {
        @Override
        public void put(Context context, String key, Integer value) {
            SharedPreferenceType.getSharedPreferences(context).edit().putInt(key, value).apply();
        }

        @Override
        public Integer get(Context context, String key, Integer defaultValue) {
            return SharedPreferenceType.getSharedPreferences(context).getInt(key, defaultValue);
        }
    }),
    LONG(new SharedPreferenceTypeListener<Long>() {
        @Override
        public void put(Context context, String key, Long value) {
            SharedPreferenceType.getSharedPreferences(context).edit().putLong(key, value).apply();
        }

        @Override
        public Long get(Context context, String key, Long defaultValue) {
            return SharedPreferenceType.getSharedPreferences(context).getLong(key, defaultValue);
        }
    }),
    STRING(new SharedPreferenceTypeListener<String>() {
        @Override
        public void put(Context context, String key, String value) {
            SharedPreferenceType.getSharedPreferences(context).edit().putString(key, value).apply();
        }

        @Override
        public String get(Context context, String key, String defaultValue) {
            return SharedPreferenceType.getSharedPreferences(context).getString(key, defaultValue);
        }
    });

    private final SharedPreferenceTypeListener mSharedPreferenceTypeListener;

    SharedPreferenceType(SharedPreferenceTypeListener<?> sharedPreferenceTypeListener) {
        mSharedPreferenceTypeListener = sharedPreferenceTypeListener;
    }

    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(SharedPreferenceService.NAME, Context.MODE_PRIVATE);
    }

    @SuppressWarnings("unchecked")
    public <T> void put(Context context, String key, T value) {
        this.mSharedPreferenceTypeListener.put(context, key, value);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(Context context, String key, T defaultValue) {
        return (T) this.mSharedPreferenceTypeListener.get(context, key, defaultValue);
    }

    private interface SharedPreferenceTypeListener<T> {

        void put(Context context, String key, T value);

        T get(Context context, String key, T defaultValue);
    }
}
