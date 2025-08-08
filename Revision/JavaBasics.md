# Questions on Java

## Java Basic Concepts

1. What is Java?

> Java is a programming language and computing platform first released by Sun Microsystems in 1995.

2. What are the advantages of using Java?

> - Easy to learn - Java is simple and easy to learn
> - Object-oriented - which allows reusable code
> - Platform independent - `Write once, run anywhere`
> - Multithreaded - Allows the program to perform numerous assignments at the same time
> - Automatic Garbage Collection
> - Secure - Examples below
>> - Compile-time checking of source code.
>> - Dynamic runtime checking of bytecode.
>> - Removal of the use of pointers and pointer arithmetic.
>> - Namespace isolation for externally loaded code.
>> - Execution takes place within a restricted sandbox.

4. What is the difference between JRE, JVM and JDK?

| Aspect              | Java Development Kit (JDK)                      | Java Runtime Environment (JRE)         | Java Virtual Machine (JVM)                               |
|---------------------|-------------------------------------------------|----------------------------------------|----------------------------------------------------------|
| Purpose             | Used to develop Java applications               | Used to run Java applications          | Executes Java bytecode                                   |
| Platform Dependency | Platform-dependent (OS specific)                | Platform-dependent (OS specific)       | JVM is OS-specific, but bytecode is platform-independent |
| Includes            | JRE + Development tools (javac, debugger, etc.) | JVM + Libraries (e.g., rt.jar)         | ClassLoader, JIT Compiler, Garbage Collector             |
| Use Case            | Writing and compiling Java code                 | Running a Java application on a system | Convert bytecode into native machine code                |

![Example of JDK vs JRE vs JVM](/Images/JDKJREJVM.png)

5. What are constructors?
> A constructor is a special method within a class that is automatically called when a new object of that class is created (instantiated)
```java
class Book {
    String title;
    String author;

    // Default constructor (implicitly provided if not defined)
    // Book() { } 

    // Parameterized constructor
    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void displayBookInfo() {
        System.out.println("Title: " + this.title + ", Author: " + this.author);
    }
}
```
6. What are interface?
> - In Java, an interface is a blueprint for a class. It defines a contract that classes can choose to implement.
> - An interface is a completely "abstract class" that is used to group related methods with empty bodies
```java
// Interface
interface Car {
  public void carSound(); // interface method (does not have a body)
  public void idle(); // interface method (does not have a body)
}

// Porsche "implements" the Car interface
class Porsche implements Car {
  public void carSound() {
    // The body of carSound() is provided here
    System.out.println("Vrooooooommmmmmm!!!");
  }
  public void idle() {
    // The body of idle() is provided here
    System.out.println("Car is idling...");
  }
}
```
7. What is object-oriented programming in Java(OOP) in Java?
> - Object-Oriented Programming (OOP) in Java is a programming paradigm that structures software design around "objects" rather than "functions" or "logic." 
> - These objects are instances of "classes," which serve as blueprints defining the object's data (attributes/fields) and behavior (methods).  
>   
> 
> - The core principles of OOP in Java, often referred to as the "four pillars," are:
>> - **Encapsulation**:  
    This principle bundles data and methods that operate on the data within a single unit (a class), and restricts direct access to some of an object's components. This "data hiding" protects the internal state of an object and promotes modularity.
>> - **Inheritance**:  
    This mechanism allows a new class (subclass/child class) to inherit properties and behaviors from an existing class (superclass/parent class). This promotes code reusability and establishes a hierarchical relationship between classes.
>> - **Polymorphism**:  
    Meaning "many forms," polymorphism allows objects of different classes to be treated as objects of a common type. In Java, this is achieved through method overloading (same method name, different parameters) and method overriding (subclass providing a specific implementation for a method defined in its superclass).
>> - **Abstraction**:  
    This principle focuses on showing only essential information and hiding complex implementation details. In Java, abstraction is achieved using abstract classes and interfaces, which define a contract for classes to implement without specifying the full implementation.