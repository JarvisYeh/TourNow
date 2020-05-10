# TourNow
A distributed system using netflix eureka and play framework


## Description
Structure of the distributed car renting system is shown as figure 1.
<div align='center'>
    <img width=600' height='800' src=TourNow_Structure.jpg><br/>
    <font size = 2>figure 1: Overall Structure</font>
</div>
Main directory contains 7 folders, which are EurekaServer, BrokerServer, CorkServer, DublinServer, GalwayServer, 
TourNowApp and DatabasesSetUp folders.<br/>

Except for the DatabasesSetUp folder, all other folders is an **independent project** for itself. Which means there are 6 separate projects.<br/>

### **1. Maven Projects:**<br/>
**/EurekaServer, /BrokerServer, /CorkServer, /DublinServer, /GalwayServer.**<br/>
EurekaServer is the center of the distributed system, BrokerServer, DublinServer, CorkServer, GalwayServer all register their services to EurekaServer.<br/>

Port Assignment:<br/>
Default: EurekaServer: 8080, BrokerServer: 8070, DublinServer: 8091, CorkServer: 8092, Galway: 8093<br/>
Port assignment could be modified in xxServer/src/main/resources/application.properties for separate server itself.<br/>
```
server.port = #desire_port
```
Note that if the port of eureka server is changed, all application.property files of client servers need to be modified.
```
eureka.client.serviceUrl.defaultZone = http://localhost:#eureka_server_port_Num#/eureka"
```

### **2. Sbt Project:**<br/>
**/TourNowApp**<br/>
Port Assignment:<br/>
TourNowApp: 9000<br/>
The TourNowAPP project is based on the play framework, please refer to TourNowApp/README.md for further detail.

### **3. DataBases:**<br/>
According to figure 1, in order to simulate the distributed system, DublinServer, CorkServer, GalwayServer, TourNowApp have their own databases. Therefore, in /DataBaseSet directory, cork.sql, dublin.sql, galway.sql, car.sql creates their own database with some test data separately.<br/>
For instance, cork.sql create a cork database which contains a table named cork, and it stores some cars information that are available for renting in Cork.<br/>
car.sql creates a tournow database with a table named cars, which stores the cars info that are currently rented.<br/>

Port Assignment/UserName/PassWord:<br/>
**For /DublinServer, /CorkServer, /GalwayServer**, modify the file xxServer/src/main/java/com/tournow/controllers/ConnectMySQL.java
```java
private static String user = "username_of_your_db";
private static String password = "password_of_your_db";
```
```java
String url = "jdbc:mysql://localhost:#desire_port#/dublin";
```
**For /TourNowApp**, modify the file /TourNowApp/conf/application.conf at line 369-371:
```
default.url="jdbc:mysql://localhost:#desire_port#/tournow"
default.username = username_of_your_db
default.password = "password_of_your_db"
```
The default port for all 4 databases above is 3306 and the default username is "root" and the default password is "".


### **4. IPStack:**<br/>


## Pre-Installation requirement
sbt, Maven, MySQL, jdbc


## Compile Process
1. 