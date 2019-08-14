package com.kodilla.stream;

/*import com.kodilla.stream.beautifier.Poe*//*mBeautifier;
import com.kodilla.stream.iterate.NumbersGenerator;
import com.kodilla.stream.lambda.ExpressionExecutor;
import com.kodilla.stream.reference.Func*//*tionalCalculator;*/
import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
//import com.kodilla.stream.person.People;

public class StreamMain {
    public static void main(String[] args) {
        Forum forum = new Forum();
        Map<Integer, ForumUser> theResultMapOfForumUser = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getSex() == 'M')
                .filter(forumUser -> LocalDate.now().getYear() - forumUser.getDateOfBirth().getYear() > 19)
                .filter(forumUser -> forumUser.getPostsNumber() > 0)
                .collect(Collectors.toMap(ForumUser::getId, forumUser -> forumUser));

        theResultMapOfForumUser.entrySet().stream()
                .map(entry -> entry.getKey() +": " + entry.getValue())
                .forEach(s -> System.out.println(s));

        /*BookDirectory theBookDirectory = new BookDirectory();
        String theResultStringOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .map(Book::toString)
                .collect(Collectors.joining(",\n","<<",">>"));

        System.out.println(theResultStringOfBooks);*/
        /*Map<String, Book> theResultMapOfBooks = theBookDirectory.getList().stream()
                .filter(book -> book.getYearOfPublication() > 2005)
                .collect(Collectors.toMap(Book::getSignature, book -> book));

        System.out.println("# elements: " + theResultMapOfBooks.size());
        theResultMapOfBooks.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);*/

/*        People.getList().stream()
                .map(s -> s.toUpperCase())
                .forEach(System.out::println);
                .map(String::toUpperCase)
                .filter(s -> s.length() > 11)
                .map(s -> s.substring(0,s.indexOf(' ') + 2) + ".")
                .filter(s -> s.substring(0, 1).equals("M"))
                .forEach(s -> System.out.println(s));*/

        /*ExpressionExecutor expressionExecutor = new ExpressionExecutor();

        System.out.println("Calculating expressions with lambdas");
        expressionExecutor.executeExpression(10, 5, (a, b) -> a + b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a - b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a * b);
        expressionExecutor.executeExpression(10, 5, (a, b) -> a / b);

        System.out.println("Calculating expressions with method references");
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::multiplyAByB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::addAToB);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::subBFromA);
        expressionExecutor.executeExpression(3, 4, FunctionalCalculator::divideAByB);

        System.out.println("Beautify function.");
        PoemBeautifier poemBeautifier = new PoemBeautifier();
        poemBeautifier.beautify("small",beautifyText -> beautifyText.toUpperCase());
        poemBeautifier.beautify("BIG",beautifyText -> beautifyText.toLowerCase());
        poemBeautifier.beautify("BIG",beautifyText -> beautifyText.substring(0,1));
        poemBeautifier.beautify("abc",beautifyText -> beautifyText + "ABC");
        poemBeautifier.beautify("abc",beautifyText -> "ABC" + beautifyText);

        System.out.println("Using Stream to generate even numbers from 1 to 20");
        NumbersGenerator.generateEven(20);*/
    }
}