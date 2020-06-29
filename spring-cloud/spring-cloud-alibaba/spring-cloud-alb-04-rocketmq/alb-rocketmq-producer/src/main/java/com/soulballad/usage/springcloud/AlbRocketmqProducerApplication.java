package com.soulballad.usage.springcloud;

import com.soulballad.usage.springcloud.model.Msg;
import com.soulballad.usage.springcloud.outptu.MySource;
import com.soulballad.usage.springcloud.service.SendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.support.MessageBuilder;

@SpringBootApplication
@EnableBinding({MySource.class})
public class AlbRocketmqProducerApplication {

    @Bean
    public CustomerRunner customerRunner() {
        return new CustomerRunner("output1");
    }

    @Bean
    public CustomerRunner customerRunner1() {
        return new CustomerRunner("output3");
    }

    @Bean
    public CustomerRunnerWithTransactional transactionalRunner() {
        return new CustomerRunnerWithTransactional();
    }

    public static void main(String[] args) {
        SpringApplication.run(AlbRocketmqProducerApplication.class, args);
    }

    public static class CustomerRunner implements CommandLineRunner {

        private final String bindingName;

        @Autowired
        private SendService sendService;

        @Autowired
        private MySource mySource;

        public CustomerRunner(String bindingName) {
            this.bindingName = bindingName;
        }

        @Override
        public void run(String... args) throws Exception {
            if ("output1".equals(bindingName)) {
                int count = 5;
                for (int index = 1; index <= count; index++) {
                    String msgContent = "msg-" + index;
                    if (index % 3 == 0) {
                        sendService.send(msgContent);
                    } else if (index % 3 == 1) {
                        sendService.sendWithTags(msgContent, "tagStr");
                    } else {
                        sendService.sendObject(new Msg(index, "msg"), "tagObj");
                    }
                }
            } else if ("output3".equals(bindingName)) {
                int count = 20;
                for (int index = 1; index <= 20; index++) {
                    String msgContent = "pullMsg-" + index;
                    mySource.output3().send(MessageBuilder.withPayload(msgContent).build());
                }
            }
        }
    }

    public static class CustomerRunnerWithTransactional implements CommandLineRunner {

        @Autowired
        private SendService sendService;

        @Override
        public void run(String... args) throws Exception {
            sendService.sentTransactionalMsg("transactional-msg1", 1);
            sendService.sentTransactionalMsg("transactional-msg2", 2);
            sendService.sentTransactionalMsg("transactional-msg3", 3);
            sendService.sentTransactionalMsg("transactional-msg4", 4);
        }
    }
}
