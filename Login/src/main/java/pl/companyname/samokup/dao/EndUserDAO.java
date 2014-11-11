package pl.companyname.samokup.dao;

import java.util.List;
 
import pl.companyname.samokup.model.EndUser;
 
public interface EndUserDAO {
 
    public void addEndUser(EndUser p);
    public void updateEndUser(EndUser p);
    public List<EndUser> listEndUsers();
    public EndUser getEndUserByEmail(String email);
    public void removeEndUser(String email);
}