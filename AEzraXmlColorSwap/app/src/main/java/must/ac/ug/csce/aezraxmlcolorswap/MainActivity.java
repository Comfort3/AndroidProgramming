package must.ac.ug.csce.aezraxmlcolorswap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    IntentFilter intentFilter;
    MyReceiver MyReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //broadcast
        intentFilter = new IntentFilter("com.mybroadcast");
        MyReceiver = new MyReceiver();
        registerReceiver(MyReceiver,intentFilter);

        final Button tapMebutton = findViewById(R.id.button1MainActivity);
        final TextView textviewMainActivity = findViewById(R.id.textviewMainActivity);

        List<Integer> colors = new ArrayList<>();
        colors.add(getResources().getColor(R.color.red));
        colors.add(getResources().getColor(R.color.green));
        colors.add(getResources().getColor(R.color.blue));
        colors.add(getResources().getColor(R.color.black));
        colors.add(getResources().getColor(R.color.teal_700));
        colors.add(getResources().getColor(R.color.teal_200));
        colors.add(getResources().getColor(R.color.purple_700));
        colors.add(getResources().getColor(R.color.purple_500));
        colors.add(getResources().getColor(R.color.purple_200));
        colors.add(getResources().getColor(R.color.yellow));
        colors.add(getResources().getColor(R.color.pink));



        tapMebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                tapMebutton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int color = randomColor();
                        if(textviewMainActivity.getCurrentTextColor() != color){
                            textviewMainActivity.setTextColor(color);
                        }else{
                            textviewMainActivity.setTextColor(randomColor());
                        }
                    }
                });


            }

            private int randomColor(){
                Random rand = new Random();
                return colors.get(rand.nextInt(colors.size()));

            }
        });
    }
}