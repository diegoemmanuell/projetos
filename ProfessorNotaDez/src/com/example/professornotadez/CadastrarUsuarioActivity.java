package com.example.professornotadez;

import com.example.dao.DataBaseHelper;
import com.example.dao.usuarioDao;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CadastrarUsuarioActivity extends Activity {
	private EditText txtNome;
	private EditText txtLogin;
	private EditText txtSenha;
	private Button btnCadastrar;
	private Button btnSair;
	private DataBaseHelper helper;
	private usuarioDao dao;
	public CadastrarUsuarioActivity(){
		dao = new usuarioDao();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastrar_usuario);
		
		txtNome = (EditText) findViewById(R.id.txtNome);
		txtLogin = (EditText) findViewById(R.id.txtLogin);
		txtSenha = (EditText) findViewById(R.id.txtSenha);
		btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
		btnSair = (Button) findViewById(R.id.btnSair);
		helper = new DataBaseHelper(this);
		btnSair.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
		btnCadastrar.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cadastrarUsuario(v);
			}
		});
	}
	
	public void cadastrarUsuario(View view){
		SQLiteDatabase db = helper.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put("nome", txtNome.getText().toString());
		values.put("login", txtLogin.getText().toString());
		values.put("senha", txtSenha.getText().toString());
		if(dao.cadastraUsuario(db, values)){
			Toast.makeText(this, "Usuário Registrado", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Não foi possível efetuar o registro!", Toast.LENGTH_SHORT).show();
		}
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastrar_usuario, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	protected void onDestroy() {
		helper.close();
		super.onDestroy();
	}
}
