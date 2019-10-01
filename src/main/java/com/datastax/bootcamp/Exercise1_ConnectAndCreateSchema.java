package com.datastax.bootcamp;

import static com.datastax.bootcamp.ClusterSettings.CASSANDRA_PORT;
import static com.datastax.bootcamp.ClusterSettings.CONTACT_POINT_1;
import static com.datastax.bootcamp.ClusterSettings.CONTACT_POINT_2;
import static com.datastax.bootcamp.ClusterSettings.DATACENTER_NAME;
import static com.datastax.bootcamp.ClusterSettings.KEYSPACENAME;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.session.Session;

/**
 * With this Exercise you will create a {@link CqlSession} object
 */
public class Exercise1_ConnectAndCreateSchema {
  
    // Logger for the class
    private static final Logger LOGGER = LoggerFactory.getLogger("Exercise1");
   
    /** 
     * - ACTION #1 -
     * 
     * Using `CqlSession.Builder` please initialize a `CqlSession`.
     *      - providing 2 Contact Points
     *      - providing the Datacenter name
     *      
     * Tips :
     * - https://docs.datastax.com/en/developer/java-driver/4.1/manual/core/
     * - https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/net/InetSocketAddress.html
     */
    public static void main(String[] args) {
        LOGGER.info("Starting exercise 1...");
        
        // Change the line below to fill the builder object
        try (CqlSession cqlSession = CqlSession.builder().build()) {
            
            // This method will create your keyspace (if it does not exists)
            Utilities.createKeyspace(cqlSession, KEYSPACENAME, DATACENTER_NAME, 3);
            LOGGER.info("Keyspace {} has been created", KEYSPACENAME);
            
            // Show list of keyspaces in the logs
            Utilities.showKeyspaces(cqlSession);
        }
        
        LOGGER.info("===================================");
        LOGGER.info("====      Exercise 1 - OK      ====");
        LOGGER.info("===================================");
    }
    
}
