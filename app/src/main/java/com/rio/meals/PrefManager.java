/*
 *     Tanggal Pengerjaan : 6/8/2024
 *     Nim : 10121050
 *     Nama : Rio Christian Cesar Sihombing
 *     email :riosihombing047@gmail.com
 *     Copyright © 2024 Rio Sihombing. All rights reserved.
 */
package com.rio.meals;
import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "introslider";
    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setFirstTimeLaunch(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.commit();
    }

    public boolean isFirstTimeLaunch() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }
}
