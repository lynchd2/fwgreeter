/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fwgreeter.User;

/**
 *
 * @author Dylan.Lynch
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Creates the User table with the column names. Also has standard getter and setter
 * methods for the private variables.
 */

@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String firstName;
    
    private String lastName;
    
    public Integer visitNumber = 0;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public Integer getVisitnumber() {
        return visitNumber;
    }
    
    public void setVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber;
    }
    
    /**
     * This method adds one to the total visit number.
     * @param visitNumber
     */
    public void addVisitNumber(Integer visitNumber) {
        this.visitNumber = visitNumber + 1;
    }


}
