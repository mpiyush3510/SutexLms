package com.mpiyush510.sutexlms.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.mpiyush510.sutexlms.R;
import com.mpiyush510.sutexlms.databinding.ActivitySignInBinding;

public class SignIn extends AppCompatActivity {
ActivitySignInBinding binding;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySignInBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        binding.CreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent=new Intent(SignIn.this, SignUp.class);
                startActivity(intent);
            }
        });
    }
}