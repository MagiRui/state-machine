package com.magirui.stateless4j.l1;

import com.github.oxo42.stateless4j.StateMachine;

/**
 * @author MagiRui
 * @description
 * @date 6/25/21
 */
public class RunStateMachine {

  private static StateMachine<CurrentState, Trigger> stateMachine =
    new StateMachine<CurrentState, Trigger>(CurrentState.SMALL, StateConver.config);


  public static void main(String[] args) {

    stateMachine.fire(Trigger.FLOWER);
    System.out.println("currentState-->" + stateMachine.getState());
  }


}
