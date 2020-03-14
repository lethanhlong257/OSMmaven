package services;

import entity.IPlaceService;
import models.Place;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.Iterator;
import java.util.List;

public class PlaceService  implements IPlaceService {

    private SessionFactory factory;

    @Override
    public int createNewPlace (Place place) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        Integer  placeId = null;
        try {

            tx = session.beginTransaction();
            placeId = (Integer) session.save(place);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return placeId;
    }

    @Override
    public void updatePlace(Place place) {

    }

    @Override
    public List listAllPlace() {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Transaction tx = null;
        List places = null;

        try {
            tx = session.beginTransaction();
            places = session.createQuery("FROM Place").list();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null)
                tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
        return places;
    }
}
