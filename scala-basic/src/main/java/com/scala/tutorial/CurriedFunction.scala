package com.scala.tutorial

/**
 * Created by grijesh on 20/6/15.
 */
object CurriedFunction extends App{

  def mutiply(m:Int)= (n:Int) => m*n

  val mul2 = mutiply(2)
  println(mul2(3))


  def add(x:Int,y:Int) = x+y
  val addCurried = (add _).curried
  val add1 = addCurried(1)
  println(add1(5))
  //val addUnCurried = Function.uncurried(add _)
}
