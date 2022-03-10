# Falabella Challenge

This project has been generated for a job interview purposes.

## Challenges

Crear un proyecto de automatización para el sitio www.falabella.com el cual realice las siguientes pruebas.
1. Validación del formulario y registro de un usuario.
2. Inicio de sesión al sitio.
3. Validar que el precio de un producto coincida con el total en el carro de compras

## Stack

- Java 8
- Selenium
- Cucumber
- Maven
- BrowserStack

# Running tests

## Environment setup
- Install [JDK 8](https://www3.ntu.edu.sg/home/ehchua/programming/howto/JDK_Howto.html)
- Install [Maven](https://maven.apache.org/install.html)
- Install [Chrome](https://www.google.com/intl/es-419/chrome/)
- Set the following environment variables:
    - FALABELLA_EMAIL: set your falabella user email as value
    - FALABELLA_PASSWORD: set your falabella user password as value
- To use cloud execution on browserstack:
  - Create a [free account](https://www.browserstack.com/users/sign_up)
  - Obtain your username and access key from your [profile](https://www.browserstack.com/accounts/profile)
  - Set the following ENV Variables:
      - BROWSERSTACK_USERNAME: set your browserstack name as value
      - BROWSERSTACK_ACCESS_KEY: set your browserstack access key as value

### Important
Please, verify that you have already set your JAVA_HOME and MAVEN_HOME correctly

## Local execution
```
mvn install integration-test -Drunner=LocalChromeRunner -Dcucumber.filter.tags=@smokeTest
```

## Cloud execution
- Enable [local execution](https://www.browserstack.com/docs/automate/selenium/getting-started/java/local-testing#enabling-local-testing-with-automate) using command line interace
- Open your console and execute the following command:
```
mvn install integration-test -Drunner=BSChromeWinRunner -Dcucumber.filter.tags=@smokeTest
```

## Resources
##### [Cucumber Docs](https://cucumber.io/docs)

##### [Cucumber School Lessons](https://cucumber.io/school#lessons)

##### [SeleniumHQ Documentation](http://www.seleniumhq.org/docs/)

##### [Junit Documentation](http://junit.org/javadoc/latest/index.html)

##### [Java Documentation](https://docs.oracle.com/javase/7/docs/api/)

##### [Browserstack Documentation](https://www.browserstack.com/docs/)

# Author
Developed by [Pedro Ibarra](https://github.com/pedrooibarra)



