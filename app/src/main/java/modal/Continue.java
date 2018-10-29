package modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class Continue implements Parcelable {

    @SerializedName("gpsoffset")
    @Expose
    private Integer gpsoffset;
    @SerializedName("continue")
    @Expose
    private String _continue;
    public final static Parcelable.Creator<Continue> CREATOR = new Creator<Continue>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Continue createFromParcel(Parcel in) {
            return new Continue(in);
        }

        public Continue[] newArray(int size) {
            return (new Continue[size]);
        }

    };

    protected Continue(Parcel in) {
        this.gpsoffset = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this._continue = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Continue() {
    }

    public Integer getGpsoffset() {
        return gpsoffset;
    }

    public void setGpsoffset(Integer gpsoffset) {
        this.gpsoffset = gpsoffset;
    }

    public String getContinue() {
        return _continue;
    }

    public void setContinue(String _continue) {
        this._continue = _continue;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(gpsoffset);
        dest.writeValue(_continue);
    }

    public int describeContents() {
        return 0;
    }

}
