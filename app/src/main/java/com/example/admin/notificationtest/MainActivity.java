package com.example.admin.notificationtest;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button sendNotice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendNotice = (Button)findViewById(R.id.send_notice);
        sendNotice.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.send_notice:
                Notification.Builder builder = new Notification.Builder(this);
                builder.setContentTitle("通知标题");
                builder.setTicker("新消息");
                builder.setContentText("主内容区");
                builder.setContentInfo("补充内容");
                builder.setSmallIcon(R.mipmap.ic_launcher);
                builder.setAutoCancel(true);
                builder.setWhen(System.currentTimeMillis());
                NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                Notification notification = builder.build();
                manager.notify(1, notification);
                break;
            default:
                break;
        }
    }
}
