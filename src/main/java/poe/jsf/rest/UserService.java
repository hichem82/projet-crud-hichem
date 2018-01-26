package poe.jsf.rest;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.User;


@Path("user")
public class UserService {

		@EJB
		UserDao userDao;
	

	    @GET
	    @Path("show")
	    @Produces("application/json")
	    public User show(@QueryParam("id") long id) {
	    	User user;
	    	user = userDao.get(id);
	        return user;
	    }
	    
	    @POST
	    @Path("add")
	    @Produces("application/json")
	    public void add(@QueryParam("email") String email, @QueryParam("password") String password ) {
	    	User user= new User();
	    	user.setEmail(email);
	    	user.setPassword(password);
	    	userDao.add(user);
	        //return user;
	    }
	    @POST
	    @Path("edit")
	    @Produces("application/json")
	    public void edit(@QueryParam("id") Long id,@QueryParam("email") String email, @QueryParam("password") String password ) {
	    	User user= userDao.get(id);
	    	
	    	user.setEmail(email);
	    	user.setPassword(password);
	    	userDao.edit(user);
	        //return user;
	    }
	    
	    @DELETE
	    @Path("delete")
	    @Produces("application/json")
	    public void delete(@QueryParam("id") Long id) {
	    	//User user= userDao.get(id);
	    	
	    	userDao.delete(id);
	        //return user;
	    }
	    

	}
    
  