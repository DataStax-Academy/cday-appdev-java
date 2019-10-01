package com.datastax.bootcamp;

public class ClusterSettings {
    
    // You don't have to change: this cluster with name DC1 has been provided to you
    public static final String DATACENTER_NAME   = "DC1";
    
    // You don't have to change: 9042 is the default TCP port from Cassandra
    public static final int CASSANDRA_PORT    = 9042;

    /** 
     * - ACTION #1 -
     *  
     * Please provide 2 nodes IP among the 3 that have been given to you this morning
     * You will have to provide them at each exercice
     */
    public static final String  CONTACT_POINT_1   = "<Enter IP of node1>";
    public static final String  CONTACT_POINT_2   = "<Enter IP of node2>";
    
    /** 
     * - ACTION #2 - 
     * 
     * Please provide a keyspace name, the you want (must be lowercase + no space)
     */
    public static final String  KEYSPACENAME = "<Choose a keyspace name>";
    
}
