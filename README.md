Kata Hotel World Clocks
=======================

Use Robot Framework Maven Plugin, Cucumber-jvm, FitNesse and Java to implement the Hotel World Clocks kata and refactor it to Observer design pattern. In this kata, a hotel has 5 clocks showing the time of Beijing (UTC+8), London (UTC+0), Moscow (UTC+4), Sydney (UTC+10), and New York (UTC-5). You have to consider daylight saving time for cities like London and New York in this kata. When the time of each one of these clocks is set due to incorrect time or start/end of daylight saving period, the time of all other clocks will be set automatically. The hotel would add more clocks for different cities in the future.

Development Environment
=======================
Windows 7
Java SE 1.7.0_25
Maven 3.0.4

How to run
==========
Fork and clone this repository to a folder of your PC.
For Robot Framework Maven Plugin, run command "mvn clean package robotframework:run".
For Cucumber-jvm, run command "mvn clean test".
For FitNesse, run command "mvn clean package", create a wiki test page according to the file content.txt, and press "Test" on the wiki page.

