package br.com.eduardo.springcrud.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "game")
public class Game implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "developer", length = 30, nullable = false)
    private String developer;

    @Column(length = 30, nullable = false)
    private String year;






    // adding attributes for version 2.0 //

    @Column(name= "register_date")
    private Date registerdate;

    @Column(length = 30)
    private String platform;

    // -------------------------------- //







    public Game() {
    }

    public Game(long id, String name, String developer, String year, Date registerdate, String platform) {
        this.id = id;
        this.name = name;
        this.developer = developer;
        this.year = year;
        this.registerdate = registerdate;
        this.platform = platform;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdeveloper() {
        return developer;
    }

    public void setdeveloper(String developer) {
        this.developer = developer;
    }

    public String getyear() {
        return year;
    }

    public void setyear(String year) {
        this.year = year;
    }

    public Date getRegisterdate() {
        return registerdate;
    }

    public void setRegisterdate(Date registerdate) {
        this.registerdate = registerdate;
    }

    public String getplatform() {
        return platform;
    }

    public void setplatform(String platform) {
        this.platform = platform;
    }
}
