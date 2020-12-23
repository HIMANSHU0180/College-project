package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity1 extends AppCompatActivity {
 ImageView imageView,allimageview,zoom,logout,reset,pdf;
 FirebaseAuth fauth;

 String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        imageView=(ImageView)findViewById(R.id.sem1);
        allimageview=(ImageView)findViewById(R.id.alldetail);
        zoom=findViewById(R.id.live);
        pdf=findViewById(R.id.pdf);
      logout=findViewById(R.id.logout);
        uid=FirebaseAuth.getInstance().getUid();
        fauth=FirebaseAuth.getInstance();
        reset=findViewById(R.id.resetpass);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity1.this,mydetail.class);
                intent.putExtra("alluid",uid);
                startActivity(intent);
            }
        });
        allimageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity1.this,alldetail.class);

                startActivity(intent);
            }
        });
        zoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity1.this,ZOOM.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fauth.signOut();
                startActivity(new Intent(MainActivity1.this,MainActivity.class));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity1.this,updatepassword.class));
            }
        });
        pdf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(  new Intent(MainActivity1.this,Sempdf.class)  );
            }
        });
    }

}