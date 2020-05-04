package br.pucminas.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.pucminas.model.entity.Categoria;
import br.pucminas.model.entity.Despesa;
import br.pucminas.model.service.CategoriaService;
import br.pucminas.model.service.DespesaService;

@Controller
@RequestMapping("/despesas")
public class DespesaController {

	@Autowired
	private DespesaService service;
	
	@Autowired
	private CategoriaService categoriaService;

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("despesas", service.buscarTodos());
		return "despesa/lista";
	}

	@GetMapping("/cadastrar")
	public String cadastrar(Despesa despesa) {
		return "despesa/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Despesa despesa, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "despesa/cadastro";
		}

		service.salvar(despesa);
		attr.addFlashAttribute("success", "Despesa inserida com sucesso");
		return "redirect:/despesas/listar";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("despesa", service.buscarPorId(id));
		return "despesa/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Despesa despesa, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "despesa/cadastro";
		}

		service.editar(despesa);
		attr.addFlashAttribute("success", "Despesa alterada com sucesso");
		return "redirect:/despesas/listar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes attr) {
		service.excluir(id);
		attr.addFlashAttribute("success", "Despesa excluida com sucesso");
		return "redirect:/despesas/listar";
	}
	
	@ModelAttribute("categorias")
	public List<Categoria> categorias(){
		return categoriaService.buscarTodos();
	}
}
