///*MIT License
//
//Copyright (c) 2020 Lucas Mendes,Marcela Cardoso,Luciano Jr.
//
//Permission is hereby granted, free of charge, to any person obtaining a copy
//of this software and associated documentation files (the "Software"), to deal
//in the Software without restriction, including without limitation the rights
//to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
//copies of the Software, and to permit persons to whom the Software is
//furnished to do so, subject to the following conditions:
//
//The above copyright notice and this permission notice shall be included in all
//copies or substantial portions of the Software.
//
//THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
//IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
//FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
//AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
//LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
//OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
//SOFTWARE.*/
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.classes.Endereco;
import java.util.List;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * @author Lucas Mendes <lucas.mendes147@live.com>
 */
public class T1EnderecoDAOTest {

    private static Endereco endereco;
    private static Endereco end;

    @BeforeClass
    public static void deveInserirEndereco() {
        endereco = new Endereco("estado", "cidade", "cep", "bairro",
                "logradouro", 0, "complemento");

        end = new Endereco("estado1", "cidade1", "cep1", "bairro1",
                "logradouro1", 1, "complemento1");

        EnderecoDAO.getInstance().inserir(endereco);
        EnderecoDAO.getInstance().inserir(end);

    }

    @Test
    public void deveRecuperarEndereco() {
        List<Endereco> enderecos = EnderecoDAO.getInstance().listarTodos();
        assertEquals("deveRecuperarEndereco", endereco,
                enderecos.get(enderecos.size() - 1));
    }

    @Test
    public void deveAlterarEndereco() {
        endereco.setBairro("bairroAlterado");
        endereco.setCidade("cidadeAlterada");
        endereco.setComplemento("complementoAlterado");

        EnderecoDAO.getInstance().alterar(endereco);
        List<Endereco> enderecos = EnderecoDAO.getInstance().listarTodos();
        assertEquals("deveAlterarEndereco", endereco,
                enderecos.get(enderecos.size() - 1));
    }

    @Test
    public void deveRecuperarTodosEnderecos() {
        List<Endereco> enderecos = EnderecoDAO.getInstance().listarTodos();

        assertTrue(enderecos.contains(end));
        assertTrue(enderecos.contains(endereco));
    }

    @AfterClass
    public static void deveDeletarEndereco() {
        EnderecoDAO.getInstance().deletar(endereco);
        EnderecoDAO.getInstance().deletar(end);
    }
}
