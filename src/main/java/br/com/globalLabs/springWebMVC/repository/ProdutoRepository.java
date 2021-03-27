package br.com.globalLabs.springWebMVC.repository;

import br.com.globalLabs.springWebMVC.model.Produto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository {
    private List<Produto> produto;
    public ProdutoRepository(){
        produto=new ArrayList<>();
        produto.add(new Produto("Laranja",20.5));
    }
    public List<Produto> getAllProdutos(){
        return  this.produto;
    }
    public void addProduto(final Produto produto){
     this.produto.add(produto);
    }

}
