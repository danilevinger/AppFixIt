package com.example.fixit1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText User,Pass;
Button btnLoginRegistrar,btnLoginIngresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // A continuación mi código para OnCreate
        Mensaje("Bienvenido Main");

        User=(EditText)findViewById(R.id.User);
        Pass=(EditText)findViewById(R.id.Pass);
        btnLoginRegistrar=(Button)findViewById(R.id.btnLoginRegistrar);
        btnLoginIngresar=(Button)findViewById(R.id.btnLoginIngresar);
        btnLoginIngresar.setOnClickListener(this);
        btnLoginRegistrar.setOnClickListener(this);

    } // Fin del Oncreate de la Actividad 01

    public void Mensaje(String msg){
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();};

    @Override


        public void onClick(View v) {
            // if(msg.equals("Texto")){Mensaje("Texto en el botón ");};
            switch (v.getId()) {

                case R.id.btnLoginIngresar:
                    Mensaje("Implementar Button1");

                    break;

                case R.id.btnLoginRegistrar:

                    Intent intento = new Intent(getApplicationContext(), Registrar.class);
                    startActivity(intento);
                 //   Mensaje("Implementar Button2");

                    break;

        }// fin del onclick

}// fin de OnclickDelButton



} // [9:16:44 PM] Fin de la Clase Actividad 01