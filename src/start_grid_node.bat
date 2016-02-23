rem Для запуска из Grid-а, adding path to lib-s

java -cp
rem перечень путей к библиотекам

PathTo/slf4j-api-1.7.16.jar;PathTo/mysql-connector-java-5.1.38.jar;PathTo/logback-core-1.1.5.jar;PathTo/logback-classic-1.1.5.jar;PathTo/selenium-server-standalone-2.51.0.jar -Djava.util/logging.config.file=logging.properties org.openqa.grid.selenium.GridLauncher -debug