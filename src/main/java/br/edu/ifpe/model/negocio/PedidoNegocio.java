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
package br.edu.ifpe.model.negocio;

import br.edu.ifpe.model.classes.Pedido;
import br.edu.ifpe.model.dao.PedidoDAO;
import java.util.List;

/**
 *
 * @author Luciano
 */
<<<<<<< HEAD:src/main/java/br/edu/ifpe/model/negocio/PedidoNegocio.java
public class PedidoNegocio {
    
    PedidoDAO pedidoJDBC = new PedidoDAO();
    
    public void inserirPedido (Pedido pedido){
        pedidoJDBC.inserir(pedido);
    }
 
    public void alterarPedido (Pedido pedido){
        pedidoJDBC.alterar(pedido);
    }
    
    public Pedido recuperarPedido (int codigo){
        return pedidoJDBC.recuperar(codigo);
    }
    
    public void deletarPedido (Pedido pedido){
        pedidoJDBC.deletar(pedido);
    }
    
    public List<Pedido> listarTodosPedidos(){
        return pedidoJDBC.listarTodos();
    }
    
}
=======
public class FreteNegocio {

    FreteDAO freteJDBC = new FreteDAO();

//    public void inserirFrete(Frete frete) {
//        freteJDBC.inserir(frete);
//    }
//
//    public void alterarFrete(Frete frete) {
//        freteJDBC.alterar(frete);
//    }
//
//    public Frete recuperarFrete(int codigo) {
//        return freteJDBC.recuperar(codigo);
//    }
//
//    public void deletarFrete(Frete frete) {
//        freteJDBC.deletar(frete);
//    }
//
//    public List<Frete> listarTodosFretes() {
//        return freteJDBC.listarTodos();
//    }

}
>>>>>>> 77102c0518a8a69ded5447ef334470cbc02c5e77:src/main/java/br/edu/ifpe/model/negocio/FreteNegocio.java
