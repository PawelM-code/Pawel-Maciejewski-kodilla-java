package com.kodilla.testing.shape;

import org.junit.*;

public class ShapeCollectorTestSuite {
    private static int testCounter = 0;

    @BeforeClass
    public static void beforeAllTests() {
        System.out.println("This is the beginning of tests.");
    }

    @AfterClass
    public static void afterAllTests() {
        System.out.println("All tests are finished.");
    }

    @Before
    public void beforeEveryTest() {
        testCounter++;
        System.out.println("Preparing to execute test #" + testCounter);
    }
    @Test
    public void testAddFigure(){
        Shape circle = new Circle(20.20);
        ShapeCollector shapeCollector = new ShapeCollector(null);

        shapeCollector.addFigure(circle);

        Assert.assertEquals(1, shapeCollector.getFiguresQuantity());
    }
    @Test
    public void testRemoveFigure(){
        Shape square = new Square(10.11);
        ShapeCollector shapeCollector = new ShapeCollector(null);
        shapeCollector.addFigure(square);

        shapeCollector.removeFigure(square);

        Assert.assertEquals(0, shapeCollector.getFiguresQuantity());
    }
    @Test
    public void testGetFigure(){
        Shape square = new Square(10.11);
        ShapeCollector shapeCollector = new ShapeCollector(null);
        shapeCollector.addFigure(square);

        Shape getShape = shapeCollector.getFigure(0);

        Assert.assertEquals(getShape, square);
    }
    @Test
    public void testShowFigures(){
        Shape square = new Square(10.11);
        ShapeCollector shapeCollector = new ShapeCollector(null);
        shapeCollector.addFigure(square);
        Shape getShape = shapeCollector.getFigure(0);
        String showFigure = getShape.getShapeName() + " " + getShape.getField();

        Assert.assertEquals(showFigure, "Square 10.11");
    }
}
