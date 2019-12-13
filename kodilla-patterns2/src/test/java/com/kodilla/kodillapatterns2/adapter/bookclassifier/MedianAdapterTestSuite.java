package com.kodilla.kodillapatterns2.adapter.bookclassifier;

import com.kodilla.kodillapatterns2.adapter.bookclasifier.MedianAdapter;
import com.kodilla.kodillapatterns2.adapter.bookclasifier.librarya.Book;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest(){
        //Given
        MedianAdapter medianAdapter = new MedianAdapter();
        Set<Book> books = new HashSet<>();
        books.add(new Book("Author1","Title1",2000,"1"));
        books.add(new Book("Author2","Title2",1900,"2"));
        books.add(new Book("Author3","Title3",2001,"3"));
        books.add(new Book("Author4","Title4",1950,"4"));
        books.add(new Book("Author5","Title5",1999,"5"));
        //When
        int medianResult = medianAdapter.publicationYearMedian(books);
        //Then
        Assert.assertEquals(1999,medianResult);
    }
}
