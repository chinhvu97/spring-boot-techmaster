package com.tiki.bookstore.repository;

import com.tiki.bookstore.model.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class Repository<T> {

    protected List<T> collections = new ArrayList<>();

    public abstract List<T> getAll();

}
