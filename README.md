# degitx-simulator
Simulation system for DeGItX

[![Build Status](https://github.com/cqfn/degitx-simulator/workflows/Build%20degitx-simulator/badge.svg)](https://github.com/cqfn/degitx-simulator)
![Build white paper document](https://github.com/cqfn/degitx-simulator/workflows/Build%20white%20paper%20document/badge.svg)
[![License](https://img.shields.io/badge/license-MIT-green.svg)](https://github.com/cqfn/degitx-simulator/blob/master/README.md)

## How it works?

White paper is available here: https://central.artipie.com/degit/wp/simulator-latest.pdf

## Usage

User write node service logic as interface:
```java

// simulating sending data from node1 to node2
class Example implements Service {

  @Override
  void run(Hardware hardware) {  
    Network net = hardware.network();
    if (net.address().equals(new Address("/simulator/node1")) { // we are on `node1`
      // sending data via simulator hardware network
      net.send(new Address("/simulator/node2"), new Data("example data".getBytes()));
    } else {
      // waiting for incoming data
      Queue<Request> queue = net.receive();
      Request req;
      while ((req = queue.poll()) == null) {
        // busy wait
      }
      // save data to storage
      hardware.storage().write("/path", req.data());
    }
  }
}
```
