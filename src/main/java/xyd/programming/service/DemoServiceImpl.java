package xyd.programming.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DemoServiceImpl implements DemoService {

    @Override
    public String getWelcomeMessage(String user) {
        return "Hello, " + user + "! Welcome!";
    }

    @Override
    public String getWelcomeMessage() {
        return "Welcome to the page!";
    }

}
