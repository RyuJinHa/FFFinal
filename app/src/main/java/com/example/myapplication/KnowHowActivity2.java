package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class KnowHowActivity2 extends AppCompatActivity {

    ImageView mainImageView;
    TextView title, description_1;

    String data1, data2;

    int myImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_know_how2);

        mainImageView = findViewById(R.id.imageView2);
        title = findViewById(R.id.textView3);
        description_1 = findViewById(R.id.textView4);
        description_1.setMovementMethod(new ScrollingMovementMethod());



        getData();
        setData();
    }


    private void getData(){
        if(getIntent().hasExtra("images") && getIntent().hasExtra("description_1")&&
                getIntent().hasExtra("title"))
        {
            data1 = getIntent().getStringExtra("title");
            data2 = getIntent().getStringExtra("description_1");

            myImage = getIntent().getIntExtra("images", 1);

        } else{
            Toast.makeText(this,"No data", Toast.LENGTH_SHORT).show();
        }


    }

    private void setData() {
        title.setText(data1);
        description_1.setText(data2);

        mainImageView.setImageResource(myImage);
    }
}