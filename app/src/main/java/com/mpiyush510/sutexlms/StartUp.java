package com.mpiyush510.sutexlms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.mpiyush510.sutexlms.Activity.SignUp;
import com.mpiyush510.sutexlms.Teachers.SignUpTeachers;
import com.mpiyush510.sutexlms.databinding.ActivityStartUpBinding;

public class StartUp extends AppCompatActivity {
ActivityStartUpBinding binding;
Intent intent;
MaterialAlertDialogBuilder materialAlertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityStartUpBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.Student.setOnClickListener(v -> {
            intent =new Intent(StartUp.this, SignUp.class);
            startActivity(intent);
        });
        binding.Teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(StartUp.this, SignUpTeachers.class);
                startActivity(intent);
            }
        });

        binding.MadeWithIndia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CustomAlertDialog();
            }
        });
    }

    private void CustomAlertDialog(){
        materialAlertDialogBuilder=new MaterialAlertDialogBuilder(this)
                .setTitle("Admin")
                .setMessage(" Developer : Piyush Makwana 😁\n SutexLms Library Management System , Which helps you to manage your Library Books !")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        materialAlertDialogBuilder.create().show();
    }
}