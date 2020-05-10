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

Except for the DatabasesSetUp folder, all other folders is an **independent project** for itself.<br/>

### **Maven Projects:**<br/>
**EurekaServer, BrokerServer, CorkServer, DublinServer, GalwayServer.**<br/>
EurekaServer is the center of the distributed system, BrokerServer, DublinServer, CorkServer, GalwayServer all register their services to EurekaServer.<br/>

Port Assignment:<br/>
EurekaServer: 8080, BrokerServer: 8070, DublinServer: 8091, CorkServer: 8092, Galway: 8093<br/>
Port assignment could be modified in xxServer/src/main/resources/application.properties<br/>
Change to "server.port = #desire_port"<br/>
Note that if the port of eureka server is changed, all application.property of client server has to modify: "eureka.client.serviceUrl.defaultZone=http://localhost:#eureka_server_port_No.#/eureka"<br/>
The servers registration 


### **Sbt Project:**<br/>
**TourNowApp**<br/>
Port Assignment:<br/>
TourNowApp: 9000<br/>
This TourNowAPP project is based on the play framework, please refer to TourNowApp/README.md for further detail.





## Pre-Installation requirement:
sbt, maven

## Compile Process




