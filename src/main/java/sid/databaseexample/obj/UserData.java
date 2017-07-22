package sid.databaseexample.obj;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Siddhesh on 7/21/2017.
 */

public class UserData implements Parcelable{

    String username = "";
    String mobile = "";
    long id;


    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }
}
