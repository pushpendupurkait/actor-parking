package com.pushp

import akka.actor.Actor

class ParkingGateOne extends Actor{

  override def receive = {
    case vehicle => {
      println(s"Entered Vehicle $vehicle")
    }
  }

}
