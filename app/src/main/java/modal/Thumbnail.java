package modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class Thumbnail implements Parcelable {

    @SerializedName("source")
    @Expose
    private String source;
    @SerializedName("width")
    @Expose
    private Integer width;
    @SerializedName("height")
    @Expose
    private Integer height;
    public final static Parcelable.Creator<Thumbnail> CREATOR = new Creator<Thumbnail>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Thumbnail createFromParcel(Parcel in) {
            return new Thumbnail(in);
        }

        public Thumbnail[] newArray(int size) {
            return (new Thumbnail[size]);
        }

    };

    protected Thumbnail(Parcel in) {
        this.source = ((String) in.readValue((String.class.getClassLoader())));
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Thumbnail() {
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(source);
        dest.writeValue(width);
        dest.writeValue(height);
    }

    public int describeContents() {
        return 0;
    }

}
