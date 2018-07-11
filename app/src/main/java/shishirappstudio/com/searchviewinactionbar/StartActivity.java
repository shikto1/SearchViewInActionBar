package shishirappstudio.com.searchviewinactionbar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    private Button searchViewWithNormalAdapterBtn;
    private Button searchViewWithCustomAdapterBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        initViews();
    }

    private void initViews() {
        searchViewWithNormalAdapterBtn = findViewById(R.id.searchViewWith_NormalAdapter_Btn);
        searchViewWithCustomAdapterBtn = findViewById(R.id.searchViewWith_CustomAdapter_Btn);

        searchViewWithNormalAdapterBtn.setOnClickListener(this);
        searchViewWithCustomAdapterBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.searchViewWith_NormalAdapter_Btn: {
                Intent intent = new Intent(this, SearchViewWithNormalAdapterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
            case R.id.searchViewWith_CustomAdapter_Btn: {
                Intent intent = new Intent(this, SearchViewWithCustomAdapterActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            }
        }
    }
}
