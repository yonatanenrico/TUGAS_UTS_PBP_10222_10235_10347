package com.example.uts;

import static com.example.uts.MyApplication.CHANNEL_1_ID;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

import com.example.uts.rv.DaftarMenu;
import com.example.uts.entity.Menu;
import com.example.uts.rv.RVMenuAdapter;
import com.example.uts.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private NotificationManagerCompat notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setTitle(R.string.menu);

        notificationManager = NotificationManagerCompat.from(this);

        notification();

        RVMenuAdapter adapter = new RVMenuAdapter(getListMenu());
        binding.rvMenu.setAdapter(adapter);

        binding.btnLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LocationActivity.class));
                finish();
            }
        });

        binding.btnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AccountActivity.class));
                finish();
            }
        });

    }

    private ArrayList<Menu> getListMenu() {
        ArrayList<Menu> listMenu = new DaftarMenu().daftarMenu;
        return listMenu;
    }

    public void notification(){
        Intent activityIntent = new Intent(this, MainActivity.class);
        PendingIntent contentIntent = PendingIntent.getActivity( this,
                0,activityIntent,0);

        Bitmap picture = BitmapFactory.decodeResource(getResources(), R.drawable.img);

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Horeg Resto")
                .setContentText("Menu Favorit Minggu ini :")
                .setLargeIcon(picture)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText("Menu Favorit Minggu ini!\n" +
                                "Papeda + Ikan Buah Kuning\n" +
                                "Harga : Rp. 60.000,-\n\n" +
                                "Tunggu Apa Lagi, Ayo Pesan Sekarang!")
                        .setBigContentTitle("Horeg Resto"))
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .setColor(Color.GREEN)
                .setContentIntent(contentIntent)
                .setAutoCancel(true)
                .setOnlyAlertOnce(true)
                .build();

        notificationManager.notify(1, notification);
    }
}