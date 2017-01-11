import java.util.*;
public class NameGenerator {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

    	List<String> names = new ArrayList<String>();
        String[] nameArray = {"brian", "tom", "fred", "max"};
        for(String name: nameArray){
            names.add(name);
        }
            
        while(names.size() > 0){
            if(names.size() == 1){
                System.out.println(names.get(0) + ": this is the final presenter");
                break;
            }
            
            int id = (int)(Math.random() * (names.size()));
            System.out.println(names.get(id) + ": " + (names.size() - 1) + " more presenters");
            System.out.print("Continue?  (y/n)");
            String val = sc.nextLine();
            
            if(val == "y"){
                
            }
            
            else if(val == "n" ){
                break;
            }

            names.remove(id);
        }
	}	
}
