package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotSuchElementException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class ArrayListTest {

    @Test
    public void givenAnNewList_whenAddAtTail_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Hola");

        Assertions.assertEquals(1, array.getSize());
        Assertions.assertEquals("Hola", array.getAt(0));
    }

    @Test
    public void givenAnNewList_whenAddAtTail2Elements_thenSizeIs2() throws NotNullValuesAllowedException, NotValidIndexException {
        ArrayList<String> array = new ArrayList<>(1);

        array.addAtTail("Hola");
        array.addAtTail("Mundo");

        Assertions.assertEquals(2, array.getSize());
    }

    @Test
    public void givenAListWithTwoElement_whenAddAtTailNullValue_ThenNotNullValueAllowedExceptionIsThrown() throws NotValidIndexException, NotNullValuesAllowedException {
        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->array.addAtTail(null));
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");

        Assertions.assertEquals(1, array.getSize());
        Assertions.assertEquals("Hola", array.getAt(0));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtFrontNullValue_thenNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {

        ArrayList<String> array=new ArrayList<>();
        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        Assertions.assertThrows(NotNullValuesAllowedException.class,()->array.addAtFront(null));
    }

    @Test
    public void givenAListWithOneElement_whenAddAtFront_thenSizeIsTwo() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");

        array.addAtFront("Mundo");

        Assertions.assertEquals(2, array.getSize());
        Assertions.assertEquals("Mundo", array.getAt(0));
        Assertions.assertEquals("Hola", array.getAt(1));
    }

    @Test
    public void givenAListWithOneElement_whenRemove_thenSizeIsZero() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");

        array.remove(0);

        Assertions.assertEquals(0,array.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemove_thenSizeIsOne() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        array.remove(0);

        Assertions.assertEquals(1,array.getSize());
        Assertions.assertEquals("Mundo",array.getAt(0));
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveIndex1_thenSizeIsOne() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        array.remove(1);

        Assertions.assertEquals(1,array.getSize());
        Assertions.assertEquals("Hola",array.getAt(0));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveIndex1_thenSizeIsTwo() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Mundo");
        array.addAtTail("Cruel");
        array.addAtFront("Adiós");

        array.remove(1);

        Assertions.assertEquals(2,array.getSize());
        Assertions.assertEquals("Adiós",array.getAt(0));
        Assertions.assertEquals("Cruel",array.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveElementAtTail_thenSizeIsTwo() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");

        array.remove(2);

        Assertions.assertEquals(2,array.getSize());
        Assertions.assertEquals("Adiós",array.getAt(0));
        Assertions.assertEquals("Mundo",array.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveAll_thenSizeIsZero() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");

        array.removeAll();

        Assertions.assertEquals(0,array.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenSetAt_thenElementIsModified() throws NotNullValuesAllowedException{

        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Mundo");
        array.addAtFront("Adiós");

        array.setAt(0,"Hola");

        Assertions.assertEquals(2,array.getSize());
        Assertions.assertEquals("Hola",array.getAt(0));
        Assertions.assertEquals("Mundo",array.getAt(1));
    }

    @Test
    public void givenAListWithTwoElements_whenSetAtNullValue_thenNotNullValuesAllowedExceptionIsThrown() throws NotNullValuesAllowedException {

        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->array.setAt(0,null));
    }

    @Test
    public void givenAListWithThreeElements_whenGetIterator_thenIteratorWorksOverThreeElements() throws NotNullValuesAllowedException, NotValidIndexException, NotSuchElementException {

        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");

        Iterator<String> iterator = array.getIterator();

        Assertions.assertEquals(3,array.getSize());
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Adiós",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Mundo",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Cruel",iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }
}
