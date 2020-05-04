package br.pucminas.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.pucminas.model.dao.CategoriaDao;
import br.pucminas.model.entity.Categoria;

@Service
@Transactional(readOnly = false)
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDao dao;

	@Override
	public void salvar(Categoria categoria) {
		dao.save(categoria);
	}

	@Override
	public void editar(Categoria categoria) {
		dao.update(categoria);
	}

	@Override
	public void excluir(Long id) {
		dao.delete(id);
	}

	@Override
	public Categoria buscarPorId(Long id) {
		return dao.findById(id);
	}

	@Override
	public List<Categoria> buscarTodos() {
		return dao.findAll();
	}

}
