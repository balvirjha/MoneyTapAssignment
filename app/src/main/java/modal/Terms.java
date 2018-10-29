package modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class Terms implements Parcelable {

    @SerializedName("description")
    @Expose
    private List<String> description = null;
    public final static Parcelable.Creator<Terms> CREATOR = new Creator<Terms>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Terms createFromParcel(Parcel in) {
            return new Terms(in);
        }

        public Terms[] newArray(int size) {
            return (new Terms[size]);
        }

    };

    protected Terms(Parcel in) {
        in.readList(this.description, (java.lang.String.class.getClassLoader()));
    }

    public Terms() {
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(description);
    }

    public int describeContents() {
        return 0;
    }

}