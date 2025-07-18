This project implements a Eureka Server using Spring Cloud Netflix Eureka, providing a robust and scalable foundation for service discovery in a microservices architecture.

In a microservices architecture, services are often deployed across dynamic environments where instances can scale up or down, move between hosts, or restart frequently. 
The Service Discovery pattern addresses the challenge of locating these services at runtime without hardcoding their network addresses.

Instead of relying on static configurations, services register themselves with a Service Registry, and clients query this registry to discover the current location of a service.

Why is Service Discovery Important?

  ✅ Dynamic Scalability: Automatically adapts to changes in service instances.
  
  ✅ Fault Tolerance: Removes unreachable instances from the registry, improving resilience.
  
  ✅ Decoupling: Services communicate using logical names, not hardcoded URLs.
  
  ✅ Load Balancing: Enables client-side or gateway-based load balancing.
  
  ✅ Simplified Configuration: Reduces the need for manual updates in service configurations.

Eureka:
  Eureka is a REST-based service registry provided by Netflix and integrated into the Spring Cloud ecosystem. It plays a central role in enabling service discovery in distributed systems.

Key Components:

  - Eureka Server: Acts as the service registry. All microservices register themselves here and periodically send heartbeats to indicate they are alive.
    
  - Eureka Clients: Microservices that register with the Eureka Server and use it to discover other services.

How It Works:

  - Registration: Each microservice registers itself with the Eureka Server on startup.
    
  - Heartbeat: Services send regular heartbeats to maintain their registration.
    
  - Discovery: Clients (or API Gateways) query Eureka to find the current list of available instances for a given service.
    
  - Load Balancing: Eureka can be used with Ribbon or Spring Cloud LoadBalancer to distribute traffic across instances.

    
