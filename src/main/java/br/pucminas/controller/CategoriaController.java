package br.pucminas.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.pucminas.model.entity.Categoria;
import br.pucminas.model.service.CategoriaService;

@Controller
@RequestMapping("/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService service;

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("categorias", service.buscarTodos());
		return "categoria/lista";
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Categoria categoria) {
		return "categoria/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Categoria categoria, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "categoria/cadastro";
		}

		service.salvar(categoria);
		attr.addFlashAttribute("success", "Categoria inserida com sucesso");
		return "redirect:/categorias/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("categoria", service.buscarPorId(id));
		return "categoria/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Categoria categoria, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "categoria/cadastro";
		}

		service.editar(categoria);
		attr.addFlashAttribute("success", "Categoria alterada com sucesso");
		return "redirect:/categorias/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("success", "Categoria excluida com sucesso");
		return "redirect:/categorias/listar";
	}
}
