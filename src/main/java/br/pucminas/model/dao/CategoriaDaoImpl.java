package br.pucminas.model.dao;

import org.springframework.stereotype.Repository;

import br.pucminas.model.entity.Categoria;

@Repository
public class CategoriaDaoImpl extends AbstractDao<Categoria, Long> implements CategoriaDao {

}
