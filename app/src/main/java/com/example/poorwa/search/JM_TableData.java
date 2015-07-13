package com.example.poorwa.search;

/**
 * Created by poorwa on 8/7/15.
 */
import android.provider.BaseColumns;

public class JM_TableData {

    public JM_TableData()
    {

    }

    public static abstract class TableInfo implements BaseColumns
    {
        public static final String MV_NAME = "mv_name" ;
        public static final String MV_NUM = "mv_num" ;
        public static final String M_NAME = "m_name" ;
        public static final String F_ID = "f_id" ;
        public static final String H_NUM = "h_num" ;
        public static final String C_ID = "c_id" ;
        public static final String BD = "bd" ;
        public static final String VOB_NAME = "vob_name" ;
        public static final String VOB_NUM = "vob_num" ;
        public static final String B_NAME = "b_name" ;
        public static final String B_METHOD = "b_method" ;
        public static final String C_G = "c_gender" ;
        public static final String P_T = "p_time" ;
        public static final String F_M = "f_msnger" ;
        public static final String HM_NAME = "hm_name" ;
        public static final String HM_DATE = "hm_date" ;
        public static final String MMKCKD = "mmkckd" ;
        public static final String DATABASE_NAME = "SEARCH";
        public static final String TABLE_NAME = "JM";
    }

}