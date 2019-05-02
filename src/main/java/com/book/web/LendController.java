package com.book.web;

import com.book.domain.Book;
import com.book.domain.ReaderCard;
import com.book.service.BookService;
import com.book.service.LendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class LendController {

    private LendService lendService;
    @Autowired
    public void setLendService(LendService lendService) {
        this.lendService = lendService;
    }
    private BookService bookService;
    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/lendbook.html")
    public ModelAndView bookLend(HttpServletRequest request){
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        Book book=bookService.getBook(bookId);
       ModelAndView modelAndView=new ModelAndView("admin_book_lend");
       modelAndView.addObject("book",book);
       return modelAndView;
    }
    //TODO reader_id AND new view

    @RequestMapping("/readerlendbook.html")
    public ModelAndView readerbookLend(HttpServletRequest request){

        //TODO 空指针
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        Book book=bookService.getBook(bookId);
        ReaderCard readerCard=(ReaderCard) request.getSession().getAttribute("readercard");
        ModelAndView modelAndView=new ModelAndView("reader_book_lend");
        modelAndView.addObject("readerId",readerCard.getReader_id());
        modelAndView.addObject("book",book);
        return modelAndView;
    }


    //TODO new reader_lend
    @RequestMapping("/lendbookdo.html")
    public String bookLendDo(HttpServletRequest request,RedirectAttributes redirectAttributes,int readerId){
        long bookId=Integer.parseInt(request.getParameter("id"));
        boolean lendsucc=lendService.bookLend(bookId,readerId);
        if (lendsucc){
            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
            return "redirect:/allbooks.html";
        }else {
            redirectAttributes.addFlashAttribute("succ", "图书借阅失败！");
            return "redirect:/allbooks.html";
        }
    }

    //TODO new reader_lend
    @RequestMapping("/readerlendbookdo.html")
    public String readerBookLendDo(HttpServletRequest request,RedirectAttributes redirectAttributes,int readerId){
        long bookId=Integer.parseInt(request.getParameter("id"));
        boolean lendsucc=lendService.bookLend(bookId,readerId);
        if (lendsucc){
            redirectAttributes.addFlashAttribute("succ", "图书借阅成功！");
            return "redirect:/readerbooks.html";
        }else {
            redirectAttributes.addFlashAttribute("succ", "图书借阅失败！");
            return "redirect:/readerbooks.html";
        }
    }


    @RequestMapping("/returnbookdo.html")
    public String bookReturnDo(HttpServletRequest request,RedirectAttributes redirectAttributes,int readerId){
        long bookId=Integer.parseInt(request.getParameter("id"));
         //TODO
        boolean lendsucc=lendService.bookReturn(bookId,readerId);
        if (lendsucc){
            redirectAttributes.addFlashAttribute("succ", "图书归还成功！");
            return "redirect:/allbooks.html";
        }else {
            redirectAttributes.addFlashAttribute("succ", "图书归还失败！");
            return "redirect:/allbooks.html";
        }


    }

    @RequestMapping("/returnbook.html")
    public ModelAndView bookReturn(HttpServletRequest request,RedirectAttributes redirectAttributes){
        long bookId=Integer.parseInt(request.getParameter("bookId"));
        Book book=bookService.getBook(bookId);
        ModelAndView modelAndView=new ModelAndView("admin_book_return");
        modelAndView.addObject("book",book);
        return modelAndView;
    }


    @RequestMapping("/lendlist.html")
    public ModelAndView lendList(){

        ModelAndView modelAndView=new ModelAndView("admin_lend_list");
        modelAndView.addObject("list",lendService.lendList());
        return modelAndView;
    }
    @RequestMapping("/mylend.html")
    public ModelAndView myLend(HttpServletRequest request){
        ReaderCard readerCard=(ReaderCard) request.getSession().getAttribute("readercard");
        ModelAndView modelAndView=new ModelAndView("reader_lend_list");
        modelAndView.addObject("list",lendService.myLendList(readerCard.getReader_id()));
        return modelAndView;
    }
    @RequestMapping("/deleteSernum.html")
    public String deleteBook(HttpServletRequest request,RedirectAttributes redirectAttributes){
        long sernum=Integer.parseInt(request.getParameter("sernum"));
        int res=lendService.deleteSernum(sernum);

        if (res==1){
            redirectAttributes.addFlashAttribute("succ", "记录日志删除成功！");
            return "redirect:/lendlist.html";
        }else {
            redirectAttributes.addFlashAttribute("error", "记录日志删除失败！");
            return "redirect:/lendlist.html";
        }
    }




}
