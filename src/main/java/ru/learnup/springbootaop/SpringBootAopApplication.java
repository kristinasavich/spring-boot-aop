package ru.learnup.springbootaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import ru.learnup.springbootaop.service.Game;
import ru.learnup.springbootaop.service.LogMethod;

@SpringBootApplication
public class SpringBootAopApplication {

	private static final Logger log = LoggerFactory.getLogger(SpringBootAopApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(SpringBootAopApplication.class, args);
		Game game = context.getBean(Game.class);
		game.start();

		//вся логика аспектов в классе GameAspect
	}

}
