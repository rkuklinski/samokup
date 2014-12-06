package pl.companyname.samokup.service;

import java.util.List;

import pl.companyname.samokup.model.EndUser;
 
public interface EndUserService {
 
    public void addEndUser(EndUser p);
    public void updateEndUser(EndUser p);
    public List<EndUser> listEndUsers();
    public EndUser getEndUserByEmail(String email);
    public void removeEndUser(String email);
     
}

