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

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author Luciano Júnior <lucianocljr7@gmail.com>
 */

@Entity
public class Produto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codProduto;
    
    @Column(name = "nomeProduto", length = 60, nullable = false)
    private String nomeProduto;
    
    @Column (name = "valorProduto", nullable = false)
    private double valorProduto;
    
    @Column(name = "quantProduto", length = 6, nullable = false)
    private int quantProduto;

    @ManyToOne(cascade = CascadeType.ALL)
    private ItemPedido itemPedido;
    public int getCodProduto() {
        return codProduto;
    }

//    public void setCodProduto(int codProduto) {
//        this.codProduto = codProduto;
//    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getValorProduto() {
        return valorProduto;
    }
    
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    
    public int getQuantProduto() {
        return quantProduto;
    }

    public void setQuantProduto(int quantProduto) {
        this.quantProduto = quantProduto;
    }

    public Produto(){
        
    }
    
    public Produto(String nomeProduto, double valorProduto, int quantProduto) {
        //this.codProduto = codProduto;
        this.nomeProduto = nomeProduto;
        this.valorProduto = valorProduto;
        this.quantProduto = quantProduto;
    }

    @Override
    public String toString() {
        return "Produto{" + "codProduto=" + codProduto + ", nomeProduto=" + nomeProduto + ", valorProduto=" + valorProduto + ", quantProduto=" + quantProduto + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + this.codProduto;
        hash = 61 * hash + Objects.hashCode(this.nomeProduto);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.valorProduto) ^ (Double.doubleToLongBits(this.valorProduto) >>> 32));
        hash = 61 * hash + this.quantProduto;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Produto other = (Produto) obj;
        if (this.codProduto != other.codProduto) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorProduto) != Double.doubleToLongBits(other.valorProduto)) {
            return false;
        }
        if (this.quantProduto != other.quantProduto) {
            return false;
        }
        if (!Objects.equals(this.nomeProduto, other.nomeProduto)) {
            return false;
        }
        return true;
    }

    
    
}
