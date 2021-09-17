FROM tomcat:8.5.71-jdk8-openjdk-slim

COPY ./target/market-0.0.1-SNAPSHOT.war /usr/local/tomcat/webapps/
COPY ../../../Desktop/market/tomcat/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml
COPY ../../../Desktop/market/tomcat/context.xml /usr/local/tomcat/webapps/manager/META-INF/context.xml

