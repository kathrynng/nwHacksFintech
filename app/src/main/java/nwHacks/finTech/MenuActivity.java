package nwHacks.finTech;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MenuActivity extends AppCompatActivity {
    private DrawerLayout mDrawerLayout;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    //FOR STOCK DETAILS
    static TableRow tblRow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_layout);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReferenceFromUrl("https://nwhacks-fintech.firebaseio.com/data");

        mDrawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        View menuView = findViewById(R.id.viewMenu);
        menuView.setTop(toolbar.getHeight());

        Log.d("pass", String.valueOf(toolbar.getHeight()));

        ActionBar actionbar = getSupportActionBar();

        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.menuicon);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });


//        TableLayout tblStocks = findViewById(R.id.tableLayout);
//        tblRow = (TableRow) tblStocks.getChildAt();
//        switch(){
//
//        }
//        for(int i = 1; i < tblStocks.getChildCount(); i++){
//            tblRow = (TableRow) tblStocks.getChildAt(i);
//            tblRow.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    tblRow.setBackgroundColor(Color.rgb(150,150,150));
//                    TextView stockName = findViewById(R.id.stockName);
//                    TextView textViewName = (TextView) tblRow.getChildAt(0);
//                    stockName.setText(textViewName.getText());
//                }
//            });
//        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void onClick(View view){
        tblRow = (TableRow) view;
        tblRow.setBackgroundColor(Color.rgb(150,150,150));
        TextView stockName = findViewById(R.id.stockName);
        TextView textViewName = (TextView) tblRow.getChildAt(0);
        stockName.setText(textViewName.getText());
    }

}
