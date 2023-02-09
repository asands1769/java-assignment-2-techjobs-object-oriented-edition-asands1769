package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job testJobOne = new Job();
        Job testJobTwo = new Job();
        assertNotEquals(testJobOne.getId(), testJobTwo.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJob.getName(), "Product tester");
        assertEquals(testJob.getEmployer().getValue(), "ACME");
        assertEquals(testJob.getLocation().getValue(), "Desert");
        assertEquals(testJob.getPositionType().getValue(), "Quality control");
        assertEquals(testJob.getCoreCompetency().getValue(), "Persistence");
        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){
    Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    Job testJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    assertFalse(testJobOne.equals(testJobTwo));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(testJobOne.toString().charAt(0), '\n');
        assertEquals(testJobOne.toString().charAt(testJobOne.toString().length() - 1), '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job testJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(testJobOne.toString().contains("Name: Product tester"));
        assertTrue(testJobOne.toString().contains("Employer: ACME"));
        assertTrue(testJobOne.toString().contains("Location: Desert"));
        assertTrue(testJobOne.toString().contains("Position Type: Quality control"));
        assertTrue(testJobOne.toString().contains("Core Competency: Persistence"));
        assertEquals(testJobOne.toString(), "\n" +
                "ID: " + testJobOne.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: ACME" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n");
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job testJobOne = new Job("Product tester", new Employer("    "), new Location(""), new PositionType(" "), new CoreCompetency("  "));
        testJobOne.toString();
        assertEquals(testJobOne.getName(), "Product tester");
        assertEquals(testJobOne.getEmployer().getValue(), "Data not available");
        assertEquals(testJobOne.getLocation().getValue(), "Data not available");
        assertEquals(testJobOne.getPositionType().getValue(), "Data not available");
        assertEquals(testJobOne.getCoreCompetency().getValue(), "Data not available");
    }
    @Test
    public void testToStringHandlesAllEmptyFieldsExceptID(){
        Job testJobOne = new Job("", new Employer("    "), new Location(""), new PositionType(" "), new CoreCompetency("  "));
        assertEquals(testJobOne.toString(), "OOPS! This job does not seem to exist.");
    }



}
