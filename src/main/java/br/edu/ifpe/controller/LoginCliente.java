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
package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Cliente;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
@ManagedBean(name = "loginCliente")
@SessionScoped
public class LoginCliente {

    private Cliente clienteLogado = null;

    public LoginCliente() {
    }

    public String logar(String login, String senha) {

        List<Cliente> clientes = new ClienteController().listarTodosClientesAction();

        for (Cliente c : clientes) {
            if (c.getEmailCliente().equals(login)) {
                if (c.getSenhaCliente().equals(senha)) {
                    this.clienteLogado = c;
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado", c);
                    return "listarProduto.xhtml";
                }
            }
        }
        return "index.xhtml";

    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        this.clienteLogado = null;
        return "index.xhtml";
    }

}
