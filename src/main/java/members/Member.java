package java;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.sun.java.util.jar.pack.Package.Class.Member;

@Entity
public class Member implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private long age;

    @ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="Member_Task",joinColumns={@joinColumn(name="TASK_ID")},inverseJoinColumns={@JoinColumn(name="MEMBER_ID")})
	private List <Task> tasks = new ArrayList <Task>();

    @ManyToOne
    private Team team;

    public void setName(String name) {
        this.name = name;
    }


    public void setAge(long age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public long getAge() {
        return age;
    }
    public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}
	public List<Task> getTasks() {
		return tasks;
	}

    public Pessoa getTeam() {
        return team;
    }
    public void setTeam(Team team) {
        this.team = team;
    }

}
