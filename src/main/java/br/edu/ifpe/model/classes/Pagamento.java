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

/**
 *
 * @author Luciano Júnior <lucianocljr7@gmail.com>
 */

@Entity
public class Pagamento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codPagamento;
    
    @Column(name = "tipoPagamento", length = 30, nullable = false)
    private String tipoPagamento;
    
    @Column(name = "valorPagamento", length = 6, nullable = false)
    private double valorPagamento;

    public int getCodPagamento() {
        return codPagamento;
    }

//    public void setCodPagamento(int codPagamento) {
//        this.codPagamento = codPagamento;
//    }

    public String getTipoPagamento() {
        return tipoPagamento;
    }

    public void setTipoPagamento(String tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }

    public double getValorPagamento() {
        return valorPagamento;
    }

    public void setValorPagamento(double valorPagamento) {
        this.valorPagamento = valorPagamento;
    }

    public Pagamento(){
        
    }
    
    public Pagamento(String tipoPagamento, double valorPagamento) {
        this.tipoPagamento = tipoPagamento;
        this.valorPagamento = valorPagamento;
    }

    @Override
    public String toString() {
        return "Pagamento{" + "codPagamento=" + codPagamento + ", tipoPagamento=" + tipoPagamento + ", valorPagamento=" + valorPagamento + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 67 * hash + this.codPagamento;
        hash = 67 * hash + Objects.hashCode(this.tipoPagamento);
        hash = 67 * hash + (int) (Double.doubleToLongBits(this.valorPagamento) ^ (Double.doubleToLongBits(this.valorPagamento) >>> 32));
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
        if (this.codPagamento != other.codPagamento) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorPagamento) != Double.doubleToLongBits(other.valorPagamento)) {
            return false;
        }
        if (!Objects.equals(this.tipoPagamento, other.tipoPagamento)) {
            return false;
        }
        return true;
    }
    
    
    
}
