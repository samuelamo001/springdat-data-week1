# Project Name

## Overview

This project is designed to showcase how to integrate logging, configure the ELK Stack (Elasticsearch, Logstash, and Kibana), and set up Logstash pipelines for processing and visualizing logs. The following steps will guide you through the setup of logging configurations, the ELK Stack, and Logstash.

## Table of Contents

1. [Logging Configuration](#logging-configuration)
2. [ELK Stack Setup](#elk-stack-setup)
3. [Logstash Pipeline Setup](#logstash-pipeline-setup)

---

## Logging Configuration

The project uses **Logback** for logging, with configurations 
to log to both the console and a file. 
You can find the logging configuration file under `src/main/resources/logback.xml`.


## ELK STACK
The ELK Stack consists of three main components:

Elasticsearch: For storing and searching log data.
Logstash: For processing log data before sending it to Elasticsearch.
Kibana: For visualizing the log data stored in Elasticsearch.
1. Installing the ELK Stack
   Follow the official ELK installation guide to install Elasticsearch, Logstash, and Kibana.

Elasticsearch will be available at http://localhost:9200.
Kibana will be available at http://localhost:5601.
2. Configuring Elasticsearch
   Once installed, you may need to update Elasticsearch's configuration file (elasticsearch.yml) located in the config directory (/etc/elasticsearch/elasticsearch.yml on most Linux systems).

3. Configuring Kibana
   You can configure Kibana by updating its configuration file (kibana.yml) typically located in /etc/kibana/kibana.yml.

4. Logstash Pipeline Setup
   Logstash Configuration
   Logstash is configured to process logs from a file and output them to Elasticsearch.


## Prerequisites
Java 8 or higher
Maven (for building the project)
Docker (optional, if you're using Docker for the ELK Stack)
ELK Stack (Elasticsearch, Logstash, Kibana)




