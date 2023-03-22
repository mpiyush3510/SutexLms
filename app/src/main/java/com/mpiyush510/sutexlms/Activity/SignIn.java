package com.mpiyush510.sutexlms.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.mpiyush510.sutexlms.MainActivity;
import com.mpiyush510.sutexlms.R;
import com.mpiyush510.sutexlms.StartUp;
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
                intent=new Intent(SignIn.this, StartUp.class);
                startActivity(intent);
            }
        });

        binding.SignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    intent= new Intent(SignIn.this, MainActivity.class);
                    showToast("Successfully SignIN !");
                    startActivity(intent);
                }
            }
        });
    }
    private boolean isValid(){
        if(binding.EmailOrPhone.getText().toString().isEmpty()){
            showToast("Please Enter Your Mail or Phone");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.EmailOrPhone.getText().toString()).matches() && !Patterns.PHONE.matcher(binding.EmailOrPhone.getText().toString()).matches()) {
            showToast("Enter Correct User ID");
            return false;
        }else if (binding.Password.getText().toString().isEmpty()) {
            showToast("Password Can't Be Empty");
            return false;
        }else if (binding.Password.getText().toString().length() <6 ) {
            showToast("Password Length Should Be 6 Character");
            return false;
        } else{
            return true;
        }
    }
    private void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}