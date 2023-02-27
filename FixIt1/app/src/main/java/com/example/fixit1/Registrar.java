package com.example.fixit1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registrar extends AppCompatActivity implements View.OnClickListener {
EditText nombre,apellido,telefono,correo,password;
    Button btnRegRegistrar,btnRegCancelar;
    daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);
        nombre=(EditText)findViewById(R.id.RegNombre);
        apellido=(EditText)findViewById(R.id.RegApellido);
        telefono=(EditText)findViewById(R.id.RegTelefono);
        correo=(EditText)findViewById(R.id.RegCorreo);
        password=(EditText)findViewById(R.id.RegPass);

        btnRegRegistrar=(Button)findViewById(R.id.btnRegRegistrar);
        btnRegCancelar=(Button)findViewById(R.id.btnRegCancelar);
        btnRegCancelar.setOnClickListener(this);
        btnRegRegistrar.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.btnRegRegistrar:
                Usuario u=new Usuario();
                u.setNombre(nombre.getText().toString());
                u.setApellido(apellido.getText().toString());
                u.setTelefono(telefono.getText().toString());
                u.setUsuario(correo.getText().toString());
                u.setPassword(password.getText().toString());
                
                //validar valores
                if(!u.isNull()){
                    Toast.makeText(this, "Error:Campos vacios", Toast.LENGTH_SHORT).show();
                    
                }else if(dao.insertUsuario(u)){
                Toast.makeText(this, "Registro Exitoso", Toast.LENGTH_SHORT).show();
                    Intent intento2 = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intento2);
                    finish();//cierra esta ventana

                }else{
                Toast.makeText(this, "Usuario ya registrado", Toast.LENGTH_SHORT).show();
            }
              break;

            case R.id.btnRegCancelar:

                Intent intento = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intento);
                finish();//cierra esta ventana
                //   Mensaje("Implementar Button2");

                break;

        }// fin del onclick

    }// fin de OnclickDelButton



} // [9:16:44 PM] Fin de la Clase Actividad 01