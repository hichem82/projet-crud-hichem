package poe.jsf.dao;


import poe.jsf.domain.Track;
import poe.jsf.domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Stateless
public class UserDao {

    @PersistenceContext(unitName = "persistence-unit-h2")
    private EntityManager em;

    public void add(User user) {
        System.out.println("em: " + em);
        em.persist(user);
    }

    public List<User> list() {
        return em.createQuery("select e from User e").getResultList();
    }
    public List<Track> listTrack(Long userId) {
    	User user = em.find(User.class, userId);
    	System.out.println(user.getId());
    	return user.getTracks();
        // em.createQuery("select e from User e").getResultList();
    }


    public void delete(Long userId) {
        User userToDelete = em.find(User.class, userId);
        em.remove(userToDelete);
    }

	public void edit(User user) {
		// TODO Auto-generated method stub
		//User userToEdit = em.find(User.class, userId);
        em.merge(user);
	}

	public User get(Long userId) {
		// TODO Auto-generated method stub
		User user = em.find(User.class, userId);
		return user;
	}
	public void addTrackToUser(Track track, User user) {
		//track.setUser(user);
		user.addTrack(track);
		em.merge(user);
		
	}
	public void deleteTrackFromUser(Long trackId, User user) {
		//track.setUser(user);
		//List<Track> list = user.getTracks();
		System.out.println("lklqskdjlkj"+user.getId());
		int indexTrack=0;
		for (Track track : user.getTracks()) {
			if (track.getId()== trackId) {
				 indexTrack= user.getTracks().indexOf(track);
			}
		}		
		user.getTracks().remove(indexTrack);
		
		em.merge(user);
		
	}


}
