package sid.databaseexample.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import sid.databaseexample.DetailsActivity;
import sid.databaseexample.R;
import sid.databaseexample.obj.UserData;
import sid.databaseexample.queries.DeleteQueries;
import sid.databaseexample.queries.UpdateQueries;

/**
 * Created by Siddhesh on 7/22/2017.
 */

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

    Context context;
    ArrayList<UserData> u_list = new ArrayList<>();

    public DataAdapter(DetailsActivity detailsActivity, ArrayList<UserData> list) {
        context = detailsActivity;
        u_list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.details_layout,parent,false);
        return new MyViewHolder(view);
    }

    UserData data;

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        data = u_list.get(position);

        holder.tv_user.setText(data.getUsername());
        holder.tv_mobile.setText(data.getMobile());

        holder.tv_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View dialogView = inflater.inflate(R.layout.update_details, null);

                final EditText et_user = (EditText)dialogView.findViewById(R.id.et_user);
                et_user.setText(u_list.get(position).getUsername());

                final EditText et_mobile= (EditText)dialogView.findViewById(R.id.et_mobile);
                et_mobile.setText(u_list.get(position).getMobile());

                builder.setView(dialogView);
                builder.setCancelable(false);
                builder.setTitle("Update Details");
                builder.setPositiveButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        UpdateQueries.updateDetails(context,et_user.getText().toString(),et_mobile.getText().toString(),u_list.get(position).getId());
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });

        holder.tv_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DeleteQueries.deleteDetails(context,u_list.get(position).getId());
            }
        });
    }

    @Override
    public int getItemCount() {
        return u_list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_user,tv_mobile,tv_edit,tv_delete;
        public MyViewHolder(View itemView) {
            super(itemView);

            tv_user = (TextView)itemView.findViewById(R.id.tv_username);
            tv_mobile = (TextView)itemView.findViewById(R.id.tv_mobile);
            tv_edit = (TextView)itemView.findViewById(R.id.tv_edit);
            tv_delete = (TextView)itemView.findViewById(R.id.tv_delete);
        }
    }
}
