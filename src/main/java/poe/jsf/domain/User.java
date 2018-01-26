package poe.jsf.domain;



import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String email;

    @Column
    private String password;
    @OneToMany( cascade = CascadeType.ALL, fetch = FetchType.EAGER )
    private List<Track> tracks = new ArrayList<Track>();

    public User() {
    	
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String name) {
        this.email = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String surname) {
        this.password = surname;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

	public List<Track> getTracks() {
		return tracks;
	}

	public void setTracks(ArrayList<Track> tracks) {
		this.tracks = tracks;
	}
    
	public void addTrack(Track track) {
		tracks.add(track);
	}
}
