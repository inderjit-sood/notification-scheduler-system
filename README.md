# notification-scheduler-system
Lightweight application to schedule notifications on demand with an expiry.


Test the endpoints:




- mvn spring-boot:run
- curl -H "Accept: */*" -H "Content-type: text/plain" -X POST -d "notification=crazyNotificationHih" http://localhost:8888/api/notification/create