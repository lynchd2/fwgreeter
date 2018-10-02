package com.mycompany.fwgreeter.User;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Dylan.Lynch
 */
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {
    
    /**
     * This method finds the visit number of the user based on their first and
     * last name. This is not case-sensitive.
     * @param firstName First name of user
     * @param lastName Last name of user
     * @return The visit number of the user.
     */
    @Query(value="SELECT visit_number FROM user WHERE LOWER(first_name) = LOWER(?1) AND LOWER(last_name) = LOWER(?2)", nativeQuery=true)
    public String findVisitNumberByFirstLastName(String firstName, String lastName);
    
    /**
     * This is an update statement to increase the total visits of a user by 1.
     * @param firstName First name of user
     * @param lastName Last name of user
     */
    @Transactional
    @Modifying(flushAutomatically = true, clearAutomatically = true)
    @Query(value="UPDATE user SET visit_number = visit_number + 1 WHERE LOWER(first_name) = LOWER(?1) AND LOWER(last_name) = LOWER(?2)", nativeQuery=true)
    public void addVisitNumber(String firstName, String lastName);
    
    @Query(value="SELECT DISTINCT(first_name) FROM user", nativeQuery=true)
    public String[] allFirstNames();
    
    @Query(value="SELECT DISTINCT(last_name) FROM user", nativeQuery=true)
    public String[] allLastNames();
    
    @Query(value="SELECT SUM(visit_number) FROM user", nativeQuery=true)
    public Integer totalVisitorCount();
}
