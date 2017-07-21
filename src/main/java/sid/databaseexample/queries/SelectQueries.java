package sid.databaseexample.queries;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import sid.databaseexample.db.DBAdapter;
import sid.databaseexample.tbl.DETAILS_TBL;

/**
 * Created by Siddhesh on 7/21/2017.
 */

public class SelectQueries {

    private static final String TAG = "SelectQueries";

    public static synchronized void getDetails(Context context){

        DBAdapter adapter = DBAdapter.getInstance(context);

        Cursor c = adapter.getDb().query(DETAILS_TBL.TBL_NAME,null,null,null,null,null,null);

        Log.d(TAG,"Count : "+c.getCount());
    }
}
