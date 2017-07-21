package sid.databaseexample.queries;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import sid.databaseexample.MainActivity;
import sid.databaseexample.db.DBAdapter;
import sid.databaseexample.obj.UserData;
import sid.databaseexample.tbl.DETAILS_TBL;

/**
 * Created by Siddhesh on 7/21/2017.
 */

public class InsertQueries {

    private static final String TAG = "InsertQueries";

    public static synchronized long insertData(Context context, UserData data){
        long retVal = -1;

        Log.d(TAG,"username : "+data.getUsername()+" mobile number : "+data.getMobile());

        DBAdapter adapter = DBAdapter.getInstance(context);
        adapter.open();

        ContentValues values = new ContentValues();
        values.put(DETAILS_TBL.ID,System.currentTimeMillis());
        values.put(DETAILS_TBL.NAME,data.getUsername());
        values.put(DETAILS_TBL.MOBILE_NUMBER,data.getMobile());

        retVal = adapter.getDb().insert(DETAILS_TBL.TBL_NAME,null,values);

        Log.d(TAG,"retval : "+retVal);

        return retVal;
    }
}
