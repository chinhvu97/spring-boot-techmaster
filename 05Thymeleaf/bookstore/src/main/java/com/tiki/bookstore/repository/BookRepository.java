package com.tiki.bookstore.repository;

import com.tiki.bookstore.model.Book;
import com.tiki.bookstore.model.Genre;

import java.util.List;
import java.util.Optional;

public class BookRepository extends Repository<Book> {

    public BookRepository() {
        collections.add(new Book(1, "Cô gái trên tàu", "Giữa một kẻ nghiện rượu, một kẻ dối trá và một kẻ ngoại tình, ta nên tin ai?", Genre.NOVEL));
        collections.add(new Book(2, "Vogue số tháng 9", "Model thay đổi ngành công nghiệp Mỹ", Genre.MAGAZINES));
        collections.add(new Book(3, "Conan tập 100", "Cuộc họp trước chương trình", Genre.COMIC));
        collections.add(new Book(4, "Sóng", "Sóng bắt đầu từ gió", Genre.POEM));
    }

    @Override
    public List<Book> getAll() {
        return collections;
    }

}
