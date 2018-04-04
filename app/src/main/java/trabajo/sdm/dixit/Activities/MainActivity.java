package trabajo.sdm.dixit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import objetos.FirebaseReferences;
import trabajo.sdm.dixit.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference(FirebaseReferences.DIXIT_REFERENCE);
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int value = dataSnapshot.getValue(Integer.class);
                Log.i("DATOS", value+"");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("ERROR", databaseError.getMessage());

            }
        });

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
