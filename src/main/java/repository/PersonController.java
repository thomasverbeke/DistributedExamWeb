package repository;
 
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

 
@Controller
public class PersonController {
 
    @Autowired
    private PersonDao personDao;

    @RequestMapping(value="/person")
    public ModelAndView getData(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    	 Map<String, Object> myModel = new HashMap<String, Object>();
         myModel.put("persons", personDao.getAllPersons());
         
         //ModelAndView(String viewName, String modelName, Object modelObject) 
        return new ModelAndView("person", "model", myModel);
    }
}