package com.thebreadiswhite.memotest.outsystems.notifier;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.thebreadiswhite.memotest.R;
import com.thebreadiswhite.memotest.activities.Splash;

import java.util.Random;


// IMPORTANT !!
// After modifing this class you should uninstall and
// reinstall the app in order for the changes to take affect;

public class Notifier
{

    public final String CHANNEL_ID;
    private Context context;
    public Notifier(@NonNull Context context, @NonNull Class klass, @NonNull String channelID, @NonNull String textTitle, @NonNull String textContent, @Nullable NotifierMultiBundle bundle)
    {
        this.context = context;
        CHANNEL_ID = channelID;
        sendMyNotification(klass, textTitle, textContent, bundle);
    }

    private void sendMyNotification(Class klass, String title, String message, @Nullable NotifierMultiBundle bundle)
    {
        Intent intent = new Intent(context, klass);

        // Init bundle
        if(bundle != null)
        {
            while (true)
            {
                if(bundle.getType() == NotifierMultiBundle.MultiBundleType.INT)
                {
                    intent.putExtra(bundle.getKey(),(int) bundle.getObject());
                }else if (bundle.getType() == NotifierMultiBundle.MultiBundleType.STRING)
                {
                    intent.putExtra(bundle.getKey(),(String) bundle.getObject());
                }

                if(bundle.hasNext()) bundle = bundle.getNext();
                else break;
            }
        }

        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(title)
                .setContentText(message)
                .setDefaults(Notification.DEFAULT_LIGHTS| Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE)
                // Vibrate -> sleep - > vibrate -> sleep
                //.setVibrate(new long[] {1000,100,100,1})
                //.setSound(Settings.System.DEFAULT_NOTIFICATION_URI)
                .setAutoCancel(true) // clear notification after click
                .setContentIntent(pendingIntent)
                // Auto disappear after an hour
                .setTimeoutAfter(3600000)
                .setPriority(NotificationManager.IMPORTANCE_HIGH)
                .addAction(R.drawable.memotest_play,"Play",pendingIntent);

        NotificationManager mNotificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, notificationBuilder.build());
    }
}
