set M2_REPO=C:/Users/greg3d/.m2/repository

rem Для запуска из Grid-а, adding path to lib-s

java -cp
rem перечень путей к библиотекам

%M2_REPO%/org/slf4j/slf4j-api/1.7.16/slf4j-api-1.7.16.jar;%M2_REPO%/mysql/mysql-connector-java/5.1.38/mysql-connector-java-5.1.38.jar;%M2_REPO%/ch/qos/logback/logback-core/1.1.5/logback-core-1.1.5.jar;%M2_REPO%/ch/qos/logback/logback-classic/1.1.5/logback-classic-1.1.5.jar;selenium-server-standalone-2.51.0.jar -Djava.util/logging.config.file=logging.properties org.openqa.grid.selenium.GridLauncher -debug