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
package br.edu.ifpe.model.dao;

import br.edu.ifpe.model.dao.resources.HibernateUtill;
import br.edu.ifpe.model.classes.Cliente;
import br.edu.ifpe.model.dao.interfaces.ClienteInterfaceDAO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Luciano Júnior <lucianocljr7@gmail.com>
 */
public class ClienteDAO implements ClienteInterfaceDAO {

    private static ClienteDAO instance = null;
    private final Session SESSION;
    private final Transaction TRANSACTION;

    public static ClienteDAO getInstance() {
        if (instance == null) {
            instance = new ClienteDAO();
        }
        return instance;
    }

    public ClienteDAO() {
        this.SESSION = HibernateUtill.getInstance().getSession();
        this.TRANSACTION = SESSION.beginTransaction();
    }

    @Override
    public void inserir(Cliente cliente) {

        try {
            SESSION.save(cliente);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }

    }

    @Override
    public void alterar(Cliente cliente) {

        try {
            SESSION.update(cliente);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }

    }

    @Override
    public Cliente recuperar(Integer codigo) {
        try {
            return (Cliente) SESSION.createQuery
                        ("FROM Cliente where id=" + codigo).getResultList();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            return null;
        } finally {
            SESSION.close();
        }
    }

    @Override
    public void deletar(Cliente cliente) {

        try {
            SESSION.delete(cliente);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }
    }

    @Override
    public List<Cliente> listarTodos() {
        List<Cliente> clientes = null;

        try{
            clientes = (List) SESSION.createQuery
                ("FROM cliente").getResultList();
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }finally{
            SESSION.close();
            return clientes;
        }
    }
}
