package views;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.assignment.moneytap.moneytapassignment.R;

import java.util.ArrayList;
import java.util.List;

import interactor.SearchInteractor;
import interfaces.ISearchPageContract;
import modal.Page;
import presenter.SearchPresenter;

/**
 * Created by BalvirJha on 29-10-2018.
 */

public class SearchFragment extends Fragment implements ISearchPageContract.View {

    private View rootView;
    private RecyclerView recycler_result_view;
    private SearchAdapter searchAdapter;
    private EditText editSearch;
    private ISearchPageContract.Presenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_search, container, false);

        SearchPresenter presenter = new SearchPresenter(this);
        new SearchInteractor(presenter);
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.start();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recycler_result_view = (RecyclerView) rootView.findViewById(R.id.recycler_result_view);
        editSearch = (EditText) rootView.findViewById(R.id.editSearch);
        editSearch.addTextChangedListener(textWatcher);
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.stop();
    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            if (TextUtils.isEmpty(charSequence.toString())) {
                displayResultInRecyclerView(new ArrayList<Page>());
            } else {
                mPresenter.callSearchQueryApi(charSequence.toString());
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void callSearchQueryApi(String searchQueryParam) {
        mPresenter.callSearchQueryApi(searchQueryParam);
    }

    @Override
    public void displayResultInRecyclerView(List<Page> pageArrayList) {
        searchAdapter = new SearchAdapter(pageArrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recycler_result_view.setLayoutManager(mLayoutManager);
        recycler_result_view.setItemAnimator(new DefaultItemAnimator());
        recycler_result_view.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();

    }

    @Override
    public void setPresenter(ISearchPageContract.Presenter presenter) {
        this.mPresenter = presenter;
    }
}
