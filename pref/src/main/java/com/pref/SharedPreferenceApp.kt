package com.pref

import android.content.Context
import android.content.SharedPreferences


/**
 *
 *
 * This is SharedPreferences SingleTon class used to store small amount of data
 * in private mode.
 *
 *
 * @author user amit.singh
 */
class SharedPreferenceApp constructor(context: Context) {
    private val pref: SharedPreferences = context.getSharedPreferences("SharedPreferenceApp", 0)
    private val editor: SharedPreferences.Editor = pref.edit()

    /**
     * Gets all.
     *
     * @return the all
     */
    val all: Map<String, Any>
        get() = pref.all as Map<String, Any>


    /**
     *
     *
     * This method used to store value of boolean type
     *
     *
     * @param key   Unique Key for a value
     * @param value Value to be stored
     * @return the shared preference app
     */
    fun save(key: String, value: Boolean) {
        editor.putBoolean(key, value).commit()
    }

    /**
     *
     *
     * This method used to store value of string type
     *
     *
     * @param key   Unique Key for a value
     * @param value Value to be stored
     * @return the shared preference app
     */
    fun save(key: String, value: String) {
        editor.putString(key, value).commit()
    }

    /**
     *
     *
     * This method used to store value of integer type
     *
     *
     * @param key   Unique Key for a value
     * @param value Value to be stored
     * @return the shared preference app
     */
    fun save(key: String, value: Int) {
        editor.putInt(key, value).commit()
    }

    /**
     *
     *
     * This method used to store value of long type
     *
     *
     * @param key   Unique Key for a value
     * @param value Value to be stored
     * @return the shared preference app
     */
    fun save(key: String, value: Long) {
        editor.putLong(key, value).commit()
    }

    /**
     *
     *
     * This method used to store value of float type
     *
     *
     * @param key   Unique Key for a value
     * @param value Value to be stored
     * @return the shared preference app
     */
    fun save(key: String, value: Float) {
        editor.putFloat(key, value).commit()
    }

    /**
     *
     *
     * This will remove the specific value from the preference by passing its
     * key.
     *
     *
     * @param key set key that value needs to be removed.
     * @return the shared preference app
     */
    fun remove(key: String) {
        editor.remove(key).commit()
    }

    /**
     * This method will clear the whole preference.
     *
     * @return the shared preference app
     */
    fun clearPref() {
        editor.clear().commit()
    }

    /**
     *
     *
     * Here all values is to get String value from shared preferences.
     *
     *
     * @param key      retrieve by unique key
     * @param defValue give here defaultValue if not found defalutValue is assigned
     * @return string string
     */
    fun getString(key: String, defValue: String): String? {
        return pref.getString(key, defValue)
    }

    /**
     *
     *
     * Here all values is to get int value from shared preferences.
     *
     *
     * @param key      retrieve by unique key
     * @param defValue give here defaultValue if not found defalutValue is assigned
     * @return int int
     */
    fun getInt(key: String, defValue: Int): Int {

        return pref.getInt(key, defValue)
    }

    /**
     *
     *
     * Here all values is to get boolean value from shared preferences.
     *
     *
     * @param key      retrieve by unique key
     * @param defValue give here defaultValue if not found defalutValue is assigned
     * @return boolean boolean
     */
    fun getBoolean(key: String, defValue: Boolean): Boolean {
        return pref.getBoolean(key, defValue)
    }

    /**
     *
     *
     * Here all values is to get long valued from shared preferences.
     *
     *
     * @param key      retrieve by unique key
     * @param defValue give here defaultValue if not found defalutValue is assigned
     * @return long long
     */
    fun getLong(key: String, defValue: Long): Long {
        return pref.getLong(key, defValue)
    }

    /**
     *
     *
     * Here all values is to get float value from shared preferences.
     *
     *
     * @param key      retrieve by unique key
     * @param defValue give here defaultValue if not found defalutValue is assigned
     * @return float float
     */
    fun getFloat(key: String, defValue: Float): Float {
        return pref.getFloat(key, defValue)
    }

    /**
     * Has preference boolean.
     *
     * @param key the key
     * @return the boolean
     */
    fun hasPreference(key: String): Boolean {
        return pref.contains(key)
    }
}
