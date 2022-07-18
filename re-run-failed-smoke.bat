call mvn clean test -D runner=Smoke.xml
call mvn test -D runner=target/surefire-reports/testng-failed.xml