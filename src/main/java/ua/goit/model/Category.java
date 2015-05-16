package ua.goit.model;

import javax.persistence.*;

@Entity
@Table(name = "categories")
public class Category {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;

  @Column(name ="name")
  private String name;

  public Category(Integer id, String name) {
    this.id = id;
    this.name = name;
  }

  public Category(String categoryName) {

    this.name = categoryName;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
