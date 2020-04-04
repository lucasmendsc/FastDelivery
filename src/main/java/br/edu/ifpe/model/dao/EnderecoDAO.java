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

import br.edu.ifpe.model.classes.Endereco;
import br.edu.ifpe.model.dao.interfaces.EnderecoInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Luciano Júnior <lucianocljr7@gmail.com>
 */
public class EnderecoDAO implements EnderecoInterfaceDAO{

    private static EnderecoDAO instance = null;
    private final Session SESSION;
    private final Transaction TRANSACTION;

    public static EnderecoDAO getInstance() {
        if (instance == null) {
            instance = new EnderecoDAO();
        }
        return instance;
    }

    public EnderecoDAO() {
        this.SESSION = HibernateUtill.getInstance().getSession();
        this.TRANSACTION = SESSION.beginTransaction();
    }

    @Override
    public void inserir(Endereco endereco) {

        try {
            SESSION.save(endereco);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }

    }

    @Override
    public void alterar(Endereco endereco) {

        try {
            SESSION.update(endereco);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }

    }

    @Override
    public Endereco recuperar(Integer codigo) {
        try {
            return (Endereco) SESSION.createQuery
                        ("FROM Endereco where id=" + codigo).getResultList();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            return null;
        } finally {
            SESSION.close();
        }
    }

    @Override
    public void deletar(Endereco endereco) {

        try {
            SESSION.delete(endereco);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }
    }

    @Override
    public List<Endereco> listarTodos() {
        List<Endereco> enderecos = null;

        try{
            enderecos = (List) SESSION.createQuery
                ("FROM Endereco").getResultList();
        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }finally{
            SESSION.close();
            return enderecos;
        }
    }
 }
    
