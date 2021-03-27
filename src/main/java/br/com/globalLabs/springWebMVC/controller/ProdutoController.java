package br.com.globalLabs.springWebMVC.controller;

import br.com.globalLabs.springWebMVC.model.Produto;
import br.com.globalLabs.springWebMVC.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;
    @GetMapping("/produtos")
    public ModelAndView produtos(){
    final ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("produto");
        modelAndView.addObject("allProduto",produtoRepository.getAllProdutos());
        return modelAndView;
    }
    @GetMapping("/new-produto")
        public ModelAndView newProduto(){
        ModelAndView modelAndView=new ModelAndView();
        modelAndView.setViewName("new-produto");
        modelAndView.addObject("produto",new Produto());
        return modelAndView;
        }
        @PostMapping("/produtos")
    public  String createProduto(@Valid @ModelAttribute Produto produto, BindingResult result, RedirectAttributes redirectAttributes){
        if(result.hasErrors()){
            return "new-produto";
        }
        produtoRepository.addProduto(produto);
        redirectAttributes.addFlashAttribute("message","produto cadastrado com sucesso!");
        return "redirect:produtos";

        }

}
