package api;

import org.greenrobot.eventbus.EventBus;

import api.interfaces.ICommonAPIRequestInterface;
import events.SearchQueryEvent;
import modal.SearchResult;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by BalvirJha on 28-10-2018.
 */

public class CommonAPIRequestClient {
    private final ICommonAPIRequestInterface iCommonAPIRequestInterface;

    public CommonAPIRequestClient(ICommonAPIRequestInterface iCommonAPIRequestInterface) {
        this.iCommonAPIRequestInterface = iCommonAPIRequestInterface;
    }

    public void getUserQueryResult(String queryParam) {
        Call<SearchResult> call = iCommonAPIRequestInterface.getUserSearchResult(queryParam);

        call.enqueue(new Callback<SearchResult>() {

            @Override
            public void onResponse(Call<SearchResult> call, Response<SearchResult> response) {
                EventBus.getDefault().post(new SearchQueryEvent.OnLoaded(response.body()));
            }

            @Override
            public void onFailure(Call<SearchResult> call, Throwable error) {
                if (error != null && error.getMessage() != null) {
                    EventBus.getDefault().post(new SearchQueryEvent.OnLoadingError(error.getMessage(), -1));
                } else {
                    EventBus.getDefault().post(SearchQueryEvent.FAILED);
                }
            }
        });
    }
}
