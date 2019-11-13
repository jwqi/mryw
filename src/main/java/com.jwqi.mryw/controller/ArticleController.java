package com.jwqi.mryw.controller;

import com.jwqi.mryw.Repository.ArticleRepository;
import com.jwqi.mryw.Repository.CollectRepository;
import com.jwqi.mryw.entity.Article;
import com.jwqi.mryw.entity.Collect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/article")
public class ArticleController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CollectRepository collectRepository;

    @GetMapping("/random")
    public Article randomArticle() {
        long count = articleRepository.count();
        return articleRepository.getRandomArticle((int) (Math.random() * count) + 1);
    }

    @PostMapping("/collect")
    public String collect(@RequestBody Collect collect) {
        String msg = "";
        try {
            collectRepository.save(collect);
            msg = "收藏成功";
        } catch (Exception e) {
            logger.error("收藏失败", e);
            msg = "收藏失败";
        }
        return msg;
    }

    @GetMapping("/getCollectionList")
    public List<Article> getCollectionList(String openId) {
        return articleRepository.getCollectionList(openId);
    }

    @DeleteMapping("/delCollection")
    public String delCollection(String openId, String articleId) {
        String msg = "";
        try {
            collectRepository.delCollection(openId, articleId);
            msg = "删除成功";
        } catch (Exception e) {
            logger.error("删除失败", e);
            msg = "删除失败";
        }
        return msg;
    }
}
