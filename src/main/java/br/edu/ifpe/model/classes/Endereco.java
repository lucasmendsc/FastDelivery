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
public class Endereco {
 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int codEndereco;
    
    @Column(name = "estadoEndereco", length = 20, nullable = false)
    private String estadoEndereco;
    
    @Column(name = "cidadeEndereco", length = 20, nullable = false)
    private String cidadeEndereco;
    
    @Column(name = "cepEndereco", length = 20, nullable = false)
    private String cepEndereco;
    
    @Column(name = "bairroEndereco", length = 20, nullable = false)
    private String bairroEndereco;
    
    @Column(name = "logradouroEndereco", length = 20, nullable = false)
    private String logradouroEndereco;
    
    @Column(name = "numeroEndereco", length = 10, nullable = false)
    private int numeroEndereco;
    
    @Column(name = "complementoEndereco", length = 20, nullable = false)
    private String complementoEndereco;

    public int getCodEndereco() {
        return codEndereco;
    }

//    public void setCodEndereco(int codEndereco) {
//        this.codEndereco = codEndereco;
//    }

    public String getEstadoEndereco() {
        return estadoEndereco;
    }

    public void setEstadoEndereco(String estadoEndereco) {
        this.estadoEndereco = estadoEndereco;
    }

    public String getCidadeEndereco() {
        return cidadeEndereco;
    }

    public void setCidadeEndereco(String cidadeEndereco) {
        this.cidadeEndereco = cidadeEndereco;
    }

    public String getCepEndereco() {
        return cepEndereco;
    }

    public void setCepEndereco(String cepEndereco) {
        this.cepEndereco = cepEndereco;
    }

    public String getBairroEndereco() {
        return bairroEndereco;
    }

    public void setBairroEndereco(String bairroEndereco) {
        this.bairroEndereco = bairroEndereco;
    }

    public String getLogradouroEndereco() {
        return logradouroEndereco;
    }

    public void setLogradouroEndereco(String logradouroEndereco) {
        this.logradouroEndereco = logradouroEndereco;
    }

    public int getNumeroEndereco() {
        return numeroEndereco;
    }

    public void setNumeroEndereco(int numeroEndereco) {
        this.numeroEndereco = numeroEndereco;
    }

    public String getComplementoEndereco() {
        return complementoEndereco;
    }

    public void setComplementoEndereco(String complementoEndereco) {
        this.complementoEndereco = complementoEndereco;
    }

    public Endereco(){
        
    }    
    
    public Endereco(String estadoEndereco, String cidadeEndereco, String cepEndereco, String bairroEndereco, String logradouroEndereco, int numeroEndereco, String complementoEndereco) {        
        this.estadoEndereco = estadoEndereco;
        this.cidadeEndereco = cidadeEndereco;
        this.cepEndereco = cepEndereco;
        this.bairroEndereco = bairroEndereco;
        this.logradouroEndereco = logradouroEndereco;
        this.numeroEndereco = numeroEndereco;
        this.complementoEndereco = complementoEndereco;
    }

    @Override
    public String toString() {
        return "Endereco{" + "codEndereco=" + codEndereco + ", estadoEndereco=" + estadoEndereco + ", cidadeEndereco=" + cidadeEndereco + ", cepEndereco=" + cepEndereco + ", bairroEndereco=" + bairroEndereco + ", logradouroEndereco=" + logradouroEndereco + ", numeroEndereco=" + numeroEndereco + ", complementoEndereco=" + complementoEndereco + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + this.codEndereco;
        hash = 37 * hash + Objects.hashCode(this.estadoEndereco);
        hash = 37 * hash + Objects.hashCode(this.cidadeEndereco);
        hash = 37 * hash + Objects.hashCode(this.cepEndereco);
        hash = 37 * hash + Objects.hashCode(this.bairroEndereco);
        hash = 37 * hash + Objects.hashCode(this.logradouroEndereco);
        hash = 37 * hash + this.numeroEndereco;
        hash = 37 * hash + Objects.hashCode(this.complementoEndereco);
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
        final Endereco other = (Endereco) obj;
        if (this.codEndereco != other.codEndereco) {
            return false;
        }
        if (this.numeroEndereco != other.numeroEndereco) {
            return false;
        }
        if (!Objects.equals(this.estadoEndereco, other.estadoEndereco)) {
            return false;
        }
        if (!Objects.equals(this.cidadeEndereco, other.cidadeEndereco)) {
            return false;
        }
        if (!Objects.equals(this.cepEndereco, other.cepEndereco)) {
            return false;
        }
        if (!Objects.equals(this.bairroEndereco, other.bairroEndereco)) {
            return false;
        }
        if (!Objects.equals(this.logradouroEndereco, other.logradouroEndereco)) {
            return false;
        }
        if (!Objects.equals(this.complementoEndereco, other.complementoEndereco)) {
            return false;
        }
        return true;
    }
  
    
    
    
    
}
