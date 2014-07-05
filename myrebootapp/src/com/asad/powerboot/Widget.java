package com.asad.powerboot;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

public class Widget extends AppWidgetProvider {
	private static final String MyOnClick = "myOnClickTag";
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		for (int i = 0; i < appWidgetIds.length; i++) {
			int appWidgetId = appWidgetIds[i];

			
			RemoteViews views = new RemoteViews(context.getPackageName(),
					R.layout.widgetlayout);

			views.setOnClickPendingIntent(R.id.imageButton1, getPendingSelfIntent(context,MyOnClick));

			appWidgetManager.updateAppWidget(appWidgetId, views);

		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		if (MyOnClick.equals(intent.getAction())){
	        hotBoot();
	    }
	}
	protected PendingIntent getPendingSelfIntent(Context context, String action) {
	    Intent intent = new Intent(context, getClass());
	    intent.setAction(action);
	    return PendingIntent.getBroadcast(context, 0, intent, 0);
	}

	public static Intent hotBoot() {
		try {
			Process proc = Runtime.getRuntime().exec(
					new String[] { "su", "-c", "setprop ctl.restart zygote" });
			proc.waitFor();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;

	}

}
