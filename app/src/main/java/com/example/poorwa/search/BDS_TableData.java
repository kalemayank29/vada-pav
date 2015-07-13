package com.example.poorwa.search;

/**
 * Created by poorwa on 8/7/15.
 */
import android.provider.BaseColumns;

public class BDS_TableData {

    public BDS_TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String MV_NAME = "mv_name" ;
        public static final String MV_NUM = "mv_num" ;
        public static final String VOB_NAME = "vob_name" ;
        public static final String VOB_NUM = "vob_num" ;
        public static final String CF_NAME = "cf_name" ;
        public static final String C_ID = "c_id" ;
        public static final String F_ID = "f_id" ;
        public static final String H_NUM = "h_num" ;
        public static final String BD = "bd" ;
        public static final String DD = "dd" ;
        public static final String AATOD = "aatod" ;
        public static final String VOD_NAME = "vod_name" ;
        public static final String VOD_NUM = "vod_num" ;
        public static final String HD_NAME = "hd_name" ;
        public static final String HDD = "hdd" ;
        public static final String MMKCKD = "mmkckd" ;
        public static final String DATABASE_NAME = "SEARCH";
        public static final String TABLE_NAME = "BDS";
    }

}