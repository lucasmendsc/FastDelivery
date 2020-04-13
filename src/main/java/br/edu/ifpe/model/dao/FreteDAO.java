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

    private final HibernateUtill UTILL;
    private static FreteDAO instance;
    private Session session;

    public FreteDAO() {
        UTILL = HibernateUtill.getInstance();
    }

    public static FreteDAO getInstance() {
        if (instance == null) {
            instance = new FreteDAO();
        }
        return instance;
    }

    @Override
    public void inserir(Frete frete) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(frete);
            transaction.commit();
        } catch (Exception createFreteException) {
            System.out.println(createFreteException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public Frete recuperar(Integer codigo) {
        try {
            session = UTILL.getSession();
            return (Frete) session.createQuery(
                    "FROM Frete where id=" + codigo).getSingleResult();
        } catch (Exception readFreteException) {
            System.out.println(readFreteException.getMessage());
            return null;
        } finally {
            session.close();
        }
    }

    @Override
    public void alterar(Frete frete) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(frete);
            transaction.commit();
        } catch (Exception updateFreteException) {
            System.out.println(updateFreteException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public void deletar(Frete frete) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(frete);
            transaction.commit();
        } catch (Exception delFreteException) {
            System.out.println(delFreteException.getMessage());
            transaction.rollback();
        } finally {
            session.close();
        }
    }

    @Override
    public List<Frete> listarTodos() {
        session = UTILL.getSession();
        List<Frete> fretes = null;
        try {
            fretes = (List) session.createQuery
                                            ("FROM Frete").getResultList();
        } catch (Exception readAllFretesException) {
            System.out.println(readAllFretesException.getMessage());
        } finally {
            session.close();
            return fretes;
        }
    }
}
