package sid.databaseexample.queries;

import android.content.Context;
import android.util.Log;

import sid.databaseexample.db.DBAdapter;
import sid.databaseexample.tbl.DETAILS_TBL;

/**
 * Created by Siddhesh on 7/22/2017.
 */

public class DeleteQueries {

    private static final String TAG = "DeleteQueries";

    public static synchronized long deleteDetails(Context context, long id){
        long retVal = -1;

        DBAdapter adapter = DBAdapter.getInstance(context);
        adapter.open();

        retVal = adapter.getDb().delete(DETAILS_TBL.TBL_NAME,DETAILS_TBL.ID+" = "+id,null);

        adapter.close();

        Log.d(TAG,"retVal : "+retVal);

        return retVal;
    }
}
