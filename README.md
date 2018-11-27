### assignDP

This repository is for SER 316 - Fall B 2018 Assignment 7: Design Pattern

Four design patterns are used to implement "Bee" system requirements, with each pattern featured in a separate package.  
The main function of this program runs each of the featured design patterns to demonstrate how it works.

---
#### Running the Project:
 - Navigate into the assignDP_jaherzog folder from the command line and type "gradle build".
 - There are two options for running the pattern demo:
    - Gradle: from the current folder, type "gradle run"
    - Executable Jar: from the current folder, navigate into the build/libs folder and type "java -jar assignDP.jar"

---

#### Featured Design Patterns:
 - **Builder Pattern**: The program implements a builder pattern to mass produce beehives with different numbers of rooms and species of bees (both of which are randomly determined at runtime as well). This pattern can both simplify complex object creation and make it more flexible. 
 -	**Singleton Pattern**: The program implements a singleton pattern to restrict the number of instances of the Apiary class to one. When apiaries are created, they are copies of one instance and updates to one apiary are reflected in the other apiaries.
 -	**Abstract Factory Pattern**: The program implements an abstract factory pattern which uses concrete bee-type factories to produce bees of a desired type without specifying their concrete classes.
 -	**Decorator Pattern**: The decorator pattern extends the functionality of the bee class by allowing the ability to apply “type” and “attribute” decorators.


---

#### Code Analysis Features:
 - **JUnit Test Coverage**: 99.7%
 - **CheckStyle Violations**: 2
    - violations are due to naming conventions and do not impact functionality.
 - **SpotBugs Violations**: 0
 
*This project is currently in edit and not complete*