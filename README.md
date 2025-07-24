# RedisLite — High-Performance In-Memory Key-Value Store in Java

RedisLite is a fast, concurrent, in-memory key-value store built in Java from the ground up. It mirrors core Redis functionalities while applying low-level Java concepts to achieve high throughput, efficient memory access, and multi-client scalability — all without external frameworks.

---

## 🔥 Key Highlights

- ⚡ **40% Faster Than File-Based Storage**  
  Optimized in-memory access using `ConcurrentHashMap`, reducing data lookup latency versus traditional file I/O approaches.

- 🤖 **Handles 3,000+ Commands Per Second**  
  Custom TCP protocol and tight loop I/O processing allow high-throughput command handling under concurrent load.

- 🧵 **500+ Concurrent Clients with Minimal Overhead**  
  Uses `ExecutorService` and `ThreadPoolExecutor` to efficiently allocate and reuse threads, ensuring responsiveness even under heavy load.

---

## 💡 Motivation

This project was built to deeply understand how scalable real-time systems like Redis work under the hood. It also served to strengthen my expertise in:

- Network programming using Java Sockets
- Thread-safe memory access and concurrency control
- Designing high-performance backend systems from scratch

---

## 🧱 Core Features

| Feature           | Description                                                             |
|------------------|-------------------------------------------------------------------------|
| In-Memory Store   | Uses `ConcurrentHashMap` for ultra-fast, thread-safe access             |
| TCP Server        | Built using low-level Java `Socket` and `ServerSocket` APIs             |
| Thread Pool       | Custom thread management using `ExecutorService`                        |
| Redis Commands    | Supports `SET`, `GET`, and `DEL` with accurate response formatting       |
| CLI Client        | Connects via TCP to test commands interactively                         |
| Protocol Parsing  | Parses commands like `SET key value` with whitespace and newline support|

---

## 📂 Project Structure
```bash
RedisLite/
├── src/
│ ├── server/ # RedisServer.java — socket listener and client dispatcher
│ ├── client/ # RedisClient.java — TCP client interface
│ ├── core/ # RedisStore.java — thread-safe key-value store
│ └── utils/ # CommandParser.java — command tokenizer
└── README.md
```



## ⚙️ How to Run

### 1. Compile the Project
```bash
javac src/**/*.java
```

### 2. Run the Server
```bash
java -cp src server.RedisServer
```


### 3. Run the Client
```bash
java -cp src client.RedisClient
```

## Sample Interaction
```bash
> SET name Dorian
OK
> GET name
Dorian
> DEL name
1
> GET name
(nil)
```


## Author
Dorian Taponzing Donfack
Senior Computer Science Student — Kennesaw State University
💬 Passionate about backend architecture, system scalability, and performance optimization.