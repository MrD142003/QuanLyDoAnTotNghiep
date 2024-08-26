package com.example.myprojects.bottomnav;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myprojects.R;
import com.example.myprojects.login.LoginActivity;

public class ProfileActivity extends AppCompatActivity {

    ImageButton btnBack;
    ImageButton btnSignOut;
    TextView profileName, profileEmail, profileUsername, profilePassword;
    TextView titleName, titleUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        InitWidget();
        showUserData();


        btnBack.setOnClickListener(v -> {
            onBackPressed();
        });

        btnSignOut.setOnClickListener(v ->{
            AlertDialog.Builder dialog = new AlertDialog.Builder(ProfileActivity.this);
            dialog.setMessage("Do you want to sign out ?").setTitle("Sign Out");

            dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });

            dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startActivity(new Intent(ProfileActivity.this, LoginActivity.class));
                    finish();
                }
            });

            dialog.show();

        });
    }

    private void InitWidget() {
        profileName = findViewById(R.id.profileName);
        profileEmail = findViewById(R.id.profileEmail);
        profileUsername = findViewById(R.id.profileUsername);
        profilePassword = findViewById(R.id.profilePassword);
        titleName = findViewById(R.id.titleName);
        titleUsername = findViewById(R.id.titleUsername);
        btnBack = findViewById(R.id.back_btn);
        btnSignOut = findViewById(R.id.SignoutBtn);
    }

    public void showUserData(){
        Intent intent = getIntent();

        String nameUser = intent.getStringExtra("name");
        String emailUser = intent.getStringExtra("email");
        String usernameUser = intent.getStringExtra("username");
        String passwordUser = intent.getStringExtra("password");

//        titleName.setText(nameUser);
//        titleUsername.setText(usernameUser);
//        profileName.setText(nameUser);
//        profileEmail.setText(emailUser);
//        profileUsername.setText(usernameUser);
//        profilePassword.setText(passwordUser);

    }

}