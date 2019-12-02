package Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    Job job1;
    Job job2;
    Job newJob;
    @Before
    public void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
        newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId() {
        assertEquals(job1.getId(), job2.getId() - 1);
    }
    @Test
    public void testJobConstructorSetsAllFields() {
        assertEquals(newJob.getEmployer().getValue(), "ACME");
        assertEquals(newJob.getLocation().getValue(), "Desert");
        assertEquals(newJob.getPositionType().getValue(), "Quality control");
        assertEquals(newJob.getCoreCompetency().getValue(), "Persistence");
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality() {
        assertNotEquals(job1, job2);
    }
    @Test
    public void testJobToStringBlankLines() {
        String[] arrOfStr = newJob.toString().split("\\r?\\n");
        assertEquals("", arrOfStr[0]);
        assertEquals(" ", arrOfStr[arrOfStr.length - 1]);
    }
    @Test
    public void testJobToStringFormat() {
        String[] arrOfStr = newJob.toString().split("\\r?\\n");
        assertEquals("ID: 3", arrOfStr[1]);
        assertEquals("Name: Product tester", arrOfStr[2]);
        assertEquals("Employer: ACME", arrOfStr[3]);
        assertEquals("Location: Desert", arrOfStr[4]);
        assertEquals("Position Type: Quality control", arrOfStr[5]);
        assertEquals("Core Competency: Persistence", arrOfStr[6]);
    }
    @Test
    public void testJobToStringNoData() {
        newJob.setName("");
        newJob.setEmployer(new Employer(""));
        String[] arrOfStr = newJob.toString().split("\\r?\\n");
        assertEquals("Name: Data not available", arrOfStr[2]);
        assertEquals("Employer: Data not available", arrOfStr[3]);
    }
    @Test
    public void testJobToStringDoesNotExist() {
        assertEquals("OOPS! This job does not seem to exist.", job1.toString());
    }
}
