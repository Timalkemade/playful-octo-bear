playful-octo-bear
=================


Install maven: http://maven.apache.org/
(or sudo apt-get install maven)

To build: mvn clean verify
This will download all dependencies and put the natives in the target folder.

To run from the ide: run the main class: nl.tim.test.HelloWorld
make sure you set the VM options: -Djava.library.path="{PROJECT_HOME}/target/natives"
