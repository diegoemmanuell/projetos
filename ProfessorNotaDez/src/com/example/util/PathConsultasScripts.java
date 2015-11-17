package com.example.util;

public enum PathConsultasScripts {
	CRIA_TABELA_ALUNO("/scripts/criarTabelaAluno.txt"),
	CRIA_TABELA_USUARIO("/scripts/criarTabelaUsuario.txt");
	private String label;
	
	private PathConsultasScripts(String label){
		this.label=label; 
	}
	
	public String getLabel(){
		return label;
	}
	
}
