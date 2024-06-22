package designpatterns;

interface Shape{
   public abstract String draw();
}

class Circle implements Shape{

    @Override
    public String draw(){
        return "Circle";
    }
}

class Triangle implements Shape{

    @Override
    public String draw(){
        return "Triangle";
    }
}

abstract class ShapeDecorator implements Shape{
    Shape shape;
    ShapeDecorator(Shape shape){
        this.shape=shape;
    }

}

class ColorDecorator extends ShapeDecorator{
    String color;

    public ColorDecorator(Shape shape, String color){
        super(shape);
        this.color=color;
    }

    public String draw(){
        return shape.draw() + "-"+ color;
    }
}

class BorderDecorator extends ShapeDecorator{
    String border;
    public BorderDecorator(Shape shape, String border){
        super(shape);
        this.border=border;
    }

    public String draw(){
        return shape.draw() + "-"+ border;
    }
}



public class ClientDecorator {

    public static void main(String[] args) {
        
        Circle circle = new Circle();
        System.out.println(circle.draw());

        ColorDecorator colorDecorator = new ColorDecorator(circle, "red");
        System.out.println(colorDecorator.draw());

        BorderDecorator borderDecorator = new BorderDecorator(colorDecorator, "dotted");
        System.out.println(borderDecorator.draw());
    }
    
}
