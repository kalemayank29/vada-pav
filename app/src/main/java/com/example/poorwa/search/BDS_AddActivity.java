package com.example.poorwa.search;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;

import com.example.poorwa.search.R;




public class BDS_AddActivity extends ActionBarActivity {
    DatePicker mmkckd_dp, bd_dp, dd_dp, hdd_dp;
    Button submit;
    EditText mvname_et, mvnum_et, vob_et, vobnum_et, cid_et, fid_et, hdname_et, hnum_et, cfn_et, vod_et, vodnum_et;
    EditText[] aatod_et = new EditText[3];
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bds__add);
        mvname_et = (EditText) findViewById(R.id.mvname_et);
        mvnum_et = (EditText) findViewById(R.id.mvnum_et);
        vob_et = (EditText) findViewById(R.id.vob_et);
        vobnum_et = (EditText) findViewById(R.id.vobnum_et);
        cfn_et = (EditText) findViewById(R.id.cfn_et);
        cid_et = (EditText) findViewById(R.id.cid_et);
        fid_et = (EditText) findViewById(R.id.fid_et);
        hnum_et = (EditText) findViewById(R.id.hnum_et);
        bd_dp = (DatePicker) findViewById(R.id.bd_dp);
        dd_dp = (DatePicker) findViewById(R.id.dd_dp);
        aatod_et[0] = (EditText) findViewById(R.id.aatod_et_1);
        aatod_et[1] = (EditText) findViewById(R.id.aatod_et_2);
        aatod_et[2] = (EditText) findViewById(R.id.aatod_et_3);
        vod_et = (EditText) findViewById(R.id.vod_et);
        vodnum_et = (EditText) findViewById(R.id.vodnum_et);
        hdname_et = (EditText) findViewById(R.id.hdname_et);
        hdd_dp = (DatePicker) findViewById(R.id.hdd_dp);
        mmkckd_dp = (DatePicker) findViewById(R.id.mmkckd_dp);

        submit = (Button) findViewById(R.id.add_mem_b);
    }

    public void save_click(View view) {
        String mvnameet, mvnumet, vobet, vobnumet, cfnet, cidet, fidet,
                hnumet, bddp, dddp, aatodet = "", vodet, vodnumet, hdnameet, hdddp, mmkckddp, temp;
        int aflag = 1;
        int[] flag = new int[14];

        /* EditTexts */

        if(!(mvnameet = mvname_et.getText().toString()).isEmpty()) {
            flag[0] = 1;
        }
        if(!(mvnumet = mvnum_et.getText().toString()).isEmpty()) {
            flag[1] = 1;
        }
        if(!(vobet = vob_et.getText().toString()).isEmpty()) {
            flag[2] = 1;
        }
        if(!(vobnumet = vobnum_et.getText().toString()).isEmpty()) {
            flag[3] = 1;
        }
        if(!(cfnet = cfn_et.getText().toString()).isEmpty()) {
            flag[4] = 1;
        }
        if(!(cidet = cid_et.getText().toString()).isEmpty()) {
            flag[5] = 1;
        }
        if(!(fidet = fid_et.getText().toString()).isEmpty()) {
            flag[6] = 1;
        }
        if(!(hnumet = hnum_et.getText().toString()).isEmpty()) {
            flag[7] = 1;
        }
        if(!(temp = aatod_et[0].getText().toString()).isEmpty()) {
            flag[8] = 1;
            aatodet = aatodet + temp + '/';
        }
        if(!(temp = aatod_et[1].getText().toString()).isEmpty()) {
            flag[9] = 1;
            aatodet = aatodet + temp + '/';
        }
        if(!(temp = aatod_et[2].getText().toString()).isEmpty()) {
            flag[10] = 1;
            aatodet = aatodet + temp;
        }
        if(!(vodet = vod_et.getText().toString()).isEmpty()) {
            flag[11] = 1;
        }
        if(!(vodnumet = vodnum_et.getText().toString()).isEmpty()) {
            flag[12] = 1;
        }
        if(!(hdnameet = hdname_et.getText().toString()).isEmpty()) {
            flag[13] = 1;
        }

        /* DatePickers */

        bddp = bd_dp.getYear() + "/" + Integer.toString(bd_dp.getMonth() + 1) + "/" + bd_dp.getDayOfMonth();
        dddp = dd_dp.getYear() + "/" + Integer.toString(dd_dp.getMonth() + 1) + "/" + dd_dp.getDayOfMonth();
        hdddp = hdd_dp.getYear() + "/" + Integer.toString(hdd_dp.getMonth() + 1) + "/" + hdd_dp.getDayOfMonth();
        mmkckddp = mmkckd_dp.getYear() + "/" + Integer.toString(mmkckd_dp.getMonth() + 1) + "/" + mmkckd_dp.getDayOfMonth();

        for (int i = 0; i < 14; i++) {
            if (flag[i] != 1) {
                displayalert();
                aflag = 0;
                break;
            }
        }

        if(aflag == 1) {
            Translation translation = new Translation();
            mvnameet = translation.Letter_M2E(mvnameet);
            vobet = translation.Letter_M2E(vobet);
            cfnet = translation.Letter_M2E(cfnet);
            //aatodet = translation.Letter_M2E(aatodet);
            vodet = translation.Letter_M2E(vodet);
            hdnameet = translation.Letter_M2E(hdnameet);
            Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
            BDS_DatabaseOperations DB = new BDS_DatabaseOperations(context);
            DB.putInformation(DB, mvnameet, mvnumet, vobet, vobnumet, cfnet, cidet, fidet, hnumet, bddp, dddp,
                    aatodet, vodet, vodnumet, hdnameet, hdddp, mmkckddp);
            Toast.makeText(getBaseContext(), "Registration success", Toast.LENGTH_LONG).show();
            finish();
        }

    }

    public void displayalert() {
        new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage("Fill in all entries")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bds__add, menu);
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