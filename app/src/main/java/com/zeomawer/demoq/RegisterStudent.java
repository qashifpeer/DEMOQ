package com.zeomawer.demoq;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class RegisterStudent extends AppCompatActivity  {
    EditText t1,t2,t3,t4,t5,t6;
    String gender="";
    RadioButton r1,r2;
    private static final String TAG= "RegisterStudent";
    private EditText mDisplayDate;
    private DatePickerDialog.OnDateSetListener onDateSetListener ;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_student);

        mDisplayDate= (EditText) findViewById(R.id.dob);

        mDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Calendar cal=Calendar.getInstance();
                int year=cal.get(Calendar.YEAR);
                int month=cal.get(Calendar.MONTH);
                int day=cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog=new DatePickerDialog(
                        RegisterStudent.this, android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        onDateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));

                dialog.show();
            }
        });

        onDateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                 month=month+1;
                 String date=dayOfMonth+ "/" + month + "/" +year;
                 mDisplayDate.setText(date);

            }
        };

    }


    public void btn_save(View view) {

        t1=findViewById(R.id.ad_Num);
        t2=findViewById(R.id.std_name);
        t3=findViewById(R.id.father_name);
        t4=findViewById(R.id.mother_name);
        t5=findViewById(R.id.residance);
        t6=findViewById(R.id.dob);
        r1=findViewById(R.id.radio_male);
        r2=findViewById(R.id.radio_female);

        String adNo=t1.getText().toString().trim();
        String Name=t2.getText().toString().trim();
        String father_name=t3.getText().toString().trim();
        String mother_name=t4.getText().toString().trim();
        String res=t5.getText().toString().trim();
        String dob=t6.getText().toString();


        if (r1.isChecked()){
            gender="Male";
        }
        if (r2.isChecked()){
            gender="Female";
        }


        if(TextUtils.isEmpty(adNo)){
            Toast.makeText(RegisterStudent.this, "Please Enter Admission Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Name)){
            Toast.makeText(RegisterStudent.this, "Please Enter your Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(father_name)){
            Toast.makeText(RegisterStudent.this, "Please Enter Father's Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mother_name)){
            Toast.makeText(RegisterStudent.this, "Please Enter Mother's", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(res)){
            Toast.makeText(RegisterStudent.this, "Please Enter Residence", Toast.LENGTH_SHORT).show();
            return;
        }


        Students obj=new Students(Name,father_name,mother_name,res,gender,dob);
        FirebaseDatabase db=FirebaseDatabase.getInstance();


        DatabaseReference node=db.getReference("students");

        node.child(adNo).setValue(obj);
        
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");
        t6.setText("");
        r1.setChecked(false);
        r2.setChecked(false);

        Toast.makeText(this, "Data Submitted Successfully", Toast.LENGTH_SHORT).show();

    }



}








