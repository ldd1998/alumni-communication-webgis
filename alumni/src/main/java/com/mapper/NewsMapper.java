package com.mapper;

import com.entity.News;

import java.util.List;

public interface NewsMapper {
    News queryNewDetailById(String newId);

    List<News> queryLimitNews(int page, int limit);
}
