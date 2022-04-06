package uaslp.objetos.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;
import uaslp.objetos.list.List;
import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotValidIndexException;

public class LinkedListTest {

    @Test
    public void givenAnNewList_whenGetAt_ThenExceptionIsThrown(){
        LinkedList<String> list = new LinkedList<>();

        try{
            list.getAt(0);
            Assertions.fail("An exception should be thrown getting element zero");
        }catch (NotValidIndexException ex){
            // Exception was thrown
        }
    }

    @Test
    public void givenAnNewList_whenGetSize_ThenResultIsZero(){
        LinkedList<String> list = new LinkedList<>();

        int sizeOfList = list.getSize();

        Assertions.assertEquals(0, sizeOfList, "Size of list after creation must be zero");
    }

    @Test
    public void givenAnNewList_whenAddAnElement_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        LinkedList<String> list=new LinkedList<>();

        list.addAtFront("Hola");

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWhit1Element_whenAddAtFrontAnElement_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        LinkedList<String> list=new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtFront("Mundo");

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Mundo", list.getAt(0));
        Assertions.assertEquals("Hola", list.getAt(1));
    }

    @Test
    public void givenAnNewList_whenAddAtTail_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        LinkedList<String> list=new LinkedList<>();

        list.addAtTail("Hola");

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWhit1Element_whenAddAtTailAnElement_thenSizeIsTwo() throws NotNullValuesAllowedException, NotValidIndexException {
        LinkedList<String> list=new LinkedList<>();

        list.addAtTail("Hola");
        list.addAtTail("Mundo");

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Mundo", list.getAt(1));
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWithOneElement_whenRemove_ThenSizeIsZero() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.remove(0);

        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWithTwoElement_whenRemoveIndex0_ThenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        list.remove(0);

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Mundo", list.getAt(0));
    }

    @Test
    public void givenAListWithTwoElement_whenRemoveIndex3_ThenNotValidIndexExceptionIsThrown() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        Assertions.assertThrows(NotValidIndexException.class, ()->list.remove(3));
    }

    @Test
    public void givenAListWithTwoElement_whenAddAtFrontNullValue_ThenNotNullValueAllowedExceptionIsThrown() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->list.addAtFront(null));
    }

    @Test
    public void givenAListWithTwoElement_whenAddAtTailNullValue_ThenNotNullValueAllowedExceptionIsThrown() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->list.addAtTail(null));
    }

    @Test
    public void givenAListWithTwoElement_whenSetAtNullValue_ThenNotNullValueAllowedExceptionIsThrown() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->list.setAt(0,null));
    }

    @Test
    public void givenAListWithTwoElement_whenSetAtIndex3_ThenNotValidIndexExceptionIsThrown() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        Assertions.assertThrows(NotValidIndexException.class, ()->list.setAt(3, "Valor"));
    }

    @Test
    public void givenAListWithTwoElement_whenRemoveIndex1_ThenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        list.remove(1);

        Assertions.assertEquals(1, list.getSize());
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWithThreeElement_whenRemoveIndex1_ThenSizeIsTwo() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        list.remove(1);

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Adios", list.getAt(0));
        Assertions.assertEquals("Cruel", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElement_whenRemoveAtTail_ThenSizeIsTwo() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        list.remove(2);

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Adios", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElement_whenRemoveAll_ThenSizeIsZero() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        list.removeAll();

        Assertions.assertEquals(0, list.getSize());
    }

    @Test
    public void givenAListWithTwoElement_whenSetAt_ThenElementIsModified() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtFront("Adios");

        list.setAt(0,"Hola");

        Assertions.assertEquals(2, list.getSize());
        Assertions.assertEquals("Hola", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElement_whenIterator_ThenIteratorWorksOverAllThreeElements() throws NotValidIndexException, NotNullValuesAllowedException {
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adios");

        Iterator<String> iterator=list.getIterator();

        int size=list.getSize();

        Assertions.assertEquals(3, size);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Adios", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Mundo", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Cruel", iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }
}
