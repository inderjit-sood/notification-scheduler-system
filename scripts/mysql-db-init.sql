CREATE DATABASE notification-scheduler-application;

USE notification-scheduler-application;

CREATE TABLE notification (
    id BIGINT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    notification VARCHAR(255) NOT NULL
);