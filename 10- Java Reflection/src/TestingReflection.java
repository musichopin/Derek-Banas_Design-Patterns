// The Java Reflection API is used to manipulate classes
// and everything in a class including fields, methods,
// constructors, private data, etc. 
// (for mostly debugging or analyzing)

// Because using the Reflection API is most often Dynamic
// it can slow down a program because the JVM can't
// optimize the code.

// The Reflection API can't be used with applets because 
// of the added security applets require.

// Because this API allows you to do things like access
// private fields, methods, etc. it should be used 
// sparingly, or else potentially destroy the logic
// of a program

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestingReflection {
	
	public static void main(String[] args){
		
		// Getting the class Object for UFOEnemyShip
		// Everything in Java has a Class Object
//		reflectClass is a reference to the class Object for UFOEnemyShip
		Class reflectClass = UFOEnemyShip.class;
		
		// *1.Get the class name of an Object*
		// UFOEnemyShip
		
		String className = reflectClass.getName();
		
		System.out.println(className + "\n");
		
		// *2.Check modifiers of a class*
		// true
		
//		other class modifiers:
		// isAbstract, isFinal, isInterface, isPrivate, isProtected,
		// isStatic, isStrict, isSynchronized, isVolatile
		
		int classModifiers = reflectClass.getModifiers();
		
		System.out.println(Modifier.isPublic(classModifiers) + "\n");
		
		// *3.You can get a list of interfaces used by a class*
		
		// Class[] interfaces = reflectClass.getInterfaces();
		// this returns an array full of class interfaces that are attached to the class"
//		birden fazla interface olabileceði için array içerisine alýndý
		
		// *4.Get the super class for UFOEnemyShip*
		// EnemyShip
		
		Class classSuper = reflectClass.getSuperclass();
		
		System.out.println(classSuper.getName() + "\n");
		
		// *5.Get the objects methods, return type and parameter type (constructor yok)*

//		Method Name: toString
//		Return Type: class java.lang.String
//		Parameters
//
//		Method Name: getName
//		Getter Method
//		Return Type: class java.lang.String
//		Parameters
//
//		Method Name: setName
//		Setter Method
//		Return Type: void
//		Parameters
//		java.lang.String
		
//		etc
		
		Method[] classMethods = reflectClass.getMethods();
		// this returns an array full of methods that are attached to the class"
		
		for(Method method : classMethods){
			
			// Get the method name
			
			System.out.println("Method Name: " + method.getName());
			
			// Check if a method is a getter or setter
			
			if(method.getName().startsWith("get")) {
				
				System.out.println("Getter Method");
				
			} else if(method.getName().startsWith("set")) {
				
				System.out.println("Setter Method");
				
			}
			
			// Get the methods return type
			
			System.out.println("Return Type: " + method.getReturnType());
			
			Class[] parameterType = method.getParameterTypes();
//			her bir metoda ait birden fazla parameter type olabileceðinden 
//			array içerisine alýndý
			
			// List parameters for a method
			
			System.out.println("Parameters");
			
			for(Class parameter : parameterType){
				
				System.out.println(parameter.getName());
				
			}
			
			System.out.println();
		
		} // close bracket for methods
		
		
		// *6.How to access class constructors*
		
		Constructor constructor = null;
		
		Object constructor2 = null;
//		constructor2 için newInstance metodu hemen kullanýldýðýndan dolayý 
//		Object type oldu
		try {
			
			// If you know the parameters of the constructor you
			// want you do the following.
			
			// To return an array of constructors instead do this
			// Constructor[] constructors = reflectClass.getConstructors();
			
			// If the constructor receives a String you'd use the
			// parameter new Class[]{String.class}
			// For others use int.class, double.class, etc.
			
			constructor = reflectClass.getConstructor(new Class[]{EnemyShipFactory.class});
			
			// Call a constructor by passing parameters to create an object
			// int.class yerine Integer.TYPE kullanýlabilirdi
			constructor2 = reflectClass.getConstructor(int.class, String.class).newInstance(12, "Random String");
//			prints "You sent: 12 Random String"
		} 
		
		catch (NoSuchMethodException | SecurityException e) {
			// Exceptions thrown
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Return the parameters for a constructor (more than once)
		
		Class[] constructParameters = constructor.getParameterTypes();
		
		for(Class parameter : constructParameters){
			
			System.out.println(parameter.getName());
//			prints "EnemyShipFactory"
			
		}
		
		UFOEnemyShip newEnemyShip = null;
		
		EnemyShipFactory shipFactory = null;
		
		try {
			
			// Create a UFOEnemyShip object by calling newInstance
			//	when we use our constructor to get a new UFOEnemyShip it doesn't know what it is, so we cast
			// (objectten downcasting yapýlýyor(yukarýda "constructor2" ya bak ve karþýlaþtýr))
			newEnemyShip = (UFOEnemyShip) constructor.newInstance(shipFactory);
			
		} 
		
		catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			
			e.printStackTrace();
			
		}
		
		// Now that we created a UFOEnemyShip object above we can call methods in the UFOEnemyShip Object
		
		newEnemyShip.setName("Xt-1000");
		System.out.println("EnemyShip Name: " + newEnemyShip.getName());
//		prints "EnemyShip Name: Xt-1000"
		
		// *7.Access private fields using reflection*
		
		// Field stores info on a single field of a class
		
		Field privateStringName = null;
		
		try {
			
			// Create a UFOEnemyShip object
			
			UFOEnemyShip enemyshipPrivate = new UFOEnemyShip(shipFactory);
			
			// Define the private field you want to access
			// I can access any field with just its name dynamically
			
			String idCodeString = "idcode";
			
			privateStringName = UFOEnemyShip.class.getDeclaredField(idCodeString);
			
			// Shuts down security allowing you to access private fields
			
			privateStringName.setAccessible(true);
			
			// Get the value of a field and store it in a String
			// object'ten stringe downcast yapýyoruz
			String valueOfName = (String) privateStringName.get(enemyshipPrivate);
			
			System.out.println("EnemyShip Private Name: " + valueOfName);
//			prints "EnemyShip Private Name: 100"
			
			// * 8. Get access to a private method*
			// getDeclaredMethod("methodName", methodParamters or null)
			
			// Since I provide the method name as a String I can run any method 
			// without needing to follow the normal convention methodName() 
			// null is parameter type
			// we can pass a method name as a string:
			String methodName = "getPrivate";
			
			Method privateMethod = UFOEnemyShip.class.getDeclaredMethod(methodName, null);
			
			// Shuts down security allowing you to access private methods
			
			privateMethod.setAccessible(true);
			
			// get the return value from the method
			// parameter value is null
			
			String privateReturnVal = (String) privateMethod.invoke(enemyshipPrivate, null);
			
			System.out.println("EnemyShip Private Method: " + privateReturnVal);
			// prints "EnemyShip Private Method: How did you get this"
			
			// *9. Execute a method that has parameters*
			
			// Define the parameters expected by the private method
			
			Class[] methodParameters = new Class[]{Integer.TYPE, String.class};
			
			// Provide the parameters above with values
			
			Object[] params = new Object[]{new Integer(10), new String("Random")};
			
			// Get the method by providing its name and a Class array with parameters
			
			privateMethod = UFOEnemyShip.class.getDeclaredMethod("getOtherPrivate", methodParameters);
			
			// Shuts down security allowing you to access private methods 
			
			privateMethod.setAccessible(true);
			
			// Execute the method and pass parameter values. The return value is stored
			
			privateReturnVal = (String) privateMethod.invoke(enemyshipPrivate, params);
			
			System.out.println("EnemyShip Other Private Method: " + privateReturnVal);
//			prints "EnemyShip Other Private Method: How did you get here 10 Random"
		} 	
		
		catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}