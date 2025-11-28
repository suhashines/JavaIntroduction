<h1 style="text-align: center;"> Coder Vai, Java Project</h1>

# 📡 Real-Time Chat System Using Java Sockets

A simple but powerful **command-line chat application** built using Java's networking API (`ServerSocket`, `Socket`).
This project teaches how to implement:

* Server ↔ Client chat (Phase 1)
* Client ↔ Client chat through relay server (Phase 2)
* Multithreading for real-time communication
* Clean networking with a **SocketWrapper** helper class

---

## 🗂 Project Structure

```
chatapp/
├── models/
│   └── Message.java
├── client/
│   └── ChatClient.java
├── server/
│   └── ChatServer.java
└── util/
    └── SocketWrapper.java
```

### 🔍 What each file does:

| File                 | Description                                                                         |
| -------------------- | ----------------------------------------------------------------------------------- |
| `ChatServer.java`    | Accepts client connections, spawns handler threads, relays messages between clients |
| `ChatClient.java`    | Connects to server, starts reader & writer threads for real-time chat               |
| `SocketWrapper.java` | Simplifies sending/receiving text messages using buffered streams                   |
| `Message.java`       | (Optional) Model demonstrating structured message representation                    |

---

# 🧠 Project Approach (Step-by-Step Explanation)

This project is built in **two phases**, gradually increasing complexity.

---

## 🔌 **Phase 1 — Server ↔ Single Client Chat**

Before jumping into multi-client chat, students learn:

1. How the server waits for a client using `ServerSocket.accept()`
2. How a client connects using `Socket`
3. How both sides communicate using:

    * InputStream (BufferedReader)
    * OutputStream (PrintWriter)
4. How the server runs a **console thread** to talk to the connected client
5. How to detect `"exit"` and close the connection properly

**Why this matters:**
It teaches the basics of TCP communication and prepares students for multi-client logic.

---

## 👥 **Phase 2 — Two Clients Chat via Server**

Once two clients connect:

1. The server stores references for:

   ```
   client1
   client2
   ```

2. Each client gets its own handler thread.

3. When Client A sends a message:

    * handler reads the message
    * server forwards it to Client B
    * server logs `[Relaying] C1: message`

4. When Client B replies:

    * same logic, reversed direction

5. Either client sending `"exit"` triggers:

    * notifying the other user
    * closing both sockets
    * cleaning references

**Important design decision:**
We use a **unified handler** so that even if Client 1 joined early, the handler transitions automatically when Client 2 arrives.

---

## 🔄 Threading Model

### Server

* **1 main thread** → accepts client connections
* **1 console thread** → allows server operator to type replies in single-client mode
* **1 thread per client** → handles reading from that client and relaying messages

### Client

* **1 reader thread** → continuously prints incoming messages
* **1 writer loop** → reads from terminal and sends to server

This multi-threaded approach ensures **non-blocking**, **real-time** chat.

---

# 🧰 Key Utility: `SocketWrapper`

To simplify socket I/O, we wrap the socket with:

* `send(String msg)`
* `receive()`
* automatic UTF-8 encoding
* thread-safe write operations
* clean connection closing

This reduces boilerplate and helps students focus on **logic**, not low-level streams.

---

# ▶️ Running the Project

### 1. Compile the whole project

```
javac $(find chatapp -name "*.java")
```

### 2. Start the server

```
java server.ChatServer
```

### 3. Start Client 1 (new terminal)

```
java client.ChatClient
```

### 4. Start Client 2 (another terminal)

```
java client.ChatClient
```

Now the two clients can chat with each other through the server.

---

# 🧪 Example Interaction

### Server

```
[Server] Listening on port 12345
Client-1 connected: 127.0.0.1
Client-2 connected: 127.0.0.1
[Server] Connecting Client-1 ↔ Client-2
[Relaying] C1: Hey there!
[Relaying] C2: Hi! Nice to meet you.
```

### Client 1

```
Connected to server.
You: Hey there!
Stranger: Hi! Nice to meet you.
You: exit
Disconnected from server.
```

### Client 2

```
Connected to server.
Stranger: Hey there!
You: Hi! Nice to meet you.
Stranger: exit
Connection closed.
```

---

# 🛡 Clean Exit & Error Handling

* `"exit"` closes the chat for both clients.
* Server detects disconnected clients automatically.
* Server operator can type:

  ```
  shutdown
  ```

  to stop the server safely.

---

