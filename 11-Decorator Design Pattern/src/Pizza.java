// Blueprint for classes that will have decorators

public interface Pizza {
	// *alt: bu projeye alternatif olarak list kullanýlabilir*
//	PlainPizza pp = new PlainPizza();
//	ArrayList<Topping> top=new ArrayList<>();
//	// setterlar constructor içerisinde olabilirdi
//	public void addMoz {
//	top.add(new Topping(Tops.MOZZARELLA, "mozzarella", 0.5));} // enum
//	}
//	public void addSauce {
//	top.add(new Topping(Tops.TOMATOSAUCE, "tomato sauce", 0.35));
//	}
//	
//	public void getter() {
//	    System.out.println(pp.getDescription()); // dough description
//		for (Topping el : top) { 		      
//        System.out.println(el.getDescription()); 		
//		}
//	
//		System.out.println(pp.getCost()); // dough cost
//		for (Topping el : top) {     
//      System.out.println(el.getCost()); 		
//		}
//	}
	
	public String getDescription();
	
	public double getCost();
	
}


/* 
 // wrong way:
 
public abstract class Pizza{
	
	public abstract void setDescription(String newDescription);
	public abstract String getDescription();
	
	public abstract void setCost(double newCost);
	public abstract double getCost();
	
	// I could use getter and setter methods for every 
	// potential Pizza topping
	
}
*/