package com.yocike.mplus;


import com.yocike.mplus.entity.User;
import com.yocike.mplus.mapper.UserMapper;

import java.util.concurrent.CyclicBarrier;

public class Task implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private UserMapper userMapper;
    public Task(CyclicBarrier cyclicBarrier, UserMapper userMapper) {
        this.cyclicBarrier = cyclicBarrier;
        this.userMapper = userMapper;
    }

    @Override
    public void run() {
        try {
            // 等待所有任务准备就绪
            cyclicBarrier.await();
            // 测试内容
            User user = userMapper.selectById(10);
            user.setName("qhds");
//            String[] split = Thread.currentThread().getName().split("-");


//            int j = new Integer(split[3]);

//            user.setVersion(j);
            int i = userMapper.updateById(user);

            System.out.println("hello"+Thread.currentThread().getName()+"------->"+i);
            if(i==0){
                throw new Exception();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try{
           throw new Exception();
        }catch (Exception e){

            e.printStackTrace();
        }
    }
}