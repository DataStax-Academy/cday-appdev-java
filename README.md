# Bootcamp Application Development

<center>![Solution Day Banner](https://s3.amazonaws.com/datastaxtraining/solution-days/cassandra-intro/DevDayBanner.png "Developer Day Banner" )</center>

----

## Pre-requisite

To run the Application Development exercice on your laptop you must have installed : 
- `JDK8+`
- `Maven` (3.6+) 
- an IDE like `Eclipse` or `IntelliJ`.


## Setup your laptop

This session will help you to setup your laptop to do the Exercices

###1.Clone the repository where you are located the Exercices

```
git clone https://github.com/DataStax-Academy/cday-appdev-java.git
```

###2.Build the project

```
cd cday-appdev-java

mvn clean install
```


This is the output you can get : 
```
cedricklunven@clunhost:~/dev/WORKSPACES/DATASTAX/cday-appdev-java> mvn clean install
[INFO] Scanning for projects...
...
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  1.923 s
[INFO] Finished at: 2019-10-01T10:54:05+02:00
[INFO] ------------------------------------------------------------------------
```


###3.Import the Project in your IDE

Import the project as a `Java` project, a `pom.xml` has been provided to you.


## Exercice 1
----


* Open the class `ClusterSettings`. And fill the 3 constants `CONTACT_POINT_1`, `CONTACT_POINT_2` and `KEYSPACENAME` as stated in the comment. 

* Open class `Exercice1_ConnectAndCreateSchema` and setup your connection to point to your Cluster and your DataCenter> you will have to edit the following line.

```
CqlSession cqlSession = CqlSession.builder().build()
```

* Execute the class as a Java Application


**Links that might be useful**:
- [Documentation Java Driver](https://docs.datastax.com/en/developer/java-driver/latest/manual/core)
- [Documentation InetSocketAddress](https://docs.oracle.com/en/java/javase/12/docs/api/java.base/java/net/InetSocketAddress.html)

#Exercice 2
----

* Open class `Exercice2_CreateSimpleStatement` and define a statement to insert a new users in the tables users

```
SimpleStatement.builder("<YOUR_STATEMENT>").build();
```

* Execute the class as a Java Application


**Links that might be useful:**
 * [Documentation on Statements](https://docs.datastax.com/en/developer/java-driver/latest/manual/core/statements/simple/)



#Exercice 3
----

* Open class `Exercice3_CreatePreparedStatement` and define `preparedStatement` in the following method

```
private static PreparedStatement prepareStatementOnce(CqlSession cqlSession) {
  return null;
}
```

* Bind the parameters to create a `BoundStatement` in the method 

```
private static BoundStatement bindQuery(PreparedStatement queryInsertUser, 
            String firstName, String lastName, int age, String city, String email) {
        LOGGER.info(" + Insert {} {}", firstName, lastName);
        return null;
}
```

* Execute the class as a Java Application

**Links that might be useful:**
 * [Documentation on Prepared Statements](https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/statements/prepared/#preparing)
 * [Documentation on Bind Statements](https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/statements/prepared/#parameters-and-binding)

After completing the exercice, you should be able to execute the request below

#Exercice 4
----

* Open class `Exercice4_ListUsers` and implements the `displayUsers` to log FirstName and LastName of each row.

```
private static void displayUsers(ResultSet rs) {
   throw new RuntimeException("Not Implemented");
}
```

* Execute the class as a Java Application

**Links that might be useful:**
 * [Documentation Statements](https://docs.datastax.com/en/developer/java-driver/4.2/manual/core/#running-queries)

 


