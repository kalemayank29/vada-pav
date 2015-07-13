package com.example.poorwa.search;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;


public class BDS_ViewForm extends ActionBarActivity {
    Context context = this;
    EditText at, bt, ct, dt, et, ft, gt, ht, lt, mt, nt;
    EditText[] kt = new EditText[3];
    DatePicker it, jt, ot, pt;
    String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "",
            j = "", k = "", l = "", m = "", n = "", o = "", p = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.bds__view_form);
        Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
        Bundle bdl = getIntent().getExtras();

        int status = bdl.getInt("status");

        BDS_DatabaseOperations DOP = new BDS_DatabaseOperations(context);

        Cursor CR = DOP.getInformation(DOP);

        Translation TR = new Translation();
        CR.moveToFirst();
        boolean loginstatus = false;

        at = (EditText) (findViewById(R.id.mvname_et));
        bt = (EditText) (findViewById(R.id.mvnum_et));
        ct = (EditText) (findViewById(R.id.vob_et));
        dt = (EditText) (findViewById(R.id.vobnum_et));
        et = (EditText) (findViewById(R.id.cfn_et));
        ft = (EditText) (findViewById(R.id.cid_et));
        gt = (EditText) (findViewById(R.id.fid_et));
        ht = (EditText) (findViewById(R.id.hnum_et));
        it = (DatePicker) (findViewById(R.id.bd_dp));
        jt = (DatePicker) (findViewById(R.id.dd_dp));
        kt[0] = (EditText) (findViewById(R.id.aatod_et_1));
        kt[1] = (EditText) (findViewById(R.id.aatod_et_2));
        kt[2] = (EditText) (findViewById(R.id.aatod_et_3));
        lt = (EditText) (findViewById(R.id.vod_et));
        mt = (EditText) (findViewById(R.id.vodnum_et));
        nt = (EditText) (findViewById(R.id.hdname_et));
        ot = (DatePicker) (findViewById(R.id.hdd_dp));
        pt = (DatePicker) (findViewById(R.id.mmkckd_dp));

        do {
            if (Integer.toString(status).equals(CR.getString(6))) {
                loginstatus = true;
                a = TR.Letter_E2M(CR.getString(0));
                b = (CR.getString(1));
                c = TR.Letter_E2M(CR.getString(2));
                d = (CR.getString(3));
                e = TR.Letter_E2M(CR.getString(4));
                f = (CR.getString(5));
                g = CR.getString(6);
                h = (CR.getString(7));
                i = (CR.getString(8));
                j = (CR.getString(9));
                k = (CR.getString(10));
                l = TR.Letter_E2M(CR.getString(11));
                m = (CR.getString(12));
                n = TR.Letter_E2M(CR.getString(13));
                o = (CR.getString(14));
                p = (CR.getString(15));
            }
        } while (CR.moveToNext());

        if (loginstatus) {
            at.setHint(a);
            bt.setHint(b);
            ct.setHint(c);
            dt.setHint(d);
            et.setHint(e);
            ft.setHint(f);
            gt.setHint(g);
            ht.setHint(h);
            setDate(i, it);
            setDate(j, jt);
            setAATODHint(k);
            lt.setHint(l);
            mt.setHint(m);
            nt.setHint(n);
            setDate(o, ot);
            setDate(p, pt);
        }

    }

    public void setAATODHint(String age) {
        int[] index = new int[2];
        int count = 0;

        for(int i = 0; i < age.length(); i++) {
            if(age.charAt(i) == '/') {
                index[count] = i;
                count++;
            }
            if(count == 2)
                break;
        }

        kt[0].setHint(age.substring(0, index[0]));
        kt[1].setHint(age.substring(index[0] + 1, index[1]));
        kt[2].setHint(age.substring(index[1] + 1, age.length()));
    }

    public void setDate(String date, DatePicker datePicker) {
        int[] index = new int[2];
        int count = 0;

        for(int i = 0; i < date.length(); i++) {
            if(date.charAt(i) == '/') {
                index[count] = i;
                count++;
            }
            if(count == 2)
                break;
        }
        int year = Integer.parseInt(date.substring(0, index[0]));
        int month = Integer.parseInt(date.substring(index[0] + 1, index[1]));
        int dayofmonth = Integer.parseInt(date.substring(index[1] + 1, date.length()));
        Calendar cal = Calendar.getInstance();
        cal.set(year, month, dayofmonth);
        datePicker.updateDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) - 1, cal.get(Calendar.DATE));
    }

    public void submit(View view) {
        BDS_DatabaseOperations DB = new BDS_DatabaseOperations(context);
        Translation TR = new Translation();

        String mvnameet, mvnumet, vobet, vobnumet, cfnet, cidet, fidet,
                hnumet, bddp, dddp, aatodet = "", vodet, vodnumet, hdnameet, hdddp, mmkckddp, temp;

        if((mvnameet = at.getText().toString()).isEmpty())
            mvnameet = at.getHint().toString();

        if((mvnumet = bt.getText().toString()).isEmpty())
            mvnumet = bt.getHint().toString();

        if((vobet = ct.getText().toString()).isEmpty())
            vobet = ct.getHint().toString();

        if((vobnumet = dt.getText().toString()).isEmpty())
            vobnumet = dt.getHint().toString();

        if((cfnet = et.getText().toString()).isEmpty())
            cfnet = et.getHint().toString();

        if((cidet = ft.getText().toString()).isEmpty())
            cidet = ft.getHint().toString();

        if((hnumet = ht.getText().toString()).isEmpty())
            hnumet = ht.getHint().toString();

        if((fidet = gt.getText().toString()).isEmpty())
            fidet = g;

        bddp = it.getYear() + "/" + Integer.toString(it.getMonth() + 1) + "/" + it.getDayOfMonth();
        dddp = jt.getYear() + "/" + Integer.toString(jt.getMonth() + 1) + "/" + jt.getDayOfMonth();

        if((kt[0].getText().toString()).isEmpty() || (kt[1].getText().toString()).isEmpty() ||
                (kt[2].getText().toString()).isEmpty()) {
            aatodet = k;
        }
        else {
            aatodet = kt[0].getText().toString() + '/' +  (kt[1].getText().toString()) + '/' +
                    kt[2].getText().toString();
        }

        if((vodet = lt.getText().toString()).isEmpty())
            vodet = lt.getHint().toString();

        if((vodnumet = mt.getText().toString()).isEmpty())
            vodnumet = mt.getHint().toString();

        if((hdnameet = nt.getText().toString()).isEmpty())
            hdnameet = nt.getHint().toString();

        hdddp = ot.getYear() + "/" + Integer.toString(ot.getMonth() + 1) + "/" + ot.getDayOfMonth();
        mmkckddp = pt.getYear() + "/" + Integer.toString(pt.getMonth() + 1) + "/" + pt.getDayOfMonth();

        mvnameet = TR.Letter_M2E(mvnameet);
        vobet = TR.Letter_M2E(vobet);
        cfnet = TR.Letter_M2E(cfnet);
        //aatodet = TR.Letter_M2E(aatodet);
        vodet = TR.Letter_M2E(vodet);
        hdnameet = TR.Letter_M2E(hdnameet);

        DB.updateUser(DB, mvnameet, mvnumet, vobet, vobnumet, cfnet, cidet, fidet,
                hnumet, bddp, dddp, aatodet, vodet, vodnumet, hdnameet, hdddp, mmkckddp);

        Toast.makeText(getBaseContext(), "Form Resubmitted", Toast.LENGTH_LONG).show();
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_bds__view_form, menu);
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