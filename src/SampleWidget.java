package com.example.appsdk_widget;

import java.util.Calendar;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.widget.RemoteViews;

public class SampleWidget extends AppWidgetProvider {

	@Override
    public void onUpdate(Context c, AppWidgetManager awm, int[] awi) {
		
		// printdateに日付を入れる
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);
		String dayofweek = "";
		switch (cal.get(Calendar.DAY_OF_WEEK)) {
		case Calendar.SUNDAY: dayofweek = "(日)";
		break;
		case Calendar.MONDAY: dayofweek = "(月)";
		break;
		case Calendar.TUESDAY: dayofweek = "(火)";
		break;
		case Calendar.WEDNESDAY: dayofweek = "(水)";
		break;
		case Calendar.THURSDAY: dayofweek = "(木)";
		break;
		case Calendar.FRIDAY: dayofweek = "(金)";
		break;
		case Calendar.SATURDAY: dayofweek = "(土)";
		break;
		}
		//System.out.println(cal.get(Calendar.DAY_OF_WEEK));
		String printdate = "平成" + (year-1988) + "年/"
		+ year + "年\n" + (month+1) + "月" + day + "日　" + dayofweek;
        //～　リモートビューにmain.xmlをセット　～//
        RemoteViews rv = new RemoteViews(c.getPackageName(), R.layout.main);
        rv.setTextViewText(R.id.textView1, printdate);
        //～　ウィジェットにremoteViewsをセット　～//
        ComponentName cn = new ComponentName(c, SampleWidget.class);
        awm.updateAppWidget(cn, rv);
    }
}
