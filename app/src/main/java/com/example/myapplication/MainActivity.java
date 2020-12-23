package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private EditText id;
    private EditText pass;
    private Button btn;
    FirebaseAuth mauth;
    FirebaseAuth firebaseAuth;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id=findViewById(R.id.ide);
        progressBar=findViewById(R.id.kk);
        pass=findViewById(R.id.pass);
        btn=findViewById(R.id.button);
        firebaseAuth=FirebaseAuth.getInstance();
        mauth=FirebaseAuth.getInstance();
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = id.getText().toString().trim();
                String password = pass.getText().toString().trim();
                if (email.isEmpty())
                    Toast.makeText(MainActivity.this, "enter your id", Toast.LENGTH_SHORT).show();
                else if (password.isEmpty())
                    Toast.makeText(MainActivity.this, "enter the password", Toast.LENGTH_SHORT).show();
                else {
                    progressBar.setVisibility(View.VISIBLE);

                    try {

                        mauth.signInWithEmailAndPassword(email, password).addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Intent intent = new Intent(MainActivity.this, MainActivity1.class);
                                    startActivity(intent);
                                    progressBar.setVisibility(View.INVISIBLE);

                                } else {
                                    Toast.makeText(MainActivity.this, "invalid id or password", Toast.LENGTH_SHORT).show();
                                    progressBar.setVisibility(View.INVISIBLE);

                                }
                            }
                        });
                    } catch (Exception e) {

                    }
                }
            }


        });


    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=firebaseAuth.getCurrentUser();
        if(user!=null){
            startActivity(new Intent(MainActivity.this,MainActivity1.class));
            finish();
        }
    }

}