package trabajo.sdm.dixit.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import trabajo.sdm.dixit.R;

public class PhotoSelectorDialogOnline extends AppCompatActivity {

    private EditText mEditText;
    private Button camara, galeria,cancel;

    static final int ACTION_AVATAR_PHOTO = 1;
    static final int ACTION_AVATAR_GALLERY = 2;

    private SharedPreferences preferences = null;
    static final String AVATAR = "avatar";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.avatar_default);

        camara = (Button)findViewById(R.id.butAvCamara);
        galeria = (Button)findViewById(R.id.butAvGaleria);
        cancel = (Button)findViewById(R.id.butAvCancel);
        preferences = getPreferences(0);
    }


    public void onClick(View v) {

        switch (v.getId()){
            case R.id.butAvCamara:
                camara.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avatarPhoto();
                    }
                });
                break;
            case R.id.butAvGaleria:
                galeria.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        avatarGallery();
                    }
                });
                break;

            case R.id.butAvCancel:
                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                });
                break;

            case R.id.ImageButton1:
                selectAvatar(1);
                break;
            case R.id.ImageButton2:
                selectAvatar(2);
                break;
            case R.id.ImageButton3:
                selectAvatar(3);
                break;
            case R.id.ImageButton4:
                selectAvatar(4);
                break;
            case R.id.ImageButton5:
                selectAvatar(5);
                break;
            case R.id.ImageButton6:
                selectAvatar(6);
                break;
            case R.id.ImageButton7:
                selectAvatar(7);
                break;
            case R.id.ImageButton8:
                selectAvatar(8);
                break;
            case R.id.ImageButton9:
                selectAvatar(9);
                break;
            case R.id.ImageButton10:
                selectAvatar(10);
                break;
            case R.id.ImageButton11:
                selectAvatar(11);
                break;
            case R.id.ImageButton12:
                selectAvatar(12);
                break;

        }
    }

    public void selectAvatar(int indice){
        Intent volver = new Intent(getApplicationContext(),UserActivity.class);
        Bundle bolsa = new Bundle();
        bolsa.putInt("indice",indice);
        volver.putExtras(bolsa);
        setResult(RESULT_OK,volver);
        startActivity(volver);
        finish();
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

/*
    public View onCreateView (LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View dlgview = inflater.inflate(R.layout.avatar_default, container);

        getDialog().setTitle(R.string.selecAvatar);

        //Camara
        Button camara = (Button) dlgview.findViewById(R.id.butAvCamara);
        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).avatarPhoto();
                dismiss();
            }
        });


        //Galería
        Button galeria = (Button) dlgview.findViewById(R.id.butAvGaleria);
        galeria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).avatarGallery();
                dismiss();
            }
        });

        //ava1
        ImageButton ava1 = (ImageButton) dlgview.findViewById(R.id.ImageButton1);
        ava1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(1);
                dismiss();
            }
        });

        //ava2
        ImageButton ava2 = (ImageButton) dlgview.findViewById(R.id.ImageButton2);
        ava2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(2);
                dismiss();
            }
        });

        //ava3
        ImageButton ava3 = (ImageButton) dlgview.findViewById(R.id.ImageButton3);
        ava3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(3);
                dismiss();
            }
        });

        //ava4
        ImageButton ava4 = (ImageButton) dlgview.findViewById(R.id.ImageButton4);
        ava4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(4);
                dismiss();
            }
        });

        //ava5
        ImageButton ava5 = (ImageButton) dlgview.findViewById(R.id.ImageButton5);
        ava5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(5);
                dismiss();
            }
        });

        //ava6
        ImageButton ava6 = (ImageButton) dlgview.findViewById(R.id.ImageButton6);
        ava6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(6);
                dismiss();
            }
        });

        //ava7
        ImageButton ava7 = (ImageButton) dlgview.findViewById(R.id.ImageButton7);
        ava7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(7);
                dismiss();
            }
        });

        //ava8
        ImageButton ava8 = (ImageButton) dlgview.findViewById(R.id.ImageButton8);
        ava8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(8);
                dismiss();
            }
        });

        //ava9
        ImageButton ava9 = (ImageButton) dlgview.findViewById(R.id.ImageButton9);
        ava9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(9);
                dismiss();
            }
        });

        //ava10
        ImageButton ava10 = (ImageButton) dlgview.findViewById(R.id.ImageButton10);
        ava10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(10);
                dismiss();
            }
        });


        //ava11
        ImageButton ava11 = (ImageButton) dlgview.findViewById(R.id.ImageButton11);
        ava11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(11);
                dismiss();
            }
        });

        //ava12
        ImageButton ava12 = (ImageButton) dlgview.findViewById(R.id.ImageButton12);
        ava12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((SettingsActivity)getActivity()).selectAvatar(12);
                dismiss();
            }
        });


        //cancelar
        Button cancel = (Button) dlgview.findViewById(R.id.butAvCancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return dlgview;

    }
*/

}
