/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

/**
 *
 * @author podos
 */
public class Session {
    
    public static int currentUserId;
    private static Session instance;
    private int uid;
    private String fname;
    private String lname;
    private String email;
    private String username;
    private String status;
    private String type;
    private String contact;
    
    private Session(){
        
    }

   
   
    public static synchronized Session getInstance() {
        if(instance == null){
           instance = new Session();
        
        }
        return instance;
    }
    
     public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public static boolean isInstanceEmpty() {
         return instance == null;    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }
        
    
}
