package com.example.myapplication;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.view.View;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.MenuItem;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.Button;
import android.widget.Toast;

public class OrderDetails extends AppCompatActivity
        {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);
        Toolbar toolbar = findViewById(R.id.nav_logout);
        setSupportActionBar(toolbar);
        Button confirm=(Button)findViewById(R.id.paymentbutton_o);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNotification();
                Intent i = new Intent(OrderDetails.this, CatlogDetails.class);
                startActivity(i);
                Toast.makeText(getApplicationContext(),"Order Placed!",Toast.LENGTH_SHORT).show();

            }
        });



    }
    private void addNotification(){
        NotificationCompat.Builder builder =new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("YOUR ORDER IS PLACED SUCCESSFULLY!!");
                //.setContentText("YOUR ORDER IS PLACED SUCCESSFULLY");
               /* .setDefaults(Notification.DEFAULT_SOUND)
                .setDefaults(Notification.DEFAULT_VIBRATE)
                //.setDefaults(Notification.DEFAULT_LIGHTS);*/
              //  long[] pattern = {500,500,500,500,500,500,500,500};
                //builder.setVibrate(pattern);
        //builder.setStyle(new NotificationCompat.InboxStyle());
        //builder.setContentIntent(contentintent);
        Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Intent i  = new Intent(this, OrderDetails.class);
        PendingIntent contentintent = PendingIntent.getActivity(this, 0,i, PendingIntent.FLAG_UPDATE_CURRENT);
        builder.setContentIntent(contentintent);
        builder.setAutoCancel(true);
        builder.setLights(Color.BLUE, 500, 500);
        long[] pattern = {500,500,500,500,500,500,500,500,500};
        builder.setVibrate(pattern);
        builder.setStyle(new NotificationCompat.InboxStyle());

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        builder.setSound(alarmSound);
        manager.notify(0,builder.build());
    }


}
