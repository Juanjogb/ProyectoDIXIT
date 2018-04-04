package trabajo.sdm.dixit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import trabajo.sdm.dixit.R;

public class PlayActivity extends AppCompatActivity {

    ImageView imagen;
    Button boton;
    public int[] cards = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                                  11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                                  21, 22, 23, 24, 25, 26, 27, 28, 29, 30};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        imagen = (ImageView) findViewById(R.id.idava1);
        boton = (Button) findViewById(R.id.boton);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                trans();
            }
        });
    }

    public void trans(){
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.trans);
        imagen.startAnimation(animation);
    }
}
