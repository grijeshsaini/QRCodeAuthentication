package com.grijesh.qrgenerator.impl

import java.awt.image.BufferedImage
import java.io.{ByteArrayInputStream, ByteArrayOutputStream, InputStream}
import javax.imageio.ImageIO

import com.google.zxing.client.j2se.MatrixToImageWriter
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
import com.google.zxing.{BarcodeFormat, EncodeHintType, MultiFormatWriter}
import com.grijesh.qrgenerator.contract.QRCodeGenerator
import com.grijesh.qrgenerator.exception.ValidationException.InvalidInputException

/**
 * Created by Grijesh Saini on 5/7/15.
 */
class QRCodeImpl extends QRCodeGenerator {

  import collection.JavaConverters._

  val charset: String = "UTF-8"
  var map = Map.empty[EncodeHintType, ErrorCorrectionLevel]
  map += EncodeHintType.ERROR_CORRECTION -> ErrorCorrectionLevel.L

  //todo exception handling after validation
  override def createQRCode(text: String, height: Int, width: Int): InputStream = {
    validateInputParameters(height, width, text)

    //Represent a 2D matrix of Bits
    //todo remove Option not required
    val matrix: Option[BitMatrix] = Some(new MultiFormatWriter().encode(
      new String(text.getBytes(charset), charset),
      BarcodeFormat.QR_CODE, width, height, map.asJava))


    //Creating Image from Matrix
    val image: BufferedImage = MatrixToImageWriter.toBufferedImage(matrix.get)
    val byteArrayOutputStream: ByteArrayOutputStream = new ByteArrayOutputStream()

    //Creating bytes
    ImageIO.write(image, "PNG", byteArrayOutputStream)

    //Input Stream of bytes
    val is: InputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray)
    is
  }

  //todo needs to check , Is it the best way to validate ?
  def validateInputParameters(height: Int, width: Int, text: String): Unit = {
    height match {
      case _ if height < 0 => throw new InvalidInputException("Height Cannot be negative")
      case _ =>
    }

    width match {
      case _ if width < 0 => throw new InvalidInputException("Width Cannot be negative")
      case _ =>
    }

    text match {
      case null => throw new InvalidInputException("Input Text Should not be null")
      case _ =>
    }
  }
}

object QRCodeImpl {
  var codeImpl: QRCodeImpl = null

  def getInstance() = {
    synchronized {
      codeImpl match {
        case null =>
          codeImpl = new QRCodeImpl()
          codeImpl
        case _ => codeImpl
      }
    }
  }
}



