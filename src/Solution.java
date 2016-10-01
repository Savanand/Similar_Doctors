
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;

public class Solution {
  private static List<Doctor> Doctors = Arrays.asList(
      new Doctor("Steve",95112, "Bone", 1),
      new Doctor("Todd",95112, "Bone", 2),
      new Doctor("Kim",95112, "Bone", 5),
      new Doctor("Joe",95111, "Teeth", 2),
      new Doctor("Cindy",95113, "Bone", 4),
      new Doctor("Mark",95112, "Bone", 3),
      new Doctor("Mike",95112, "Heart", 1),
      new Doctor("George",95113, "Heart", 2),
      new Doctor("Jim",95114, "Heart", 4),
      new Doctor("Chuck",95114, "Surgen", 5),
      new Doctor("Jorje", 95110,"Surgen", 5),
      new Doctor("Jane",95111, "Teeth", 1),
      new Doctor("Kim", 95112, "Teeth", 3)
    );

  public static void main(String[] args) throws IOException {
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
	  
	  newGetResults(95112, "Bone", 2);
	  
	// newGetResults(zip, speciality, rating);
  }

/*
  private static void getResults(int zip, String speciality, int rating) {
    List<Doctor> olderDoctors = Doctors.stream().filter(u -> (u.zip ==zip)).collect(Collectors.toList());
    printResults("New way older Doctors", olderDoctors);
  }
*/
  private static void newGetResults(int zip, String speciality, int rating) {
	  //  List<Doctor> olderDoctors = Doctors.stream().filter(u -> (u.zip ==zip)).collect(Collectors.toList());
	  //  printResults("New way older Doctors", olderDoctors);
	    
	    Predicate<Doctor> zipPredicate = u -> (u.zip+2>=zip);
	    Predicate<Doctor> specialityPredicate = u -> (u.speciality ==speciality);
	    Predicate<Doctor> ratingPredicate = u -> (u.rating>=rating);
	    Predicate<Doctor> fullPredicate = zipPredicate.and(specialityPredicate).and(ratingPredicate);

	   Comparator<Doctor> byReverseRating = (f1, f2) -> Long.compare(f2.getRating(), f1.getRating());

	    // apply composite predicate
	    
	    List<Doctor> olderDoctors = Doctors.stream().filter(fullPredicate)
	            .collect(Collectors.toList());

	    
	    //olderDoctors.sort(Comparator.comparing(a -> a.rating)); for ascending order of rating 
	   olderDoctors.sort(byReverseRating);
	   // olderDoctors.sort((f1, f2) -> Long.compare(f2.getRating(), f1.getRating())); // for descending order of rating
	    
	    
	    printResults("New way older Doctors", olderDoctors);
	    
	    
	  }
 
  private static void printResults(String type, List<Doctor> Doctors) {
    System.out.println(type + ":");

    Doctors.forEach(u -> System.out.println("\t" + u));

    System.out.println();
  }
}