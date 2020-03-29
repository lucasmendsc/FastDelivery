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

import br.edu.ifpe.model.classes.Pagamento;
import br.edu.ifpe.model.dao.interfaces.PagamentoInterfaceDAO;
import br.edu.ifpe.model.dao.resources.HibernateUtil;
import java.util.List;
import javax.persistence.TypedQuery;
import org.hibernate.Session;

/**
 *
 * @author Luciano
 */
public class PagamentoDAO implements PagamentoInterfaceDAO {

    @Override
    public void inserir(Pagamento pagamento) {
        
        Session session = HibernateUtil.getSession();
        try {
            session.getTransaction().begin();
            session.save(pagamento);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao INSERIR " + e.toString());
        } finally {
            session.close();
        }}

    @Override
    public void alterar(Pagamento pagamento) {
        
        Session session = HibernateUtil.getSession();
        try {
            session.getTransaction().begin();
            session.update(pagamento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println("Erro ao ATUALIZAR " + e.toString());
        } finally {
            session.close();
        }}

    @Override
    public Pagamento recuperar(Integer codigo) {
        Pagamento pagamento = null;

        Session session = HibernateUtil.getSession();
        try {
            pagamento = session.find(Pagamento.class, codigo);
            session.close();
        } catch (Exception e) {
            System.out.println("Erro ao RECUPERAR " + e.toString());
        }
        return pagamento;
    }

    @Override
    public void deletar(Pagamento pagamento) {
    Session session = HibernateUtil.getSession();

        try {
            session.getTransaction().begin();
            session.delete(pagamento);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.err.println("Falha ao DELETAR " + e.toString());
        } finally {
            session.close();
        }}

    @Override
    public List<Pagamento> listarTodos() {
        List<Pagamento> pagamentos;

        try (Session session = HibernateUtil.getSession()) {

            TypedQuery<Pagamento> c = session.createNativeQuery("select * from pagamento", Pagamento.class);
            pagamentos = c.getResultList();
            if (pagamentos != null) {
                return pagamentos;
            }

        } catch (Exception e) {
            System.err.println("Erro ao recuperar todos" + e.toString());
        }
        return null;}
    
}
