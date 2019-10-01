package com.datastax.bootcamp;

/**
 * In this class you define constants once, you will use them in the different exercices later.
 */
public class ClusterSettings {
    
    // You don't have to change this value: datacenter name DC1 has been provided to you
    public static final String DATACENTER_NAME = "DC1";
    
    // You don't have to change this value: This is the default TCP port for Cassandra to listen
    public static final int CASSANDRA_PORT = 9042;

    /** 
     * - ACTION #1 -
     *  
     * Please provide 2 nodes IP (among the 3) that have been given to you today.
     * You can use the result of CQL queries on the notebook.
     */
    public static final String  CONTACT_POINT_1   = "<Enter IP of node1>";
    public static final String  CONTACT_POINT_2   = "<Enter IP of node2>";
    
    /** 
     * - ACTION #2 - 
     * 
     * Please provide a keyspace name, choose the one you want:
     * - must be lowercase
     * - must have no space
     * - not existing system keyspaces
     */
    public static final String  KEYSPACENAME = "<Choose a keyspace name>";
    
}
