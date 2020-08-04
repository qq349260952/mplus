package com.yocike.mplus;

import com.yocike.mplus.entity.User;
import com.yocike.mplus.entity.Book;
import com.yocike.mplus.mapper.UserMapper;
import com.yocike.mplus.mapper.BookMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


@RunWith(SpringRunner.class)
@SpringBootTest
class MplusApplicationTests {
    @Autowired
    private BookMapper bookMapper;
    @Autowired
    private UserMapper bMapper;
    @Autowired

    @Test
    void contextLoads() {
        List<Book> books = bookMapper.selectList(null);
        System.out.println(books);
    }
    @Test
    void addBook(){
        User b = new User();
        b.setName("yocike");
        b.setAge(32);
        b.setEmail("ewjqk");

        bMapper.insert(b);
    }
    @Test
    void testCycleBarrier () {
        // 并发次数
        int testCount = 5;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(testCount);
        ArrayList<Future<String>> results = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(testCount);
        for (int i = 0; i < testCount; i++) {
            executorService.execute(new Task(cyclicBarrier,bMapper));
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    @Test
    public void leguansuo(){
        User user = bMapper.selectById(10);
        user.setId(10L);
        user.setName("逮住就是干");
        int i = bMapper.updateById(user);
        System.out.println(i);
    }

}
