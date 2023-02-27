package com.example.fixit1;

import android.content.ContentValues;
import android.database.Cursor;
import  android.database.sqlite.SQLiteDatabase.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

public class daoUsuario {
    Context c;
    Usuario u;
    ArrayList<Usuario>lista;
    SQLiteDatabase sql;
    String bd="BDUsuarios";
    String tabla="create table if not exists usuario(id integer primary key autoincrement,nombre text,apellido text," +
            "usuario text,password text,telefono text)";

public daoUsuario(Context c){
    this.c=c;
    sql = c.openOrCreateDatabase(bd, c.MODE_PRIVATE, null);
sql.execSQL(tabla);
u=new Usuario();
    lista=new ArrayList<Usuario>();

}
    public boolean insertUsuario(Usuario u){
        if (buscar(u.getUsuario())==0){
            ContentValues cv= new ContentValues();
            cv.put("nombre",  u.getNombre());
            cv.put("apellido",  u.getApellido());
            cv.put("usuario", u.getUsuario());
            cv.put("password", u.getPassword());
            cv.put("telefono",  u.getTelefono());
            return (sql.insert("usuario", null, cv)>0);
        }
        else{
            return false;
        }

    }

    public int buscar (String u){
        int x=0;
        lista=selectUsuarios();
        for (Usuario  us:lista){
            if(us.getUsuario().equals(u)){
                x++;
            }
        }
        return x;
    }

    public ArrayList<Usuario> selectUsuarios(){
        lista.clear();
        ArrayList<Usuario>lista = new ArrayList<Usuario>();
        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do {
                Usuario u=new Usuario();
                u.setId(cr.getInt(0));
                u.setNombre(cr.getString(1));
                u.setApellido(cr.getString(2));
                u.setUsuario(cr.getString(3));
                u.setPassword(cr.getString(4));
                u.setTelefono(cr.getString(5));

                lista.add(u);
            }while(cr.moveToNext());

        }
        return lista;
    }

   /* public int login(String u,String p){
       int a =0;

        Cursor cr=sql.rawQuery("select * from usuario", null);
        if(cr!=null&&cr.moveToFirst()){
            do {
             if()
            }while(cr.moveToNext());

        }
        return lista;
    }
    */





}
