/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.fwgreeter.Configuration;

/**
 *
 * @author Dylan.Lynch
 */
public class Configuration {
    
    private String port;
    
    /**
     * This getter method always for the access of the private port variable.
     * @return the port
     */
    public String getPort() {
        return this.port;
    } 

    /**
     * This method sets the port based on the command-line arguments set up the user.
     * If no argument was provided, the default port is 8080.
     * @param args
     */
    public void setPort(String[] args) {
       //Checks to make sure there were any arguments and that it is a string
       if(args.length > 0 && args[0] instanceof String) {
           this.port = args[0];
       } else {
           this.port = "8080";
       }
    }
}
