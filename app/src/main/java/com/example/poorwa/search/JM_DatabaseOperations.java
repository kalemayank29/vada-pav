package com.example.poorwa.search;

/**
 * Created by poorwa on 8/7/15.
 */
import com.example.poorwa.search.JM_TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Columns;
import android.util.Log;

public class JM_DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.MV_NAME+" TEXT,"+TableInfo.MV_NUM+" TEXT,"
            +TableInfo.M_NAME+" TEXT,"+TableInfo.F_ID+" TEXT,"+TableInfo.H_NUM+" TEXT,"+TableInfo.C_ID+" TEXT,"
            +TableInfo.BD+" TEXT,"+TableInfo.VOB_NAME+" TEXT,"+TableInfo.VOB_NUM+" TEXT,"+TableInfo.B_NAME+" TEXT,"
            +TableInfo.B_METHOD+" TEXT,"+TableInfo.C_G+" TEXT,"+TableInfo.P_T+" TEXT,"+TableInfo.F_M+" TEXT,"
            +TableInfo.HM_NAME+" TEXT,"+TableInfo.HM_DATE+" TEXT,"+TableInfo.MMKCKD+")";


    public JM_DatabaseOperations(Context context) {
        super(context, TableInfo.DATABASE_NAME, null, database_version);
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }

    public void putInformation(JM_DatabaseOperations dop,String a,String b, String c, String d,String e,String f, String g,
                               String h,String i,String j, String k, String l,String m,String n, String o, String p, String q) {

        SQLiteDatabase SQ = dop.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TableInfo.MV_NAME, a);
        cv.put(TableInfo.MV_NUM, b);
        cv.put(TableInfo.M_NAME, c);
        cv.put(TableInfo.F_ID, d);
        cv.put(TableInfo.H_NUM, e);
        cv.put(TableInfo.C_ID, f);
        cv.put(TableInfo.BD, g);
        cv.put(TableInfo.VOB_NAME, h);
        cv.put(TableInfo.VOB_NUM, i);
        cv.put(TableInfo.B_NAME, j);
        cv.put(TableInfo.B_METHOD, k);
        cv.put(TableInfo.C_G, l);
        cv.put(TableInfo.P_T, m);
        cv.put(TableInfo.F_M, n);
        cv.put(TableInfo.HM_NAME, o);
        cv.put(TableInfo.HM_DATE, p);
        cv.put(TableInfo.MMKCKD, q);
        long r = SQ.insert(TableInfo.TABLE_NAME, null, cv);

        SQ.close();
    }

    public Cursor getInformation(JM_DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TableInfo.MV_NAME, TableInfo.MV_NUM, TableInfo.M_NAME,
                TableInfo.F_ID, TableInfo.H_NUM, TableInfo.C_ID, TableInfo.BD,
                TableInfo.VOB_NAME, TableInfo.VOB_NUM, TableInfo.B_NAME,
                TableInfo.B_METHOD, TableInfo.C_G, TableInfo.P_T, TableInfo.F_M,
                TableInfo.HM_NAME, TableInfo.HM_DATE, TableInfo.MMKCKD};
        Cursor CR = SQ.query(TableInfo.TABLE_NAME,coloumns, null, null, null, null, null);
        return CR;
    }
    public void deleteUser(JM_DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p)
    {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
        String selection = TableInfo.F_ID + " = ?";
        String args[] = {d};

        SQ.delete(TableInfo.TABLE_NAME, selection, args);
        SQ.close();
    }

    public void updateUser(JM_DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p, String q) {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableInfo.MV_NAME, a);
        cv.put(TableInfo.MV_NUM, b);
        cv.put(TableInfo.M_NAME, c);
        cv.put(TableInfo.F_ID, d);
        cv.put(TableInfo.H_NUM, e);
        cv.put(TableInfo.C_ID, f);
        cv.put(TableInfo.BD, g);
        cv.put(TableInfo.VOB_NAME, h);
        cv.put(TableInfo.VOB_NUM, i);
        cv.put(TableInfo.B_NAME, j);
        cv.put(TableInfo.B_METHOD, k);
        cv.put(TableInfo.C_G, l);
        cv.put(TableInfo.P_T, m);
        cv.put(TableInfo.F_M, n);
        cv.put(TableInfo.HM_NAME, o);
        cv.put(TableInfo.HM_DATE, p);
        cv.put(TableInfo.MMKCKD, q);
        String selection = TableInfo.F_ID + " = ?";
        String args[] = {d};
        SQ.update(TableInfo.TABLE_NAME, cv, selection, args);
        SQ.close();
    }

/*    public void updateUser(DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                             String h,String i,String j, String k, String l,String m,String n, String o, String p) {
        SQLiteDatabase DB = DOP.getWritableDatabase();
        Log.e("", p);
        ContentValues values = new ContentValues();
        values.put(TableInfo.MV_NAME, a);
        values.put(TableInfo.MV_NUM, b);
        values.put(TableInfo.VOB_NAME, c);
        values.put(TableInfo.VOB_NUM, d);
        values.put(TableInfo.CF_NAME, e);
        values.put(TableInfo.C_ID, f);
        values.put(TableInfo.H_NUM, h);
        values.put(TableInfo.BD, i);
        values.put(TableInfo.DD, j);
        values.put(TableInfo.AATOD, k);
        values.put(TableInfo.VOD_NAME, l);
        values.put(TableInfo.VOD_NUM, m);
        values.put(TableInfo.HD_NAME, n);
        values.put(TableInfo.HDD, o);
        values.put(TableInfo.MMKCKD, p);
        String selection = TableInfo.MMKCKD + " LIKE ?";
        String[] args = {g};
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = " + g, null);
        DB.update(TableInfo.TABLE_NAME, values, selection, args);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID + " = '" + g + "'", null);
        //DB.update(TableInfo.TABLE_NAME, values, TableInfo.F_ID +" = ? " + g , new String[] {g});
        DB.close();


    }
*/

/*    public Cursor getUserPass(DatabaseOperations DOP)
    {
        Log.e("CURSOR", "PROBLEM IN CURSOR0");
        SQLiteDatabase SQ = DOP.getReadableDatabase();
        //SQLiteDatabase SQ;
        //SQ = SQLiteDatabase.openOrCreateDatabase(TableInfo.DATABASE_NAME, null, null);
        Log.e("CURSOR", "PROBLEM IN CURSOR1");


        Log.e("CURSOR", "PROBLEM IN CURSOR2");
        Cursor CR = SQ.query(TableInfo.TABLE_NAME, null, null, null, null, null, null);
        Log.e("CURSOR", "PROBLEM IN CURSOR3");

        return CR;

    }
*/

}