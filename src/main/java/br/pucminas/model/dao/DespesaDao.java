package br.pucminas.model.dao;

import java.util.List;

import br.pucminas.model.entity.Despesa;

public interface DespesaDao {

	void save(Despesa despesa);

	void update(Despesa despesa);

	void delete(Long id);

	Despesa findById(Long id);

	List<Despesa> findAll();
}
