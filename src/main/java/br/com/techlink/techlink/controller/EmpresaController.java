package br.com.techlink.techlink.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.techlink.techlink.model.Empresa;
import br.com.techlink.techlink.repository.EmpresaRepository;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/empresas")
public class EmpresaController {

    private final EmpresaRepository empresaRepository;

    public EmpresaController(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empresas", empresaRepository.findAll());
        return "empresas";
    }

    @GetMapping("/nova")
    public String formulario(Model model) {
        model.addAttribute("empresa", new Empresa());
        return "empresa-form";
    }

    @PostMapping
    public String salvar(@Valid @ModelAttribute("empresa") Empresa empresa,
                         BindingResult resultado) {
        if (resultado.hasErrors()) {
            return "empresa-form";
        }
        empresaRepository.save(empresa);
        return "redirect:/empresas";
    }
}