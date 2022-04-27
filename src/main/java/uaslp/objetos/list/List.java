package uaslp.objetos.list;

import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotValidIndexException;
import uaslp.objetos.list.linkedlist.LinkedListIterator;

public interface List <T> {

    void addAtTail(T data) throws NotNullValuesAllowedException;

    void addAtFront(T data) throws NotNullValuesAllowedException;

    void remove(int index) throws NotValidIndexException;

    void removeAll();

    void setAt(int index, T data) throws NotValidIndexException, NotNullValuesAllowedException;

    T getAt(int index) throws NotValidIndexException;

    Iterator<T> getIterator();

    int getSize();
}
