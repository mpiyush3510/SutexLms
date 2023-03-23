package com.mpiyush510.sutexlms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.mpiyush510.sutexlms.databinding.ActivityExportDataBinding;

public class ExportData extends AppCompatActivity {
ActivityExportDataBinding binding;
Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        binding=ActivityExportDataBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        Callers();
    }

    private void Callers() {
        ImportData();
    }

    private void ImportData() {
        intent = getIntent();
        String FirstName=intent.getStringExtra("FirstName");
        String Lastname=intent.getStringExtra("LastName");
        String Email=intent.getStringExtra("Email");
        String BirthDate=intent.getStringExtra("BirthDate");
        String PhoneNo=intent.getStringExtra("PhoneNo");
        String Tid=intent.getStringExtra("Tid");
        String Rno=intent.getStringExtra("Rno");
        String Division=intent.getStringExtra("Division");
        String Sid=intent.getStringExtra("Sid");

        binding.FirstName.setText(FirstName);
        binding.LastName.setText(Lastname);
        binding.Email.setText(Email);
        binding.BirthDate.setText(BirthDate);
        binding.PhoneNo.setText(PhoneNo);
        binding.Tid.setText(Tid);
        binding.Rno.setText(Rno);
        binding.Division.setText(Division);
        binding.Sid.setText(Sid);
    }
}