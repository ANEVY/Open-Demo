# OPen Demo Automation using Selenium

<a href="https://demo.opencart.com/admin/index.php">Visit Open Demo</a>

A selenium framework to automate test cases on open demo website.

## Test Cases
Find a well documented list of test cases <a href="https://docs.google.com/spreadsheets/d/1Yg_433qEPyp470N5btWdLG4h2kCGR7a1KiMdqJwYbKc/edit#gid=544612438">here</a>

## Installing

Follow these steps to set it up
### Prerequisite
* install java on your computer
* install maven
* install intelliJ(optional)
### Setup
* clone the project git clone <git url>
* open the POM file and refresh the maven dependencies
* There you go happy testing

## Naming Conventions
* Classes - Pascal Case
* Functions - Snake Case
* Variable - Camel Case
* Directories - Hyphenated

## Framework Properties
* Use the properties file to set your browser

## Cloud flair issues
You might run into Cloudflare security check. I have managed to limit it by using testNg BeforeMethod to set the driver and AfterMethod to quit the driver
