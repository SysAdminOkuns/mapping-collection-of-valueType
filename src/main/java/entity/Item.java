package entity;
import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.*;

@Entity
public class Item{

	//for Hibernate 4.3.x Users
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	// for Hibernate 5.x Users
	// if you're using Hibernate 5.x, use GenerationType.IDENTITY id generator strategy explicitly
	// for more information on "GenerationType" have a look at https://www.udemy.com/hibernate-and-jpa-fundamentals/learn/v4/questions/937412
	/*
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	*/
	
	private String name;
	

	@ElementCollection
	@CollectionTable(name = "item_image", joinColumns=@JoinColumn(name = "item_id"))
	@Column(name = "filename")
	private Collection<String> images = new ArrayList<String>();

	
//	@ElementCollection
//	@Column(name = "filename")
//	private Collection<String> images = new ArrayList<String>();
	
	public Item() {}
	public Item(String name) {
		this.name = name;
	}
	
	public Collection<String> getImages() {
		return images;
	}
	
	@Override
	public String toString() {
		return "Item [id=" + id + ", name=" + name + ", images=" + images + "]";
	}
	
}
