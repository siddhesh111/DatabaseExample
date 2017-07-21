package sid.databaseexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import sid.databaseexample.obj.UserData;
import sid.databaseexample.queries.InsertQueries;
import sid.databaseexample.queries.SelectQueries;

public class MainActivity extends AppCompatActivity {

    EditText et_user,et_mob;
    Button btn_save,btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initControls();
    }

    private void initControls() {

        et_user = (EditText)findViewById(R.id.et_user);
        et_mob = (EditText)findViewById(R.id.et_mobile);

        btn_save = (Button)findViewById(R.id.btn_save);
        btn_show = (Button)findViewById(R.id.btn_show);

        btn_save.setOnClickListener(listener);
        btn_show.setOnClickListener(listener);
    }

    Button.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.btn_save:

                    validateData();

                    break;

                case R.id.btn_show:

                    SelectQueries.getDetails(MainActivity.this);

                    break;

                default:
                    break;
            }
        }
    };

    private void validateData() {

        String username = et_user.getText().toString().trim();
        String mobile = et_mob.getText().toString().trim();

        boolean isCancel = false;
        View focusView = null;

        if(TextUtils.isEmpty(username)){
            isCancel = true;
            et_user.setError("Please enter username");
            focusView=et_user;
        }

        if(TextUtils.isEmpty(mobile)){
            isCancel = true;
            et_mob.setError("Please enter mobile number");
            focusView=et_mob;
        }

        if(isCancel){
            focusView.requestFocus();
        }else{

            UserData data = new UserData();
            data.setMobile(mobile);
            data.setUsername(username);

            InsertQueries.insertData(MainActivity.this,data);
        }
    }
}
