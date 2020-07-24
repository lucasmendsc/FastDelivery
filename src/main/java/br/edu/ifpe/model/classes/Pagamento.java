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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Luciano Júnior <lucianocljr7@gmail.com>
 */
@Entity
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "tipoPagamento", length = 30, nullable = false)
    private String tipoPagamento;
    
    @Column(name = "valorTotalPagamento", length = 6, nullable = false)
    private double valorTotalPagamento;

    @Column(name = "valorPagamento", length = 6, nullable = false)
    private double valorPagamento;

    @OneToOne
    @JoinColumn(name = "cod_cliente")
    private Cliente cliente;
    public Pagamento() {
    }

    public Pagamento(int id, String tipoPagamento, double valorPagamento,
            Cliente cliente) {
        this.id = id;
        this.tipoPagamento = tipoPagamento;
        this.valorPagamento = valorPagamento;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorTotalPagamento() {
        return valorTotalPagamento;
    }

    public void setValorTotalPagamento(double valorTotalPagamento) {
        this.valorTotalPagamento = valorTotalPagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.id;
        hash = 53 * hash + Objects.hashCode(this.tipoPagamento);
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorTotalPagamento) ^ (Double.doubleToLongBits(this.valorTotalPagamento) >>> 32));
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.valorPagamento) ^ (Double.doubleToLongBits(this.valorPagamento) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.cliente);
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
        final Pagamento other = (Pagamento) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorTotalPagamento) != Double.doubleToLongBits(other.valorTotalPagamento)) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorPagamento) != Double.doubleToLongBits(other.valorPagamento)) {
            return false;
        }
        if (!Objects.equals(this.tipoPagamento, other.tipoPagamento)) {
            return false;
        }
        if (!Objects.equals(this.cliente, other.cliente)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "tipoPagamento=" + tipoPagamento + ", valorTotalPagamento=" + valorTotalPagamento + ", valorPagamento=" + valorPagamento + ", cliente=" + cliente + '}';
    }


}
