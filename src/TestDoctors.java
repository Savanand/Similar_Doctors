import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class TestDoctors {

	@Test
	public void testDoctors() {
//		fail("Not yet implemented");
		
		Solution s= new Solution();
		s.newGetResults(95112, "Bone", 2);
		List<Doctor> searchResult= s.getDoctorDisplay();
		s.printResults();
		assertNotNull(searchResult);
		
		//ReflectionAssert.assertReflectionEquals(expectedCollection,actualCollection)
	}

	@Test
	public void testSingleUniqueDoctor() {
//		fail("Not yet implemented");
		
		Solution s= new Solution();
		s.newGetResults(95112, "Lung", 4);
		List<Doctor> searchResult= s.getDoctorDisplay();
		s.printResults();
		assertNotNull(searchResult);
		
		//ReflectionAssert.assertReflectionEquals(expectedCollection,actualCollection)
	}
	
	

	@Test
	public void checkSpecialityNull() {
//		fail("Not yet implemented");
		
		Solution s= new Solution();
		s.newGetResults(95112, null, 4);
		List<Doctor> searchResult= s.getDoctorDisplay();
		s.printResults();
		assertNotEquals(null, searchResult);
		
		//ReflectionAssert.assertReflectionEquals(expectedCollection,actualCollection)
	}
}
