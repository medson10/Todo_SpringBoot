package api.models;

import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String content;
    private long hours;
    private String status;

    @ManyToMany(mappedBy="tasks", cascade = CascadeType.ALL)
    private List <Member> members = new ArrayList <Member>();
    
    public void setContent(String content) {    
        this.content = content;
    }

    public void setHours(long hours) {
        this.hours = hours;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public long getHours() {
        return hours;
    }
    
    public String getStatus() {
        return status;
    }

    public void setMembers(ArrayList<Member> members) {
		this.members = members;
	}
	public List<Member> getMembers() {
		return members;
	}
}
