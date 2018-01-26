package poe.jsf.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import poe.jsf.domain.Track;
import poe.jsf.domain.User;

@Stateless

public class TrackDao {
	
	 @PersistenceContext(unitName = "persistence-unit-h2")
	    private EntityManager em;

	 public void add(Track track) {
	        em.persist(track);
	    }
	 

	    public List<Track> list() {
	        return em.createQuery("select e from Track e").getResultList();
	    }

	    public void delete(Long trackId) {
	        Track trackToDelete = em.find(Track.class, trackId);
	        em.remove(trackToDelete);
	    }

		public void edit(Track track) {
			// TODO Auto-generated method stub
			//User userToEdit = em.find(User.class, userId);
	        em.merge(track);
		}

		public Track get(Long trackId) {
			// TODO Auto-generated method stub
			Track track = em.find(Track.class, trackId);
			return track;
		}

		
}
