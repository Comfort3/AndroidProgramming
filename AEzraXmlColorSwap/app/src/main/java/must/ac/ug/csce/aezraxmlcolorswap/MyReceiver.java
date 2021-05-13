package must.ac.ug.csce.aezraxmlcolorswap;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        String broadcastedMessage = intent.getStringExtra("message");

        if (intent.getAction().equals("com.mybroadcast")) {
            // Display message
            Toast.makeText(context, ""+ broadcastedMessage ,Toast.LENGTH_LONG).show();
        }

        else if (intent.getAction().equals(Intent.ACTION_BATTERY_CHANGED)){
            NotificationCompat.Builder builder = new NotificationCompat.Builder(context,"not_001");
            builder.setContentTitle("Broadcast Notification");
            builder.setContentText("Battery Notification");

            builder.setSmallIcon(R.drawable.ic_baseline_add_alert_24);
            builder.setAutoCancel(true);
            NotificationManagerCompat managerCompat = NotificationManagerCompat.from(context);
            managerCompat.notify(12,builder.build());
        }
    }
}