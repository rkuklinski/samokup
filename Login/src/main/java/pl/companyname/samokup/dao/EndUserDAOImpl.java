package pl.companyname.samokup.dao;

import java.util.List;
 
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
 
import pl.companyname.samokup.model.EndUser;
 
@Repository
public class EndUserDAOImpl implements EndUserDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(EndUserDAOImpl.class);
 
    private SessionFactory sessionFactory;
     
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }
 
    @Override
    public void addEndUser(EndUser p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.save(p);
        logger.info("EndUser saved successfully, EndUser Details="+p);
    }
 
    @Override
    public void updateEndUser(EndUser p) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(p);
        logger.info("EndUser updated successfully, EndUser Details="+p);
    }
 
    @SuppressWarnings("unchecked")
    @Override
    public List<EndUser> listEndUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<EndUser> EndUsersList = session.createQuery("from EndUser").list();
        for(EndUser p : EndUsersList){
            logger.info("EndUser List::"+p);
        }
        return EndUsersList;
    }
 
    @Override
    public EndUser getEndUserByEmail(String email) {
        Session session = this.sessionFactory.getCurrentSession();      
        EndUser p = (EndUser) session.load(EndUser.class, new String(email));
        logger.info("EndUser loaded successfully, EndUser details="+p);
        return p;
    }
 
    @Override
    public void removeEndUser(String email) {
        Session session = this.sessionFactory.getCurrentSession();
        EndUser p = (EndUser) session.load(EndUser.class, new String(email));
        if(null != p){
            session.delete(p);
        }
        logger.info("EndUser deleted successfully, EndUser details="+p);
    }
 
}