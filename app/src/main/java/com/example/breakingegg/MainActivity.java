package com.example.breakingegg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button gameStart;
    private TextView countText;
    private ImageView egg;
    private Random random;
    private int count = 0;
    private boolean isStart = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        random = new Random();
        countText = (TextView)findViewById(R.id.count);
        countText.setVisibility(View.INVISIBLE);
        gameStart = (Button)findViewById(R.id.gameStart);
        gameStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                egg.setImageResource(R.drawable.egg1);
                count = random.nextInt(50) + 1;
                countText.setText(String.valueOf(count));
                countText.setVisibility(View.VISIBLE);
                isStart = true;
            }
        });
        egg = (ImageView)findViewById(R.id.egg);
        egg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(count == 1 && isStart){
                    count--;
                    countText.setText(String.valueOf(count));
                    egg.setImageResource(R.drawable.egg2);
                    Toast.makeText(MainActivity.this, "게임을 다시 시작해주세요", Toast.LENGTH_SHORT).show();
                }
                else if(!isStart){
                    Toast.makeText(MainActivity.this, "게임을 시작해주세요", Toast.LENGTH_SHORT).show();
                }
                else {
                    count--;
                    countText.setText(String.valueOf(count));
                }
            }
        });
    }
}
