package com.datastax.bootcamp;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.querybuilder.QueryBuilder;
import com.datastax.oss.driver.api.querybuilder.SchemaBuilder;

/**
 * Boilerplate code to cleanup Exercices.
 */
public class Utilities {
   
    /** Logging on Console. */
    private static final Logger LOGGER = LoggerFactory.getLogger("BOOTCAMP");
   
    /**
     * Hide Default Constructor
     */
    private Utilities() {}
    
    public static void showKeyspaces(CqlSession cqlSession) {
        cqlSession.getMetadata().getKeyspaces().keySet().stream()
                  .map(CqlIdentifier::asInternal)
                  .forEach(ks -> LOGGER.info("+ Found keyspace: {}", ks));
    }
    
    public static void createKeyspace(CqlSession cqlSession, String keyspaceName, String dataCenterName, int rf) {
        cqlSession.execute(SchemaBuilder
                .createKeyspace(CqlIdentifier.fromInternal(keyspaceName))
                .ifNotExists()
                .withNetworkTopologyStrategy(Map.of(dataCenterName, rf))
                .build());
    }
    
    public static void createTableUser(CqlSession cqlSession) {
        
        
    }
    
    public static void dropKeyspace(CqlSession cqlSession, String keyspacename) {
        cqlSession.executeAsync(SchemaBuilder
                .dropKeyspace(keyspacename)
                .ifExists()
                .build());
    }
    
    public static void truncateTable(CqlSession cqlSession, CqlIdentifier keyspace, CqlIdentifier tableName) {
        cqlSession.execute(QueryBuilder.truncate(keyspace, tableName).build());
    }

}
