import javax.swing.JOptionPane;

public class CircleTable {

	public static void main(String[] args) {
		
		String radiusInput = JOptionPane.showInputDialog("Enter radius");
		String incrementInput = JOptionPane.showInputDialog("Enter increment of the radius");
		
		double radius = Double.parseDouble(radiusInput);
		double increment = Double.parseDouble(incrementInput);
		
		Circle c = new Circle(radius);
		
		System.out.println("Radius | Perimeter    | Surface    ");
		System.out.println("");
		
		for(int i = 0; i < 30; i++) {
		System.out.println(c.getRadius() + " | " + c.getPerimeter() + " | " + c.getSurface());
		radius += increment;
		c.setRadius(radius);
		}
	}

}
