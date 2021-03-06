package com.example.spring_boot1.service;

import com.example.spring_boot1.entity.News;
import com.example.spring_boot1.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NewsService {
    @Autowired
    private NewsRepository newsRepository;
    public List<News> findAll(){
        return newsRepository.findAll();
    }
    public Optional<News> findById(int id){
        return newsRepository.findById(id);
    }
    public News save(News news){
        return newsRepository.save(news);
    }
    public void deleteById(int id){
        newsRepository.deleteById(id);
    }
}
