package no.iterate.scozon.web

import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response._
import com.mongodb.casbah.Imports._
import com.mongodb.casbah.commons.conversions.scala.RegisterJodaTimeConversionHelpers
import org.joda.time.DateTime
import com.mongodb.casbah.commons.conversions.scala.DeregisterJodaTimeConversionHelpers

object IrcLog extends Plan {
  
  val mongoDb = MongoClient("192.168.1.60")("scozon")

  def intent = {
    case Path("/") =>
      
      val q = MongoDBObject("command" -> "PRIVMSG")
      val cursor = mongoDb("log").find(q).sort(MongoDBObject("time" -> -1)).limit(5)
      cursor.toList.reverse.foreach { x =>
      	x.getAs[String]("trailing") match {
      		case Some(text) => println(text) 
      		case None => // do nothing
      	}
      }
      Html(<h1>Hello world!</h1>) 
  }
  
}