package com.beehyv.algebra_services;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.*;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String userId;
    private HashMap<Character,Integer> operatorUsed;
    
	public User() {
        
    }
 
    public User(String userId, HashMap<Character,Integer> operatorUsed) {
        this.userId = userId;
        this.operatorUsed = operatorUsed;
	}
 
    @Column
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Column
    public HashMap<Character,Integer> getOperatorUsed() {
        return operatorUsed;
    }
    public void setOperatorUsed(HashMap<Character,Integer> operatorUsed) {
        this.operatorUsed = operatorUsed;
    }
}