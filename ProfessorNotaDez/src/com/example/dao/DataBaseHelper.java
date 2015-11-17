package com.example.dao;

import com.example.util.PathConsultasScripts;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper{
	private static final String BANCO_DADOS = "Professor";
	private static final int VERSAO = 1;
	
	public DataBaseHelper(Context context){
		super(context, BANCO_DADOS, null, VERSAO);
	}
	@Override
	public void onCreate(SQLiteDatabase db){
		db.execSQL("CREATE TABLE usuario(nome TEXT, login TEXT, senha TEXT);");
		db.execSQL("CREATE TABLE aluno(turma TEXT, nome TEXT, notaBimestre1 TEXT, notaBimestre2 TEXT, notaBimestre3 TEXT, notaBimestre4 TEXT, media TEXT, situacao TEXT);");
	}
	
	@Override 
	public void onUpgrade(SQLiteDatabase db, int ondVersion, int newVersion){
		
	}
}
