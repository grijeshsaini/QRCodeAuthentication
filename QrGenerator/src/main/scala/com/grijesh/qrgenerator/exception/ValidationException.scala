package com.grijesh.qrgenerator.exception

/**
 * Created by grijesh on 5/7/15.
 */
object ValidationException {
   class InvalidInputException(message: String) extends BaseExceptionClass(message) {
    override def getMessage(message:String): String = super.getMessage
  }
}