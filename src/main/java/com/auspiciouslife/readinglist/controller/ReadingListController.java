package com.auspiciouslife.readinglist.controller;

import com.auspiciouslife.readinglist.entities.Book;
import com.auspiciouslife.readinglist.repositories.ReadingListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping("/readingList")
public class ReadingListController {
    private ReadingListRepository readingListRepository;

    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository) {
        this.readingListRepository = readingListRepository;
    }

//    /**
//     * reader's readinglist
//     * @param reader
//     * @param model
//     * @return
//     */
//    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
//    public String readerBooks(@PathVariable("reader") String reader, Model model) {
//
//        List<Book> readingList = readingListRepository.findByReader(reader);
//        if (readingList != null) {
//            model.addAttribute("books", readingList);
//        }
//        return "readingList";
//    }

    /**
     * list all books
     * @date 20220608
     */
    @RequestMapping(method = RequestMethod.GET)
    public String allBooks(Model model) {

        List<Book> readingList = (List<Book>) readingListRepository.findAll();
        if (readingList != null) {
            model.addAttribute("books", readingList);
        }
        return "reader_readingList";
    }

    /**
     * View a specific book by its id.
     * @param id
     * @param model
     * @return
     */
    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    public String showbook(@PathVariable Long id, Model model) {
//        model.addAttribute("book", readingListRepository.findById(id));
        readingListRepository.findById(id).ifPresent(o -> model.addAttribute("book", o));
        System.out.println("book.info" + readingListRepository.findById(id));
        return "bookshow";
    }

    /**
     * Add a new book
     * @param
     * @param
     * @return
     */
    @GetMapping(value = "/new")
    public String addToReadingList(Model model) {
        model.addAttribute("book", new Book());
        return "bookform";
    }

    /**
     * Edit a book
     */
    @RequestMapping(value = "/book/edit/{id}")
    public String editbook(@PathVariable Long id, Model model) {
        model.addAttribute("book", readingListRepository.findById(id));
        return "bookform";
    }
//    public String addToReadingList(Book book) {
//        readingListRepository.save(book);
//        return "redirect:/readingList/book/" + book.getId();
//    }
    /**
     * save book to database
     * @param book
     * @return
     */
    @RequestMapping(value = "book", method = RequestMethod.POST)
    public String saveBook(Book book) {
        readingListRepository.save(book);
        return "redirect:/readingList/book/" + book.getId();
    }
    /**
     * Delete book by its id.
     * @return
     */
    @RequestMapping(value = "/delete/{id}")
    public  String delete(@PathVariable Long id) {
        readingListRepository.deleteById(id);
        return "redirect:/readingList";
    }
}

//@Controller
//public class GreetingController {
//    @GetMapping("/greeting")
//    public String greetingForm(Model model) {
//        model.addAttribute("greeting", new Greeting());
//        return "greeting";  }
//    @PostMapping("/greeting")
//    public String greetingSubmit(@ModelAttribute Greeting greeting, Model model) {
//        model.addAttribute("greeting", greeting);
//        return "result";  }
//}