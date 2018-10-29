package api.interfaces;

import api.APIConstants;
import modal.SearchResult;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public interface ICommonAPIRequestInterface {

    @GET(APIConstants.QUERY_URL)
    Call<SearchResult> getUserSearchResult(@Query("gpssearch") String searchQuery);
}
