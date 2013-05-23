package no.iterate.scozon.web

import unfiltered.jetty.Http

object Main extends App {

  Http(8080).filter(IrcLog).run
  
}