package com.example.poorwa.search;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class JM_MainActivity extends ActionBarActivity {
    Button Login, Register, Delete, Update, Family_ID;
    int status = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jm__main);
        Register = (Button) findViewById(R.id.Reg);
        Family_ID = (Button) findViewById(R.id.Family_ID);

        Register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i  = new Intent(JM_MainActivity.this, JM_AddActivity.class);
                startActivity(i);
            }
        });
        Family_ID.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                EditText fid = (EditText)(findViewById(R.id.Family_ID_et));
                status = Integer.parseInt(fid.getText().toString());
                Bundle b = new Bundle();
                b.putInt("status", status);
                Intent i  = new Intent(JM_MainActivity.this, JM_ViewForm.class);
                i.putExtras(b);
                startActivity(i);
            }
        });
    }


}