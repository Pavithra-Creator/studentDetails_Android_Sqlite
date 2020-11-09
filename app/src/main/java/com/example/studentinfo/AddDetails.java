package com.example.studentinfo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddDetails extends AppCompatActivity {

    DbHelper dbHelper;
    EditText student_id_edt, m1_edt, m2_edt, m3_edt;
    Button addBtnn;
    String stuid, m1, m2, m3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_details);

        student_id_edt = findViewById(R.id.edtID);
        m1_edt = findViewById(R.id.edtM1);
        m2_edt = findViewById(R.id.edtM2);
        m3_edt = findViewById(R.id.edtM3);
        addBtnn = findViewById(R.id.addBtn);

        addBtnn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                stuid = student_id_edt.getText().toString();
                m1 = m1_edt.getText().toString();
                m2 = m2_edt.getText().toString();
                m3 = m3_edt.getText().toString();

                if(stuid.equals("")){
                    Toast.makeText(AddDetails.this, "Student ID should not empty", Toast.LENGTH_SHORT).show();
                } else if (m1.equals("")) {
                    Toast.makeText(AddDetails.this, "Mark1 should not empty", Toast.LENGTH_SHORT).show();
                } else if (m2.equals("")) {
                    Toast.makeText(AddDetails.this, "Mark2 should not empty", Toast.LENGTH_SHORT).show();
                } else if (m3.equals("")) {
                    Toast.makeText(AddDetails.this, "Mark3 should not empty", Toast.LENGTH_SHORT).show();
                } else {
                    dbHelper = new DbHelper(getApplicationContext());
                    dbHelper.insertUserDetails(stuid, m1, m2, m3);
                    Toast.makeText(AddDetails.this, "Added successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(AddDetails.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

    }
}