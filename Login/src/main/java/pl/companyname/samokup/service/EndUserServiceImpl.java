package pl.companyname.samokup.service;

import java.util.List;
 
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 
import pl.companyname.samokup.dao.EndUserDAO;
import pl.companyname.samokup.model.EndUser;
 
@Service
public class EndUserServiceImpl implements EndUserService {
     
    private EndUserDAO EndUserDAO;
 
    public void setEndUserDAO(EndUserDAO EndUserDAO) {
        this.EndUserDAO = EndUserDAO;
    }
 
    @Override
    @Transactional
    public void addEndUser(EndUser p) {
    	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    	
    	String encPassword = passwordEncoder.encode(p.getPassword());
    	p.setPassword(encPassword);
        this.EndUserDAO.addEndUser(p);
    }
 
    @Override
    @Transactional
    public void updateEndUser(EndUser p) {
        this.EndUserDAO.updateEndUser(p);
    }
 
    @Override	
    @Transactional
    public List<EndUser> listEndUsers() {
        return this.EndUserDAO.listEndUsers();
    }
 
    @Override
    @Transactional
    public EndUser getEndUserByEmail(String email) {
        return this.EndUserDAO.getEndUserByEmail(email);
    }
 
    @Override
    @Transactional
    public void removeEndUser(String email) {
        this.EndUserDAO.removeEndUser(email);
    }
 
}