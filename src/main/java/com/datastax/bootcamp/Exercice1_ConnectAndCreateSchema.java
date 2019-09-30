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
 * With this class you will define a {@link Session} object
 * 
 * @author DataStax Developer Team
 */
public class Exercice1_ConnectAndCreateSchema {
  
    // Logger for the class
    private static final Logger LOGGER = LoggerFactory.getLogger("Exercice1");
   
    /** 
     * - ACTION #1 -
     * 
     * Using `CqlSession.Builder` please initialize a CqlSession.
     *      - providing the 2 Contact Points
     *      - providing DatacenterName
     * Tips :
     * - https://docs.datastax.com/en/developer/java-driver/4.1/manual/core/
     * - https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/net/InetSocketAddress.html
     */
    public static void main(String[] args) {
        LOGGER.info("Starting exercice 1...");
        
        // Change the line below to fill the builder object
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_1, CASSANDRA_PORT))
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_2, CASSANDRA_PORT))
                .withLocalDatacenter(DATACENTER_NAME)
                .build()) {
            
            // This utility method will create the keyspace you expect
            Utilities.createKeyspace(cqlSession, KEYSPACENAME, DATACENTER_NAME, 3);
            LOGGER.info("Keyspace {} has been created", KEYSPACENAME);
            
            // Show the list of Keyspaces in the console
            Utilities.showKeyspaces(cqlSession);
        }
        
        LOGGER.info("===================================");
        LOGGER.info("====      Exercice 1 - OK      ====");
        LOGGER.info("===================================");
    }
    
}
