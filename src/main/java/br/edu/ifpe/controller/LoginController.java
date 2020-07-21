package br.edu.ifpe.controller;

import br.edu.ifpe.model.classes.Cliente;
import br.edu.ifpe.model.negocio.ClienteNegocio;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author marce
 */

@Named
@SessionScoped
public class LoginController implements Serializable {

    private Cliente clienteLogado = null;
    private String login;
    private String senha;

    public LoginController() {
    }

    public Cliente getClienteLogado() {
        return clienteLogado;
    }

    public void setClienteLogado(Cliente clienteLogado) {
        this.clienteLogado = clienteLogado;
    }

    public String loginCliente() {
        ClienteNegocio clienteNegocio = new ClienteNegocio();
        List<Cliente> clienteLogin = clienteNegocio.listarTodosClientes();
        
        if(clienteLogin != null) {
            for(Cliente clienteLogando : clienteLogin) {
                if(clienteLogando.getEmailCliente().equals(this.login) 
                        && clienteLogando.getSenhaCliente().equals(this.senha)) {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Você esta Logado!"));
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("clienteLogado", this.clienteLogado);
                    return "perfilCliente.xhtml?faces-redirect=true";
                }
            }
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Usuario não encontrado!"));
        return "index.html";
    }

    public String logout() {

        this.clienteLogado = null;

        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();

        return "";
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
