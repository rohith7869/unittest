package hacs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CourseIteratorTest {
	CourseIterator itr;
	ClassCourseList courseList;

	@BeforeEach
	void start() {
		courseList = new ClassCourseList();
		courseList.initializeFromFile("CourseInfo.txt");
		itr = new CourseIterator(courseList);
	}

	@Test
	void testingNextString() {
		assertEquals(itr.next("SER502").courseName, "SER502");
		assertNull(itr.next("CS"));
	}

	@Test
	void testingNext() {
		assertEquals(itr.next().courseName, "SER515");
		assertEquals(itr.next().courseName, "SER502");
	}
	

	@Test
	void testingNextNull() {
		courseList = new ClassCourseList();
		itr = new CourseIterator(courseList);
		assertNull(itr.next());

	}

	@Test
	void testingRemove() {
		int length = itr.theCourseList.size();
		itr.remove();
		assertEquals(itr.theCourseList.size(), length - 1);
	}

	@Test
	void testingHasNext() {
		assertTrue(itr.hasNext());
		courseList = new ClassCourseList();
		itr = new CourseIterator(courseList);
		assertFalse(itr.hasNext());
	}

}
