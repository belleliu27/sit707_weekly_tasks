package sit707_tasks;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;


/**
 * @author Zhaojun Liu
 */
public class DateUtilTest {
	
	@Test
	public void testStudentIdentity() {
		String studentId = "223924007";
		Assert.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "ZHAOJUN LIU";
		Assert.assertNotNull("Student name is null", studentName);
	}

	@Test
	public void testMaxJanuary31ShouldIncrementToFebruary1() {
		// January max boundary area: max+1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldIncrementToFebruary1 > " + date);
        date.increment();
        System.out.println(date);
        Assert.assertEquals(2, date.getMonth());
        Assert.assertEquals(1, date.getDay());
	}
	
	@Test
	public void testMaxJanuary31ShouldDecrementToJanuary30() {
		// January max boundary area: max-1
		DateUtil date = new DateUtil(31, 1, 2024);
        System.out.println("january31ShouldDecrementToJanuary30 > " + date);
        date.decrement();
        System.out.println(date);
        Assert.assertEquals(30, date.getDay());
        Assert.assertEquals(1, date.getMonth());
	}
	
	@Test
	public void testNominalJanuary() {
		int rand_day_1_to_31 = 1 + new Random().nextInt(31);
        DateUtil date = new DateUtil(rand_day_1_to_31, 1, 2024);
        System.out.println("testJanuaryNominal > " + date);
        date.increment();
        System.out.println(date);
	}

    @Test
    public void testMinJanuary1ShouldIncrementToJanuary2() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testMinJanuary1ShouldDecrementToDecember31() {
        DateUtil date = new DateUtil(1, 1, 2024);
        date.decrement();
        Assert.assertEquals(31, date.getDay());
        Assert.assertEquals(12, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
    
    @Test
    public void testMaxJune30ShouldIncrementToJuly1() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    @Test
    public void testMidMonthJune15ShouldIncrementToJune16() {
        DateUtil date = new DateUtil(15, 6, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
    
    @Test
    public void testInvalidDateJune31() {
        try {
            new DateUtil(31, 6, 1994); // Should throw an exception
            Assert.fail("Expected an exception for invalid date.");
        } catch (RuntimeException e) { // Catch RuntimeException instead
            // Test passes because the expected exception was thrown
        }
    }


    @Test
    public void testLeapYearFebruary29ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(29, 2, 2024); // 2024 is a leap year
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2024, date.getYear());
    }

    @Test
    public void testNonLeapYearFebruary28ShouldIncrementToMarch1() {
        DateUtil date = new DateUtil(28, 2, 2023); // 2023 is not a leap year
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
        Assert.assertEquals(2023, date.getYear());
    }
 // Test cases from the Orange Table
    @Test
    public void testNextDate_1B() {
        DateUtil date = new DateUtil(1, 6, 1994);
        date.increment();
        Assert.assertEquals(2, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }

    @Test
    public void testNextDate_2B() {
        DateUtil date = new DateUtil(2, 6, 1994);
        date.increment();
        Assert.assertEquals(3, date.getDay());
        Assert.assertEquals(6, date.getMonth());
        Assert.assertEquals(1994, date.getYear());
    }
    
    @Test
    public void testNextDate_3B() {
        DateUtil date = new DateUtil(15, 6, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_4B() {
        DateUtil date = new DateUtil(30, 6, 1994);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
    }
    
    @Test
    public void testInvalidDate_5B() {
        try {
            new DateUtil(31, 6, 1994);
            Assert.fail("Expected an exception for invalid date.");
        } catch (RuntimeException e) {
            // Expected exception
        }
    }
    
    @Test
    public void testNextDate_6B() {
        DateUtil date = new DateUtil(15, 1, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_7B() {
        DateUtil date = new DateUtil(15, 2, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_8B() {
        DateUtil date = new DateUtil(15, 11, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_9B() {
        DateUtil date = new DateUtil(15, 12, 1994);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_10B() {
        DateUtil date = new DateUtil(15, 6, 1700);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_11B() {
        DateUtil date = new DateUtil(15, 6, 1701);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_12B() {
        DateUtil date = new DateUtil(15, 6, 2023);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }
    
    @Test
    public void testNextDate_13B() {
        DateUtil date = new DateUtil(15, 6, 2024);
        date.increment();
        Assert.assertEquals(16, date.getDay());
    }

 // Test cases for all months of 2024
    @Test
    public void testNextDate_January() {
        DateUtil date = new DateUtil(31, 1, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(2, date.getMonth());
    }

    @Test
    public void testNextDate_FebruaryLeapYear() {
        DateUtil date = new DateUtil(29, 2, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(3, date.getMonth());
    }

    @Test
    public void testNextDate_March() {
        DateUtil date = new DateUtil(31, 3, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(4, date.getMonth());
    }

    @Test
    public void testNextDate_April() {
        DateUtil date = new DateUtil(30, 4, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(5, date.getMonth());
    }

    @Test
    public void testNextDate_May() {
        DateUtil date = new DateUtil(31, 5, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(6, date.getMonth());
    }

    @Test
    public void testNextDate_June() {
        DateUtil date = new DateUtil(30, 6, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(7, date.getMonth());
    }

    @Test
    public void testNextDate_July() {
        DateUtil date = new DateUtil(31, 7, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(8, date.getMonth());
    }

    @Test
    public void testNextDate_August() {
        DateUtil date = new DateUtil(31, 8, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(9, date.getMonth());
    }

    @Test
    public void testNextDate_September() {
        DateUtil date = new DateUtil(30, 9, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(10, date.getMonth());
    }

    @Test
    public void testNextDate_October() {
        DateUtil date = new DateUtil(31, 10, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(11, date.getMonth());
    }

    @Test
    public void testNextDate_November() {
        DateUtil date = new DateUtil(30, 11, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(12, date.getMonth());
    }

    @Test
    public void testNextDate_December() {
        DateUtil date = new DateUtil(31, 12, 2024);
        date.increment();
        Assert.assertEquals(1, date.getDay());
        Assert.assertEquals(1, date.getMonth());
        Assert.assertEquals(2025, date.getYear()); // Ensuring year change works
    }

}
