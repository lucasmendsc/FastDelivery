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

import br.edu.ifpe.model.classes.Frete;
import br.edu.ifpe.model.dao.interfaces.FreteInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Luciano
 */
public class FreteDAO implements FreteInterfaceDAO {

    private static FreteDAO instance = null;
    private final  Session SESSION;
    private final Transaction TRANSACTION;

    public static FreteDAO getInstance() {
        if (instance == null) {
            instance = new FreteDAO();
        }
        return instance;
    }

    public FreteDAO() {
        this.SESSION = HibernateUtill.getInstance().getSession();
        this.TRANSACTION = SESSION.beginTransaction();
    }

    @Override
    public void inserir(Frete frete) {

        try {
            SESSION.save(frete);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }

    }

    @Override
    public void alterar(Frete frete) {

        try {
            SESSION.update(frete);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }

    }

    @Override
    public Frete recuperar(Integer codigo) {
        try {
            return (Frete) SESSION.createQuery
                            ("FROM Frete where id=" + codigo).getResultList();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            return null;
        } finally {
            SESSION.close();
        }
    }

    @Override
    public void deletar(Frete frete) {

        try {
            SESSION.delete(frete);
            TRANSACTION.commit();

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
            TRANSACTION.rollback();

        } finally {
            SESSION.close();
        }
    }

    @Override
    public List<Frete> listarTodos() {
        List<Frete> fretes = null;

        try {
            fretes = (List) SESSION.createQuery("FROM Frete").getResultList();
        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        } finally {
            SESSION.close();
            return fretes;
        }
    }
}
