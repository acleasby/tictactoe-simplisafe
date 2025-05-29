# Builds a docker container to run TicTacToe
# dependencies are downloaded and code is compiled (and unit tests run) as part of image build process

FROM maven:3-amazoncorretto-21-alpine

COPY src /src
COPY pom.xml /
RUN mvn package

CMD java -cp /target/tictactoe-1.0-SNAPSHOT.jar org.cleasby.tictactoe.Main
