package trabajo.sdm.dixit.Activities;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;


import adapters.ImageAdapter;
import trabajo.sdm.dixit.R;

public class CardsActivity extends AppCompatActivity{

    private static final float MIN_SCALE = 0.75f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cards);

        ViewPager viewPager = findViewById(R.id.viewPagerCards);
        ImageAdapter adapter = new ImageAdapter(this);
        viewPager.setAdapter(adapter);

        viewPager.setPageTransformer(true, new DepthPageTransformer());

    }


}
