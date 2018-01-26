package poe.jsf.rest;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import poe.jsf.dao.TrackDao;
import poe.jsf.dao.UserDao;
import poe.jsf.domain.Track;
import poe.jsf.domain.User;

@Path("trackUser")
public class TrackToUserSerice {

	@EJB
	TrackDao trackDao;
	@EJB
	UserDao userDao;

    @POST
    @Path("add")
    @Produces("application/json")
    public void addTrackToUser(@QueryParam("idTrack") long idTrack, @QueryParam("idUser") long idUser) {
    	Track track;
    	User user;
    	track = trackDao.get(idTrack);
    	user = userDao.get(idUser);
    	userDao.addTrackToUser(track, user);
    }
    @DELETE
    @Path("delete")
    @Produces("application/json")
    public void delete(@QueryParam("idTrack") long idTrack, @QueryParam("idUser") long idUser) {
    	User user;
    	user = userDao.get(idUser);
    	userDao.deleteTrackFromUser(idTrack, user);
       	
        
    }

}
