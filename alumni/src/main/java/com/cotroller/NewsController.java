package com.cotroller;

import com.entity.News;
import com.mapper.NewsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class NewsController {
    @Autowired
    private NewsMapper newsMapper;

    @GetMapping("/news")
    public String news(int page,int limit,Model model){
        List<News> newsList = newsMapper.queryLimitNews((page-1)*limit,limit);
        List<News> newsListHot = newsMapper.queryLimitNews((page-1)*limit,limit-2);

        model.addAttribute("newsList",newsList);
        model.addAttribute("page",page);
        model.addAttribute("newsListHot",newsListHot);
        return "news/news";
    }

    @GetMapping("/admin/news")
    public String newsList(int page,int limit,Model model){
        List<News> newsList = newsMapper.queryLimitNews((page-1)*limit,limit);
        model.addAttribute("newsList",newsList);
        model.addAttribute("page",page);
        return "admin/news/newsList";
    }

//    @GetMapping("/news/new1")
//    public String newsDetail(){
//        return "/news/news-detail";
//    }

    @GetMapping("/news/newsDetail")
    public String newsDetail(String newId, Model model){
       News news = newsMapper.queryNewDetailById(newId);
        List<News> newsList = newsMapper.queryLimitNews(0,8);
        model.addAttribute("newsList",newsList);

        model.addAttribute("news",news);
       return "news/news-detail";
    }
}
