package trabajo.sdm.dixit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TabHost;

import trabajo.sdm.dixit.R;

public class ScoresActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scores);

        //Tabs Control
        TabHost host = (TabHost) findViewById(R.id.my_tabhost);
        host.setup();

        //--- Tab1 ---
        TabHost.TabSpec spec = host.newTabSpec("mitab1");
        //Tab Indicator specified as Label and Icon
        spec.setIndicator("Local", getResources().getDrawable(R.drawable.ic_person_outline));
        spec.setContent(R.id.tab1);
        host.addTab(spec);

        //--- Tab2 ---
        spec = host.newTabSpec("mitab2");
        // Tab Indicator specified as Label and Icon
        spec.setIndicator("Friends", getResources().getDrawable(R.drawable.ic_people));
        spec.setContent(R.id.tab2);

         host.addTab(spec);


    }
}
