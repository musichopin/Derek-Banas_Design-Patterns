public class VisitorTest {
	public static void main(String[] args) {
		
		Visitor taxCalc = new TaxVisitor();
		Visitor taxHolidayCalc = new TaxHolidayVisitor();
		
		Visitable milk = new Necessity(3.47);
		Visitable vodka = new Liquor(11.99);
		Visitable cigars = new Tobacco(19.99);
		
		System.out.println("REGULAR TAX PRICES\n");
		
		System.out.println(milk.accept(taxCalc) + "\n");
		System.out.println(vodka.accept(taxCalc) + "\n");
		System.out.println(cigars.accept(taxCalc) + "\n");
		
		System.out.println("TAX HOLIDAY PRICES\n");
		
		System.out.println(milk.accept(taxHolidayCalc) + "\n");
		System.out.println(vodka.accept(taxHolidayCalc) + "\n");
		System.out.println(cigars.accept(taxHolidayCalc) + "\n");
		
	}
}
/*
REGULAR TAX PRICES

Necessity Item: Price with Tax
3.0

Liquor Item: Price with Tax
14.0

Tobacco Item: Price with Tax
26.0

TAX HOLIDAY PRICES

Necessity Item: Price with Tax
3.0

Liquor Item: Price with Tax
13.0

Tobacco Item: Price with Tax
26.0
*/