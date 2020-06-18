package com.prova.segbim.entidade;

public class Time {
	
	long id;
	String nome;
	String tecnico;
	Integer qtdJogador; 
	String site;
	String estadio;
	
	public Time (long idEnviado, String nomeEnviado, String tecnicoEnviado, Integer qtdJogadorEnviado, String siteEnviado, String estadioEnviado) {
		setId(idEnviado);
		setNome(nomeEnviado);
		setTecnico(tecnicoEnviado);
		setQtdJogador(qtdJogadorEnviado);
		setSite(siteEnviado);
		setEstadio(estadioEnviado);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;		
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getTecnico() {
		return tecnico;
	}
	
	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}
	
	public Integer getQtdJogador() {
		return qtdJogador;
	}
	
	public void setQtdJogador(Integer qtdJogador) {
		this.qtdJogador = qtdJogador; 
		
	}
	
	public String getSite() {
		return site;
	}
	
	public void setSite(String site) {
		this.site = site;
	}
	
	public String getEstadio() {
		return estadio;
	}
	
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}


}
