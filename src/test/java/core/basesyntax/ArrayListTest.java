package core.basesyntax;

import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

public class ArrayListTest {
    private static final int ELEMENTS_COUNT = 1000;

    @Test
    public void addElementToArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Test");
        arrayList.add(null);
        arrayList.add("for");
        arrayList.add("Mate");
        Assert.assertEquals("Test failed! Size of array should be " + 4 + "but it is "
                + arrayList.size(), 4, arrayList.size());
        Assert.assertEquals("Test failed! Element is not added correctly",
                "Test", arrayList.get(0));
        Assert.assertNull("Test failed! Element is not added correctly", arrayList.get(1));
        Assert.assertEquals("Test failed! Element is not added correctly",
                "for", arrayList.get(2));
        Assert.assertEquals("Test failed! Element is not added correctly",
                "Mate", arrayList.get(3));
    }

    @Test
    public void addElementToArrayListByIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Test");
        arrayList.add("for");
        arrayList.add("Mate");
        Assert.assertEquals("Test failed! Size of array should be " + 3 + "but it is "
                + arrayList.size(), 3, arrayList.size());
        arrayList.add("Academy");
        Assert.assertEquals("Test", arrayList.get(0));
        Assert.assertEquals("Test failed! Can't correctly add element by index ",
                "Academy", arrayList.get(1));
        Assert.assertEquals("for", arrayList.get(2));
        Assert.assertEquals("Mate", arrayList.get(3));
        arrayList.add(null);
        Assert.assertEquals("Test failed! Size of array should be " + 5 + "but it is "
                + arrayList.size(), 5, arrayList.size());
        Assert.assertNull(arrayList.get(0));
        arrayList.add("value");
        Assert.assertEquals("Test failed! Can't correctly add element by index " + 5,
                "value", arrayList.get(5));
        Assert.assertEquals("Test failed! Size of array should be " + 6 + "but it is "
                + arrayList.size(), 6, arrayList.size());
    }


    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void addElementInTheNonExistentPosition() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add(5, "Second");
    }

    @Test
    public void addListToArrayList() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Test");
        arrayList.add("for");
        arrayList.add("Mate");
        Assert.assertEquals(3, arrayList.size());
        ArrayList<String> newArrayList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            newArrayList.add("academy_" + i);
            newArrayList.add("Kyiv_" + i);
        }
        arrayList.addAll(newArrayList);
        Assert.assertEquals("Test failed! Size of array should be " + 43 + "but it is "
                + arrayList.size(), 43, arrayList.size());
        Assert.assertEquals("academy_0", arrayList.get(3));
        Assert.assertEquals("Kyiv_0", arrayList.get(4));
        Assert.assertEquals("Kyiv_19", arrayList.get(42));
    }

    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void addElementInTheNegativePosition() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String");
        arrayList.add(-6, "Java");
    }

    @Test
    public void checkingResize() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            arrayList.add("First + " + i);
        }
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            Assert.assertEquals("Test failed! Array can't resize correctly",
                    "First + " + i, arrayList.get(i));
        }
    }

    @Test
    public void checkingResizeInAddByIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            arrayList.add("First + " + i);
            Assert.assertEquals("Test failed! Size of array should be " + (i + 1) + "but it is "
                    + arrayList.size(), i + 1, arrayList.size());
        }
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            Assert.assertEquals("Test failed! Array can't resize correctly",
                    "First + " + (ELEMENTS_COUNT - i - 1), arrayList.get(i));
        }
    }

    @Test
    public void removeElementFromArrayListByIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String");
        arrayList.add("null");
        arrayList.add("Java");
        arrayList.add("Private");
        Assert.assertEquals(4, arrayList.size());
        String actualResult = arrayList.remove(2);
        Assert.assertEquals("Test failed! Returned value should be " + actualResult,
                "Java", actualResult);
        Assert.assertEquals("Test failed! Size of array after removed element should be "
                + 3 + "but it is " + arrayList.size(), 3, arrayList.size());
        Assert.assertEquals("Test failed! Can't remove element by index ",
                "Private", arrayList.get(2));
        actualResult = arrayList.remove(0);
        Assert.assertEquals("Test failed! Returned value should be " + actualResult,
                "String", actualResult);
        Assert.assertEquals(2, arrayList.size());
        Assert.assertNull("Test failed! Can't remove element by index ", arrayList.get(0));
        actualResult = arrayList.remove(1);
        Assert.assertEquals("Test failed! Returned value should be null",
                "Private", actualResult);
        Assert.assertEquals(1, arrayList.size());
        Assert.assertNull("Test failed! Can't remove element by index ", arrayList.get(0));
    }

    @Test
    public void removeElementFromFullArrayListByIndex() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(0);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.add(5);
        arrayList.add(6);
        arrayList.add(7);
        arrayList.add(8);
        arrayList.add(9);
        Assert.assertEquals(10, arrayList.size());
        Integer actualResult = arrayList.remove(9);
        Assert.assertEquals(String.format("Test failed! Returned value should be %d, "
                + "but was %d\n", 9, actualResult), 9, actualResult.longValue());
        int actualSize = arrayList.size();
        Assert.assertEquals(String.format("Test failed! Size of array after removing element "
                + "should be %d, but it is %d\n", 9, actualSize), 9, actualSize);
    }

    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void removeElementFromArrayListByNonExistentIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(1,"String");
        arrayList.add("Java");
        arrayList.add("Private");
        arrayList.remove(3);
    }

    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void removeElementFromArrayListByNegativeIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add(1,"String");
        arrayList.remove(-5);
    }

    @Test
    public void removeElementFromArrayListByValue() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("String");
        arrayList.add("Another string");
        arrayList.add(null);
        arrayList.add("Java");
        arrayList.add("Private");
        arrayList.add(null);

        Assert.assertNull("Test failed! Returned value should be null", null);
        int actualSize = arrayList.size();
        Assert.assertEquals(String.format("Test failed! Size of array after removing element "
                + "should be %d, but it is %d\n", 3, actualSize), 3, actualSize);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeElementFromArrayListByNonExistentValue() {
        ArrayList<String> list = new ArrayList<>();
        list.add("String");
        list.add("Java");
        list.add("Private");
        Assert.assertNull(list.remove("Public"));
    }

    @Test
    public void removeObjectValueByValue() {
        Cat firstCat = new Cat("Fantic", "grey");
        Cat secondCat = new Cat("Barsik", "black");
        Cat thirdCat = new Cat("Tom", "white");
        Cat fourthCat = new Cat("Barsik", "black");
        ArrayList<Cat> cats = new ArrayList<>();
        cats.add(firstCat);
        cats.add(secondCat);
        cats.add(thirdCat);
        cats.add(fourthCat);
    }

    @Test
    public void setValueInIndex() {
        ArrayList<String> list = new ArrayList<>();
        list.add("5");
        list.add("115");
        Assert.assertEquals("115", list.get(1));
        list.set(1, "511");
        Assert.assertEquals("Test failed! Wrong value at index 0", "115",
                list.get(0));
    }

    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void setValueInTheNonExistentPosition() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.set(2, "Third");
    }

    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void setValueInTheNegativePosition() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.set(-2, "Third");
    }

    @Test
    public void getElementByIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add("Third");
        arrayList.add(null);
        String actualResult = arrayList.get(2);
        Assert.assertEquals("Third", actualResult);
        actualResult = arrayList.get(3);
        Assert.assertNull(actualResult);
    }

    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void getElementByNonExistedIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.add("Second");
        arrayList.add("Third");
        arrayList.get(3);
    }

    @Test(expected = ArrayListIndexOutOfBoundsException.class)
    public void getElementByNegativeIndex() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("First");
        arrayList.get(-2);
    }
}
