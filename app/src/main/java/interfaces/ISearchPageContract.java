package interfaces;

import android.content.Context;

import java.util.List;

import common.IBaseInteractor;
import common.IBasePresenter;
import common.IBaseView;
import modal.Page;

/**
 * Created by BalvirJha on 29-10-2018.
 */

public class ISearchPageContract {

    public interface View extends IBaseView<Presenter> {
        void displayResultInRecyclerView(List<Page> pageArrayList);
    }

    public interface Presenter extends IBasePresenter<Interactor> {
        void callSearchQueryApi(String searchQueryParam);

        void searchQueryApiSuccess(List<Page> pageArrayList);

        Context getContext();
    }

    public interface Interactor extends IBaseInteractor {
        void callSearchQueryApi(String searchQueryParam);
    }
}
