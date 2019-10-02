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
import com.datastax.oss.driver.api.core.cql.BoundStatement;
import com.datastax.oss.driver.api.core.cql.PreparedStatement;
import com.datastax.oss.driver.api.core.cql.SimpleStatement;

/**
 * With this Exercice you will prepare your previous {@link SimpleStatement} to get a {@link PreparedStatement}.
 */
public class Exercise3_CreatePreparedStatement {

    // Logger for the class
    private static final Logger LOGGER = LoggerFactory.getLogger("Exercise3");
   
    /** 
     * - ACTION #1 - 
     * 
     * Based on the work you did in previous exercise, prepare the insert statement
     * 
     * Documentation:
     *  - https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/statements/prepared/#preparing
     */
    private static PreparedStatement prepareStatementOnce(CqlSession cqlSession) {
        // Change the line below to 
        // (1) Define the SimpleStatement (no need for addPositionalValues this time) 
        // (2) Use cqlSession to prepare the simpleStatement and return a PreparedStatement
        throw new RuntimeException("Exercise3: prepareStatementOnce method should be implemented");
    }
    
    /** 
     * - ACTION #2 - 
     * 
     * Use the prepared statement to bind parameters and create a {@link BoundStatement}.
     * 
     * Documentation:
     *  - https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/statements/prepared/#parameters-and-binding
     */
    private static BoundStatement bindQuery(PreparedStatement queryInsertUser, 
            String firstName, String lastName, int age, String city, String email) {
        LOGGER.info(" + Insert {} {}", firstName, lastName);
        // Change this line to create and return the expected BoundStatement 
        throw new RuntimeException("Exercise3: bindQuery method should be implemented");
    }
    
    /** 
     * Main CLASS
     */
    public static void main(String[] args) {
        LOGGER.info("Starting exercise 3...");
        
        try (CqlSession cqlSession = CqlSession.builder()
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_1, CASSANDRA_PORT))
                .addContactPoint(new InetSocketAddress(CONTACT_POINT_2, CASSANDRA_PORT))
                .withLocalDatacenter(DATACENTER_NAME)
                .withKeyspace(KEYSPACENAME)
                .build()) {

            // Prepared Once
            PreparedStatement query = prepareStatementOnce(cqlSession);

            // Execute Many
            cqlSession.execute(bindQuery(query, "Arya", "Stark", 16, "Winterfell", "aray.stark@got.com"));
            cqlSession.execute(bindQuery(query, "Jamie", "Lannister", 32, "Kingslandhill", "jamie@got.com"));
            cqlSession.execute(bindQuery(query, "Ramsay", "Bolton", 42, "CastleRock", "ramsay@got.com"));
        }
        LOGGER.info("===================================");
        LOGGER.info("====      Exercise 3 - OK      ====");
        LOGGER.info("===================================");
    }
    
    
    
}
