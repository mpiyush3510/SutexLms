package com.mpiyush510.sutexlms.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.mpiyush510.sutexlms.R;
import com.mpiyush510.sutexlms.Teachers.SignUpTeachers;
import com.mpiyush510.sutexlms.databinding.ActivitySignInBinding;
import com.mpiyush510.sutexlms.databinding.ActivitySignUpBinding;

public class SignUp extends AppCompatActivity {
ActivitySignUpBinding binding;
Intent intent;
MaterialDatePicker<Long> materialDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivitySignUpBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        CustomDatePicker();
        binding.BirthDateCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(),"Material_date_picker");
                materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                    @Override
                    public void onPositiveButtonClick(Long selection) {
                        binding.BirthDate.setText(materialDatePicker.getHeaderText());
                    }
                });
            }
        });

        binding.AlreadyAccount.setOnClickListener(v -> {
            intent=new Intent(SignUp.this, SignIn.class);
            startActivity(intent);
        });
    }
    private void CustomDatePicker(){
        materialDatePicker=MaterialDatePicker.Builder.datePicker()
                .setTitleText("Select Your BirthDate")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
    }
}