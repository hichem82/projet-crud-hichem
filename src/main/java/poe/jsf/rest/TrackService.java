package poe.jsf.rest;

import javax.ejb.EJB;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import poe.jsf.dao.TrackDao;
import poe.jsf.dao.UserDao;
import poe.jsf.domain.Track;
import poe.jsf.domain.User;

@Path("track")
public class TrackService {

	@EJB
	TrackDao trackDao;


    @GET
    @Path("show")
    @Produces("application/json")
    public Track show(@QueryParam("id") long id) {
    	Track track;
    	track = trackDao.get(id);
        return track;
    }
    
    @POST
    @Path("add")
    @Produces("application/json")
    public void add(@QueryParam("title") String title, @QueryParam("artist") String artist ) {
    	Track track= new Track();
    	track.setTitle(title);
    	track.setArtist(artist);
    	trackDao.add(track);
        //return user;
    }
    @POST
    @Path("edit")
    @Produces("application/json")
    public void edit(@QueryParam("id") Long id,@QueryParam("title") String title, @QueryParam("artist") String artist ) {
    	Track track= trackDao.get(id);
    	track.setTitle(title);
    	track.setArtist(artist);
    	trackDao.edit(track);
        //return user;
    }
    
    @DELETE
    @Path("delete")
    @Produces("application/json")
    public void delete(@QueryParam("id") Long id) {
    	//User user= userDao.get(id);
    	trackDao.delete(id);
    	
        
    }

}
