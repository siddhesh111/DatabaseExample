package sid.databaseexample.queries;

import android.content.ContentValues;
import android.content.Context;
import android.util.Log;

import sid.databaseexample.db.DBAdapter;
import sid.databaseexample.tbl.DETAILS_TBL;

/**
 * Created by Siddhesh on 7/22/2017.
 */

public class UpdateQueries {

    private static final String TAG = "UpdateQueries";

    public static synchronized long updateDetails(Context context, String username, String mobile, long id){
        long retVal = -1;

        DBAdapter adapter = DBAdapter.getInstance(context);
        adapter.open();

        ContentValues cv = new ContentValues();
        cv.put(DETAILS_TBL.NAME,username);
        cv.put(DETAILS_TBL.MOBILE_NUMBER,mobile);

        String query = "update "+DETAILS_TBL.TBL_NAME+" set "+DETAILS_TBL.NAME+" = '"+username+"' , "+DETAILS_TBL.MOBILE_NUMBER+" = '"+mobile+"' where "+DETAILS_TBL.ID+" = "+id;

        Log.d(TAG,"query : "+query);

        retVal = adapter.getDb().update(DETAILS_TBL.TBL_NAME,cv,DETAILS_TBL.ID+" = "+id,null);

        Log.d(TAG,"retval : "+retVal);

        adapter.close();

        return retVal;
    }
}
