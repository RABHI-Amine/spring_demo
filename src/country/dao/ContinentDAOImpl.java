package country.dao;

import country.model.Continent;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ContinentDAOImpl implements ContinentDAO{

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public Continent getContientByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Continent c where c.name = :name");
        query.setString("name",name);
        return (Continent) query.list().get(0);
    }

    @Override
    public boolean exists(String code) {
            Session session = sessionFactory.getCurrentSession();
            Query query = session.createQuery("from Continent c where c.code = :code");
            query.setString("code",code);
            return query.list().size() > 0;
        }

    @Override
    public Continent getContientByCode(String code) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Continent c where c.code = :code");
        query.setString("code",code);
        return (Continent) query.list().get(0);
    }

    @Override
    public boolean existsByName(String name) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Continent c where c.name = :name");
        query.setString("name",name);
        return query.list().size() > 0;
    }

}



