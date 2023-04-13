public class Shape {
    private String color;
    private boolean filled;

    public Shape(){
        color = "blue";
        filled = true;
    }
    public Shape(String color, boolean filled){
        this.color = color;
        this.filled = filled;
    }
    public String getColor(){
        return color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public String toString(){
        return "color: " + color + ", filled: " + filled;
    }

    public static void main(String[] args) {
        Shape aShape = new Shape();
        Shape anotherShape = new Shape("green", false);
        System.out.println("Color: " + aShape.getColor());
        System.out.println("Color: " + anotherShape.getColor());
        System.out.println(anotherShape.toString());
    }
}

