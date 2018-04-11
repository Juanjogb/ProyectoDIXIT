package trabajo.sdm.dixit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import trabajo.sdm.dixit.R;

public class SelectReversoBaraja extends AppCompatActivity {

    private ImageButton bt1,bt2,bt3,bt4,bt5;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reverso_cards);

        bt1 = findViewById(R.id.rev_azul);
        bt2 = findViewById(R.id.rev_mecanico);
        bt3 = findViewById(R.id.rev_rojo);
        bt4 = findViewById(R.id.rev_verde);
        bt5 = findViewById(R.id.rev_orig);

    }

    public void onClick(View v) {

        switch (v.getId()){
            case R.id.rev_azul:
                selectReverso("azul");
                break;
            case R.id.rev_mecanico:
                selectReverso("mecanico");
                break;
            case R.id.rev_orig:
                selectReverso("orig");
                break;
            case R.id.rev_rojo:
                selectReverso("rojo");
                break;
            case R.id.rev_verde:
                selectReverso("verde");
                break;

        }
    }

    public void selectReverso(String s) {
        Intent volver = new Intent(getApplicationContext(),SettingsActivity.class);
        Bundle bolsa = new Bundle();
        bolsa.putString("reverso",s);
        volver.putExtras(bolsa);
        setResult(RESULT_OK,volver);
        startActivity(volver);
        finish();
    }
}
