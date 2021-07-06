package com.magirui.stateless4j.l2;

import com.github.oxo42.stateless4j.StateMachine;
import com.magirui.stateless4j.l1.CurrentState;
import com.magirui.stateless4j.l1.Trigger;

/**
 * @author MagiRui
 * @description
 * @date 6/25/21
 */
public class RunStateMachine {

  private static final StateMachine<CurrentState, Trigger>
    stateMachine = new StateMachine<CurrentState, Trigger>(
        CurrentState.SMALL, StateConver.config);


  public static void main(String[] args) {

    stateMachine.fire(Trigger.FLOWER);
    System.out.println("currentState-->" + stateMachine.getState());

    stateMachine.fire(Trigger.MONSTER);
  }
}
