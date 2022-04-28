package uaslp.objetos.list;

import uaslp.objetos.list.exception.NotNullValuesAllowedException;
import uaslp.objetos.list.exception.NotValidIndexException;

public interface Set <T> {

    void add(T element) throws NotValidIndexException, NotNullValuesAllowedException;

    void remove(T element) throws NotValidIndexException;

    boolean contains(T element) throws NotValidIndexException;

    Iterator<T> iterator();

    int size();
}
