
public class TString {

	public static void main(String[] args) {
		String str1 = "Sitaram";
		String str2 = "Sitaram";
		
		//1
		if(str1 == str2) System.out.println("1 Equal"); 
		
		//2
		str2 = "Aditya";
		if(str1 == str2) System.out.println("2 Equal"); 
		
		//3
		String str3 = new String("Sitaram");
		if(str1 == str3) System.out.println("3 Equal"); 
		
		//4
		String str4 = "Sita"+"ram";
		if(str1 == str4) System.out.println("4 Equal"); 
		
		//5
		String s1 = "Sita";
		String s2 = "ram";
		String str5 = s1+s2;
		if(str1 == str5) System.out.println("5 Equal"); 
		
		//6
		String str6 = (s1 + s2).intern();
		if(str1 == str6) System.out.println("6 Equal"); 
		
		//7
		TClass obj = new TClass();
		if(str1 == obj.str) System.out.println("7 Equal"); 
		
		//8
		
		
	}
	
	

}
class TClass{
	public String str = "Sitaram";
}
