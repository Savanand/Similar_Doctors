
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Solution {
	
/*
 * Doctor is a list of doctors manually added to the collection List
 */
  private List<Doctor> Doctors = Arrays.asList(
      new Doctor("Steve",95112, "Bone", 3),
      new Doctor("John",95112, "Lung", 5),
      new Doctor("Todd",95117, "Bone", 2),
      new Doctor("Kim",95112, "Bone", 5),
      new Doctor("Joe",95111, "Teeth", 2),
      new Doctor("Cindy",95110, "Bone", 4),
      new Doctor("Mark",95111, "Bone", 3),
      new Doctor("Mike",95112, "Heart", 5),
      new Doctor("George",95113, "Heart", 2),
      new Doctor("Jim",95114, "Heart", 4),
      new Doctor("Chuck",95114, "Surgen", 5),
      new Doctor("Jorje", 95110,"Surgen", 5),
      new Doctor("Jane",95111, "Teeth", 1),
      new Doctor("Ron", 95009, "Bone", 3),
      new Doctor("Mike",95114, "Bone", 4),
      new Doctor("Lara",95118, "Heart", 2),
      new Doctor("Maya",95120, "Heart", 4),
      new Doctor("Hector",95125, "Surgen", 5),
      new Doctor("Jay", 95600,"Surgen", 5),
      new Doctor("Rose",93001, "Teeth", 1),
      new Doctor("Mak", 91302, "Teeth", 3)
		  );
  private List<Doctor> doctorDisplay;
  
 /* public static void main(String[] args) throws IOException {
    //  oldJavaWay();
  /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      String currLine=br.readLine();
      System.out.println("here");
     String[] input=currLine.split(" ");
      int zip= Integer.parseInt(input[0]);
     
      String speciality=  input[1];
      int rating= Integer.parseInt(input[2]);
 */
/*	  int zip=95112;
	  String speciality= "Bone";
	  int rating=2;
	  
	  */
	 // System.out.println(args[0]+args[1]+args[2]); 
	/* int zip= Integer.parseInt(args[0]);
	 String speciality= args[1];
	int rating= Integer.parseInt(args[2]);
	  System.out.println(zip+speciality+rating); */
	  
	  /* 
	   * Values are manually passed to the newGetResults function 
	   * which prints a new list containing similar doctors
	   * search results
	   * 
	   */
	  
	//  newGetResults(95112, "Bone", 2);
	  
	  
	  
	// newGetResults(zip, speciality, rating);
 // }

public List<Doctor> getDoctorDisplay() {
	return doctorDisplay;
}

public void setDoctorDisplay(List<Doctor> doctorDisplay) {
	this.doctorDisplay = doctorDisplay;
}

/*
  private static void getResults(int zip, String speciality, int rating) {
    List<Doctor> doctorDisplay = Doctors.stream().filter(u -> (u.zip ==zip)).collect(Collectors.toList());
    printResults("New way older Doctors", doctorDisplay);
  }
*/
  public void newGetResults(int zip, String speciality, int rating) {
	  //  List<Doctor> doctorDisplay = Doctors.stream().filter(u -> (u.zip ==zip)).collect(Collectors.toList());
	  //  printResults("New way older Doctors", doctorDisplay);
	    
	  	/* Search result Assumptions- 
	  	 * Similar Doctors==
	  	 * +/-2 zip codes(Location)
	  	 * Specialty exact
	  	 * rating greater than equal to >=
	  	 * 
	  	 * 
	  	 * Priority Doctors-
	  	 * Greater rating doctors first
	  	 * Closer zip doctors first
	  	 
	  			
	  */
	    Predicate<Doctor> zipPredicate = u -> (u.zip+2>=zip && zip+2>=u.zip); // returns location +-2 zips
	    Predicate<Doctor> specialityPredicate = u -> (u.speciality ==speciality);
	    Predicate<Doctor> ratingPredicate = u -> (u.rating>=rating);
	    
	    Predicate<Doctor> fullPredicate=null; 
	    if(speciality!=null){
	    fullPredicate = zipPredicate.and(specialityPredicate).and(ratingPredicate);
// this full predicate is combination of all three predicates before it
	    }
	    else{
	    	fullPredicate = zipPredicate.and(ratingPredicate);	
	    }
	    
	    // comparator for reverse rating
	   Comparator<Doctor> byReverseRating = (f1, f2) -> Long.compare(f2.getRating(), f1.getRating());

	    // applying full predicate
	    
	    doctorDisplay = Doctors.stream().filter(fullPredicate)
	            .collect(Collectors.toList());

	    
	    
	    
	    //doctorDisplay.sort(Comparator.comparing(a -> a.rating)); for ascending order of rating 
	   doctorDisplay.sort(byReverseRating);
	   // doctorDisplay.sort((f1, f2) -> Long.compare(f2.getRating(), f1.getRating())); // for descending order of rating
	    
	    
	 //   printResults("Displaying Doctors: ", doctorDisplay);
	    
	    
	  }
 
  public void printResults() {
    
	// printing doctors  
	  System.out.println("Displaying Similar Doctors:\n");

    doctorDisplay.forEach(u -> System.out.println("\t" + u));

    System.out.println();
  }
}