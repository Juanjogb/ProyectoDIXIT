package trabajo.sdm.dixit.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import objetos.FirebaseReferences;
import objetos.Partida;
import trabajo.sdm.dixit.R;

public class PartidaActivity extends AppCompatActivity {
    private Button play;
    private EditText nombre, numJ, numR, maxP;
    public int idPartida = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_partida);

        nombre = (EditText) findViewById(R.id.nombreText);
        numJ = (EditText) findViewById(R.id.numJugadoresText);
        numR = (EditText) findViewById(R.id.numRondasText);
        maxP = (EditText) findViewById(R.id.maxPuntosText);
        play = (Button) findViewById(R.id.bPlay);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference partidaRef = database.getReference(FirebaseReferences.DIXIT_REFERENCE);


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                Partida partida = new Partida(idPartida,nombre.getText().toString(),Integer.parseInt(numJ.getText().toString()),Integer.parseInt(numR.getText().toString()),Integer.parseInt(maxP.getText().toString()));
                partidaRef.child(FirebaseReferences.PARTIDA_REFERENCE).push().setValue(partida);
                idPartida++;
                Toast.makeText(PartidaActivity.this, "Partida iniciada por "+partida.getNombreJugador(), Toast.LENGTH_SHORT).show();
                setContentView(R.layout.activity_play);
            }
        });
    }
}
