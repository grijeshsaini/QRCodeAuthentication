package com.grijesh.qrkeygenerator.impl

import com.grijesh.qrgenerator.exception.ValidationException.InvalidInputException
import com.grijesh.qrkeygenerator.contract.QRKeyGenerator

import scala.util.Random

/**
 * Created by grijesh on 6/7/15.
 */
object QRKeyGeneratorImpl extends QRKeyGenerator{
  override def createKey(length: Int): String = {
    validate(length)
    Random.alphanumeric.take(length).mkString
  }

  def validate(length:Int)={
    length match {
      case _ if length < 0 => throw new InvalidInputException("Length should be greater than zero")
      case _ =>
    }
  }

}
