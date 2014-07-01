package com.asad.powerboot;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class startingPoint extends ListActivity {
	String bootOptions[] = {"Reboot","Reboot Recovery","Reboot Bootloader","Power Off"};
			
	
	
    
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
			powerOff();
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
	
	public void powerOff(){
		try {
		    Process proc = Runtime.getRuntime()
		                    .exec(new String[]{ "su", "-c", "reboot -p" });
		    proc.waitFor();
		} catch (Exception ex) {
		    ex.printStackTrace();
		}
	}
	
}