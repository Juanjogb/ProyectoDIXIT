package trabajo.sdm.dixit.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import trabajo.sdm.dixit.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = findViewById(R.id.bPlayer);
        Button btn2 = findViewById(R.id.bOnline);
        Button btn3 = findViewById(R.id.bScores);

        Typeface face = Typeface.createFromAsset(getAssets(),"fonts/jungle_fever.ttf");
        btn1.setTypeface(face);
        btn2.setTypeface(face);
        btn3.setTypeface(face);

    }

    // This method is executed when any button in the Main screen is clicked
    public void onClick(View v) {

        // Intent object to launch the related activity
        Intent intent = null;

        // Determine the activity to launch according to the Id of the Button clicked
        switch (v.getId()) {

            // Activity for starting the game
            case R.id.bPlayer:
                intent = new Intent(this, PartidaActivity.class);
                break;

            // Activity for register player
            case R.id.bOnline:
                intent = new Intent(this, OnlineActivity.class);
                break;

            // Activity for showing score
            case R.id.bScores:
                intent = new Intent(this, ScoresActivity.class);
                break;

            // Activity for configuring the application
            case R.id.bSettings:
                intent = new Intent(this, SettingsActivity.class);
                break;

            case R.id.bInstructions:
                intent = new Intent(this, RulesActivity.class);
                break;

            // Activity for showing credits
            /*case R.id.creditsoption:
                intent = new Intent(this, SettingsActivity.class);
                break;
            */

            //Activity for showing cards
            case R.id.bCards:
                intent = new Intent(this, CardsActivity.class);
                break;
        }

        // Launch the required activity
        if (intent != null) {
            startActivity(intent);
        }
    }

    /* This method is executed automatically when the activity starts and it creates an ActionBar */
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /* This method is executed when an menu option is clicked */
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case R.id.creditsoption:
                Intent intent = new Intent(this, CreditsActivity.class);
                this.startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
        return true;
    }


}
