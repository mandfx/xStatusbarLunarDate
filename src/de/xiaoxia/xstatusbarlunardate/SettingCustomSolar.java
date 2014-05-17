﻿/**
 * Copyright (C) 2014 xiaoxia.de
 * 
 * @author by xiaoxia.de
 * @date 2014
 * @license MIT
 *
 * This file is subject to the terms and conditions defined in
 * file 'LICENSE.txt', which is part of this source code package.
 * 
 */

// 自定义公历界面

package de.xiaoxia.xstatusbarlunardate;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;

public class SettingCustomSolar extends PreferenceActivity implements OnSharedPreferenceChangeListener{

    EditTextPreference lp;

    @SuppressWarnings("deprecation")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.setting_custom_solar);

        getActionBar().setDisplayHomeAsUpEnabled(true);

        for(int i = 0; i < 15; i++){
            lp = (EditTextPreference)findPreference("custom_solar_item_" + i);
            if(!"".equals(lp.getText()) && lp.getText() != null)
                lp.setSummary(lp.getText());
            lp.setTitle(getString(R.string.custom_solar) + " " + (i + 1));
        }

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        prefs.registerOnSharedPreferenceChangeListener(this);
    }

    @SuppressWarnings("deprecation")
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        for(int i = 0; i < 15; i++){
            if(key.equals("custom_solar_item_" + i)){
                lp = (EditTextPreference)findPreference("custom_solar_item_" + i);
                if(!"".equals(lp.getText()) && lp.getText() != null){
                    lp.setSummary(lp.getText());
                }else{
                    lp.setSummary(getString(R.string.custom_solar_summary));
                }
                break;
            }
        }
    }
}
