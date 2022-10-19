package com.example.cs501_hw6p2_maintainstatebundlesandsharedpreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.SharedPreferences;
import java.util.Random;


public class MainActivity extends AppCompatActivity {
    private EditText edittext_one;
    private Button button_one;
    private ImageView imageview_one;
    private Random random = new Random();
    private Integer random_num = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_one = findViewById(R.id.button_one);
        edittext_one = findViewById(R.id.edittext_one);
        imageview_one = findViewById(R.id.imageview_one);




        button_one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random_num = random.nextInt(6);
                if (random_num == 0){
                    imageview_one.setImageResource(R.drawable.cat);
                }else if (random_num == 1){
                    imageview_one.setImageResource(R.drawable.dog);
                }else if (random_num == 2){
                    imageview_one.setImageResource(R.drawable.lion);
                }else if (random_num == 3){
                    imageview_one.setImageResource(R.drawable.cow);
                }else if (random_num == 4){
                    imageview_one.setImageResource(R.drawable.sheep);
                }else{
                    imageview_one.setImageResource(R.drawable.ragdoll);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences sharedP = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        random_num = sharedP.getInt("imageview_one", 0);
        String str = sharedP.getString("edittext_one","");

        edittext_one.setText(str);
        if (random_num == 0){
            imageview_one.setImageResource(R.drawable.cat);
        }else if (random_num == 1){
            imageview_one.setImageResource(R.drawable.dog);
        }else if (random_num == 2){
            imageview_one.setImageResource(R.drawable.lion);
        }else if (random_num == 3){
            imageview_one.setImageResource(R.drawable.cow);
        }else if (random_num == 4){
            imageview_one.setImageResource(R.drawable.sheep);
        }else{
            imageview_one.setImageResource(R.drawable.ragdoll);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor data = sharedPreferences.edit();

        data.putString("edittext_one", edittext_one.getText().toString());
        data.putInt("imageview_one",random_num);
        data.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        SharedPreferences.Editor data = sharedPreferences.edit();

        data.putString("edittext_one", edittext_one.getText().toString());
        data.putInt("imageview_one",random_num);
        data.apply();

    }
}