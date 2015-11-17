package com.example.professornotadez;

import com.example.dao.DataBaseHelper;
import com.example.dao.usuarioDao;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	private EditText txtLogin;
	private EditText txtSenha;
	private Button btnLogin;
	private Button btnCadastrar;
	private Button btnSair;
	private usuarioDao dao;
	private DataBaseHelper helper;
	public LoginActivity(){
		dao = new usuarioDao();
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		txtLogin = (EditText) findViewById(R.id.txtLogin);
		txtSenha = (EditText) findViewById(R.id.txtSenha);
		btnCadastrar = (Button) findViewById(R.id.btnCadastrar);
		btnLogin = (Button) findViewById(R.id.btnLogin);
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
				startActivity(new Intent(LoginActivity.this, CadastrarUsuarioActivity.class));
			}
		});
		btnLogin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				realizaLogin(txtLogin.getText().toString(), txtSenha.getText().toString());	
			}
		});
	}
	public void realizaLogin(String login, String senha){
		String auxSenha;
		SQLiteDatabase db = helper.getReadableDatabase();
		auxSenha = dao.consultaSenhaUsuario(login, db);
		if(txtSenha.getText().toString().equals(auxSenha)){
			Toast.makeText(this, "Confere!", Toast.LENGTH_SHORT).show();
		}else{
			Toast.makeText(this, "Credenciais não conferem!!", Toast.LENGTH_SHORT).show();
		}
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
}
