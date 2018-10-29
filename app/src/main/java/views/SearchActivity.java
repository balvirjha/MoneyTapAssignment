package views;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.assignment.moneytap.moneytapassignment.R;

import views.SearchFragment;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        addSearchFragment();
    }

    private void addSearchFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new SearchFragment()).commit();
    }
}
