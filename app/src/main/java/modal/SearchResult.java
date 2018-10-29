package modal;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class SearchResult implements Parcelable {

    @SerializedName("batchcomplete")
    @Expose
    private Boolean batchcomplete;
    @SerializedName("continue")
    @Expose
    private Continue _continue;
    @SerializedName("query")
    @Expose
    private Query query;
    public final static Parcelable.Creator<SearchResult> CREATOR = new Creator<SearchResult>() {


        @SuppressWarnings({
                "unchecked"
        })
        public SearchResult createFromParcel(Parcel in) {
            return new SearchResult(in);
        }

        public SearchResult[] newArray(int size) {
            return (new SearchResult[size]);
        }

    };

    protected SearchResult(Parcel in) {
        this.batchcomplete = ((Boolean) in.readValue((Boolean.class.getClassLoader())));
        this._continue = ((Continue) in.readValue((Continue.class.getClassLoader())));
        this.query = ((Query) in.readValue((Query.class.getClassLoader())));
    }

    public SearchResult() {
    }

    public Boolean getBatchcomplete() {
        return batchcomplete;
    }

    public void setBatchcomplete(Boolean batchcomplete) {
        this.batchcomplete = batchcomplete;
    }

    public Continue getContinue() {
        return _continue;
    }

    public void setContinue(Continue _continue) {
        this._continue = _continue;
    }

    public Query getQuery() {
        return query;
    }

    public void setQuery(Query query) {
        this.query = query;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(batchcomplete);
        dest.writeValue(_continue);
        dest.writeValue(query);
    }

    public int describeContents() {
        return 0;
    }

}