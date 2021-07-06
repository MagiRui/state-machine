package com.magirui.stateless4j.l2;

import com.github.oxo42.stateless4j.delegates.Action1;
import com.github.oxo42.stateless4j.transitions.Transition;
import com.magirui.stateless4j.l1.CurrentState;
import com.magirui.stateless4j.l1.Trigger;

/**
 * @author MagiRui
 * @description
 * @date 6/25/21
 */
public class EntryAction implements Action1<Transition<CurrentState, Trigger>> {

  @Override
  public void doIt(Transition<CurrentState, Trigger> arg1) {

    System.out.println("Entry to:" + arg1.getDestination());
  }
}
