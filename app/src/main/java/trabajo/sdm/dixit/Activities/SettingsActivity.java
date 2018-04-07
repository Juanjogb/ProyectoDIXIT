package trabajo.sdm.dixit.Activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import trabajo.sdm.dixit.R;

public class SettingsActivity extends AppCompatActivity {

    private ImageButton avatar = null;

    static final int ACTION_AVATAR_PHOTO = 1;
    static final int ACTION_AVATAR_GALLERY = 2;

    private SharedPreferences preferences = null;
    static final String AVATAR = "avatar";
    static final String NAME = "name";
    static final String YEARS = "age";
    static final String SEX = "sex";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        avatar = (ImageButton) findViewById(R.id.butAvatarImage);
        avatar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View arg0) {
                showPhotoDialog();
            }
        });

        //obtener las preferencias
        preferences = getPreferences(0);
    }

    public void showPhotoDialog(){
        FragmentManager fm= getSupportFragmentManager();
        PhotoSelectorDialog avatarDialog = new PhotoSelectorDialog();
        avatarDialog.show(fm,"photo");
    }

    public void avatarPhoto() {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(pictureIntent, ACTION_AVATAR_PHOTO);
    }

    public void avatarGallery() {
        Intent pickPhoto = new Intent(Intent.ACTION_PICK);
        pickPhoto.setType("image/*");
        startActivityForResult(pickPhoto, ACTION_AVATAR_GALLERY);
    }

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

    public void avatarDefault(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.remove(AVATAR);
        editor.commit();
        setAvatar();
    }

    private void setAvatar() {
        String uriString = preferences.getString(AVATAR,"android.resource://trabajo.sdm.dixit/" + R.drawable.ava4);
        avatar.setImageURI(Uri.parse(uriString));
    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences.Editor edit = preferences.edit();
        //EditText ed = (EditText) findViewById(R.id.nJug);
    }
}
