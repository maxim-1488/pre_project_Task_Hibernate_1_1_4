package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    //private final Session session = Util.getSessionFactory().openSession();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("CREATE TABLE users (id BIGINT NOT NULL AUTO_INCREMENT, " +
                "name VARCHAR(45), lastName VARCHAR(45), age SMALLINT NOT NULL, " +
                "PRIMARY KEY (id))").addEntity(User.class);

        transaction.commit();
        session.close();
    }

    @Override
    public void dropUsersTable() {
        Session session = Util.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Query query = session.createSQLQuery("DROP TABLE IF EXISTS users").addEntity(User.class);

        transaction.commit();
        session.close();
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            //session.createSQLQuery("INSERT INTO users (name, lastName, age) VALUES (?, ?, ?)");
            Query query = session.createQuery("insert into users");
            query.setParameter(1, name);
            query.setParameter(2, lastName);
            query.setParameter(3, age);
            session.beginTransaction().commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            try {
                //session.getTransaction().rollback();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }

    @Override
    public void removeUserById(long id) {


    }

    @Override
    public List<User> getAllUsers() {
        List<User> list = null;
        try (Session session = Util.getSessionFactory().openSession()) {
            session.beginTransaction();
            Query query = session.createQuery("from users");
            list = (List<User>) query.list();
            session.beginTransaction().commit();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public void cleanUsersTable() {


    }
}
