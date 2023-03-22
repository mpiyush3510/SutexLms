package com.mpiyush510.sutexlms.Teachers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.mpiyush510.sutexlms.Activity.SignIn;
import com.mpiyush510.sutexlms.R;
import com.mpiyush510.sutexlms.databinding.ActivitySignUpTeachersBinding;

public class SignUpTeachers extends AppCompatActivity {
ActivitySignUpTeachersBinding binding;
Intent intent;
MaterialDatePicker<Long> materialDatePicker;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivitySignUpTeachersBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
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
            intent=new Intent(SignUpTeachers.this, SignIn.class);
            startActivity(intent);
        });

    }
    private void CustomDatePicker(){
        materialDatePicker=MaterialDatePicker.Builder.datePicker()
                .setTitleText("SElect Your BirthDate")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
    }
}