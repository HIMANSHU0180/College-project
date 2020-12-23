package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class mydetail extends AppCompatActivity {
FirebaseAuth firebaseAuth;
FirebaseDatabase firebaseDatabase;
DatabaseReference databaseReference;
DatabaseReference d1;
    ProgressBar pb;
    ListView listView;
    ImageView imagestu;
TextView name,enrollment,cgpa,attendence,sem;
ArrayList<String> arrayList=new ArrayList<>();

String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mydetail);

        dec();
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(mydetail.this, android.R.layout.simple_list_item_1, arrayList);


        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String namee=snapshot.child("name").getValue(String.class);
                String enroolementt=snapshot.child("enrollment").getValue(String.class);
                String cgpaa=snapshot.child("cgpa").getValue(String.class);
                String attendencee=snapshot.child("attendence").getValue(String.class);
                String semesterr=snapshot.child("Semester").getValue(String.class);
                String link=snapshot.child("link").getValue(String.class);
                Picasso.get().load(link).into(imagestu);

                name.setText(namee);
                enrollment.setText(enroolementt);
                cgpa.setText(cgpaa);
                attendence.setText(attendencee);
                sem.setText(semesterr);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        d1.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                String value=snapshot.getValue(String.class);
                arrayList.add((value));
                arrayAdapter.notifyDataSetChanged();
                pb.setVisibility(View.GONE);

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {
                arrayAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot snapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot snapshot, @Nullable String previousChildName) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        listView.setAdapter(arrayAdapter);


    }
    public void dec(){
        uid=getIntent().getStringExtra("alluid");
        listView=findViewById(R.id.listv);


        firebaseDatabase=FirebaseDatabase.getInstance();
        pb=findViewById(R.id.pb);
        pb.setVisibility(View.VISIBLE);
   imagestu=findViewById(R.id.imgstu);
        databaseReference=firebaseDatabase.getReference("User").child(uid).child("genral");
        d1=firebaseDatabase.getReference("User").child(uid).child("semester");
        Toast.makeText(this, databaseReference.getKey(), Toast.LENGTH_SHORT).show();
        name=findViewById(R.id.name);
        enrollment=findViewById(R.id.enroll);
        cgpa=findViewById(R.id.cgpa);

        attendence=findViewById(R.id.atten);
        sem=findViewById(R.id.sem);

    }
}