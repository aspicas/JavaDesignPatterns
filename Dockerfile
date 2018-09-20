FROM openjdk:11
RUN \
	mkdir /jdk && \
	cd /usr/lib/jvm/java-11-openjdk-amd64/ && \
	tar -czvf /jdk/jdk.tar.gz *
COPY start.sh /opt
CMD sh /opt/start.sh > /dev/null
