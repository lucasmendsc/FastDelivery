
import br.edu.ifpe.controller.PagamentoController;
import br.edu.ifpe.controller.ProdutoController;
import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.classes.Produto;
import java.util.List;

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
/**
 *
 * @author Luciano
 */
public class teste {

    public static void main(String[] args) {

        //INSERIR - OK
        ProdutoController pc = new ProdutoController();
//        Produto produto = new Produto("Teste2", 5);
//        pc.inserirProdutoAction(produto);
        
        
        //RECUPERAR - OK
        
        Produto produto = pc.recuperarProdutoAction(2);
        //System.out.println("Produto recuperado: " + produto);
        
        //ALTERAR - OK
//        System.out.println("Produto ANTES de ser alterado: " + produto);
//        
//        produto.setNomeProduto("FEIJAO");
//        produto.setQuantProduto(10);
//        
//        pc.alterarProdutoAction(produto);
//        
//        Produto p2 = pc.recuperarProdutoAction(1);
//        System.out.println("Produto DEPOIS de ser alterado: " + p2);
        
        //DELETAR
        
        List<Produto> p1 = pc.listarTodosProdutoAction();
        System.out.println("Todos os produtos ANTES de ser deletado: " + p1.toString());
        pc.deletarProdutoAction(produto);
        List<Produto>p2 = pc.listarTodosProdutoAction();
        System.out.println("Todos os produtos DEPOIS de ser deletado: " + p2.toString());
        
        //LISTAR - OK
        
//        List<Produto> produtos = pc.listarTodosProdutoAction();
//        System.out.println("Todos os produtos: " + produtos.toString() + "\n");
              
        
       
        
    }
}
