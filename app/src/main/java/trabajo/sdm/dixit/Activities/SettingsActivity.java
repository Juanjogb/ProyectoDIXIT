package trabajo.sdm.dixit.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

import trabajo.sdm.dixit.R;

public class SettingsActivity extends AppCompatActivity {

    private ImageButton avatar = null;
    private int indice;
    static final int ACTION_AVATAR_PHOTO = 1;
    static final int ACTION_AVATAR_GALLERY = 2;

    private SharedPreferences preferences = null;
    static final String AVATAR = "avatar";
    Intent intent = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        avatar = (ImageButton) findViewById(R.id.butAvatarImage);
        avatar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                //showPhotoDialog();
                intent = new Intent(getApplicationContext(), PhotoSelectorDialog.class);
                startActivity(intent);
                getIntent().getIntExtra("num_avatar",indice);
                //setAvatar(indice);
                //String aux = "R.drawable.ava"+indice;
               // Bitmap bmp = BitmapFactory.decodeResource(getResources(), "R.drawable.ava"+indice);
                //avatar.setImageBitmap(bmp);
                String uriString = preferences.getString(AVATAR,"android.resource://trabajo.sdm.dixit/R.drawable.ava" + indice);
                avatar.setImageURI(Uri.parse(uriString));
            }
        });

        //obtener las preferencias
        preferences = getPreferences(0);
    }

    /*public void showPhotoDialog(){
        Intent avatarSelect = new Intent(getApplicationContext(), PhotoSelectorDialog.class);
        startActivity(avatarSelect);
        // FragmentManager fm= getSupportFragmentManager();
       // PhotoSelectorDialog avatarDialog = new PhotoSelectorDialog();
        //avatarDialog.show(fm,"photo");
        getIntent().getIntExtra("num_avatar",indice);
        setAvatar(indice);
    }*/

    /*public void avatarPhoto() {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(pictureIntent, ACTION_AVATAR_PHOTO);
    }

    public void avatarGallery() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK);
        pickPhoto.setType("image/*");
        startActivityForResult(pickPhoto, ACTION_AVATAR_GALLERY);
    }
*/
    protected  void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_CANCELED) {
            //no hacer nada
        }
        else if (resultCode == Activity.RESULT_OK) {
            switch (requestCode) {
                case ACTION_AVATAR_PHOTO:
                    Bitmap cameraPic = (Bitmap) data.getExtras().get("data");
                    saveAvatar(cameraPic);
                    break;
                case ACTION_AVATAR_GALLERY:
                    Uri photoUri = data.getData();
                    try{
                        Bitmap galleryPic = MediaStore.Images.Media.getBitmap(getContentResolver(),photoUri);
                        saveAvatar(galleryPic);
                    } catch (Exception e){
                        new AlertDialog.Builder(this).setMessage("ERROR: "+ e.getLocalizedMessage()).setPositiveButton(android.R.string.ok, null).show();
                    }
                    break;
            }
        }
    }

    private void saveAvatar(Bitmap bitmap) {
        ImageButton avatar = (ImageButton) findViewById(R.id.butAvatarImage);
        avatar.setImageBitmap(bitmap);
    }

    public void selectAvatar(int indice){
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(AVATAR);
        editor.commit();
        setAvatar(indice);
    }

    private void setAvatar(int x) {
        String uriString = preferences.getString(AVATAR,"android.resource://trabajo.sdm.dixit/R.drawable.ava" + x);
        avatar.setImageURI(Uri.parse(uriString));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edit = preferences.edit();
        //EditText ed = (EditText) findViewById(R.id.nJug);
    }
}
