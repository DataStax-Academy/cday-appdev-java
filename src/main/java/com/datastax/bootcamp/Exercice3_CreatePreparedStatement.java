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

public class Exercice3_CreatePreparedStatement {

    // Logger for the class
    private static final Logger LOGGER = LoggerFactory.getLogger("Exercice3");
   
    /** 
     * - ACTION #1 - 
     * 
     * Based on the work you did in previous exercice please prepard your insert statement
     * 
     * Documentation:
     * https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/statements/prepared/#preparing
     */
    private static PreparedStatement prepareStatementOnce(CqlSession cqlSession) {
        return cqlSession.prepare(
                SimpleStatement.builder(""
                        + "INSERT INTO users (firstName,lastName,age,city,email) "
                        + "VALUES (?,?,?,?,?)").build());
    }
    
    /** 
     * - ACTION #2 - 
     * 
     * Use the prepared statement to bind parameters and create a {@link BoundStatement}.
     * 
     * Documentation:
     * https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/statements/prepared/#parameters-and-binding
     */
    private static BoundStatement bindQuery(PreparedStatement queryInsertUser, 
            String firstName, String lastName, int age, String city, String email) {
        LOGGER.info(" + Insert {} {}", firstName, lastName);
        return queryInsertUser.bind(firstName, lastName, age, city, email);
    }
    
    /** 
     * Main CLASS
     */
    public static void main(String[] args) {
        LOGGER.info("Starting exercice 3...");
        
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
        LOGGER.info("Exercice 3 OK.");
        LOGGER.info("===================================");
    }
    
    
    
}
