package trabajo.sdm.dixit.Activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import trabajo.sdm.dixit.R;

public class OnlineActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bReg;
    private Button bIni;
    private EditText emailText, passText;
    private ProgressDialog progressDialog;

    //FirebaseAuth.AuthStateListener mAuthListener;

    //Declaramos un objeto firebaseAuth
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_online);


        //Referenciamos los views y los botones
        bIni = findViewById(R.id.bIni);
        bReg = findViewById(R.id.bReg);
        emailText = findViewById(R.id.editTextEmail);
        passText = findViewById(R.id.editTextPass);

        //listener de los botones
        bIni.setOnClickListener(this);
        bReg.setOnClickListener(this);

        //inicializamos el objeto firebaseAuth
        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);
    }


    public void registrar(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        String email = emailText.getText().toString().trim();
        String password  = passText.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_SHORT).show();
            return;
        }


        progressDialog.setMessage("Realizando registro en linea...");
        progressDialog.show();

        //Creando nuevo usuario
        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if(task.isSuccessful()){

                            Toast.makeText(OnlineActivity.this,"Se ha registrado el usuario con el email: "+ emailText.getText(),Toast.LENGTH_SHORT).show();
                            setContentView(R.layout.activity_user);
                        }else{

                            Toast.makeText(OnlineActivity.this,"No se pudo registrar el usuario ",Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.dismiss();
                    }
                });
    }

    public void iniciarSesion(){

        //Obtenemos el email y la contraseña desde las cajas de texto
        String email = emailText.getText().toString().trim();
        String password  = passText.getText().toString().trim();

        //Verificamos que las cajas de texto no esten vacías
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Se debe ingresar un email",Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Falta ingresar la contraseña",Toast.LENGTH_SHORT).show();
            return;
        }


        progressDialog.setMessage("Realizando inicio de sesión...");
        progressDialog.show();

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                //checking if success
                if(task.isSuccessful()){
                    Toast.makeText(OnlineActivity.this,"Se ha iniciado sesion con el email: "+ emailText.getText(),Toast.LENGTH_SHORT).show();
                    setContentView(R.layout.activity_user);
                }else{

                    Toast.makeText(OnlineActivity.this,"No se pudo iniciar sesión ",Toast.LENGTH_SHORT).show();
                }
                progressDialog.dismiss();
            }

        });
    }


    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bIni :
                iniciarSesion();
                break;
            case R.id.bReg :
                registrar();
                break;
        }
    }
}

