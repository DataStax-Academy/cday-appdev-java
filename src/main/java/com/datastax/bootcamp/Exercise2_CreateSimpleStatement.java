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
import com.datastax.oss.driver.api.core.cql.SimpleStatement;

/**
 * With this class you will learn how to create a {@link SimpleStatement} object
 */
public class Exercise2_CreateSimpleStatement {

    // Logger for the class
    private static final Logger LOGGER = LoggerFactory.getLogger("Exercise2");
    
    /** 
     * - ACTION #1 - 
     * 
     * Create a statement in order to insert a User in the `user` Table.
     * 
     * Here a sample cql statement to help you:
     * INSERT INTO users (firstname,lastname,age,city,email) 
     * VALUES ('Jon', 'Snow', 35, 'Winterfell', 'jon.snow@got.com')
     * 
     * Tips:
     *  - https://docs.datastax.com/en/developer/java-driver/latest/manual/core/statements/simple/
     *  - You can use DataStax Studio to check if users have been created. (select * from users)
     */
    private static SimpleStatement insertUserSimple(String firstName, String lastName, int age, String city, String email) {
        LOGGER.info(" + Insert {} {}", firstName, lastName);
        return SimpleStatement.builder("<YOUR_STATEMENT>").build();
    }
    
    /** 
     * Main Function
     */
    public static void main(String[] args) {
        LOGGER.info("Starting exercise 2...");
        
        // We did that for you this time
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_1, CASSANDRA_PORT))
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_2, CASSANDRA_PORT))
                .withLocalDatacenter(DATACENTER_NAME)
                .withKeyspace(KEYSPACENAME)
                .build()) {
            
            // Create expected Table (if not exist)
            Utilities.createTableUser(cqlSession, KEYSPACENAME);
            
            // Insert some Data (upserts)
            cqlSession.execute(insertUserSimple("john", "snow", 30, "Winterfell", "jon.snow@got.com"));
            cqlSession.execute(insertUserSimple("Sansa", "Stark", 20, "Winterfell", "sansa.stark@got.com"));
        }
        
        LOGGER.info("===================================");
        LOGGER.info("====      Exercise 2 - OK      ====");
        LOGGER.info("===================================");
    }
    
}
