package com.zeomawer.demoq;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    EditText t1,t2,t3,t4,t5;
    //RadioButton r1,r2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    public void btn_save(View view) {

        t1=findViewById(R.id.ad_Num);
        t2=findViewById(R.id.std_name);
        t3=findViewById(R.id.father_name);
        t4=findViewById(R.id.mother_name);
        t5=findViewById(R.id.residance);
       // r1=findViewById(R.id.radio_male);
        //r2=findViewById(R.id.radio_female);

        String adNo=t1.getText().toString().trim();
        String Name=t2.getText().toString().trim();
        String father_name=t3.getText().toString().trim();
        String mother_name=t4.getText().toString().trim();
        String res=t5.getText().toString().trim();
        //String male=r1.getText().toString();
        //String female=r2.getText().toString();

        if(TextUtils.isEmpty(adNo)){
            Toast.makeText(MainActivity.this, "Please Enter Admission Number", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(Name)){
            Toast.makeText(MainActivity.this, "Please Enter your Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(father_name)){
            Toast.makeText(MainActivity.this, "Please Enter Father's Name", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(mother_name)){
            Toast.makeText(MainActivity.this, "Please Enter Mother's", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(res)){
            Toast.makeText(MainActivity.this, "Please Enter Residence", Toast.LENGTH_SHORT).show();
            return;
        }


        Students obj=new Students(Name,father_name,mother_name,res);
        FirebaseDatabase db=FirebaseDatabase.getInstance();
        DatabaseReference node=db.getReference("students");

        node.child(adNo).setValue(obj);
        
        t1.setText("");
        t2.setText("");
        t3.setText("");
        t4.setText("");
        t5.setText("");

        Toast.makeText(this, "Data Submitted Successfully", Toast.LENGTH_SHORT).show();

    }
}








