package com.prova.segbim.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import com.prova.segbim.entidade.Time;

public class TimeDao implements Dao<Time>{
	
	public List<Time> times = new ArrayList<Time>();
	
	public TimeDao() {
		
	}

	public Optional<Time> get(long id) {
		return Optional.ofNullable(times.get((int) id));
	}

	public List<Time> getAll() {
		return times;
	}

	public void save(Time timeEnviado) {
		times.add(timeEnviado);
	}

	public void update(Time timeEnviado, String[] params) {
		timeEnviado.setNome(Objects.requireNonNull(params[0], "O nome do time n�o pode ser nulo."));
		timeEnviado.setTecnico(Objects.requireNonNull(params[1], "O nome do t�cnico n�o pode ser nulo."));
		timeEnviado.setSite(Objects.requireNonNull(params[2], "O site do time n�o pode ser nulo."));
		timeEnviado.setEstadio(Objects.requireNonNull(params[3], "O nome do est�dio do time n�o pode ser nulo."));
	}

	public void update(Time timeEnviado, Integer[] params) {
		
		timeEnviado.setQtdJogador(Objects.requireNonNull(params[0], "A quantidade de jogadores do time n�o pode ser nulo."));
		
	}
	
	public void remove(Time timeEnviado) {
		times.remove(timeEnviado);
	}

}
