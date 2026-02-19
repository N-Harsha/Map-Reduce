# Map-Reduce

### Problem statement:

- Imagine we have 10GB of logs (initially 1GB)
- We want to be able to compute meaningful metrics out of the logs
- This task is easily achievable on a single machine (vertical scaling), but we want to solve this problem using multiple machines (horizontal scaling)
- We want to extract meaningful metrics using MapReduce from the large log file

### Project Goal

- Explore distributed systems concepts
- Use technologies such as Spring Boot, Docker, gRPC, and message queues
- Build a solution that is close to real-world distributed computing
- Achieve distributed computation using MapReduce

### Solution Approach

We will use the Apriori algorithm implemented with MapReduce to solve the Market Basket Analysis problem. The goal is to find frequent itemsets and association rules from large-scale transaction data, enabling us to discover products that are often purchased together.

#### Why Apriori with MapReduce?
- Apriori is a classic algorithm for frequent itemset mining and association rule learning.
- MapReduce allows us to scale the computation horizontally across multiple machines, making it feasible to process very large transaction datasets.
- This approach is widely used in real-world scenarios for market basket analysis, recommendation systems, and retail analytics.

#### Technologies Used
- Spring Boot
- Docker
- gRPC
- Message Queues
- MapReduce paradigm

#### Example Use Case
Given a large transactions file containing product purchases, we will use the Apriori algorithm with MapReduce to identify sets of products that are frequently bought together. This can help businesses with product placement, cross-selling, and targeted marketing strategies.
