package com.example.myapplrsqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper dbobject;
    EditText et1,et2;
    Button btn_add;
    RadioGroup rg1;
    RadioButton rb1;
    CheckBox chk1,chk2,chk3,chk4;
    String strb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbobject=new DatabaseHelper(this);
        et1=(EditText)findViewById(R.id.edittext1);
        et2=(EditText)findViewById(R.id.edittext2);
        rg1=(RadioGroup)findViewById(R.id.radiogroup1);
        rb1=(RadioButton)findViewById(R.id.radioButton1);
        chk1=(CheckBox)findViewById(R.id.checkBox1);
        chk2=(CheckBox)findViewById(R.id.checkBox2);
        chk3=(CheckBox)findViewById(R.id.checkBox3);
        chk4=(CheckBox)findViewById(R.id.checkBox4);
        btn_add=(Button)findViewById(R.id.button1);
        addData();
        strb=" ";
    }


    private void addData() {
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId=rg1.getCheckedRadioButtonId();
                rb1=(RadioButton)findViewById(selectedId);
                StringBuilder strb=new StringBuilder();
                if(chk1.isChecked())
                {
                    strb.append(chk1.getText());
                }
                if(chk2.isChecked())
                {
                    strb.append(chk2.getText());
                }
                if(chk3.isChecked())
                {
                    strb.append(chk3.getText());
                }
                if(chk4.isChecked())
                {
                    strb.append(chk4.getText());
                }

                boolean isInserted = dbobject.insertData1(et1.getText().toString(), et2.getText().toString(),rb1.getText().toString(),strb.toString());
                if (isInserted) {
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Data not inserted", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}




