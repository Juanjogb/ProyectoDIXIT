package trabajo.sdm.dixit.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import objetos.FirebaseReferences;
import trabajo.sdm.dixit.R;

public class UserActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView name, nick, puntos, partidas;
    private EditText newPass, idGame, searchGame;
    private Button bchangePass, bnewGame, bsearchGame;
    private ImageButton avatar;

    private SharedPreferences preferences = null;
    static final String AVATAR = "avatar";
    //String nickRecibido = extras.getString("nick");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        Bundle extras = getIntent().getExtras();
        name = findViewById(R.id.nameUserText);
        name.setText(extras.getString("nickKey"));
        nick = findViewById(R.id.nomLabel);
        nick.setText(extras.getString("nickKey"));
        puntos = findViewById(R.id.puntosLabel);
        partidas = findViewById(R.id.partidasLabel);

        newPass = (EditText) findViewById(R.id.newPassText);
        idGame = (EditText) findViewById(R.id.newGameText);
        searchGame = (EditText) findViewById(R.id.searchGameText);

        bchangePass = (Button) findViewById(R.id.bChangePass);
        bnewGame = (Button) findViewById(R.id.bNewGame);
        bsearchGame = (Button) findViewById(R.id.bSearchGame);

        bchangePass.setOnClickListener(this);
        bnewGame.setOnClickListener(this);
        bsearchGame.setOnClickListener(this);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference myRef = database.getReference(FirebaseReferences.DIXIT_REFERENCE);


        avatar = (ImageButton) findViewById(R.id.imageButtonAva);
        avatar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                Intent intent = new Intent(getApplicationContext(), PhotoSelectorDialogOnline.class);
                startActivity(intent);
                //String uriString = preferences.getString(AVATAR,"android.resource://trabajo.sdm.dixit/R.drawable.ava" + indice);
                //avatar.setImageURI(Uri.parse(uriString));
            }
        });


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK){

            //String uri = "@drawable/ava" + data.getExtras().getString("indice");
            //int imageResource = getResources().getIdentifier(uri, null, getPackageName());
            //Drawable imagen = ContextCompat.getDrawable(getApplicationContext(), imageResource);

            String uriString = preferences.getString(AVATAR,"android.resource://trabajo.sdm.dixit/R.drawable.ava" + data.getExtras().getString("indice"));
            avatar.setImageURI(Uri.parse(uriString));
            //avatar.setImageDrawable(imagen);
            //String uriString = preferences.getString(AVATAR,"android.resource://trabajo.sdm.dixit/R.drawable.ava" + data.getExtras().getString("indice"));
            //avatar.setImageURI(Uri.parse(uriString));
        }
    }

    public void cambiarPass() {

    }

    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bChangePass :
                cambiarPass();
                break;
            case R.id.bNewGame :
                //iniciarPartida();
                break;
            case R.id.bSearchGame :
                //buscarPartida();
                break;
        }
    }
}
