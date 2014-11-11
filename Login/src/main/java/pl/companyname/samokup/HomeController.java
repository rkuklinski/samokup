package pl.companyname.samokup;

 
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.companyname.samokup.model.EndUser;
import pl.companyname.samokup.service.EndUserService;
 
@Controller
public class HomeController {
     
    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    
    private EndUserService endUserService;
    
    @Autowired(required=true)
    @Qualifier(value="endUserService")
    public void setEndUserService(EndUserService ps){
        this.endUserService = ps;
    }
/*    
   @RequestMapping(value = "/", method = RequestMethod.GET)
   public String mainTotal(Locale locale, Model model) {
       logger.info("Welcome home! The client locale is {}.", locale);
       Date date = new Date();
       DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
        
       String formattedDate = dateFormat.format(date);
        
       model.addAttribute("serverTime", formattedDate );
        
       return "home";
   }
*/   
  @RequestMapping(value = "/home", method = RequestMethod.GET)
  public String home(Locale locale, Model model) {
      logger.info("Welcome home! The client locale is {}.", locale);
      Date date = new Date();
      DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
       
      String formattedDate = dateFormat.format(date);
       
      model.addAttribute("serverTime", formattedDate );
       
      return "home";
  }
     
    @RequestMapping(value = "/emp/get/{id}", method = RequestMethod.GET)
    public String getEmployee(Locale locale, Model model,@PathVariable("id") int id) {
        logger.info("Welcome user! Requested Emp ID is: "+id);
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
         
        String formattedDate = dateFormat.format(date);
         
        model.addAttribute("serverTime", formattedDate );
        model.addAttribute("id", id);
        model.addAttribute("name", "Pankaj");
         
        return "employee";
    }
     
    @RequestMapping(value="/login")
    public String login(HttpServletRequest request, Model model){
        return "login";
    }
     
    @RequestMapping(value="/logout")
    public String logout(){
        return "logout";
    }
     
    @RequestMapping(value="/denied")
    public String denied(){
        return "denied";
    }
    
    @RequestMapping(value="/create")
    public String create(){
        return "create";
    }
    
    //For add and update person both
    @RequestMapping(value= "/create/add", method = RequestMethod.POST)
    public String createAccount(@ModelAttribute("endUser") EndUser p) {
    	logger.debug("Attempt to create end user");
        this.endUserService.addEndUser(p);
        return "redirect:/home";
         
    }
     
}