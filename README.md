# smsmanager-java-library
[![Build Status](https://travis-ci.org/hrubysoftware/smsmanager-java-library.svg?branch=master)](https://travis-ci.org/hrubysoftware/smsmanager-java-library) 
[![Release](https://jitpack.io/v/hrubysoftware/smsmanager-java-library.svg)](https://jitpack.io/#hrubysoftware/smsmanager-java-library)

Java Library for smsmanager.cz

```java
class Main{
    public static void main(String[] args){
        SmsManager smsManager = new SmsManager("smsmanager@username.tld", "smsmanager-password");
        smsManager.sendMessage("textMessage", "737111222", "777123456"); //one or more phone numbers
    }    
}


```