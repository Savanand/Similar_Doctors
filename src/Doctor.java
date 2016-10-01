
/*
 * This is doctor class having 4 properties
 * Name- Name of the doctor
 * Zip- Location of doctor
 * Specialty- Specialty of the doctor
 * Rating- Rating of the doctor based on 5 star rating system
 */
public class Doctor {

		String name;
		Integer zip;
		String speciality;
		int rating;
		public Doctor(String name, int zip, String speciality, int rating) {
			this.name = name;
			this.zip = zip;
			this.speciality = speciality;
			this.rating = rating;
		}
		
	
		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public int getZip() {
			return zip;
		}


		public void setZip(int zip) {
			this.zip = zip;
		}


		public String getSpeciality() {
			return speciality;
		}


		public void setSpeciality(String speciality) {
			this.speciality = speciality;
		}


		public Integer getRating() {
			return rating;
		}


		public void setRating(int rating) {
			this.rating = rating;
		}


		public String toString(){
			
			return "Doctor: name="+this.name+" zip="+this.zip+" speciality="+this.speciality+" rating="+this.rating;
		}
		
}
