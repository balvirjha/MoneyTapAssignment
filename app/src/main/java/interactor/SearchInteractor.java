package interactor;

import android.util.Log;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

import api.APIClient;
import api.CommonAPIRequestClient;
import api.interfaces.ICommonAPIRequestInterface;
import events.SearchQueryEvent;
import interfaces.ISearchPageContract;
import modal.Page;
import modal.SearchResult;

/**
 * Created by BalvirJha on 29-10-2018.
 */

public class SearchInteractor implements ISearchPageContract.Interactor {

    private ISearchPageContract.Presenter mPresenter;
    List<Page> pageArrayList = new ArrayList<>();

    public SearchInteractor(ISearchPageContract.Presenter presenter) {
        mPresenter = presenter;
        mPresenter.setInteractor(this);
    }

    @Override
    public void start() {
        EventBus.getDefault().register(this);
    }

    @Override
    public void stop() {
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void callSearchQueryApi(String searchQueryParam) {
        new CommonAPIRequestClient(APIClient.getClient(mPresenter.getContext())
                .create(ICommonAPIRequestInterface.class))
                .getUserQueryResult(searchQueryParam);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchResultStarted(SearchQueryEvent.OnLoadingStart onLoadingStart) {
        Log.e("bvc", "on started");
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchResultSuccess(SearchQueryEvent.OnLoaded onLoaded) {
        SearchResult searchResult = onLoaded.getResponse();
        if (pageArrayList != null) {
            pageArrayList.clear();
        }
        if (searchResult != null && searchResult.getQuery() != null &&
                searchResult.getQuery().getPages() != null &&
                searchResult.getQuery().getPages().size() > 0)
            for (Page page : searchResult.getQuery().getPages()) {
                if (pageArrayList == null) {
                    pageArrayList = new ArrayList<>();
                }
                pageArrayList.add(page);
                mPresenter.searchQueryApiSuccess(pageArrayList);
            }
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onSearchResultFailure(SearchQueryEvent.OnLoadingError onLoadingError) {
        Log.e("bvc", "on error");
    }
}
