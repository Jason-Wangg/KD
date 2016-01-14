package com.beta.jason.kd;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Jason on 1/6/2016.
 */
public class BaseActivity extends Activity {
    public String[] companyCodes;
    public String[] companyNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppManager.getAppManager().addActivity(this);
        companyCodes = getResources().getStringArray(R.array.company_code);
        companyNames = getResources().getStringArray(R.array.company_name);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AppManager.getAppManager().finishActivity(this);
    }
}
