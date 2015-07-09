package com.grijesh.qrkeygenerator.cache

/**
 * Created by grijesh on 7/7/15.
 */
import java.util.concurrent.TimeUnit

import com.google.common.cache.CacheBuilder
import com.typesafe.config.ConfigFactory
import org.springframework.cache.Cache
import org.springframework.cache.guava.GuavaCacheManager

/**
 * Created by Grijesh
 * Class will be used to hold the keys
 * Can Easily Integrate with spring framework
 */
class QRKeyKeeper {

  var config = ConfigFactory.load("keyKeeper.properties")
  private[QRKeyKeeper] var cacheManager:GuavaCacheManager = new GuavaCacheManager("keyKeeper")
  init()
  private[QRKeyKeeper] def init()={
    setCacheBuilder(CacheBuilder.newBuilder().expireAfterWrite(getProperty("timeout").toLong,TimeUnit.MINUTES))//.maximumSize(getProperty("maxelements").toLong))
  }

  private[QRKeyKeeper] def getProperty(property:String):String = config.getString(property)


  def put(key:String,value:String)={
    getCache.put(key,value)
  }


  def get(key:String):String = {
    if(!isValidationKey(key)) return null
    getCache.get(key).get().toString
  }

  private[QRKeyKeeper] def isValidationKey(key:String):Boolean={
    if(key==null || getCache.get(key)==null ) false
    else true
  }

  def remove(key:String)={
    getCache.evict(key)
  }

  private[QRKeyKeeper] def getCache:Cache ={
    synchronized{
      cacheManager.getCache("keyKeeper")
    }
  }

  def setCacheBuilder(cacheBuilder: CacheBuilder[AnyRef,AnyRef])={
    cacheManager.setCacheBuilder(cacheBuilder)
  }

}

object QRKeyKeeper {
  var instance: QRKeyKeeper = null

  def getInstance:QRKeyKeeper = {
    synchronized {
      if (instance == null) instance = new QRKeyKeeper
      instance
    }
  }
}