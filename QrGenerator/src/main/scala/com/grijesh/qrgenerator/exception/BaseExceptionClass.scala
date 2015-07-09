package com.grijesh.qrgenerator.exception

/**
 * Created by grijesh on 5/7/15.
 */
abstract class BaseExceptionClass(message:String) extends Exception{

   def getMessage(message:String):String={
    message
  }

}
