package com.grijesh.qrgenerator.contract

import java.io.InputStream

/**
 * Created by Grijesh Saini on 5/7/15.
 */
trait QRCodeGenerator {
  def createQRCode(text:String,height:Int,width:Int):InputStream
}
