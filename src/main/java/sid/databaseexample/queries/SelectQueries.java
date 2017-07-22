package sid.databaseexample.queries;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import java.util.ArrayList;

import sid.databaseexample.db.DBAdapter;
import sid.databaseexample.obj.UserData;
import sid.databaseexample.tbl.DETAILS_TBL;

/**
 * Created by Siddhesh on 7/21/2017.
 */

public class SelectQueries {

    private static final String TAG = "SelectQueries";

    public static synchronized ArrayList<UserData> getDetails(Context context){
        ArrayList<UserData> list = null;
        try {
            DBAdapter adapter = DBAdapter.getInstance(context);

//            Cursor c = adapter.getDb().query(DETAILS_TBL.TBL_NAME,null,null,null,null,null,null);
            adapter.open();
            Cursor c = adapter.getDb().rawQuery("Select * from "+DETAILS_TBL.TBL_NAME,null);

            Log.d(TAG,"Count : "+c.getCount());
            int count = c.getCount();
            UserData data;

            list = new ArrayList<>();
            if(count > 0){

               while (c.moveToNext()){
                   data = new UserData();
                   data.setId(c.getLong(c.getColumnIndex(DETAILS_TBL.ID)));
                   data.setUsername(c.getString(c.getColumnIndex(DETAILS_TBL.NAME)));
                   data.setMobile(c.getString(c.getColumnIndex(DETAILS_TBL.MOBILE_NUMBER)));

                   list.add(data);
               }
            }
            c.close();
            adapter.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return list;

    }
}
