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
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.Calendar;


public class JM_ViewForm extends ActionBarActivity {
    Context context = this;
    EditText at, bt, ct, dt, et, ft, ht, it, jt, ot;
    RadioButton[] kt = new RadioButton[5];
    RadioButton[] lt = new RadioButton[2];
    RadioButton[] mt = new RadioButton[6];
    RadioButton[] nt = new RadioButton[2];
    DatePicker gt, pt, qt;
    String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "", i = "",
            j = "", k = "", l = "", m = "", n = "", o = "", p = "", q = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.jm__view_form);
        Toast.makeText(getBaseContext(), "Please wait...", Toast.LENGTH_LONG).show();
        Bundle bdl = getIntent().getExtras();

        int status = bdl.getInt("status");

        JM_DatabaseOperations DOP = new JM_DatabaseOperations(context);

        Cursor CR = DOP.getInformation(DOP);

        Translation TR = new Translation();
        CR.moveToFirst();
        boolean loginstatus = false;

        at = (EditText) (findViewById(R.id.mvname_et));
        bt = (EditText) (findViewById(R.id.mvnum_et));
        ct = (EditText) (findViewById(R.id.mname_et));
        dt = (EditText) (findViewById(R.id.fid_et));
        et = (EditText) (findViewById(R.id.hnum_et));
        ft = (EditText) (findViewById(R.id.cid_et));
        gt = (DatePicker) (findViewById(R.id.bd_dp));
        ht = (EditText) (findViewById(R.id.vob_et));
        it = (EditText) (findViewById(R.id.vobnum_et));
        jt = (EditText) (findViewById(R.id.bname_et));
        kt[0] = (RadioButton) (findViewById(R.id.daai));
        kt[1] = (RadioButton) (findViewById(R.id.nurse));
        kt[2] = (RadioButton) (findViewById(R.id.doctor));
        kt[3] = (RadioButton) (findViewById(R.id.relatives));
        kt[4] = (RadioButton) (findViewById(R.id.other));
        lt[0] = (RadioButton) (findViewById(R.id.girl));
        lt[1] = (RadioButton) (findViewById(R.id.boy));
        mt[0] = (RadioButton) (findViewById(R.id.less7));
        mt[1] = (RadioButton) (findViewById(R.id.m7));
        mt[2] = (RadioButton) (findViewById(R.id.m8));
        mt[3] = (RadioButton) (findViewById(R.id.m8d21));
        mt[4] = (RadioButton) (findViewById(R.id.m9));
        mt[5] = (RadioButton) (findViewById(R.id.pdk));
        nt[0] = (RadioButton) (findViewById(R.id.yes));
        nt[1] = (RadioButton) (findViewById(R.id.no));
        ot = (EditText) (findViewById(R.id.hmname_et));
        pt = (DatePicker) (findViewById(R.id.hmdate_dp));
        qt = (DatePicker) (findViewById(R.id.mmkckd_dp));

        do {
            if (Integer.toString(status).equals(CR.getString(3))) {
                loginstatus = true;
                a = TR.Letter_E2M(CR.getString(0));
                b = (CR.getString(1));
                c = TR.Letter_E2M(CR.getString(2));
                d = (CR.getString(3));
                e = (CR.getString(4));
                f = (CR.getString(5));
                g = (CR.getString(6));
                h = TR.Letter_E2M(CR.getString(7));
                i = (CR.getString(8));
                j = TR.Letter_E2M(CR.getString(9));
                k = (CR.getString(10));
                l = (CR.getString(11));
                m = (CR.getString(12));
                n = (CR.getString(13));
                o = TR.Letter_E2M(CR.getString(14));
                p = (CR.getString(15));
                q = (CR.getString(16));
            }
        } while (CR.moveToNext());

        if (loginstatus) {
            at.setHint(a);
            bt.setHint(b);
            ct.setHint(c);
            dt.setHint(d);
            et.setHint(e);
            ft.setHint(f);
            setDate(g, gt);
            ht.setHint(h);
            it.setHint(i);
            jt.setHint(j);
            setbmethodRB();
            setcgenderRB();
            setptimeRB();
            setfmsngerRB();
            setDate(p, pt);
            setDate(q, qt);

        }

    }

    public void setbmethodRB() {
        char[] ch = new char[5];
        boolean[] bool = new boolean[5];
        for(int i = 0; i < 5; i++) {
            ch[i] = k.charAt(i);
            if(ch[i] == '0') {
                bool[i] = false;
            }
            else
                bool[i] = true;
        }
        kt[0].setChecked(bool[0]);
        kt[1].setChecked(bool[1]);
        kt[2].setChecked(bool[2]);
        kt[3].setChecked(bool[3]);
        kt[4].setChecked(bool[4]);
    }

    public void setcgenderRB() {
        char[] ch = new char[2];
        boolean[] bool = new boolean[2];
        for(int i = 0; i < 2; i++) {
            ch[i] = l.charAt(i);
            if(ch[i] == '0') {
                bool[i] = false;
            }
            else
                bool[i] = true;
        }
        lt[0].setChecked(bool[0]);
        lt[1].setChecked(bool[1]);
    }

    public void setptimeRB() {
        char[] ch = new char[6];
        boolean[] bool = new boolean[6];
        for(int i = 0; i < 6; i++) {
            ch[i] = m.charAt(i);
            if(ch[i] == '0') {
                bool[i] = false;
            }
            else
                bool[i] = true;
        }
        mt[0].setChecked(bool[0]);
        mt[1].setChecked(bool[1]);
        mt[2].setChecked(bool[2]);
        mt[3].setChecked(bool[3]);
        mt[4].setChecked(bool[4]);
        mt[5].setChecked(bool[5]);
    }

    public void setfmsngerRB() {
        char[] ch = new char[2];
        boolean[] bool = new boolean[2];
        for(int i = 0; i < 2; i++) {
            ch[i] = k.charAt(i);
            if(ch[i] == '0') {
                bool[i] = false;
            }
            else
                bool[i] = true;
        }
        nt[0].setChecked(bool[0]);
        nt[1].setChecked(bool[1]);
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

    public void daai_click(View view) {
        kt[0].setChecked(true);
        kt[1].setChecked(false);
        kt[2].setChecked(false);
        kt[3].setChecked(false);
        kt[4].setChecked(false);
        k = "10000";
    }

    public void nurse_click(View view) {
        kt[0].setChecked(false);
        kt[1].setChecked(true);
        kt[2].setChecked(false);
        kt[3].setChecked(false);
        kt[4].setChecked(false);
        k = "01000";
    }

    public void doctor_click(View view) {
        kt[0].setChecked(false);
        kt[1].setChecked(false);
        kt[2].setChecked(true);
        kt[3].setChecked(false);
        kt[4].setChecked(false);
        k = "00100";
    }

    public void relatives_click(View view) {
        kt[0].setChecked(false);
        kt[1].setChecked(false);
        kt[2].setChecked(false);
        kt[3].setChecked(true);
        kt[4].setChecked(false);
        k = "00010";
    }

    public void other_click(View view) {
        kt[0].setChecked(false);
        kt[1].setChecked(false);
        kt[2].setChecked(false);
        kt[3].setChecked(false);
        kt[4].setChecked(true);
        k = "00001";
    }

    public void girl_click(View view) {
        lt[0].setChecked(true);
        lt[1].setChecked(false);
        l = "10";
    }

    public void boy_click(View view) {
        lt[0].setChecked(false);
        lt[1].setChecked(true);
        l = "01";
    }

    public void less7_click(View view) {
        mt[0].setChecked(true);
        mt[1].setChecked(false);
        mt[2].setChecked(false);
        mt[3].setChecked(false);
        mt[4].setChecked(false);
        mt[5].setChecked(false);
        m = "100000";
    }

    public void m7_click(View view) {
        mt[0].setChecked(false);
        mt[1].setChecked(true);
        mt[2].setChecked(false);
        mt[3].setChecked(false);
        mt[4].setChecked(false);
        mt[5].setChecked(false);
        m = "010000";
    }

    public void m8_click(View view) {
        mt[0].setChecked(false);
        mt[1].setChecked(false);
        mt[2].setChecked(true);
        mt[3].setChecked(false);
        mt[4].setChecked(false);
        mt[5].setChecked(false);
        m = "001000";
    }

    public void m8d21_click(View view) {
        mt[0].setChecked(false);
        mt[1].setChecked(false);
        mt[2].setChecked(false);
        mt[3].setChecked(false);
        mt[4].setChecked(true);
        mt[5].setChecked(false);
        m = "000100";
    }
    public void m9_click(View view) {
        mt[0].setChecked(false);
        mt[1].setChecked(false);
        mt[2].setChecked(false);
        mt[3].setChecked(false);
        mt[4].setChecked(true);
        mt[5].setChecked(false);
        m = "000010";
    }

    public void pdk_click(View view) {
        mt[0].setChecked(false);
        mt[1].setChecked(false);
        mt[2].setChecked(false);
        mt[3].setChecked(false);
        mt[4].setChecked(false);
        mt[5].setChecked(true);
        m = "000001";
    }

    public void yes_click(View view) {
        nt[0].setChecked(true);
        nt[1].setChecked(false);
        n = "10";
    }

    public void no_click(View view) {
        nt[0].setChecked(true);
        nt[1].setChecked(false);
        n = "01";
    }

    public void submit(View view) {
        JM_DatabaseOperations DB = new JM_DatabaseOperations(context);
        Translation TR = new Translation();

        String mvnameet, mvnumet, mnameet, fidet, hnumet, cidet, bddp, vobet, vobnumet,
                bname, bmethod, cgender, ptime, fmsnger, hmnameet, hmdatedp, mmkckddp;

        if((mvnameet = at.getText().toString()).isEmpty())
            mvnameet = at.getHint().toString();

        if((mvnumet = bt.getText().toString()).isEmpty())
            mvnumet = bt.getHint().toString();

        if((mnameet = ct.getText().toString()).isEmpty())
            mnameet = ct.getHint().toString();

        if((fidet = dt.getText().toString()).isEmpty())
            fidet = d;

        if((hnumet = et.getText().toString()).isEmpty())
            hnumet = et.getHint().toString();

        if((cidet = ft.getText().toString()).isEmpty())
            cidet = ft.getHint().toString();

        bddp = gt.getYear() + "/" + Integer.toString(gt.getMonth() + 1) + "/" + gt.getDayOfMonth();

        if((vobet = ht.getText().toString()).isEmpty())
            vobet = ht.getHint().toString();

        if((vobnumet = it.getText().toString()).isEmpty())
            fidet = it.getHint().toString();

        if((bname = jt.getText().toString()).isEmpty())
            bname = jt.getHint().toString();

        bmethod = k;
        cgender = l;
        ptime = m;
        fmsnger = n;

        if((hmnameet = ot.getText().toString()).isEmpty())
            hmnameet = ot.getHint().toString();



        hmdatedp = pt.getYear() + "/" + Integer.toString(pt.getMonth() + 1) + "/" + pt.getDayOfMonth();
        mmkckddp = qt.getYear() + "/" + Integer.toString(qt.getMonth() + 1) + "/" + qt.getDayOfMonth();

        mvnameet = TR.Letter_M2E(mvnameet);
        vobet = TR.Letter_M2E(vobet);
        mnameet = TR.Letter_M2E(mnameet);
        hmnameet = TR.Letter_M2E(hmnameet);
        bname = TR.Letter_M2E(bname);

        DB.updateUser(DB, mvnameet, mvnumet, mnameet, fidet, hnumet, cidet, bddp, vobet, vobnumet,
                bname, bmethod, cgender, ptime, fmsnger, hmnameet, hmdatedp, mmkckddp);

        Toast.makeText(getBaseContext(), "Form Resubmitted", Toast.LENGTH_LONG).show();
        finish();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_jm__view_form, menu);
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