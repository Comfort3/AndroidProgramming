package must.ac.ug.csce.aezraprogcolorswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button sendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button tapMebutton = findViewById(R.id.button1MainActivity);
        final TextView textviewMainActivity = findViewById(R.id.textviewMainActivity);

        sendBroadcast = findViewById(R.id.sendBroadcast);

        tapMebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Random random = new Random();
                int red = random.nextInt(255);
                int green = random.nextInt(255);
                int blue = random.nextInt(255);

                int textColorTextview = Color.rgb(red, green, blue);

                textviewMainActivity.setTextColor(textColorTextview);
                textviewMainActivity.setText("COLOR: "+ Integer.toString(red)+ "r, "+ Integer.toString(green)+ "g, " + Integer.toString(blue)+ "b");
            }
        });

        sendBroadcast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message="Sent Broadcast Message";
                Intent intent = new Intent();
                intent.setAction("com.mybroadcast");
                intent.putExtra("message",message);
                intent.setFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
            }
        });


    }
}