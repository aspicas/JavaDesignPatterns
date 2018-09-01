FROM openjdk:11
COPY start.sh /opt
CMD sh /opt/start.sh > /dev/null
