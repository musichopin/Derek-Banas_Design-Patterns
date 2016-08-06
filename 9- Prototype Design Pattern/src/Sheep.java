public class Sheep implements Animal {

	public Sheep(){
		
		System.out.println("Sheep is Made");
		
	}
	
//	this method clones the super type of Animal and then cast it 
//	into being whatever it is (sheep in this example)
	public Animal makeCopy() {
//		return type interface olduðu için poly olur
		
		System.out.println("Copy Sheep is Being Made");
		
		Sheep sheepObject = null;
		
		try {
			
			// Calls the Animal super classes clone()
			// Then casts the results to Sheep
			
//			String return eden metod çaðýrýlýp stringi return edince int e cast etmeye benziyor
			sheepObject = (Sheep) super.clone(); // calls clone method of Cloneable interface
//			we use try catch block while cloning sth
			
		}
		
		// If Animal didn't extend Cloneable this error 
		// is thrown
		
		catch (CloneNotSupportedException e) {
			  
			System.out.println("The Sheep was Turned to Mush");
			
			e.printStackTrace();
			  
		 }
		
//		return our finished sheep that has been cloned
		return sheepObject;
	}
	
	public String toString(){
		
		return "Dolly is my Hero, Baaaaa";
		
	}
	
}

/*
SUPERCLASS OLMADAN CLONLAMAK ÝÇÝN:

    class Student18 implements Cloneable{  
    int rollno;  
    String name;  
      
    Student18(int rollno,String name){  
    this.rollno=rollno;  
    this.name=name;  
    }  
   
// returns of type Object
    public Object clone()throws CloneNotSupportedException{  
    return super.clone();  
    }  
      
    public static void main(String args[]){  
    try{  
    Student18 s1=new Student18(101,"amit");  
      
    Student18 s2=(Student18)s1.clone();  
      
    System.out.println(s1.rollno+" "+s1.name);  
    System.out.println(s2.rollno+" "+s2.name);  
      
    }catch(CloneNotSupportedException c){}  
      
    }  
    }  
*/