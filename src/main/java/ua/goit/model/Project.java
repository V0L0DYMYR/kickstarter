package ua.goit.model;

import javax.persistence.*;

@Entity
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @JoinColumn(name = "category_id")
  @ManyToOne
  private Category category;

  @Column(name = "name")
  private String name;

  private String description;

  public Project(Integer id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }
}
