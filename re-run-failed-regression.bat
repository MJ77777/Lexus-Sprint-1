call mvn clean test -D runner=Regression.xml
call mvn test -D runner=target/surefire-reports/testng-failed.xml