package trabajo.sdm.dixit.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import trabajo.sdm.dixit.R;

public class PartidaActivity extends AppCompatActivity {
    private Button play;
    private EditText nombre, numJ, numR, maxP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        nombre = findViewById(R.id.nombreText);
        numJ = findViewById(R.id.numJugadoresText);
        numR = findViewById(R.id.numRondasText);
        maxP = findViewById(R.id.maxPuntosText);

    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bPlay :
                setContentView(R.layout.activity_play);
                break;
        }
    }
}
