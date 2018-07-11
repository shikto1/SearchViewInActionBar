package shishirappstudio.com.searchviewinactionbar;

import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

public class SearchViewWithNormalAdapterActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    private ListView listView;
    private String[] countries = {"Bangladesh", "Argentina", "Brazil", "Iceland", "Croatia", "Franc", "Belgium", "Nigeria", "Russia"};
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
        setupAdapter();
    }


    private void initViews() {
        listView = findViewById(R.id.list_View);
    }

    private void setupAdapter() {
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countries);
        listView.setAdapter(adapter);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.getFilter().filter(newText);
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.expandActionView();
        searchView = (SearchView) searchItem.getActionView();

        //For Modifying color of searchView text..

//        EditText searchEditText = (EditText) searchView.findViewById(android.support.v7.appcompat.R.id.search_src_text);
//        searchEditText.setTextColor(getResources().getColor(R.color.searchViewTextColor));
//        searchEditText.setHintTextColor(getResources().getColor(R.color.searchViewTextColor));

        searchView.setMaxWidth(android.R.attr.width);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            this.onBackPressed();
        }
//        switch (menuItem.getItemId()) {
//
//            case R.id.action_search:
//                if (searchView.getVisibility() == View.VISIBLE) {
//                    searchView.setVisibility(View.GONE);
//                    getSupportActionBar().setTitle("");
//                    // item.setIcon(getResources().getDrawable(R.drawable.ic_action_search));
//                } else {
//                    searchView.setVisibility(View.VISIBLE);
//                    // item.setIcon(getResources().getDrawable(R.drawable.ic_action_search_b));
//                }
//
//                return true;
//            default:
//                break;
//        }
        return super.onOptionsItemSelected(menuItem);
    }

}
