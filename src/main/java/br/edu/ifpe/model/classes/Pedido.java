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

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Luciano
 */

@Entity
public class Pedido {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codPedido;
    
    @Column (name = "valorFretePedido", length = 10, nullable = false)
    private double valorFretePedido;
    
    @Column (name = "dataHoraPedido", length = 30, nullable = true)
    private LocalDate dataHoraPedido;
    
    @OneToOne
    @JoinColumn (name = "codPagamento")
    private Pagamento formaPagamento;
    
    
    @OneToOne
    @JoinColumn (name = "codItemPedido")
    private ItemPedido itemPedido;

    public double getValorFretePedido() {
        return valorFretePedido;
    }

    public void setValorFretePedido(double valorFretePedido) {
        this.valorFretePedido = valorFretePedido;
    }

    public LocalDate getDataHoraPedido() {
        return dataHoraPedido;
    }

    public void setDataHoraPedido(LocalDate dataHoraPedido) {
        this.dataHoraPedido = dataHoraPedido;
    }

    public Pagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(Pagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public ItemPedido getItemPedido() {
        return itemPedido;
    }

    public void setItemPedido(ItemPedido itemPedido) {
        this.itemPedido = itemPedido;
    }

    public Pedido(double valorFretePedido, LocalDate dataHoraPedido, Pagamento formaPagamento, ItemPedido itemPedido) {
        this.valorFretePedido = valorFretePedido;
        this.dataHoraPedido = dataHoraPedido;
        this.formaPagamento = formaPagamento;
        this.itemPedido = itemPedido;
    }
    
    public Pedido (){
        
    }

    @Override
    public String toString() {
        return "Pedido{" + "codPedido=" + codPedido + ", valorFretePedido=" + valorFretePedido + ", dataHoraPedido=" + dataHoraPedido + ", formaPagamento=" + formaPagamento + ", itemPedido=" + itemPedido + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.codPedido;
        hash = 29 * hash + (int) (Double.doubleToLongBits(this.valorFretePedido) ^ (Double.doubleToLongBits(this.valorFretePedido) >>> 32));
        hash = 29 * hash + Objects.hashCode(this.dataHoraPedido);
        hash = 29 * hash + Objects.hashCode(this.formaPagamento);
        hash = 29 * hash + Objects.hashCode(this.itemPedido);
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
        final Pedido other = (Pedido) obj;
        if (this.codPedido != other.codPedido) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorFretePedido) != Double.doubleToLongBits(other.valorFretePedido)) {
            return false;
        }
        if (!Objects.equals(this.dataHoraPedido, other.dataHoraPedido)) {
            return false;
        }
        if (!Objects.equals(this.formaPagamento, other.formaPagamento)) {
            return false;
        }
        if (!Objects.equals(this.itemPedido, other.itemPedido)) {
            return false;
        }
        return true;
    }
    
}
