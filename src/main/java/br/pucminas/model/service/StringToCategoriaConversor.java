package br.pucminas.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import br.pucminas.model.entity.Categoria;

@Component
public class StringToCategoriaConversor implements Converter<String, Categoria> {

	@Autowired
	private CategoriaService service;

	@Override
	public Categoria convert(String source) {

		if (source.isEmpty()) {
			return null;
		}
		Long id = Long.valueOf(source);
		return service.buscarPorId(id);
	}

}
