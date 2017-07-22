package sid.databaseexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import sid.databaseexample.adapter.DataAdapter;
import sid.databaseexample.obj.UserData;
import sid.databaseexample.queries.SelectQueries;

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivity";

    RecyclerView rv;
    ArrayList<UserData> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        initControls();

        list = new ArrayList<>();

        list.clear();
        list = SelectQueries.getDetails(DetailsActivity.this);

        LinearLayoutManager manager = new LinearLayoutManager(DetailsActivity.this);
        rv.setLayoutManager(manager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(new DataAdapter(DetailsActivity.this,list));

    }

    private void initControls() {

        rv = (RecyclerView)findViewById(R.id.rv);

    }
}
