package com.kodilla.kodillapatterns2.adapter.bookclasifier.libraryb;

import java.util.Map;

public interface BookStatistics {
    int averagePublicationYear(Map<BookSignature, Book> books);

    int medianPublicationYear(Map<BookSignature, Book> books);
}
