package com.example.user.myclases;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.myclases.data.DataBaseManager;
import com.example.user.myclases.data.MyProfe;


/**
 * A login screen that offers login via email/password.

 */
public class LoginActivity extends Activity implements View.OnClickListener{

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return id == R.id.action_settings || super.onOptionsItemSelected(item);
    }



    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */


    // UI references.
    private EditText mEmailView;
    private EditText mPasswordView;
    private String nombre;
    private Button boton;
    private MyProfe globalVariable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Set up the login form.
        mEmailView = (EditText) findViewById(R.id.nombrelogin);
        mPasswordView = (EditText) findViewById(R.id.passwordlogin);
        boton = (Button) findViewById(R.id.email_sign_in_button);
        boton.setOnClickListener(this);
        globalVariable=(MyProfe)getApplicationContext();




;





       TextView Regis = (TextView) findViewById(R.id.textView4);
        Regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,
                        MyActivity.class);
                startActivity(intent);}});
        }









        // Store values at the time of the login attempt.








    private boolean isEmailValid(String email) {
        //TODO: Replace this with your own logic
        return email.contains("@");
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 4;
    }



    @Override
    public void onClick(View view) {
        if (view.getId()== R.id.email_sign_in_button) {
            DataBaseManager manager = new DataBaseManager(this);
            String email = mEmailView.getText().toString();
            String password = mPasswordView.getText().toString();
            String con = mPasswordView.getText().toString();
            if(manager.contraseña(con).moveToFirst()){
                do{
                nombre = manager.contraseña1(con).getString(0);}while(manager.contraseña1(con).moveToNext());
                if(nombre.equals(email)){
                    globalVariable.setContrasena(mPasswordView.getText().toString());
                    globalVariable.setNombre(email);
                    Intent i=new Intent(this,Menus.class) ;
                    startActivity(i);
                    Toast toast = Toast.makeText(this, "Bienvenido "+email, Toast.LENGTH_LONG);
                    toast.show();}
                else{
                    Toast toast = Toast.makeText(this, "Contraseña o Usuario incorrecto", Toast.LENGTH_LONG);
                    toast.show();
                }

    }
    else{
                    Toast toast = Toast.makeText(this, "Nombre o Usuario no ingresado", Toast.LENGTH_LONG);
                    toast.show();
            }}





}}



