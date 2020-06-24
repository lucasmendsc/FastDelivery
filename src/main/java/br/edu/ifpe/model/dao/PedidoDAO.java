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

<<<<<<< HEAD:src/main/java/br/edu/ifpe/model/dao/PedidoDAO.java
import br.edu.ifpe.model.classes.Pedido;
import br.edu.ifpe.model.dao.interfaces.PedidoInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtil;
=======
import br.edu.ifpe.model.classes.Frete;
import br.edu.ifpe.model.dao.interfaces.FreteInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtill;
>>>>>>> 77102c0518a8a69ded5447ef334470cbc02c5e77:src/main/java/br/edu/ifpe/model/dao/FreteDAO.java
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Luciano
 */
public class PedidoDAO implements PedidoInterfaceDAO {

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
<<<<<<< HEAD:src/main/java/br/edu/ifpe/model/dao/PedidoDAO.java
    public void inserir(Pedido pedido) {
        Session session = HibernateUtil.getSession();
        try {
            session.getTransaction().begin();
            session.save(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao INSERIR " + e.toString());
=======
    public void inserir(Frete frete) {
        session = UTILL.getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(frete);
            transaction.commit();
        } catch (Exception createFreteException) {
            System.out.println(createFreteException.getMessage());
            transaction.rollback();
>>>>>>> 77102c0518a8a69ded5447ef334470cbc02c5e77:src/main/java/br/edu/ifpe/model/dao/FreteDAO.java
        } finally {
            session.close();
        }
    }

    @Override
<<<<<<< HEAD:src/main/java/br/edu/ifpe/model/dao/PedidoDAO.java
    public void alterar(Pedido pedido) {
        Session session = HibernateUtil.getSession();
        try {
            session.getTransaction().begin();
            session.update(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Erro ao ATUALIZAR " + e.toString());
=======
    public Frete recuperar(Integer codigo) {
        try {
            session = UTILL.getSession();
            return (Frete) session.createQuery(
                    "FROM Frete where id=" + codigo).getSingleResult();
        } catch (Exception readFreteException) {
            System.out.println(readFreteException.getMessage());
            return null;
>>>>>>> 77102c0518a8a69ded5447ef334470cbc02c5e77:src/main/java/br/edu/ifpe/model/dao/FreteDAO.java
        } finally {
            session.close();
        }
    }

    @Override
<<<<<<< HEAD:src/main/java/br/edu/ifpe/model/dao/PedidoDAO.java
    public Pedido recuperar(Integer codigo) {
        Pedido pedido = null;

        Session session = HibernateUtil.getSession();
        try {
            pedido = session.find(Pedido.class, codigo);
=======
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
>>>>>>> 77102c0518a8a69ded5447ef334470cbc02c5e77:src/main/java/br/edu/ifpe/model/dao/FreteDAO.java
            session.close();
        }
<<<<<<< HEAD:src/main/java/br/edu/ifpe/model/dao/PedidoDAO.java
        return pedido;
    }

    @Override
    public void deletar(Pedido pedido) {
        Session session = HibernateUtil.getSession();

        try {
            session.getTransaction().begin();
            session.delete(pedido);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao DELETAR " + e.toString());
=======
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
>>>>>>> 77102c0518a8a69ded5447ef334470cbc02c5e77:src/main/java/br/edu/ifpe/model/dao/FreteDAO.java
        } finally {
            session.close();
        }

    }

    @Override
<<<<<<< HEAD:src/main/java/br/edu/ifpe/model/dao/PedidoDAO.java
    public List<Pedido> listarTodos() {
        List<Pedido> pedidos;

        try (Session session = HibernateUtil.getSession()) {

            TypedQuery<Pedido> c = session.createNativeQuery("select * from pedido", Pedido.class);
            pedidos = c.getResultList();
            if (pedidos != null) {
                return pedidos;
            }

        } catch (Exception e) {
            System.err.println("Erro ao recuperar todos" + e.toString());
=======
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
>>>>>>> 77102c0518a8a69ded5447ef334470cbc02c5e77:src/main/java/br/edu/ifpe/model/dao/FreteDAO.java
        }
    }

}
