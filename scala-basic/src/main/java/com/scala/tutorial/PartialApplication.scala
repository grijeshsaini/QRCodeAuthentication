package com.scala.tutorial

/**
 * Created by grijesh on 20/6/15.
 */
object PartialApplication extends App{

  def adder(m:Int,n:Int) =   m+n

  val add2 = adder(2,_:Int)
  println(add2(3))

}
