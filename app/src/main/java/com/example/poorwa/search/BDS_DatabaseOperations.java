package com.example.poorwa.search;

/**
 * Created by poorwa on 8/7/15.
 */
import com.example.poorwa.search.BDS_TableData.TableInfo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.SyncStateContract.Columns;
import android.util.Log;

public class BDS_DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = "CREATE TABLE "+TableInfo.TABLE_NAME+"("+TableInfo.MV_NAME+" TEXT,"+TableInfo.MV_NUM+" TEXT,"
            +TableInfo.VOB_NAME+" TEXT,"+TableInfo.VOB_NUM+" TEXT,"+TableInfo.CF_NAME+" TEXT,"+TableInfo.C_ID+" TEXT,"
            +TableInfo.F_ID+" TEXT,"+TableInfo.H_NUM+" TEXT,"+TableInfo.BD+" TEXT,"+TableInfo.DD+" TEXT,"
            +TableInfo.AATOD+" TEXT,"+TableInfo.VOD_NAME+" TEXT,"+TableInfo.VOD_NUM+" TEXT,"+TableInfo.HD_NAME+" TEXT,"
            +TableInfo.HDD+" TEXT,"+TableInfo.MMKCKD+")";


    public BDS_DatabaseOperations(Context context) {
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

    public void putInformation(BDS_DatabaseOperations dop,String a,String b, String c, String d,String e,String f, String g,
                               String h,String i,String j, String k, String l,String m,String n, String o, String p) {

        SQLiteDatabase SQ = dop.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(TableInfo.MV_NAME, a);
        cv.put(TableInfo.MV_NUM, b);
        cv.put(TableInfo.VOB_NAME, c);
        cv.put(TableInfo.VOB_NUM, d);
        cv.put(TableInfo.CF_NAME, e);
        cv.put(TableInfo.C_ID, f);
        cv.put(TableInfo.F_ID, g);
        cv.put(TableInfo.H_NUM, h);
        cv.put(TableInfo.BD, i);
        cv.put(TableInfo.DD, j);
        cv.put(TableInfo.AATOD, k);
        cv.put(TableInfo.VOD_NAME, l);
        cv.put(TableInfo.VOD_NUM, m);
        cv.put(TableInfo.HD_NAME, n);
        cv.put(TableInfo.HDD, o);
        cv.put(TableInfo.MMKCKD, p);
        long q = SQ.insert(TableInfo.TABLE_NAME, null, cv);

        SQ.close();
    }

    public Cursor getInformation(BDS_DatabaseOperations dop)
    {
        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TableInfo.MV_NAME, TableInfo.MV_NUM, TableInfo.VOB_NAME, TableInfo.VOB_NUM,
                TableInfo.CF_NAME, TableInfo.C_ID, TableInfo.F_ID, TableInfo.H_NUM,
                TableInfo.BD, TableInfo.DD, TableInfo.AATOD, TableInfo.VOD_NAME,
                TableInfo.VOD_NUM, TableInfo.HD_NAME, TableInfo.HDD, TableInfo.MMKCKD};
        Cursor CR = SQ.query(TableInfo.TABLE_NAME,coloumns, null, null, null, null, null);
        return CR;
    }
    public void deleteUser(BDS_DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p)
    {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
        String selection = TableInfo.F_ID + " = ?";
        String args[] = {g};

        SQ.delete(TableInfo.TABLE_NAME, selection, args);
        SQ.close();
    }

    public void updateUser(BDS_DatabaseOperations DOP, String a,String b, String c, String d,String e,String f, String g,
                           String h,String i,String j, String k, String l,String m,String n, String o, String p) {

        SQLiteDatabase SQ = DOP.getWritableDatabase();
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
        String selection = TableInfo.F_ID + " = ?";
        String args[] = {g};
        SQ.update(TableInfo.TABLE_NAME, values, selection, args);
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