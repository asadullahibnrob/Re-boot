package com.asad.powerboot;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class startingPoint extends ListActivity {
	String bootOptions[] = {"Reboot","Reboot Recovery","Reboot Bootloader","Hot Boot","Power Off","Safe Mode"};
			
	
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1 , bootOptions));
    }

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
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