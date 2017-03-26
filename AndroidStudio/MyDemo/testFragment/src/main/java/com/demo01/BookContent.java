package com.demo01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by YR on 2015/5/31.
 */
public class BookContent {
    public static class Book{
        public Integer id;
        public String title;
        public String desc;
        public Book(Integer id,String title,String desc){
            this.id = id;
            this.title = title;
            this.desc = desc;
        }

        @Override
        public String toString() {
            return title;
        }
    }
    public static List<Book> ITEMS = new ArrayList<>();
    public static Map<Integer,Book> ITEMS_MAP = new HashMap<>();
    static{
            addItem(new Book(1,"C程序设计","讲述了C语言的基础知识"));
            addItem(new Book(2,"C++程序设计语言","讲述了C++程序设计语言的基本知识"));
            addItem(new Book(3,"Java编程思想","讲述了Java语言的详细知识，被誉为java兵书"));
    }
    private static void addItem(Book book){
        ITEMS.add(book);
        ITEMS_MAP.put(book.id,book);
    }
}
