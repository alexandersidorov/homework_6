package ru.smsoft;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class LessonSixTest {

    private List<String> stringList;
    private Set<Integer> integerSet;
    private Set<MyClass> myClassSet;

    private List<String> stringList1;
    private Set<Integer> integerSet1;
    private Set<MyClass> myClassSet1;

    private Map<Integer,String> testMapA;
    private Map<Integer,String> testMapB;

    private Map<Integer,MyClass> testMapA1;
    private Map<Integer,MyClass> testMapB1;

    @BeforeEach
    void setUp() {
        stringList = new ArrayList<>(Arrays.asList("one","two","three","four","five"));
        integerSet = new HashSet<>(Arrays.asList(1,2,3,4,5));
        myClassSet = new HashSet<>(Arrays.asList(new MyClass(1,"one"),
                new MyClass(2,"two"),
                new MyClass(3,"three"),
                new MyClass(4,"four"),
                new MyClass(5,"five")));

        stringList1 = new ArrayList<>(Arrays.asList("two","three","four","five","six","seven"));
        integerSet1 = new HashSet<>(Arrays.asList(2,3,4,5,6,7));
        myClassSet1 = new HashSet<>(Arrays.asList(new MyClass(2,"two"),
                new MyClass(3,"three"),
                new MyClass(4,"four"),
                new MyClass(5,"five"),
                new MyClass(6,"six"),
                new MyClass(7,"seven")));

        testMapA = Map.ofEntries(
                Map.entry(1,"one"),
                Map.entry(2,"two"),
                Map.entry(3,"three"),
                Map.entry(4,"four"),
                Map.entry(5,"five")
        );
        testMapB = Map.ofEntries(
                Map.entry(6,"six"),
                Map.entry(7,"seven"),
                Map.entry(3,"three1"),
                Map.entry(4,"four1"),
                Map.entry(5,"five1")
        );

        testMapA1 = Map.ofEntries(
                Map.entry(1,new MyClass(1,"one")),
                Map.entry(2,new MyClass(2,"two")),
                Map.entry(3,new MyClass(3,"three")),
                Map.entry(4,new MyClass(4,"four")),
                Map.entry(5,new MyClass(5,"five"))
        );
        testMapB1 = Map.ofEntries(
                Map.entry(6,new MyClass(6,"six")),
                Map.entry(7,new MyClass(7,"seven")),
                Map.entry(3,new MyClass(3,"three1")),
                Map.entry(4,new MyClass(4,"four1")),
                Map.entry(5,new MyClass(5,"five1"))
        );

    }

    @AfterEach
    void tearDown() {
        stringList.clear();
        integerSet.clear();
        myClassSet.clear();

        stringList1.clear();
        integerSet1.clear();
        myClassSet1.clear();
    }

    @Test
    void containAllElements() {
        boolean result1 = LessonSix.containAllElements(stringList,"one","two","three","four","five");
        assertTrue(result1);

        boolean result2 = LessonSix.containAllElements(stringList,"six","seven");
        assertFalse(result2);

        boolean result3 = LessonSix.containAllElements(integerSet,1,2,3,4,5);
        assertTrue(result3);

        boolean result4 = LessonSix.containAllElements(integerSet,6,7);
        assertFalse(result4);

        boolean result5 = LessonSix.containAllElements(myClassSet,new MyClass(1,"one"),
                new MyClass(2,"two"),
                new MyClass(3,"three"),
                new MyClass(4,"four"),
                new MyClass(5,"five"));
        assertTrue(result5);

        boolean result6 = LessonSix.containAllElements(myClassSet,new MyClass(6,"six"),
                new MyClass(7,"seven"));
        assertFalse(result6);
    }

    @Test
    void unique(){
        Collection<String> result1 = LessonSix.unique(stringList,stringList1);
        assertEquals(3,result1.size());

        Collection<Integer> result2 = LessonSix.unique(integerSet,integerSet1);
        assertEquals(3,result2.size());

        Collection<MyClass> result3 = LessonSix.unique(myClassSet,myClassSet1);
        assertEquals(3,result3.size());
    }

    @Test
    void mergeMap(){
        Map<Integer,String> resultMap1 = LessonSix.mergeMap(testMapA,testMapB);
        assertEquals(7,resultMap1.entrySet().size());

        Map<Integer,MyClass> resultMap2 = LessonSix.mergeMap(testMapA1,testMapB1);
        assertEquals(7,resultMap2.entrySet().size());
    }
}