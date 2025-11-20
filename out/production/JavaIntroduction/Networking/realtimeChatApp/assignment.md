# 🎓 **Assignment: Real-Time Chat System using Java Sockets**

## 📝 **Problem Statement**

You are to implement a **real-time command line chat system** using **Java sockets**. The system should support:

### ✅ Phase 1: Server ↔ Client Chat

* A client connects to the server
* Client sends a message (from terminal)
* Server replies back (from terminal)
* This continues in real time until either party types `"exit"`

### ✅ Phase 2: Two Clients Talk via Server

* Two clients connect to the server
* The server acts as a **bridge**
* When Client A sends a message, the server forwards it to Client B
* When Client B replies, the server sends it back to Client A
* They can chat **in real-time** until either sends `"exit"`

---

# 🧱 **System Architecture**

```
+----------+          +----------+          +----------+
|  Client1 |<-------->|  Server  |<-------->|  Client2 |
+----------+          +----------+          +----------+
```

* All communication is text-based
* The server handles each client in a **separate thread**
* In Phase 2, server **forwards messages** from one client to the other

---

## 🧑‍💻 **Phase 1 Example (Server ↔ Client)**

**Client Side:**

```bash
Connected to server.
You: Hello Server!
Server: Hello there! How can I help you?
You: exit
Disconnected from server.
```

**Server Side:**

```bash
Client connected: 127.0.0.1
Client: Hello Server!
You: Hello there! How can I help you?
Client disconnected.
```

---

## 👥 **Phase 2 Example (Client ↔ Client via Server)**

**Client 1 Terminal:**

```bash
Waiting for another user to join...
[Chat started]
You: Hey! Who are you?
Stranger: I'm your chat buddy for now.
You: Let's ace this assignment!
Stranger: Haha! Good luck to both of us.
You: exit
```

**Client 2 Terminal:**

```bash
Waiting for another user to join...
[Chat started]
Stranger: Hey! Who are you?
You: I'm your chat buddy for now.
Stranger: Let's ace this assignment!
You: Haha! Good luck to both of us.
Stranger: exit
Connection closed.
```

**Server Terminal:**

```bash
Client-1 connected: 127.0.0.1
Client-2 connected: 127.0.0.1
[Server] Connecting Client-1 ↔ Client-2
[Relaying] C1: Hey! Who are you?
[Relaying] C2: I'm your chat buddy for now.
...
```

---

## 💡 **Guidelines**

### 🔌 Server

* Accepts incoming clients via `ServerSocket.accept()`
* Maintains a list of connected clients (can just be 2 for now)
* Starts a new thread per client
* Forwards messages between the two clients
* If any client sends `"exit"`, notify the other and close both connections

### 💬 Client

* Connects to server using `Socket`
* Starts:

    * One thread to **read messages from the server**
    * One thread to **write messages to the server**
* Input from terminal, output to terminal
* Exits cleanly on `"exit"`

---

## 📁 Suggested File Structure

```
chatapp/
├── models/
│   └── Message.java          # optional: timestamp, sender, text
├── client/
│   └── ChatClient.java
├── server/
│   └── ChatServer.java
├── util/
│   └── SocketWrapper.java    # for serialization abstraction
```

---