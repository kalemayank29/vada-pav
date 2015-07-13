package com.example.poorwa.search;

import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import android.util.Log;
import android.widget.Toast;


public class JM_AddActivity extends ActionBarActivity {
    RadioButton daai, nurse, doctor, relatives, other, girl, boy, less7, m7, m8, m8d21, m9, pdk, yes, no;
    DatePicker mmkckd_dp, bd_dp, hmdate_dp;
    Button submit;
    EditText mvname_et, mvnum_et, mname_et, vob_et, vobnum_et, cid_et, fid_et, hmname_et, hnum_et, bname_et;
    Context context = this;
    String bmethod, cgender, ptime, fmsnger;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jm__add);

        mvname_et = (EditText) findViewById(R.id.mvname_et);
        mvnum_et = (EditText) findViewById(R.id.mvnum_et);
        mname_et = (EditText) findViewById(R.id.mname_et);
        fid_et = (EditText) findViewById(R.id.fid_et);
        hnum_et = (EditText) findViewById(R.id.hnum_et);
        cid_et = (EditText) findViewById(R.id.cid_et);
        bd_dp = (DatePicker) findViewById(R.id.bd_dp);
        vob_et = (EditText) findViewById(R.id.vob_et);
        vobnum_et = (EditText) findViewById(R.id.vobnum_et);
        bname_et = (EditText) findViewById(R.id.bname_et);

        daai = (RadioButton) findViewById(R.id.daai);
        nurse = (RadioButton) findViewById(R.id.nurse);
        doctor = (RadioButton) findViewById(R.id.doctor);
        relatives = (RadioButton) findViewById(R.id.relatives);
        other = (RadioButton) findViewById(R.id.other);
        bmethod = "00000";
        daai.setChecked(false);
        nurse.setChecked(false);
        doctor.setChecked(false);
        relatives.setChecked(false);
        other.setChecked(false);


        girl = (RadioButton) findViewById(R.id.girl);
        boy = (RadioButton) findViewById(R.id.boy);
        cgender = "00";
        girl.setChecked(false);
        boy.setChecked(false);

        less7 = (RadioButton) findViewById(R.id.less7);
        m7 = (RadioButton) findViewById(R.id.m7);
        m8 = (RadioButton) findViewById(R.id.m8);
        m8d21 = (RadioButton) findViewById(R.id.m8d21);
        m9 = (RadioButton) findViewById(R.id.m9);
        pdk = (RadioButton) findViewById(R.id.pdk);
        ptime = "000000";
        less7.setChecked(false);
        m7.setChecked(false);
        m8.setChecked(false);
        m8d21.setChecked(false);
        m9.setChecked(false);
        pdk.setChecked(false);

        yes = (RadioButton) findViewById(R.id.yes);
        no = (RadioButton) findViewById(R.id.no);
        fmsnger = "00";
        yes.setChecked(false);
        no.setChecked(false);

        hmname_et = (EditText) findViewById(R.id.hmname_et);
        hmdate_dp = (DatePicker) findViewById(R.id.hmdate_dp);
        mmkckd_dp = (DatePicker) findViewById(R.id.mmkckd_dp);

        submit = (Button) findViewById(R.id.add_mem_b);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jm__add, menu);
        return true;
    }

	public void daai_click(View view) {
        daai.setChecked(true);
        nurse.setChecked(false);
        doctor.setChecked(false);
        relatives.setChecked(false);
        other.setChecked(false);
		bmethod = "10000";
	}

    public void nurse_click(View view) {
        daai.setChecked(false);
        nurse.setChecked(true);
        doctor.setChecked(false);
        relatives.setChecked(false);
        other.setChecked(false);
        bmethod = "01000";
    }

    public void doctor_click(View view) {
        daai.setChecked(false);
        nurse.setChecked(false);
        doctor.setChecked(true);
        relatives.setChecked(false);
        other.setChecked(false);
        bmethod = "00100";
    }

    public void relatives_click(View view) {
        daai.setChecked(false);
        nurse.setChecked(false);
        doctor.setChecked(false);
        relatives.setChecked(true);
        other.setChecked(false);
        bmethod = "00010";
    }

    public void other_click(View view) {
        daai.setChecked(false);
        nurse.setChecked(false);
        doctor.setChecked(false);
        relatives.setChecked(false);
        other.setChecked(true);
        bmethod = "00001";
    }

    public void girl_click(View view) {
        girl.setChecked(true);
        boy.setChecked(false);
        cgender = "10";
    }

    public void boy_click(View view) {
        girl.setChecked(false);
        boy.setChecked(true);
        cgender = "01";
    }

    public void less7_click(View view) {
        less7.setChecked(true);
        m7.setChecked(false);
        m8.setChecked(false);
        m8d21.setChecked(false);
        m9.setChecked(false);
        pdk.setChecked(false);
        ptime = "100000";
    }

    public void m7_click(View view) {
        less7.setChecked(false);
        m7.setChecked(true);
        m8.setChecked(false);
        m8d21.setChecked(false);
        m9.setChecked(false);
        pdk.setChecked(false);
        ptime = "010000";
    }

    public void m8_click(View view) {
        less7.setChecked(false);
        m7.setChecked(false);
        m8.setChecked(true);
        m8d21.setChecked(false);
        m9.setChecked(false);
        pdk.setChecked(false);
        ptime = "001000";
    }

    public void m8d21_click(View view) {
        less7.setChecked(false);
        m7.setChecked(false);
        m8.setChecked(false);
        m8d21.setChecked(true);
        m9.setChecked(false);
        pdk.setChecked(false);
        ptime = "000100";
    }
    public void m9_click(View view) {
        less7.setChecked(false);
        m7.setChecked(false);
        m8.setChecked(false);
        m8d21.setChecked(false);
        m9.setChecked(true);
        pdk.setChecked(false);
        ptime = "000010";
    }

    public void pdk_click(View view) {
        less7.setChecked(false);
        m7.setChecked(false);
        m8.setChecked(false);
        m8d21.setChecked(false);
        m9.setChecked(false);
        pdk.setChecked(true);
        ptime = "000001";
    }

    public void yes_click(View view) {
        yes.setChecked(true);
        no.setChecked(false);
        fmsnger = "10";
    }

    public void no_click(View view) {
        no.setChecked(true);
        yes.setChecked(false);
        fmsnger = "01";
    }

    public void save_click(View view) {
        String mvnameet, mvnumet, mnameet, fidet, hnumet, cidet, bddp, vobet, vobnumet,
                bname, hmnameet, hmdatedp, mmkckddp;
        int aflag = 1;
        int[] flag = new int[14];

        /* EditTexts */

        if(!(mvnameet = mvname_et.getText().toString()).isEmpty()) {
            flag[0] = 1;
        }
        if(!(mvnumet = mvnum_et.getText().toString()).isEmpty()) {
            flag[1] = 1;
        }
        if(!(mnameet = mname_et.getText().toString()).isEmpty()) {
            flag[2] = 1;
        }
        if(!(fidet = fid_et.getText().toString()).isEmpty()) {
            flag[3] = 1;
        }
        if(!(hnumet = hnum_et.getText().toString()).isEmpty()) {
            flag[4] = 1;
        }
        if(!(cidet = cid_et.getText().toString()).isEmpty()) {
            flag[5] = 1;
        }
        if(!(vobet = vob_et.getText().toString()).isEmpty()) {
            flag[6] = 1;
        }
        if(!(vobnumet = vobnum_et.getText().toString()).isEmpty()) {
            flag[7] = 1;
        }
        if(!(bname = bname_et.getText().toString()).isEmpty()) {
            flag[8] = 1;
        }
        if(!(bmethod.equals("00000")))
            flag[9] = 1;
        if(!(cgender.equals("00")))
            flag[10] = 1;
        if(!(ptime.equals("000000")))
            flag[11] = 1;
        if(!(fmsnger.equals("00")))
            flag[12] = 1;
        if(!(hmnameet = hmname_et.getText().toString()).isEmpty()) {
            flag[13] = 1;
        }


        /* DatePickers */

        bddp = bd_dp.getYear() + "/" + Integer.toString(bd_dp.getMonth() + 1) + "/" + bd_dp.getDayOfMonth();
        hmdatedp = hmdate_dp.getYear() + "/" + Integer.toString(hmdate_dp.getMonth() + 1) + "/" + hmdate_dp.getDayOfMonth();
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
            mnameet = translation.Letter_M2E(mnameet);
            bname = translation.Letter_M2E(bname);
            hmnameet = translation.Letter_M2E(hmnameet);
            Toast.makeText(getBaseContext(), "Form Submitted", Toast.LENGTH_LONG).show();
            JM_DatabaseOperations DB = new JM_DatabaseOperations(context);
            DB.putInformation(DB, mvnameet, mvnumet, mnameet, fidet, hnumet, cidet, bddp, vobet, vobnumet, bname, bmethod,
                    cgender, ptime, fmsnger, hmnameet, hmdatedp, mmkckddp);
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
