package com.magirui.stateless4j.l2;

import com.github.oxo42.stateless4j.StateMachineConfig;
import com.magirui.stateless4j.l1.CurrentState;
import com.magirui.stateless4j.l1.Trigger;

/**
 * @author MagiRui
 * @description
 * @date 6/25/21
 */
public class StateConver {

  protected static StateMachineConfig<CurrentState, Trigger> config =
      new StateMachineConfig<>();

  static {

    /**
     * 最初为small状态
     */
    config.configure(CurrentState.SMALL)

        /**
         * 从当前状态改变时所触发的动作
         */
        .onExit(new ExitAction())

        /**
         * 改变到当前状态时所触发的动作
         */
        .onEntry(new EntryAction())
    /**
     * 遇到蘑菇触发-->big状态
     */
      .permit(Trigger.MONSTER, CurrentState.BIG)
    /**
     * 花朵触发-->直接变为可攻击状态
     */
      .permit(Trigger.FLOWER, CurrentState.ATTACH)
    /**
     * 妖怪触发,死亡状态
     */
       .permit(Trigger.MONSTER, CurrentState.DEAD);


     config.configure(CurrentState.BIG)
         .ignore(Trigger.MUSHROOM)
         .permit(Trigger.FLOWER, CurrentState.ATTACH)
         .permit(Trigger.MONSTER,CurrentState.SMALL);


     config.configure(CurrentState.ATTACH)
         .ignore(Trigger.MUSHROOM)
         .ignore(Trigger.FLOWER)
         .permit(Trigger.MONSTER, CurrentState.SMALL);

     config.configure(CurrentState.DEAD)
         .ignore(Trigger.MUSHROOM)
         .ignore(Trigger.FLOWER)
         .ignore(Trigger.MONSTER);


  }
}
