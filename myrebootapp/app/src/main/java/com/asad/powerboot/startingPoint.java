package com.asad.powerboot;

import android.app.Activity;
import android.app.UiModeManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class startingPoint extends Activity implements OnItemClickListener{
	String bootOptions[] = {"Reboot","Recovery","Bootloader","Hot Boot","Power Off","Safe Mode"};
	ListView list;
    UiModeManager modeManager ;
	
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        modeManager = (UiModeManager)getSystemService(UI_MODE_SERVICE);
        if (modeManager.getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION){
            startActivity(new Intent(this,AndroidTvStartingPoint.class));
            finish();
        }else{

        setContentView(R.layout.mlist);}
        list = (ListView)findViewById(R.id.listview);
        list.setPadding(10, 5, 10, 5);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.row, bootOptions);
        list.setAdapter(adapter);
       
        list.setOnItemClickListener(this);
    }

	
	public void reboot(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "reboot" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public void rebootRecovery(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "reboot recovery" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public void rebootBootloader(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "reboot bootloader" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public void hotBoot(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "setprop ctl.restart zygote" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public void safeMode(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "setprop persist.sys.safemode 1"});
		                    
		    proc.waitFor();
		    Runtime.getRuntime()
            .exec(new String[]{ "su", "-c","setprop ctl.restart zygote"});
		    proc.waitFor();
		    
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
	public void powerOff(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "reboot -p" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
			long id) {
		switch(position){
		case 0:
			reboot();
			break;
		case 1:
			rebootRecovery();
			break;
		case 2:
			rebootBootloader();
			break;
		case 3:
			hotBoot();
			break;
		case 4:
			powerOff();
			break;
		case 5:
			safeMode();
			break;
		}
		
	}
	
/*	public void moveToSystem(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "mount -o remount,rw /data","mount -o remount,rw /system" });
		    proc.waitFor();
		    //cp -f com.asad.powerboot-1.apk /system/app/
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}*/
	
	
	
	
	
}