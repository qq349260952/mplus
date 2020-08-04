package com.yocike.mplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class Book {
    @TableId(type = IdType.ID_WORKER)
    private long id;
    private String author;
//    private Integer fkId;
    private String name;
    private Timestamp createTime;
    @Haha(value = "yocike")
    private Timestamp updateTime;

}
