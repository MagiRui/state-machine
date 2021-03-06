package com.magirui.statematchine.l1.config;

import com.magirui.statematchine.l1.events.TurnstileEvents;
import com.magirui.statematchine.l1.states.TurnstileStates;
import java.util.EnumSet;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

/**
 * @author MagiRui
 * @description
 * @date 6/26/21
 */
@EnableStateMachine
@Configuration
public class StatemachineConfigurer
    extends EnumStateMachineConfigurerAdapter<TurnstileStates, TurnstileEvents> {

  @Override
  public void configure(StateMachineStateConfigurer<TurnstileStates, TurnstileEvents> states)
      throws Exception {

    states.withStates()
        .initial(TurnstileStates.Locked)//εε§ηΆζ:Locked
        .states(EnumSet.allOf(TurnstileStates.class));
  }

  @Override
  public void configure(
      StateMachineTransitionConfigurer<TurnstileStates, TurnstileEvents> transitions)
      throws Exception {

    transitions.withExternal()
        .source(TurnstileStates.Unlocked).target(TurnstileStates.Locked)
        .event(TurnstileEvents.PUSH).action(customerPassAndLock())
        .and()
        .withExternal()
        .source(TurnstileStates.Locked).target(TurnstileStates.Unlocked)
        .event(TurnstileEvents.COIN).action(turnstileUnlock());
  }

  @Override
  public void configure(
      StateMachineConfigurationConfigurer<TurnstileStates, TurnstileEvents> config)
      throws Exception {

    config.withConfiguration()
        .machineId("turnstileStateMachine");
  }

  public Action<TurnstileStates, TurnstileEvents> turnstileUnlock() {

    return xxx -> {

      System.out.println("θ§£ιζθ½¬ι¨,δ»₯δΎΏζΈΈε?’θ½ε€ιθΏ");
    };
  }


  public Action<TurnstileStates, TurnstileEvents> customerPassAndLock() {

    return xxx -> {

      System.out.println("ε½ζΈΈε?’ιθΏ,ιε?ζθ½¬ι¨");
    };
  }


}
