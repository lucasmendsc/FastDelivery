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

import java.time.LocalDateTime;
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
public class Frete {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codFrete;
    
    @Column(name = "valorFrete", length = 6, nullable = false)
    private double valorFrete;
    
    @Column(name = "dataHoraFrete", length = 4, nullable = false)
    private LocalDateTime dataHoraFrete;

    public int getCodFrete() {
        return codFrete;
    }

//    public void setCodFrete(int codFrete) {
//        this.codFrete = codFrete;
//    }

    public double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(double valorFrete) {
        this.valorFrete = valorFrete;
    }

    public LocalDateTime getDataHoraFrete() {
        return dataHoraFrete;
    }

    public void setDataHoraFrete(LocalDateTime dataHoraFrete) {
        this.dataHoraFrete = dataHoraFrete;
    }

    public Frete(){
        
    }
    
    public Frete(double valorFrete, LocalDateTime dataHoraFrete) {
        this.valorFrete = valorFrete;
        this.dataHoraFrete = dataHoraFrete;
    }

    @Override
    public String toString() {
        return "Frete{" + "codFrete=" + codFrete + ", valorFrete=" + valorFrete + ", dataHoraFrete=" + dataHoraFrete + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.codFrete;
        hash = 83 * hash + (int) (Double.doubleToLongBits(this.valorFrete) ^ (Double.doubleToLongBits(this.valorFrete) >>> 32));
        hash = 83 * hash + Objects.hashCode(this.dataHoraFrete);
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
        final Frete other = (Frete) obj;
        if (this.codFrete != other.codFrete) {
            return false;
        }
        if (Double.doubleToLongBits(this.valorFrete) != Double.doubleToLongBits(other.valorFrete)) {
            return false;
        }
        if (!Objects.equals(this.dataHoraFrete, other.dataHoraFrete)) {
            return false;
        }
        return true;
    }
    
    
    
}
