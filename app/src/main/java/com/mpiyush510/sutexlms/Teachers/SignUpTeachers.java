package com.mpiyush510.sutexlms.Teachers;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.mpiyush510.sutexlms.Activity.SignIn;
import com.mpiyush510.sutexlms.ExportData;
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
        binding.SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isValid()){
                    intent= new Intent(SignUpTeachers.this, ExportData.class);
                    showToast("Teacher Successfully registered !");
                    exportData();
                    startActivity(intent);
                }
            }
        });

    }
    private void CustomDatePicker(){
        materialDatePicker=MaterialDatePicker.Builder.datePicker()
                .setTitleText("SElect Your BirthDate")
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build();
    }
    private boolean isValid(){
        if(binding.FirstName.getText().toString().isEmpty()){
            showToast("Please Enter First Name");
            return false;
        }else if (binding.LastName.getText().toString().isEmpty()){
            showToast("Enter Your Surname");
            return false;
        }else if (binding.Email.getText().toString().isEmpty()){
            showToast("Please Enter your Mail");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(binding.Email.getText().toString()).matches()) {
            showToast("Enter Correct Email");
            return false;
        } else if (binding.BirthDate.getText().toString().isEmpty()) {
            showToast("Enter Tour BirthDate");
            return false;
        } else if (binding.PhoneNo.getText().toString().isEmpty()){
            showToast("Enter Your Mobile Number");
            return false;
        }else if (binding.PhoneNo.getText().toString().length() <10 ) {
            showToast("Phone No Must Be 10 Digit");
            return false;
        }  else if (binding.Tid.getText().toString().isEmpty()) {
            showToast("Enter Your Teachers ID");
            return false;
        }else{
            return true;
        }
    }
    private void exportData(){
        intent.putExtra("FirstName",binding.FirstName.getText().toString());
        intent.putExtra("LastName",binding.LastName.getText().toString());
        intent.putExtra("Email",binding.Email.getText().toString());
        intent.putExtra("BirthDate",binding.BirthDate.getText().toString());
        intent.putExtra("PhoneNo",binding.PhoneNo.getText().toString());
        intent.putExtra("Tid",binding.Tid.getText().toString());
    }
    private void showToast(String str){
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }
}