# smsmanager-java-library
[![Build Status](https://travis-ci.org/hrubysoftware/smsmanager-java-library.svg?branch=master)](https://travis-ci.org/hrubysoftware/smsmanager-java-library) 
[![Release](https://jitpack.io/v/hrubysoftware/smsmanager-java-library.svg)](https://jitpack.io/#hrubysoftware/smsmanager-java-library)

Java Library for smsmanager.cz

## Download

### Maven

1. Add the JitPack repository to your build file 
    ```xml
    <repositories>
    	<repository>
    	    <id>jitpack.io</id>
    	    <url>https://jitpack.io</url>
    	</repository>
    </repositories>
    ```
2. Add the dependency
    ```xml
	<dependency>
	    <groupId>com.github.hrubysoftware</groupId>
	    <artifactId>smsmanager-java-library</artifactId>
	    <version>1.1.0</version>
	</dependency>
    ```

## How to use

First parameter is a type of request, available values:

- Type.lowcost,
- Type.high, 
- Type.economy.

```java
class Main{
    public static void main(String[] args){
        SmsManager smsManager = new SmsManager(Type.lowcost, smsmanager@username.tld", "smsmanager-password");
        smsManager.sendMessage("textMessage", "737111222", "777123456"); //one or more phone numbers
    }    
}


```