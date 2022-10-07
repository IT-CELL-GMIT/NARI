package com.beast.nari;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;

import java.util.ResourceBundle;

public class notificationbar extends AppCompatActivity {

//    private static final String CHANNEL_ID = "NARI";
//
//    private static final int REQ_CODE = 100;
//
//    private static final int NOTIFICATION_ID = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationbar);
//
//        Drawable drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.icon, null);
//
//        BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
//
//        Bitmap largeIcon = bitmapDrawable.getBitmap();
//
//        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
//
//        Notification notification;
//
//        Intent iNotify = new Intent(getApplicationContext(),notificationbar.class);
//        iNotify.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//
//        PendingIntent pi = PendingIntent.getActivity(this,REQ_CODE,iNotify);
//
//        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//
//            notification = new Notification.Builder(this).setLargeIcon(largeIcon).setSmallIcon(R.drawable.icon).setContentText()
//        }

    }
}
