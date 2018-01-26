package poe.jsf.controller;

import java.io.Serializable;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import poe.jsf.dao.TrackDao;
import poe.jsf.domain.Track;
import poe.jsf.domain.User;

@ManagedBean
@RequestScoped
public class TrackController implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Track track;
	
	 @EJB
	    private TrackDao trackDao;

	public TrackController() {
		track = new Track();
	}
	public List<Track> list() {
        return trackDao.list();
    }
	
	public String  add() {
        trackDao.add(track);
        return "index";
    }
	
	 public String delete(Long trackId) {
		 trackDao.delete(trackId);
	        return "list-tracks";
	    }
	 public String showEdit (Long trackId) {
	       // userDao.edit(userId);
	    	this.track = trackDao.get(trackId);
	    	
	        return "edit-track";
	    }
	 
	 public String update () {
		 trackDao.edit(this.track);
     	
         return "list-tracks";
     }

	public Track getTrack() {
		return track;
	}

	public void setTrack(Track track) {
		this.track = track;
	}
	 
	
	 
}
