package com.soulballad.usage.springboot;

import java.math.BigDecimal;
import java.security.SecureRandom;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.soulballad.usage.springboot.model.Order;
import com.soulballad.usage.springboot.model.User;
import com.soulballad.usage.springboot.repository.OrderRepository;
import com.soulballad.usage.springboot.repository.UserRepository;

/**
 * @author ：soulballad
 * @version : v1.0
 * @apiNote : 预置数据（user，order）
 * @since ：2020/5/23 12:05
 */
@Component
public class InitializeDataCommand implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("zhangsan", 20, "2000-01-01", "shenzhen", "13888888888");
        User user2 = new User("lisi", 21, "1999-01-01", "shanghai", "13777777777");
        User user3 = new User("wangwu", 22, "1998-01-01", "beijing", "13666666666");
        User user4 = new User("zhaoliu", 23, "1997-01-01", "guangzhou", "13555555555");
        User user5 = new User("sunqi", 24, "1996-01-01", "wuhan", "13444444444");

        SecureRandom random = SecureRandom.getInstance("SHA1PRNG", "SUN");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        List<User> users = userRepository.saveAll(Arrays.asList(user1, user2, user3, user4, user5));

        List<Order> orders = users.stream().map(user -> {
            Order order = new Order();
            order.setUserId(user.getId());
            order.setOrderCode("OC202005231205000" + (users.indexOf(user) + 1));
            order.setOrderDate(dateTimeFormatter.format(now.minusDays(random.nextInt(100))));
            order.setTotalMoney(BigDecimal.valueOf(random.nextDouble() * random.nextInt(10000)));
            return order;
        }).collect(Collectors.toList());

        orderRepository.saveAll(orders);
    }
}
