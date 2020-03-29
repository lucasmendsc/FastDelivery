
import br.edu.ifpe.model.dao.ClienteDAO;
import br.edu.ifpe.controller.ClienteController;
import br.edu.ifpe.controller.EnderecoController;
import br.edu.ifpe.model.classes.Cliente;
import br.edu.ifpe.model.classes.Endereco;
import java.time.LocalDate;
import java.util.List;

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
/**
 *
 * @author Luciano
 */
public class teste {

    public static void main(String[] args) {

        /* Testes da classe básica CLIENTE - OK!*/
        
       // ClienteDAO clientedao = new ClienteDAO();

        //Teste - Inserção - OK!
//        clientedao.inserir(
//                new Cliente
//        ("teste","1111","1111",LocalDate.now(),"1111-1111","1111"));


        //Teste - Recuperar - OK!
//        Cliente c = clientedao.recuperar(2);
//        System.out.println("Cliente recuperado: " + c.toString());


        //Teste - Alteração - OK
//        System.out.println("Cliente ANTES de ser alterado: " + c.toString());
//        c.setNomeCliente("Luciano Júnior");
//        clientedao.alterar(c);
//        System.out.println("Cliente DEPOIS de ser alterado: " + c.toString());
        
        // Teste - Deletar - OK!
//        List<Cliente> c = clientedao.listarTodos();
//        System.out.println("Clientes cadastrados ANTES de deletar: " + c.toString());
//        Cliente cliente = clientedao.recuperar(2);
//        System.out.println("Cliente que vai ser deletado: " + cliente.toString());
//        clientedao.deletar(cliente);
//        List<Cliente> c2 = clientedao.listarTodos();
//        System.out.println("Clientes cadastrados DEPOIS de deletar: " + c2.toString());
        
        //Teste - Listagem - OK!
//        List<Cliente> c = clientedao.listarTodos();
//        System.out.println("Clientes cadastrados: " + c.toString());





        /* Testes da classe básica ENDERECO - EM ANDAMENTO!*/
        
        //Teste - Inserção - OK!
        
//        Endereco endereco = new Endereco("TESTE2", "TESTE2", "TESTE2", "TESTE2", "TESTE2", 2, "TESTE2");
        EnderecoController ec = new EnderecoController();
//        ec.inserirEnderecoAction(endereco);

        //Teste - Recuperar - OK!
        //Endereco end = ec.recuperarEnderecoAction(1);
//        System.out.println("Endereco recuperado: " + end.toString());

        //Teste - Alteração - OK!
//        System.out.println("Endereco ANTES de ser alterado: " + end.toString());
//        end.setBairroEndereco("ALTERAÇÃO DO BAIRRO");
//        ec.alterarEnderecoAction(end);
//        System.out.println("Endereco DEPOIS de ser alterado: " + end.toString());

        // Teste - Deletar - OK!
//        List<Endereco> e = ec.listarTodosEnderecosAction();
//        System.out.println("Enderecos cadastrados ANTES de deletar: " + e.toString());
//        Endereco end = ec.recuperarEnderecoAction(2);
//        System.out.println("Endereco que vai ser deletado: " + end.toString());
//        ec.deletarEnderecoAction(end);
//        List<Endereco> c2 = ec.listarTodosEnderecosAction();
//        System.out.println("Enderecos cadastrados DEPOIS de deletar: " + c2.toString());
        
        //Teste - Listagem - EM ANDAMENTO!
        
        List<Endereco> enderecos = ec.listarTodosEnderecosAction();
        System.out.println("Enderecos Cadastrados: " + enderecos.toString());
        

    }

}
