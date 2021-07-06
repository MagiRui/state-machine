package com.magirui.statematchine.l1;

import com.magirui.statematchine.l1.events.TurnstileEvents;
import com.magirui.statematchine.l1.states.TurnstileStates;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.statemachine.StateMachine;

/**
 * @author MagiRui
 * @description
 * @date 6/26/21
 */

@SpringBootApplication
public class StateMachineApplication implements CommandLineRunner {

  @Autowired
  private StateMachine<TurnstileStates, TurnstileEvents> statemachine;

  public static void main(String[] args) {

    SpringApplication.run(StateMachineApplication.class, args);
  }

  @Override
  public void run(String... strings) throws Exception{

    statemachine.start();


    System.out.println("--- coin ---");
    statemachine.sendEvent(TurnstileEvents.COIN);

    System.out.println("--- push ---");
    statemachine.sendEvent(TurnstileEvents.PUSH);
    statemachine.stop();
  }

}
