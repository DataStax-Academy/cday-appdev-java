package com.datastax.bootcamp;

import static com.datastax.bootcamp.ClusterSettings.CASSANDRA_PORT;
import static com.datastax.bootcamp.ClusterSettings.CONTACT_POINT_1;
import static com.datastax.bootcamp.ClusterSettings.CONTACT_POINT_2;
import static com.datastax.bootcamp.ClusterSettings.DATACENTER_NAME;

import java.net.InetSocketAddress;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.datastax.oss.driver.api.core.cql.Row;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;

public class Exercice4_ListUsers {

    // Logger for the class
    private static final Logger LOGGER = LoggerFactory.getLogger("Exercice4");
  
    /** 
     * - ACTION #1 - 
     * 
     * Please provide a keyspace name, the you want (must be lowercase + no space)
     */
    public static final String  KEYSPACENAME = "truc";
    
    /** 
     * - ACTION #3 - 
     * 
     * Parse {@link ResultSet} to display firstname and lastname in the console.
     * 
     * Documentation:
     * https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/#running-queries
     */
    private static void displayUsers(ResultSet rs) {
        if (null != rs) {
            LOGGER.info("Total items on page 1 " + rs.getAvailableWithoutFetching());
            for (Row row : rs) {
                LOGGER.info("+ User: {} {}", row.getString("firstname"), row.getString("lastname"));
            }
        }       
    }
    
    /** 
     * Main CLASS
     */
    public static void main(String[] args) {
        LOGGER.info("Starting exercice 4...");
        
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_1, CASSANDRA_PORT))
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_2, CASSANDRA_PORT))
                .withLocalDatacenter(DATACENTER_NAME)
                .withKeyspace(KEYSPACENAME)
                .build()) {

            // Prepared Once
            PreparedStatement query = cqlSession.prepare(
                    SimpleStatement.builder("SELECT * FROM users").build());

            // Execute Many
            ResultSet rs = cqlSession.execute(query.bind());
            
            // Display Result
            displayUsers(rs);
        }
        LOGGER.info("===================================");
        LOGGER.info("Exercice 4 OK.");
        LOGGER.info("===================================");
    }
    
    
}
