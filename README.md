# Bootcamp Application Development

## Prerequisites
  * Open this project in [gitpod](https://gitpod.io/#https://github.com/DataStax-Academy/cday-appdev-java)

Cluster 15
---------------------------------------------------------------------
Node 1 - 34.248.51.239
Web terminal - https://n1.c15.danskebank.datastaxtraining.com
DataStax Studio - http://n1.c15.danskebank.datastaxtraining.com:9091
---------------------------------------------------------------------
Node 2 - 34.254.180.234
Web terminal - https://n2.c15.danskebank.datastaxtraining.com
Eclipse - http://34.254.180.234:8080/che/killrvideo
KillrVideo - http://n2.c15.danskebank.datastaxtraining.com:3000
---------------------------------------------------------------------
Node 3 - 18.203.231.38
Web terminal - https://n3.c15.danskebank.datastaxtraining.com
OpsCenter - http://n3.c15.danskebank.datastaxtraining.com:8888/opscenter

 
## Create the keyspace and table
The `resources/users.cql` file provides the schema used for this project:

```sql
CREATE KEYSPACE demo
    WITH replication = {'class': 'SimpleStrategy', 'replication_factor': '1'};

CREATE TABLE demo.users (
    lastname text PRIMARY KEY,
    age int,
    city text,
    email text,
    firstname text);
```

## Connect to your cluster

All of our code is contained in the `GettingStarted` class. 
Note how the main method creates a session to connect to our cluster and runs the CRUD operations against it. 
Replace the default parameters in `CqlSession.builder()` with your own hostname, port and datacenter.

```java
CqlSession session = CqlSession.builder()
                .addContactPoint(new InetSocketAddress("127.0.0.1", 9042))
                .withKeyspace("demo")
                .withLocalDatacenter("datacenter1")
                .build();
```

## CRUD Operations
Fill the code in the methods that will add a user, get a user, update a user and delete a user from the table with the driver.

### INSERT a user
```java
public static void setUser(CqlSession session, String lastname, int age, String city, String email, String firstname) {

        session.execute("INSERT INTO users (lastname, age, city, email, firstname) VALUES " +
                " ('" +lastname+ "'," +age+ ", '"+city+"', '" +email+ "', '" +firstname+ "')");
    }

```

### SELECT a user
```java
public static void getUser(CqlSession session, String lastname) {

        ResultSet rs = session.execute("SELECT * FROM users WHERE lastname='" +lastname + "'");
        Row row = rs.one();
        System.out.format("%s %d\n", row.getString("firstname"), row.getInt("age"));
    }

```

### UPDATE a user's age
```java
public static void updateUser(CqlSession session, int age, String lastname) {

        session.execute("UPDATE users SET age =" +age+  " WHERE lastname = '" +lastname+ "'");
    }
```   

### DELETE a user
```java
public static void deleteUser(CqlSession session, String lastname) {

        session.execute("DELETE FROM users WHERE lastname = '"+lastname+"'");
    }
```
    


