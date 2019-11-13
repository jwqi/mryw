package com.jwqi.mryw.Repository;

import com.jwqi.mryw.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {

    @Query(nativeQuery=true, value = "select * from article limit :index,1")
    Article getRandomArticle(@Param("index") int index);

    @Query(nativeQuery=true, value = "select t2.id,t2.name,t2.author,t2.text from collect t1 left join article t2 on t2.id=t1.article_id where t1.open_id=:openId")
    List<Article> getCollectionList(@Param("openId")String openId);
}
