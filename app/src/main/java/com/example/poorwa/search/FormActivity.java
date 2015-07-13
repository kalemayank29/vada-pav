package com.example.poorwa.search;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class FormActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
    }

    public void gotoBDS(View view) {
        Button b = (Button)findViewById(R.id.bBDS);
        Intent BDSintent = new Intent(FormActivity.this, BDS_MainActivity.class);
        startActivity(BDSintent);
    }

    public void gotoJM(View view) {
        Button b = (Button)findViewById(R.id.bJM);
        Intent JMintent = new Intent(FormActivity.this, JM_MainActivity.class);
        startActivity(JMintent);
    }

    public void gotoCF(View view) {
        Intent CFintent = new Intent(FormActivity.this, CF_MainActivity.class);
        startActivity(CFintent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_form, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
