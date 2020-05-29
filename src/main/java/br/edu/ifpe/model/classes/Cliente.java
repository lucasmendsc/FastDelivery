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

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Luciano Júnior <lucianocljr7@gmail.com>
 */
@SuppressWarnings("serial")
@Entity
public class Cliente implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nomeCliente", length = 30, nullable = false)
    private String nomeCliente;

    @Column(name = "senhaCliente", length = 20, nullable = false)
    private String senhaCliente;

    @Column(name = "cpfCliente", length = 11, nullable = false)
    private String cpfCliente;

    @Column(name = "dtNascimentoCliente", nullable = true)
    private LocalDate dtNascimentoCliente;

    @Column(name = "telefoneCliente", nullable = false)
    private String telefoneCliente;

    @Column(name = "emailCliente", nullable = false)
    private String emailCliente;
    
   @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name ="cod_endereco")
    private Endereco endereco;

    public Cliente() {
    this.endereco = new Endereco();
    }

    public Cliente(String nomeCliente, String senhaCliente, 
            String cpfCliente, LocalDate dtNascimentoCliente, 
            String telefoneCliente, String emailCliente, Endereco endereco) {
        this.nomeCliente = nomeCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.dtNascimentoCliente = dtNascimentoCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getSenhaCliente() {
        return senhaCliente;
    }

    public void setSenhaCliente(String senhaCliente) {
        this.senhaCliente = senhaCliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public LocalDate getDtNascimentoCliente() {
        return dtNascimentoCliente;
    }

    public void setDtNascimentoCliente(LocalDate dtNascimentoCliente) {
        this.dtNascimentoCliente = dtNascimentoCliente;
    }

    public String getTelefoneCliente() {
        return telefoneCliente;
    }

    public void setTelefoneCliente(String telefoneCliente) {
        this.telefoneCliente = telefoneCliente;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    
    @Override
    public String toString() {
        return "Cliente{" + "nomeCliente=" + nomeCliente + ", senhaCliente=" + 
                senhaCliente + ", cpfCliente=" + cpfCliente + 
                ", dtNascimentoCliente=" + dtNascimentoCliente + 
                ", telefoneCliente=" + telefoneCliente + ", emailCliente=" +
                emailCliente + ", endereco=" + endereco + '}';
    }

    @Override
    public int hashCode() {
        final int PRIMO = 3;
        int resultado = 1;
        resultado += (PRIMO * resultado) + id;
        resultado += (PRIMO * resultado) + nomeCliente.hashCode();
        resultado += (PRIMO * resultado) + senhaCliente.hashCode();
        resultado += (PRIMO * resultado) + cpfCliente.hashCode();
        resultado += (PRIMO * resultado) + dtNascimentoCliente.hashCode();
        resultado += (PRIMO * resultado) + telefoneCliente.hashCode();
        resultado += (PRIMO * resultado) + emailCliente.hashCode();

        return (resultado * PRIMO) + endereco.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (!((obj) instanceof Cliente)) {
            return false;
        }

        if (!((Cliente) obj).nomeCliente.equals(this.nomeCliente)) {
            return false;
        }

        if (!((Cliente) obj).senhaCliente.equals(this.senhaCliente)) {
            return false;
        }

        if (!((Cliente) obj).cpfCliente.equals(this.cpfCliente)) {
            return false;
        }

        if (!((Cliente) obj).dtNascimentoCliente.equals(
                this.dtNascimentoCliente)) {
            return false;
        }

        if (!((Cliente) obj).telefoneCliente.equals(this.telefoneCliente)) {
            return false;
        }

        return ((Cliente) obj).emailCliente.equals(this.emailCliente);
    }
}
