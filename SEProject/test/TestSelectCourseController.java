import static org.junit.Assert.*;

import java.awt.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;



public class TestSelectCourseController {
	private ArrayList<String> course;
	SelectCourseController select = new SelectCourseController("Tanadoon");

	@Test
	public void testUserSelectCourseController() {
		String accountName = "Tanadoon";
		String intput = select.getName();                   
	    assertTrue("ERROR",intput.equals(accountName));
		
	}
	
	@Test
	public void testEmptyUserSelectCourseController() {
		String accountName = "Tanadoon";
		String intput = select.getName();                   
	    assertFalse("ERROR",!intput.equals(accountName));
		
	}

	@Test
	public void testFind() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("CS284");
		expected.add("CS285");
		expected.add("CS286");
		expected.add("CS287");
		select.find();

		course = select.getAllCourseId();
	    assertEquals(expected, course);
		
	}
	
	@Test
	public void testFileNotFound() {
		ArrayList<String> expected = new ArrayList<String>();
		expected.add("CS284");
		expected.add("CS285");
		expected.add("CS286");
		expected.add("CS287");
		expected.add("287");
		SelectCourseController sel = new SelectCourseController("Tanadoon");
		sel.find();

		course = sel.getAllCourseId();
	    assertFalse("ERROR",course.equals(expected));
		
	}

	

}
