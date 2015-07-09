package com.grijesh.qrkeygenerator.contract

/**
 * Created by grijesh on 6/7/15.
 */
trait QRKeyGenerator {
  def createKey(length:Int):String
}
