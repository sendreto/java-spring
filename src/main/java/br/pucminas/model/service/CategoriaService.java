package br.pucminas.model.service;

import java.util.List;

import br.pucminas.model.entity.Categoria;

public interface CategoriaService {

	void salvar(Categoria categoria);

	void editar(Categoria categoria);

	void excluir(Long id);
	
	Categoria buscarPorId(Long id);

	List<Categoria> buscarTodos();
}
