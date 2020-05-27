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
import br.edu.ifpe.model.negocio.ClienteNegocio;
import java.util.List;

/**
 *
 * @author Luciano
 */
public class ClienteController {
    
    ClienteNegocio clienteModel = new ClienteNegocio();
    
    public void inserirClienteAction (Cliente cliente){
        clienteModel.inserirCliente(cliente);
    }

    public void alterarClienteAction (Cliente cliente){
        clienteModel.alterarCliente(cliente);
    }
    
    public Cliente recuperarClienteAction(int codigo){
        return clienteModel.recuperarCliente(codigo);
    }
    
    public void deletarClienteAction (Cliente cliente){
        clienteModel.deletarCliente(cliente);
    }
    
    public List<Cliente> listarTodosClientesAction(){
        return clienteModel.listarTodosClientes();
    }
    
}
