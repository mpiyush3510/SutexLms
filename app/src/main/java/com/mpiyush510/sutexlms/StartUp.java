package com.mpiyush510.sutexlms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mpiyush510.sutexlms.Activity.SignUp;
import com.mpiyush510.sutexlms.Teachers.SignUpTeachers;
import com.mpiyush510.sutexlms.databinding.ActivityStartUpBinding;

public class StartUp extends AppCompatActivity {
ActivityStartUpBinding binding;
Intent intent;
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
    }
}