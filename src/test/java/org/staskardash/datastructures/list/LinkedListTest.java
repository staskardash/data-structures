package org.staskardash.datastructures.list;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTest<T> extends AbstractListTest{

    @Override
    protected List<T> getList() {
        return new LinkedList<>();
    }
}
