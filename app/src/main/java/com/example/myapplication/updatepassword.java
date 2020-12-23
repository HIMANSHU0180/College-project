package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class updatepassword extends AppCompatActivity {
     FirebaseAuth firebaseAuth;
     EditText newpass;
     EditText reenter;
     Button bt;
     String neww;
     String again;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_updatepassword);
        firebaseAuth=FirebaseAuth.getInstance();
        newpass=findViewById(R.id.newpass);
        reenter=findViewById(R.id.reenter);
        bt=findViewById(R.id.update);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                neww=newpass.getText().toString();
                again=reenter.getText().toString();
                if(neww.isEmpty())
                    Toast.makeText(updatepassword.this, "please enter the password", Toast.LENGTH_SHORT).show();
               else if(again.isEmpty())
                    Toast.makeText(updatepassword.this, "  enter password again", Toast.LENGTH_SHORT).show();
               else if(neww.length()<8)
                    Toast.makeText(updatepassword.this, "password must be of 8 charecter", Toast.LENGTH_SHORT).show();
               else if(!neww.equals(again))
                    Toast.makeText(updatepassword.this, "password donot match", Toast.LENGTH_SHORT).show();
               else{
                    FirebaseUser user = firebaseAuth.getCurrentUser();


                    user.updatePassword(neww)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Toast.makeText(updatepassword.this, "Password Updated", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(updatepassword.this,MainActivity1.class));
                                    }
                                }
                            });
                }
            }
        });

    }
}