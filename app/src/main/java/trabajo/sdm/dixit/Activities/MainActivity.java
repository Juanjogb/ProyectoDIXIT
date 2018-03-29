package trabajo.sdm.dixit.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import trabajo.sdm.dixit.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // This method is executed when any button in the Main screen is clicked
    public void onClick(View v) {

        // Intent object to launch the related activity
        Intent intent = null;

        // Determine the activity to launch according to the Id of the Button clicked
        switch (v.getId()) {

            // Activity for starting the game
            case R.id.bPlay:
                intent = new Intent(this, PlayActivity.class);
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

            case R.id.bCards:
                intent = new Intent(this, CardsActivity.class);
                break;
        }

        // Launch the required activity
        if (intent != null) {
            startActivity(intent);
        }
    }


}
