package uaslp.objetos.list.hashset;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotSuchElementException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class HashSetTest {

    @Test
    public void createANewHashSet_WhenTheSizeIsInitial(){
        HashSet<String> hashSet=new HashSet<>();

        Assertions.assertEquals(0, hashSet.size());
    }

    @Test
    public void getAHashSet_WhenAddTwoEqualElements_ThenAddOnlyOneOfThese() throws NotValidIndexException, NotNullValuesAllowedException {
        HashSet<String> hashSet=new HashSet<>();

        hashSet.add("One");
        hashSet.add("One");
        Assertions.assertEquals(1, hashSet.size());
    }

    @Test
    public void GivenAHashSet_addOneHundredElements_ThenReorganize() throws NotNullValuesAllowedException, NotValidIndexException {

        HashSet<String> hashSet = new HashSet<>();

        for(int i=0; i<100; i++){
            hashSet.add("Index: " + i);
        }

        Iterator<String> iterator = hashSet.iterator();
        int size = hashSet.size();
        HashSet<String> iterations = new HashSet<>();

        Assertions.assertEquals(100, size);
        Assertions.assertNotNull(iterator);

        while(iterator.hasNext()){
            iterations.add(iterator.next());
        }

        for(int i=0; i<100; i++){
            Assertions.assertTrue(hashSet.contains("E: " + i));
        }

    }

    @Test
    public void givenAHashSet_AddOneElement_ThenTheElementIsInTheHashSet() throws NotValidIndexException, NotNullValuesAllowedException{

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("One");

        Assertions.assertEquals(1, hashSet.size());
        Assertions.assertTrue(hashSet.contains("One"));
    }

    @Test
    public void givenAHashset_AndThreeElements_VerifyIfFirstElementExists() throws  NotValidIndexException, NotNullValuesAllowedException{
        HashSet<String> hashSet=new HashSet<>();

        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");

        Assertions.assertEquals(3, hashSet.size());
        Assertions.assertFalse(hashSet.contains("Four"));
    }

    @Test
    public void givenAHashSetWithTwoElements_WhenRemoveTheFirstElement_ThenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException{
        HashSet<String> hashSet=new HashSet<>();

        hashSet.add("One");
        hashSet.add("Two");

        hashSet.remove("One");

        Assertions.assertEquals(1, hashSet.size());
    }

    @Test
    public void givenASetWithThreeElements_whenGetIterator_thenIterator() throws NotNullValuesAllowedException, NotValidIndexException {

        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("One");
        hashSet.add("Two");
        hashSet.add("Three");


        Iterator<String> iterator = hashSet.iterator();

        int size = hashSet.size();
        HashSet<String> iterations = new HashSet<>();

        Assertions.assertEquals(3, size);

        Assertions.assertNotNull(iterator);

        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        iterations.add(iterator.next());

        Assertions.assertFalse(iterator.hasNext());

        Assertions.assertTrue(hashSet.contains("One"));
        Assertions.assertTrue(hashSet.contains("Two"));
        Assertions.assertTrue(hashSet.contains("Three"));

        Assertions.assertThrows(NotSuchElementException.class, iterator::next);
    }


}
