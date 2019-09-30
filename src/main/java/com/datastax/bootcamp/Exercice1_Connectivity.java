package com.datastax.bootcamp;

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
public class Exercice1_Connectivity {
  
    private static final Logger LOGGER            = LoggerFactory.getLogger("Exercice1");
    public static final String  DATACENTER_NAME   = "DC1";
    public static final int     CASSANDRA_PORT    = 9042;
    
    public static final String  CONTACT_POINT_1   = "34.248.51.239";
    public static final String  CONTACT_POINT_2   = "34.254.180.234";
    //public static final String  CONTACT_POINT_1   = "X";
    //public static final String  CONTACT_POINT_2   = "Y";
    public static final String  KEYSPACENAME      = "truc";
    
    /** 
     * Using Builder object please initiate a CqlSession.
     * - with 2 Contact Points
     * - with DatacenterName
     * 
     * Help:
     * - https://docs.datastax.com/en/developer/java-driver/4.1/manual/core/
     * - https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/net/InetSocketAddress.html
     */
    public static void main(String[] args) {
        LOGGER.info("Starting exercice 1...");
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_1, CASSANDRA_PORT))
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_1, CASSANDRA_PORT))
                .withLocalDatacenter(DATACENTER_NAME)
                .build()) {
            
            Utilities.createKeyspace(cqlSession, KEYSPACENAME, DATACENTER_NAME, 3);
            Utilities.showKeyspaces(cqlSession);
            LOGGER.info("Keyspace {} has been created", KEYSPACENAME);
            cqlSession.execute("CREATE TABLE IF NOT EXISTS " + KEYSPACENAME + ".users (" 
                    + " lastname text PRIMARY KEY," 
                    + " age int," 
                    + " city text," 
                    + " email text," + 
                      " firstname text)");
        }
        LOGGER.info("===================================");
        LOGGER.info("Exercice 1 OK.");
        LOGGER.info("===================================");
    }
    
    
    
   
    
}
