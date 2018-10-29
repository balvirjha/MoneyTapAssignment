package presenter;

import android.content.Context;

import java.util.List;

import interfaces.ISearchPageContract;
import modal.Page;
import views.SearchFragment;

/**
 * Created by BalvirJha on 29-10-2018.
 */

public class SearchPresenter implements ISearchPageContract.Presenter {
    private ISearchPageContract.View mSearchView;
    private ISearchPageContract.Interactor mSearchInteractor;

    public SearchPresenter(ISearchPageContract.View view) {
        mSearchView = view;
        mSearchView.setPresenter(this);
    }

    @Override
    public void setInteractor(ISearchPageContract.Interactor interactor) {
        mSearchInteractor = interactor;
    }

    @Override
    public void callSearchQueryApi(String searchQueryParam) {
        mSearchInteractor.callSearchQueryApi(searchQueryParam);
    }

    @Override
    public void searchQueryApiSuccess(List<Page> pageArrayList) {
        ((SearchFragment) mSearchView).displayResultInRecyclerView(pageArrayList);
    }

    @Override
    public void start() {
        mSearchInteractor.start();
    }

    @Override
    public void stop() {
        mSearchInteractor.stop();
    }

    @Override
    public Context getContext() {
        return ((SearchFragment) mSearchView).getActivity();
    }

}
