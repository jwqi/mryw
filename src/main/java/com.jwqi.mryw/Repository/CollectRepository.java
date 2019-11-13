package com.jwqi.mryw.Repository;

import com.jwqi.mryw.entity.Collect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface CollectRepository extends JpaRepository<Collect, Integer> {

    @Query(nativeQuery=true, value = "delete from collect where open_id=:openId and article_id=:articleId")
    @Modifying
    @Transactional
    void delCollection(@Param("openId")String openId, @Param("articleId")String articleId);
}
