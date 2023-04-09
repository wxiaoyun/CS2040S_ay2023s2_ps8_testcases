import static org.junit.Assert.*;
import org.junit.Test;
import java.util.Random;

public class TSPGraphTester {
		/**
			* @author Wu Xiaoyun
			*/
		@Test
		public void testTimeComplexityMST() {
				String[] inputFiles = {
						"tenpoints.txt",
						"twentypoints.txt",
						"fiftypoints.txt",
						"hundredpoints.txt"
				};
				
				int[] inputSizes = {10, 20, 50, 100};
				
				TSPGraph graph = new TSPGraph();
				
				// Record the times for each input size
				long[] times = new long[inputFiles.length];
				for (int i = 0; i < inputFiles.length; i++) {
						String filename = inputFiles[i];
						
						TSPMap map = new TSPMap(filename);
						long startTime = System.nanoTime();
						graph.MST(map);
						long endTime = System.nanoTime();
						times[i] = endTime - startTime;
				}
				
				// Compare the time growth to the expected O(n^2 * log n) complexity
				for (int i = 1; i < times.length; i++) {
						double previousN = inputSizes[i - 1];
						double currentN = inputSizes[i];
						double previousTime = times[i - 1];
						double currentTime = times[i];
						
						double expectedTimeGrowth = Math.pow(currentN / previousN, 2) * (Math.log(currentN) / Math.log(previousN));
						double actualTimeGrowth = currentTime / previousTime;
						
						// You may want to use a tolerance value to account for small variations in time measurements
						double tolerance = 0.25;
						double upperBound = expectedTimeGrowth * (1 + tolerance);
						System.out.println(String.format("Test %d:\nExpected time growth: %f\nActual time growth: %f",
								i, expectedTimeGrowth, actualTimeGrowth));
						assertTrue("Time complexity is worse than O(n^2 * log n)", actualTimeGrowth <= upperBound);
				}
		}
		
		/**
			* @author Wu Xiaoyun
			*/
		@Test
		public void testTimeComplexityTSP() {
				String[] inputFiles = {
						"tenpoints.txt",
						"twentypoints.txt",
						"fiftypoints.txt",
						"hundredpoints.txt"
				};
				
				int[] inputSizes = {10, 20, 50, 100};
				
				TSPGraph graph = new TSPGraph();
				
				// Record the times for each input size
				long[] times = new long[inputFiles.length];
				for (int i = 0; i < inputFiles.length; i++) {
						String filename = inputFiles[i];
						
						TSPMap map = new TSPMap(filename);
						long startTime = System.nanoTime();
						graph.TSP(map);
						long endTime = System.nanoTime();
						times[i] = endTime - startTime;
				}
				
				// Compare the time growth to the expected O(n^2 * log n) complexity
				for (int i = 1; i < times.length; i++) {
						double previousN = inputSizes[i - 1];
						double currentN = inputSizes[i];
						double previousTime = times[i - 1];
						double currentTime = times[i];
						
						double expectedTimeGrowth = Math.pow(currentN / previousN, 2) * (Math.log(currentN) / Math.log(previousN));
						double actualTimeGrowth = currentTime / previousTime;
						
						// You may want to use a tolerance value to account for small variations in time measurements
						double tolerance = 0.25;
						double upperBound = expectedTimeGrowth * (1 + tolerance);
						System.out.println(String.format("Test %d:\nExpected time growth: %f\nActual time growth: %f",
								i, expectedTimeGrowth, actualTimeGrowth));
						assertTrue("Time complexity is worse than O(n^2 * log n)", actualTimeGrowth <= upperBound);
				}
		}
		
		/**
			* @author Ernest
			*/
		@Test
		public void testValidTour1() {
				TSPMap map = new TSPMap("tenpoints.txt");
				map.setLink(0, 1);
				map.setLink(1, 2);
				map.setLink(2, 3);
				map.setLink(3, 4);
				map.setLink(4, 0);
				map.setLink(5, 6);
				map.setLink(6, 7);
				map.setLink(7, 8);
				map.setLink(8, 9);
				map.setLink(9, 5);
				TSPGraph graph = new TSPGraph();
				
				boolean expected = false;
				boolean result = graph.isValidTour(map);

				System.out.println("This tour is valid: " + result);
				assertEquals(expected, result);
		}
		
		/**
			* @author Ernest
			*/
		@Test
		public void testValidTour2() {
				TSPMap map = new TSPMap("tenpoints.txt");
				map.setLink(0, 1);
				map.setLink(1, 2);
				map.setLink(2, 3);
				map.setLink(3, 4);
				map.setLink(4, 5);
				map.setLink(5, 6);
				map.setLink(6, 7);
				map.setLink(7, 8);
				map.setLink(8, 9);
				map.setLink(9, 0);
				map.eraseLink(9);
				TSPGraph graph = new TSPGraph();
				
				boolean expected = false;
				boolean result = graph.isValidTour(map);
				
				System.out.println("This tour is valid: " + result);
				assertEquals(expected, result);
		}
		
		/**
			* @author Ernest
			*/
		@Test
		public void testValidTour3() {
				TSPMap map = new TSPMap("tenpoints.txt");
				map.setLink(0, 1);
				map.setLink(1, 2);
				map.setLink(2, 3);
				map.setLink(3, 4);
				map.setLink(4, 5);
				map.setLink(5, 6);
				map.setLink(6, 7);
				map.setLink(7, 8);
				map.setLink(8, 9);
				map.setLink(9, 1);
				TSPGraph graph = new TSPGraph();
				
				boolean expected = false;
				boolean result = graph.isValidTour(map);
				
				System.out.println("This tour is valid: " + result);
				assertEquals(expected, result);
		}
		
		/**
			* @author Wu Xiaoyun
			*/
		@Test
		public void testValidTour4() {
				TSPMap map = new TSPMap("tenpoints.txt");
				map.setLink(0, 1);
				map.setLink(1, 2);
				map.setLink(2, 3);
				map.setLink(3, 4);
				map.setLink(4, 5);
				map.setLink(5, 6);
				map.setLink(6, 7);
				map.setLink(7, 8);
				map.setLink(8, 9);
				map.setLink(9, 0);
				TSPGraph graph = new TSPGraph();
				
				boolean expected = true;
				boolean result = graph.isValidTour(map);
				
				System.out.println("This tour is valid: " + result);
				assertEquals(expected, result);
		}
		
		/**
			* @author Wu Xiaoyun
			*/
		@Test
		public void testTourDistance1() {
				TSPMap map = new TSPMap("tenpoints.txt");
				map.setLink(0, 1);
				map.setLink(1, 2);
				map.setLink(2, 3);
				map.setLink(3, 4);
				map.setLink(4, 5);
				map.setLink(5, 6);
				map.setLink(6, 7);
				map.setLink(7, 8);
				map.setLink(8, 9);
				map.setLink(9, 0);
				TSPGraph graph = new TSPGraph();
				
				String expected = "740.85868";
				double result = graph.tourDistance(map);
				
				System.out.println("Tour distance: " + result);
				assertEquals(expected, String.format("%.5f", result));
		}
		
		/**
			* @author Wu Xiaoyun
			*/
		@Test
		public void testTourDistance2() {
				TSPMap map = new TSPMap("tenpoints.txt");
				map.setLink(0, 9);
				map.setLink(9, 1);
				map.setLink(1, 8);
				map.setLink(8, 2);
				map.setLink(2, 7);
				map.setLink(7, 3);
				map.setLink(3, 6);
				map.setLink(6, 4);
				map.setLink(4, 5);
				map.setLink(5, 0);
				TSPGraph graph = new TSPGraph();
				
				String expected = "724.29177";
				double result = graph.tourDistance(map);
				
				System.out.println("Tour distance: " + result);
				assertEquals(expected, String.format("%.5f", result));
		}
		
		/**
			* @author Wu Xiaoyun
			*/
		@Test
		public void testTourDistance3() {
				TSPMap map = new TSPMap("tenpoints.txt");
				map.setLink(0, 1);
				map.setLink(1, 2);
				map.setLink(2, 3);
				map.setLink(3, 4);
				map.setLink(4, 5);
				map.setLink(5, 6);
				map.setLink(6, 7);
				map.setLink(7, 8);
				map.setLink(8, 9);
				map.setLink(9, 1);
				TSPGraph graph = new TSPGraph();
				
				String expected = "-1.0";
				double result = graph.tourDistance(map);
				
				System.out.println("Tour distance: " + result);
				assertEquals(expected, String.format("%.1f", result));
		}
		
		/**
			* No matter how many tests you failed, this test will never fail you.
			* You can do it!
			* But if you are really stuck, try go for a walk, or have a cup of coffee.
			* Or go watch Suzume, it's amazing!
			* -
			* Inspired by the coin flipping scene between Tanjiro and Kanao in
			* Demon	Slayer: Kimetsu no Yaiba. (And screw you uncultured spell checker)
			*
			* @author Wu Xiaoyun
			*/
		@Test
		public void testYouCanDoIt() {
				Random rnd = new Random();
				double threshold = 0.001;
				int count = 0;
				
				boolean expected = true;
				boolean result = rnd.nextDouble() < threshold;
;
				while (result !=	expected) {
						System.out.printf("You may have failed %d %s.\n", ++count , count == 1 ? "time" : "times");
						threshold *= 2;
						result = rnd.nextDouble() < threshold;
				}
				
				System.out.println("But you can do it in the end!");
				assertEquals(expected, result); // indeed "The value of result is always true"
		}
}
