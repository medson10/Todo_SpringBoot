[![Build Status](https://travis-ci.org/medson10/Todo_SpringBoot.svg?branch=master)](https://travis-ci.org/medson10/Todo_SpringBoot)
# Todo_SpringBoot
A Todo Api built with Spring Boot
# Instructions

## What you need

* Java
* Maven
* Spring
* Docker
* Docker-compose

## How to run

* ```
    mvn clean -Dspring.profiles.active-dev spring-boot:run
  ```

## How to run with docker

* ```
    mvn package docker:build -DpushImage
    docker run -p 8080:8080 -t springio/todo-spring-boot  
  ```

## How to run with docker-compose

* ```
    docker-compose up
  ```
