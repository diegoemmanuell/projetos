package com.example.dao;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class usuarioDao {
	public boolean cadastraUsuario(SQLiteDatabase db, ContentValues values){
		long resultado = db.insert("usuario", null, values);
		if(resultado != -1){
			return true;
		}else{
			return false;
		}
	}

	public String consultaSenhaUsuario(String login, SQLiteDatabase db) {
		String script = "SELECT senha FROM usuario where login = ':login'";
		Cursor cursor = db.rawQuery(script.replaceAll(":login", login), null);
		cursor.moveToFirst();
		String senha = cursor.getString(0);
		return senha;
	}
}
