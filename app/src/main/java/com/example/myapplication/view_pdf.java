package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class view_pdf extends AppCompatActivity {

    ListView mypdf;
    DatabaseReference databaseReference;
    ArrayList<downloadpdf> downloadpdfs;
    String value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pdf);
        mypdf=findViewById(R.id.pdflist);

        downloadpdfs=new ArrayList<>();
        viewallfile();
       mypdf.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               downloadpdf downpdf=downloadpdfs.get(position);
               Intent intent=new Intent();
               intent.setType(Intent.ACTION_VIEW);
               intent.setData(Uri.parse(downpdf.getUrl()));
               intent.setPackage("com.android.chrome");
               startActivity(intent);
           }
       });
    }

    private void viewallfile() {

        value=getIntent().getStringExtra("value");
        databaseReference= FirebaseDatabase.getInstance().getReference("pdfs").child(value);
        Toast.makeText(this, databaseReference.getKey(), Toast.LENGTH_SHORT).show();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for(DataSnapshot postsnapshot:snapshot.getChildren()){
                    downloadpdf pdfdown=postsnapshot.getValue(downloadpdf.class);
                    downloadpdfs.add(pdfdown);
                }
                String []uploads=new String[downloadpdfs.size()];
                for(int i=0;i<downloadpdfs.size();i++){
                   uploads[i]=downloadpdfs.get(i).getName();
                    Toast.makeText(view_pdf.this, uploads[i], Toast.LENGTH_SHORT).show();
                }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1,uploads);
                mypdf.setAdapter(arrayAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(view_pdf.this, "fail", Toast.LENGTH_SHORT).show();
            }
        });

    }
}