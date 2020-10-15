# degitx-simulator
Simulation system for DeGItX

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
