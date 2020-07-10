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
package br.edu.ifpe.model.classes;

import java.util.ArrayList;
import br.edu.ifpe.model.classes.Produto;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Luciano
 */
@Entity
public class ItemPedido {

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codItemPedido;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "codItemPedido")
    private List<Produto> produtos;
    
    @JoinColumn (name = "subTotal")
    private double subTotal;

    public int getCodItemPedido() {
        return codItemPedido;
    }

//    public void setCodItemPedido(int codItemPedido) {
//        this.codItemPedido = codItemPedido;
//    }
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(ArrayList<Produto> produtos) {
        this.produtos = produtos;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void adicionarProdutos(Produto prod) {

        this.produtos.add(prod);

    }

    public ItemPedido() {

    }

    public ItemPedido(ArrayList<Produto> produtos, double subTotal) {
        this.produtos = produtos;
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "ItemPedido{" + "codItemPedido=" + codItemPedido + ", produtos=" + produtos + ", subTotal=" + subTotal + '}';
    }

    public void calculoSubTotal() {

        //System.out.println("Entrou aqui!");
        for (Produto produto : produtos) {
            this.subTotal += produto.getValorProduto();
        }
        System.out.println("SubTotal: " + subTotal);
    }

}
