

public class Circle {
	
	double radius;
	
	public Circle() {
		radius = 0;
	}
	
	public Circle(double pRadius) {
		radius = pRadius;
	}
	
	double getRadius() {
		return radius;
	}
	
	void setRadius(double pRadius) {
		radius = pRadius;
	}
	
	double getPerimeter() {
		return 2 * 3.14 * radius;
	}
	
	double getSurface() {
		return 3.14 * radius * radius;
	}
}
