# TourNow
A distributed system using netflix eureka and play framework


## Description
Structure of the distributed car renting system is shown as figure 1.
<div align='center'>
    <img src=TourNow_Structure.jpg><br/>
    <font size = 2>figure 1: Overall Structure</font>
</div>
Main directory contains 7 folders, which are EurekaServer, BrokerServer, CorkServer, DublinServer, GalwayServer, 
TourNowApp and DatabasesSetUp folders.<br/>

Except for the DatabasesSetUp folder, all other folders is an independent project for itself.<br/>

### Maven Projects:<br/>
**EurekaServer, BrokerServer, CorkServer, DublinServer, GalwayServer.**<br/>
EurekaServer is the center of the distributed system, BrokerServer, DublinServer, CorkServer, GalwayServer all register their services to EurekaServer.<br/>
Port Assignment:<br/>
EurekaServer: 8080, BrokerServer: 8070, DublinServer: 8091, CorkServer: 8092, Galway: 8093
Port assignment could be modified in xxServer/src/main/resources/application.properties


### Sbt Projects:<br/>
**TourNowApp**





## Pre-Installation requirement:
sbt, maven

## Compile Process




