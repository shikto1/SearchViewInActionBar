package shishirappstudio.com.searchviewinactionbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class SearchViewWithCustomAdapterActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    private ListView listView;
    private ArrayList<Student> studentArrayList;
    private StudentAdapter studentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_view_with_custom_adapter);
        initViews();
        setupCustomAdapter();
    }

    private void initViews() {
        listView = findViewById(R.id.list_View);
    }

    private void setupCustomAdapter() {
        createStudentDataList();
        studentAdapter = new StudentAdapter(this, studentArrayList);
        listView.setAdapter(studentAdapter);
    }

    private void createStudentDataList() {
        studentArrayList = new ArrayList<>();
        studentArrayList.add(new Student("Shikto Shishir", "Dhaka"));
        studentArrayList.add(new Student("Shojib Flamon", "Khilkhet"));
        studentArrayList.add(new Student("Abdul Sohel", "Barishal"));
        studentArrayList.add(new Student("Abu Usman", "Comilla"));
        studentArrayList.add(new Student("Shahin Alam", "Bogura"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        searchItem.expandActionView();
        searchView = (SearchView) searchItem.getActionView();
        searchView.setMaxWidth(android.R.attr.width);
        searchView.setOnQueryTextListener(this);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        studentAdapter.getFilter().filter(newText);
        return true;
    }
}
