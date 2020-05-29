/*MIT License

Copyright (c) 2020 Lucas Mendes,Marcela Cardoso,Luciano Jr.

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.*/
package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Produto;
import br.edu.ifpe.model.negocio.ProdutoNegocio;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

/**
 *
 * @author Luciano
 */
@SuppressWarnings("serial")
@ManagedBean(name = "produtoController")
public class ProdutoController implements Serializable {

    private ProdutoNegocio produtoModel = null;
    private Produto produto;

//    ProdutoNegocio produtoModel = new ProdutoNegocio();
    public ProdutoController() {
        this.produto = new Produto();
        this.produtoModel = new ProdutoNegocio();
    }

    public void inserirProdutoAction() {
//        produtoModel.inserirProduto(produto);
        this.produtoModel.inserirProduto(this.produto);
        this.produto = new Produto();
        FacesMessage mensagem = new FacesMessage("Produto Cadastrado com Sucesso");
        FacesContext contexto = FacesContext.getCurrentInstance();
        contexto.addMessage(null, mensagem);

    }

    public void alterarProdutoAction(Produto produto) {
        produtoModel.alterarProduto(produto);
    }

    public Produto recuperarProdutoAction(int codigo) {
        return produtoModel.recuperarProduto(codigo);
    }

    public void deletarProdutoAction(Produto produto) {
        produtoModel.deletarProduto(produto);
    }

    public List<Produto> listarTodosProdutoAction() {
        return produtoModel.listarTodosProdutos();
    }

    public ProdutoNegocio getProdutoModel() {
        return produtoModel;
    }

    public void setProdutoModel(ProdutoNegocio produtoModel) {
        this.produtoModel = produtoModel;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    
}
