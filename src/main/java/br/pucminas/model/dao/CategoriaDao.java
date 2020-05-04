package br.pucminas.model.dao;

import java.util.List;

import br.pucminas.model.entity.Categoria;

public interface CategoriaDao {

	void save(Categoria categoria);

	void update(Categoria categoria);

	void delete(Long id);
	
	Categoria findById(Long id);

	List<Categoria> findAll();

}
