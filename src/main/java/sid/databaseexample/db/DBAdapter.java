package sid.databaseexample.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import sid.databaseexample.tbl.DETAILS_TBL;

/**
 * Created by Siddhesh on 7/20/2017.
 */

public class DBAdapter {

    public DBAdapter(){};

    private static String DB_NAME = "DETAILS";
    private SQLiteDatabase dbObject;
    private static int db_version = 1;

    public static DBAdapter adapter;

    private static DBHelper helper;

    public SQLiteDatabase getDb(){
        return dbObject;
    }

    private DBAdapter(Context context){
        helper = new DBHelper(context);
    }

    public static synchronized DBAdapter getInstance(Context context){
        if(adapter == null){
            adapter = new DBAdapter(context);
        }

        return adapter;
    }

    private static class DBHelper extends SQLiteOpenHelper {
        public DBHelper(Context context) {
            super(context, DB_NAME, null, db_version);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {
            sqLiteDatabase.execSQL(DETAILS_TBL.createTable());
        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVer, int newVer) {
            db_version = newVer;
            sqLiteDatabase.execSQL(DETAILS_TBL.dropTable());
            onCreate(sqLiteDatabase);
        }
    }

    public DBAdapter open(){
        dbObject = helper.getWritableDatabase();
        return this;
    }

    public void close(){
        dbObject.close();
    }
}
