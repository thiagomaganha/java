An API Gateway is a server that acts as a single entry point into a system, routing client requests to the appropriate backend services. 
It handles common cross-cutting concerns such as authentication, logging, rate limiting, and response transformation. By centralizing these responsibilities, an API Gateway simplifies client interactions and enhances the scalability and maintainability of microservices architectures.

🚀 Benefits of Using an API Gateway
  - Centralized Access Control: Manage authentication and authorization in one place.
  - Load Balancing: Distribute traffic across multiple service instances.
  - Service Discovery: Dynamically route requests to services registered in a discovery server.
  - Protocol Translation: Convert between protocols (e.g., HTTP to WebSocket).
  - Rate Limiting & Throttling: Protect services from overload.
  - Caching & Response Aggregation: Improve performance and reduce latency.
  - Monitoring & Logging: Gain insights into traffic and service health.

Spring Cloud Gateway is a modern, reactive, and lightweight API Gateway built on top of Spring WebFlux. It is designed to work seamlessly in Spring-based microservices environments and integrates tightly with the Spring ecosystem.

Key Advantages:
  ✅ Reactive and Non-blocking: Built on Project Reactor for high scalability.
  ✅ Eureka Integration: Supports dynamic routing via service discovery.
  ✅ Declarative Route Configuration: Define routes easily using YAML or Java DSL.
  ✅ Custom Filters: Create reusable filters for authentication, logging, etc.
  ✅ Spring Boot Native: Leverages Spring Boot’s simplicity and auto-configuration.
  ✅ Extensible: Easily extend with custom logic and filters.
