package com.asad.powerboot;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

/**
 * Created by machine7 on 8/19/2015.
 */
public class AndroidTvStartingPoint extends Activity implements View.OnClickListener{
    startingPoint bootup = new startingPoint();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.androidtvlayout);
        View v1 = (View)findViewById(R.id.reboot);
        View v2 = (View)findViewById(R.id.recovery);
        View v3 = (View)findViewById(R.id.bootloader);
        View v4 = (View)findViewById(R.id.hotboot);
        View v5 = (View)findViewById(R.id.poweroff);
        View v6 = (View)findViewById(R.id.safemode);
        v1.setOnClickListener(this);
        v2.setOnClickListener(this);
        v3.setOnClickListener(this);
        v4.setOnClickListener(this);
        v5.setOnClickListener(this);
        v6.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.reboot:
                bootup.reboot();
                Log.d("hello", "view1 has been clicked");

                break;
            case R.id.recovery:
                bootup.rebootRecovery();
                break;
            case R.id.bootloader:
                bootup.rebootBootloader();
                break;
            case R.id.hotboot:
                bootup.hotBoot();
                break;
            case R.id.poweroff:
                bootup.powerOff();
                break;
            case R.id.safemode:
                bootup.safeMode();
                break;


        }
    }
}
