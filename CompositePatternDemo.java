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
