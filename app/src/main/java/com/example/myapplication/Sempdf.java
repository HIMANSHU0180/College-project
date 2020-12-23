package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class Sempdf extends AppCompatActivity {
   ImageView sem1,sem2,sem3,sem4,sem5,sem6,sem7,sem8;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sempdf);
        sem1=findViewById(R.id.sem1);
        sem2=findViewById(R.id.sem2);
        sem3=findViewById(R.id.sem3);
        sem4=findViewById(R.id.sem4);
        sem5=findViewById(R.id.sem5);
        sem6=findViewById(R.id.sem6);
        sem7=findViewById(R.id.sem7);
        sem8=findViewById(R.id.sem8);

        sem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent intent=new Intent(Sempdf.this,view_pdf.class);
               intent.putExtra("value","1");
               startActivity(intent);
            }
        });
        sem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sempdf.this,view_pdf.class);
                intent.putExtra("value","2");
                startActivity(intent);
            }
        });
        sem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sempdf.this,view_pdf.class);
                intent.putExtra("value","3");
                Toast.makeText(Sempdf.this, "item is not avilable", Toast.LENGTH_SHORT).show();
            }
        });
        sem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sempdf.this,view_pdf.class);
                intent.putExtra("value","4");
                Toast.makeText(Sempdf.this, "item is not avilable", Toast.LENGTH_SHORT).show();
            }
        });
        sem5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sempdf.this,view_pdf.class);
                intent.putExtra("value","5");
                Toast.makeText(Sempdf.this, "item is not avilable", Toast.LENGTH_SHORT).show();
            }
        });
        sem6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sempdf.this,view_pdf.class);
                intent.putExtra("value","6");
                Toast.makeText(Sempdf.this, "item is not avilable", Toast.LENGTH_SHORT).show();
            }
        });
        sem7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sempdf.this,view_pdf.class);
                intent.putExtra("value","7");
                Toast.makeText(Sempdf.this, "item is not avilable", Toast.LENGTH_SHORT).show();
            }
        });
        sem8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Sempdf.this,view_pdf.class);
                intent.putExtra("value","8");
                Toast.makeText(Sempdf.this, "item is not avilable", Toast.LENGTH_SHORT).show();
            }
        });
    }
}