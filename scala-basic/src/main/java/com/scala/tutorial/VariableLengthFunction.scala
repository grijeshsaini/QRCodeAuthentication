package com.scala.tutorial

/**
 * Created by grijesh on 20/6/15.
 */
object VariableLengthFunction extends App{

  def capitalizeAll(args : String*) = {
    args map( arg =>
      arg.capitalize
      )
  }

  println(capitalizeAll("grijesh","saini"))

}
