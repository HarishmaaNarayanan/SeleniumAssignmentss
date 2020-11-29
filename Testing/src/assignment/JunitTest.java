package assignment;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitTest {
	
	
	
		@BeforeClass
		public static void beforeClass() {
			System.out.println("Inside before class method.");
		}

		@Before
		public void before() {
			System.out.println("Inside before method.");
		}

		@Test
		public void test() {
			System.out.println("Inside test method.");
		}
        @After
		public void after() {
			System.out.println("Inside after method.");
		}

		@AfterClass
		public static void afterClass() {
			System.out.println("Inside after class method.");
		}
	}



