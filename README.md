# composite-pattern

# Composite Design Pattern Example in Java

## Overview

This Java program demonstrates the Composite Design Pattern, a structural design pattern that allows you to compose objects into tree-like structures to represent part-whole hierarchies. In this example, we model a building composed of generic housing structures. The building can have floors, and each floor can have rooms.

## Table of Contents

-   [Classes](#classes)
    -   [HousingStructure Interface](#housingstructure-interface)
    -   [Room Class](#room-class)
    -   [Floor Class](#floor-class)
    -   [Building Class](#building-class)
-   [Main Program](#main-program)

## Classes

### HousingStructure Interface

This is the interface for both leaf and composite classes. It declares a `display` method that should be implemented by concrete classes.

```java
interface HousingStructure {
    void display();
}
```

### Room Class

This is a leaf class that represents a room in a building.

```java
class Room implements HousingStructure {
    private String name;

    public Room(String name) {
        this.name = name;
    }

    @Override
    public void display() {
        System.out.println("Room: " + name);
    }
}
```

### Floor Class

This is a composite class representing a floor in a building. It can contain rooms.

```java
class Floor implements HousingStructure {
    private String name;
    private List<HousingStructure> structures = new ArrayList<>();

    public Floor(String name) {
        this.name = name;
    }

    public void addStructure(HousingStructure structure) {
        structures.add(structure);
    }

    @Override
    public void display() {
        System.out.println("Floor: " + name);
        for (HousingStructure structure : structures) {
            structure.display();
        }
    }
}
```

### Building Class

This is a composite class representing a building. It can contain floors.

```java
class Building implements HousingStructure {
    private String name;
    private List<HousingStructure> structures = new ArrayList<>();

    public Building(String name) {
        this.name = name;
    }

    public void addStructure(HousingStructure structure) {
        structures.add(structure);
    }

    @Override
    public void display() {
        System.out.println("Building: " + name);
        for (HousingStructure structure : structures) {
            structure.display();
        }
    }
}
```

### Main Program

The CompositePatternDemo class contains the main method, where we create instances of rooms, floors, and a building to demonstrate the Composite Design Pattern.

```java
public class CompositePatternDemo {
    public static void main(String[] args) {
        // Create room objects
        Room bedroom = new Room("Bedroom");
        Room livingRoom = new Room("Living Room");
        Room kitchen = new Room("Kitchen");

        // Create floor objects
        Floor firstFloor = new Floor("First Floor");
        firstFloor.addStructure(bedroom);
        firstFloor.addStructure(livingRoom);

        Floor secondFloor = new Floor("Second Floor");
        secondFloor.addStructure(kitchen);

        // Create a building and add floors to it
        Building house = new Building("My House");
        house.addStructure(firstFloor);
        house.addStructure(secondFloor);

        // Display the building structure
        house.display();
    }
}
```
