package com.example.spring_boot1.api;

import com.example.spring_boot1.entity.News;
import com.example.spring_boot1.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/news")
public class NewsApi {
    @Autowired
    NewsRepository newsRepository;
    public static List<News> listNews;

    static {
        listNews = new ArrayList<>();
        listNews.add(new News(1, "Tin tuc moi nhat", "Tin 24h", "https://scontent.fhan7-1.fna.fbcdn.net/v/t1.6435-9/158742505_1104575593355909_3319842201103674313_n.jpg?_nc_cat=107&ccb=1-5&_nc_sid=09cbfe&_nc_ohc=Es4C_Ch4-wgAX-GdHz4&_nc_ht=scontent.fhan7-1.fna&oh=00_AT9GmjczG9YImh3Uy-6RWAxAwSP96I1b192FbRMuJVGc4g&oe=628647F5", "asdasd", "asdasd", "Con hoat dong"));

    }

    @RequestMapping(method = RequestMethod.GET)
    public List<News> getList(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int limit
    ) {
        return newsRepository.findAll();
    }
    @RequestMapping(method = RequestMethod.GET, path = "{id}")
    public News findById(@PathVariable int id){
        return newsRepository.findById(id).get();
    }

    @PostMapping
    public boolean save(@RequestBody News news) {
        if (news != null) {
            newsRepository.save(news);
            return true;
        } else {
            return false;
        }
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public News update(@PathVariable int id, @RequestBody News news) {
        News found = newsRepository.findById(id).get();
        if (found != null) {
            found.setTitle(news.getTitle());
            found.setDescription(news.getDescription());
            found.setImage(news.getImage());
            found.setCategory(news.getCategory());
            found.setCreateAt(news.getCreateAt());
            found.setUpdateAt(news.getUpdateAt());
            found.setStatus(news.getStatus());
        }
        newsRepository.save(found);
        return found;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public String delete(@PathVariable int id) {
        newsRepository.delete(newsRepository.findById(id).get());
        return "OK";
    }
}


