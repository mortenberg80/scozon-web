package no.iterate.scozon.web

import unfiltered.filter.Plan
import unfiltered.request._
import unfiltered.response._

object IrcLog extends Plan {

  def intent = {
    case Path("/") =>
        Html(<h1>Hello world!</h1>)
  }
  
}