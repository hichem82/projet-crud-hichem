package poe.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import poe.jsf.dao.UserDao;
import poe.jsf.domain.Track;
import poe.jsf.domain.User;

@ManagedBean
@RequestScoped
public class UserController implements Serializable {
    private static final long serialVersionUID = 1L;

    private User user;

    @EJB
    private UserDao userDao;

    public UserController() {
        user = new User();
    }

    public String  add() {
        System.out.println("adding user " + user.getEmail());
        userDao.add(user);
        return "index";
    }

    public List<User> list() {
        return userDao.list();
    }
    
    public String addTrackToUser(Track track, User user) {
		userDao.addTrackToUser(track, user);
    	//System.out.println("la chanson est "+track.getId() +"******"+ track.getUser().getId() + "**********"+ user.getId() );
		return"list-tracks-choice";
	}
    public List<Track> listTrack(Long id) {
    	
    	System.out.println("" + id);
        return userDao.listTrack(id);
    }
    public String delete(Long userId) {
        userDao.delete(userId);
        return "list-users";
    }
    public String showEdit (Long userId) {
       // userDao.edit(userId);
    	this.user = userDao.get(userId);
    	
        return "edit-user";
    }
    public String update () {
         userDao.edit(this.user);
     	//this.user = userDao.get(userId);
     	
         return "list-users";
     }
    public String trackChoice(User user1) {
    	user= user1;
    	return"list-tracks-choice";
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
