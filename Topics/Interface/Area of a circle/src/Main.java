class Circle implements Measurable {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;

    }
}

interface Measurable {
    double area();
}
