package com.asad.powerboot;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.RemoteViews;

public class Widget2 extends AppWidgetProvider {
	startingPoint bootup = new startingPoint();
	private static final String MyOnClick = "myOnClickTag";
	ImageView b1;
	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		// TODO Auto-generated method stub
		super.onUpdate(context, appWidgetManager, appWidgetIds);
		for (int i = 0; i < appWidgetIds.length; i++) {
			int appWidgetId = appWidgetIds[i];

			
			RemoteViews views = new RemoteViews(context.getPackageName(),
					R.layout.widgetlayout2);
           // views.setImageViewResource(R.id.imageButton1, R.drawable.app_icon);
			views.setOnClickPendingIntent(R.id.imageButton2, getPendingSelfIntent(context,MyOnClick));

			appWidgetManager.updateAppWidget(appWidgetId, views);

		}
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
		if (MyOnClick.equals(intent.getAction())){
	        bootup.powerOff();
	    }
	}
	protected PendingIntent getPendingSelfIntent(Context context, String action) {
	    Intent intent = new Intent(context, getClass());
	    intent.setAction(action);
	    return PendingIntent.getBroadcast(context, 0, intent, 0);
	}

	

}