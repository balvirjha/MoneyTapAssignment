package modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class Page implements Parcelable {

    @SerializedName("pageid")
    @Expose
    private Integer pageid;
    @SerializedName("ns")
    @Expose
    private Integer ns;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("index")
    @Expose
    private Integer index;
    @SerializedName("thumbnail")
    @Expose
    private Thumbnail thumbnail;
    @SerializedName("terms")
    @Expose
    private Terms terms;
    public final static Parcelable.Creator<Page> CREATOR = new Creator<Page>() {


        @SuppressWarnings({
                "unchecked"
        })
        public Page createFromParcel(Parcel in) {
            return new Page(in);
        }

        public Page[] newArray(int size) {
            return (new Page[size]);
        }

    };

    protected Page(Parcel in) {
        this.pageid = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.ns = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.index = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.thumbnail = ((Thumbnail) in.readValue((Thumbnail.class.getClassLoader())));
        this.terms = ((Terms) in.readValue((Terms.class.getClassLoader())));
    }

    public Page() {
    }

    public Integer getPageid() {
        return pageid;
    }

    public void setPageid(Integer pageid) {
        this.pageid = pageid;
    }

    public Integer getNs() {
        return ns;
    }

    public void setNs(Integer ns) {
        this.ns = ns;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public Thumbnail getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Thumbnail thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Terms getTerms() {
        return terms;
    }

    public void setTerms(Terms terms) {
        this.terms = terms;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(pageid);
        dest.writeValue(ns);
        dest.writeValue(title);
        dest.writeValue(index);
        dest.writeValue(thumbnail);
        dest.writeValue(terms);
    }

    public int describeContents() {
        return 0;
    }

}
