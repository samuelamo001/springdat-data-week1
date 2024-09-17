
# Spring Boot Application with MySQL and Redis

This project demonstrates a Spring Boot application that integrates with MySQL for database management and Redis for caching, all containerized using Docker. The guide provides instructions for both local development and cloud deployment.

## Prerequisites

Before starting, ensure you have:

- Docker installed on your machine
- A working knowledge of Docker and Spring Boot
- MySQL and Redis credentials for environment setup

## Table of Contents

- [Getting Started](#getting-started)
- [Environment Configuration](#environment-configuration)
- [Building and Running the Application](#building-and-running-the-application)
- [Docker Architecture](#docker-architecture)
- [Deploying to the Cloud](#deploying-to-the-cloud)
- [Useful Commands](#useful-commands)
- [Best Practices](#best-practices)

## Getting Started

### Clone the repository

```bash
git clone https://github.com/yourusername/your-repo-name.git
cd your-repo-name
```

## Environment Configuration

Before running the application, ensure you have the following environment variables defined in a `.env` file:

```bash
MYSQL_ROOT_PASSWORD=your_root_password
MYSQL_DATABASE=your_database
SPRING_DATASOURCE_URL=jdbc:mysql://mysql:3306/your_database
SPRING_DATASOURCE_USERNAME=root
SPRING_DATASOURCE_PASSWORD=your_root_password
SPRING_DATA_REDIS_HOST=redis
SPRING_DATA_REDIS_PORT=6379
```

## Building and Running the Application

To build and run the application locally using Docker:

1. Build the Docker containers:

   ```bash
   docker-compose up --build
   ```

2. Access the application at `http://localhost:8080`. The application will be connected to MySQL as the primary database and Redis as the caching solution, both of which are managed within Docker containers.

## Docker Architecture

### Dockerfile

The Dockerfile follows a multi-stage build process for optimizing the final container image:

- **Stage 1 (deps)**: Prepares the environment and downloads dependencies.
- **Stage 2 (package)**: Packages the Spring Boot application.
- **Stage 3 (extract)**: Extracts the layers from the Spring Boot JAR for optimized container startup.
- **Final Stage**: Runs the JAR using `JarLauncher` with a non-root user for enhanced security.

### Docker Compose Configuration

The `docker-compose.yml` file defines the services and their interactions:

- **MySQL**: Acts as the primary database for the application.
- **Redis**: Used for caching.
- **Server**: Represents the Spring Boot application.

The `server` service depends on the health of both the MySQL and Redis containers before starting.

### MySQL Service

- **Image**: `mysql:8.0`
- **Volumes**: Persistent storage for MySQL data at `mysql-data:/var/lib/mysql`.
- **Healthcheck**: Ensures MySQL is running and healthy before starting dependent services.
- **Ports**: Exposes port `3306` for MySQL.

### Redis Service

- **Image**: `redis:alpine`
- **Healthcheck**: Ensures Redis is available for connections.
- **Ports**: Exposes port `6379` for Redis.

## Deploying to the Cloud

To deploy the application in a cloud environment:

1. Build the image for the appropriate architecture:

   ```bash
   docker build --platform=linux/amd64 -t myapp .
   ```

2. Push the image to your Docker registry:

   ```bash
   docker push myregistry.com/myapp
   ```

3. Deploy the container in your cloud environment, ensuring MySQL and Redis services are correctly configured.

## Useful Commands

- **Build and run containers**: `docker-compose up --build`
- **Stop running containers**: `docker-compose down`
- **Check logs for a specific service**: `docker-compose logs <service_name>`
- **Restart services**: `docker-compose restart`

## Best Practices

- Use multi-stage Docker builds to reduce image size and improve security.
- Configure health checks for services like MySQL and Redis to ensure they are fully operational before the Spring Boot application starts.
- Ensure environment variables are securely managed, especially sensitive information such as database credentials.
- When deploying to production, use a Docker image optimized for the target cloud environment and push it to a secure container registry.