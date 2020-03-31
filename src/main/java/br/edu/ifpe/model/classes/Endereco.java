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
    private int id;
    
    @Column(name = "estadoEndereco", length = 20, nullable = false)
    private String estado;
    
    @Column(name = "cidadeEndereco", length = 20, nullable = false)
    private String cidade;
    
    @Column(name = "cepEndereco", length = 20, nullable = false)
    private String cep;
    
    @Column(name = "bairroEndereco", length = 20, nullable = false)
    private String bairro;
    
    @Column(name = "logradouroEndereco", length = 20, nullable = false)
    private String logradouro;
    
    @Column(name = "numeroEndereco", length = 10, nullable = false)
    private int numero;
    
    @Column(name = "complementoEndereco", length = 20, nullable = false)
    private String complemento;

    public Endereco() {
    }

    public Endereco(int id, String estado, String cidade, String cep,
            String bairro, String logradouro, int numero, String complemento) {
        this.id = id;
        this.estado = estado;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
    }

    public int getId() {
        return id;
    }
    
    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    @Override
    public String toString() {
        return "Endereco{" + "estado=" + estado + ", cidade=" + cidade + 
                ", cep=" + cep + ", bairro=" + bairro + ", logradouro=" + 
                logradouro + ", numero=" + numero + ", complemento=" + 
                complemento + '}';
    }

    @Override
    public int hashCode() {
        final int PRIMO = 5;
        int resultado = 1;
        resultado += (resultado * PRIMO) + id;
        resultado += (resultado * PRIMO) + estado.hashCode();
        resultado += (resultado * PRIMO) + cidade.hashCode();
        resultado += (resultado * PRIMO) + cep.hashCode();
        resultado += (resultado * PRIMO) + bairro.hashCode();
        resultado += (resultado * PRIMO) + logradouro.hashCode();
        resultado += (resultado * PRIMO) + numero;
        return (resultado * PRIMO) + complemento.hashCode() ;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Endereco))
            return false;

        if (!((Endereco) obj).estado.equals(this.estado))
            return false;

        if (!((Endereco) obj).cidade.equals(this.cidade))
            return false;

        if (!((Endereco) obj).cep.equals(this.cep))
            return false;

        if (!((Endereco) obj).bairro.equals(this.bairro))
            return false;

        if (!((Endereco) obj).logradouro.equals(this.logradouro))
            return false;

        if (((Endereco) obj).numero != this.numero)
            return false;

        return ((Endereco) obj).complemento.equals(this.complemento);
    }   
}
