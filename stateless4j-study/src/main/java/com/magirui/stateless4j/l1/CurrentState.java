package com.magirui.stateless4j.l1;

/**
 * @author MagiRui
 * @description
 * @date 6/25/21
 */
public enum CurrentState {

  
  /**
   *
   * 初始化小形态
   */
  SMALL,

  /**
   * 吃到一个蘑菇时的大形态
   */
  BIG,

  /**
   *
   * 吃到花朵,可攻击形态
   */
  ATTACH,

  /**
   * godead
   */
  DEAD
}
