// ***This factory only creates a new rectangle if it 
// uses a color not previously used.
// Intrinsic State: Color
// Extrinsic State: X & Y Values.
// every time we create a new rectangle that has a color already been used we dont 
//create a new rectangle object. we just share what is already created with that similar color.
//so that just leaves the Extrinsic state which will be a different sized rectangle.
//speed improvement derives from Intrinsic state***

import java.util.HashMap;
import java.awt.Color;
public class RectFactory {
	
	// **The HashMap uses the color (class) as the key (MyRect (class) becomes value) for every 
	// rectangle it will make up to 8 total**
	
	private static final HashMap<Color, MyRect> rectsByColor = new HashMap<Color, MyRect>();
   
	public static MyRect getRect(Color color) {
//		rectsByColor.get(color) hashmapte yok ise null olur
		MyRect rect = (MyRect)rectsByColor.get(color); // *no need for casting*
		
		// **Checks if a rectangle with a specific
		// color has been made. If not it makes a
		// new one, otherwise it returns one made already**
		if(rect == null) {
//			*this rectangle with this color has never been created before and thus created now*
			rect = new MyRect(color);
			
			// Add new rectangle to HashMap
			
			rectsByColor.put(color, rect);
         
		}
		return rect;
	}
}