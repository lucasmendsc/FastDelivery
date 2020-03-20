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

/**
 *
 * @author Luciano Júnior <lucianocljr7@gmail.com>
 */
public class Cliente {
    
    private int codCliente;
    private String nomeCliente;
    private String senhaCliente;
    private String cpfCliente;
    private LocalDate dtNascimentoCliente;
    private String telefoneCliente;
    private String emailCliente;

    public int getCodCliente() {
        return codCliente;
    }

//    public void setCodCliente(int codCliente) {
//        this.codCliente = codCliente;
//    }

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

    public Cliente(){
        
    }
    
    public Cliente(String nomeCliente, String senhaCliente, String cpfCliente, LocalDate dtNascimentoCliente, String telefoneCliente, String emailCliente) {
        this.nomeCliente = nomeCliente;
        this.senhaCliente = senhaCliente;
        this.cpfCliente = cpfCliente;
        this.dtNascimentoCliente = dtNascimentoCliente;
        this.telefoneCliente = telefoneCliente;
        this.emailCliente = emailCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "codCliente=" + codCliente + ", nomeCliente=" + nomeCliente + ", senhaCliente=" + senhaCliente + ", cpfCliente=" + cpfCliente + ", dtNascimentoCliente=" + dtNascimentoCliente + ", telefoneCliente=" + telefoneCliente + ", emailCliente=" + emailCliente + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.codCliente;
        hash = 97 * hash + Objects.hashCode(this.nomeCliente);
        hash = 97 * hash + Objects.hashCode(this.senhaCliente);
        hash = 97 * hash + Objects.hashCode(this.cpfCliente);
        hash = 97 * hash + Objects.hashCode(this.dtNascimentoCliente);
        hash = 97 * hash + Objects.hashCode(this.telefoneCliente);
        hash = 97 * hash + Objects.hashCode(this.emailCliente);
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
        final Cliente other = (Cliente) obj;
        if (this.codCliente != other.codCliente) {
            return false;
        }
        if (!Objects.equals(this.nomeCliente, other.nomeCliente)) {
            return false;
        }
        if (!Objects.equals(this.senhaCliente, other.senhaCliente)) {
            return false;
        }
        if (!Objects.equals(this.cpfCliente, other.cpfCliente)) {
            return false;
        }
        if (!Objects.equals(this.telefoneCliente, other.telefoneCliente)) {
            return false;
        }
        if (!Objects.equals(this.emailCliente, other.emailCliente)) {
            return false;
        }
        if (!Objects.equals(this.dtNascimentoCliente, other.dtNascimentoCliente)) {
            return false;
        }
        return true;
    }    
}
