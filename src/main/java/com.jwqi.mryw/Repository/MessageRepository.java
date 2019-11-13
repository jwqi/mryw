package com.jwqi.mryw.Repository;


import com.jwqi.mryw.entity.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query(nativeQuery=true, value = "select * from message where status is null and date_time <= :currentTime")
    List<Message> findUnsendMessage(@Param("currentTime")String currentTime);

    @Query(nativeQuery=true, value = "update message set status = :status where id = :id")
    @Modifying
    @Transactional
    void updateMessageStatusById(@Param("id")Integer id, @Param("status")String status);
}
