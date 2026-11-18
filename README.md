# Real-Time Chat

A Java and Spring Boot chat application with live messaging over WebSocket/STOMP and chat history stored in MySQL.

## Features

- Broadcast messages to connected clients with STOMP and SockJS.
- Save messages with Spring Data JPA and MySQL.
- Load previous messages when the chat page opens.
- Responsive dark interface built with Thymeleaf, HTML, JavaScript, and Bootstrap.
- Send messages with Enter and automatically scroll to the latest message.

## Stack

Java 17 · Spring Boot · WebSocket · STOMP · SockJS · Spring Data JPA · MySQL · Thymeleaf · Bootstrap

## Run locally

1. Install Java 17 or newer and MySQL, and create a database named `chat_app`.
2. Clone this repository and open its directory.
3. Set these environment variables in your terminal or IDE run configuration:

| Variable | Purpose | Default |
| :--- | :--- | :--- |
| `DB_PASSWORD` | Your local MySQL password | Required |
| `DB_USERNAME` | MySQL username | `root` |
| `DB_URL` | JDBC connection URL | `jdbc:mysql://localhost:3306/chat_app` |

Keep actual credentials outside Git. Spring Boot reads these from the process environment; this project does not automatically load a `.env` file.

4. Start the application with the included Maven wrapper:

**Windows (PowerShell)**

```powershell
.\mvnw.cmd spring-boot:run
```

**macOS / Linux**

```sh
sh mvnw spring-boot:run
```

5. Open `http://localhost:8080/chat` in two browser tabs, enter a name in each, and send a message.

The current WebSocket configuration allows the origin `http://localhost:8080`.

## Message flow

```text
Browser → /app/sendMessage → ChatController → MySQL
                                  ↓
                          /topic/message → connected browsers
```

`GET /messages` returns stored messages; `GET /chat` serves the chat interface.

## Scope

This is a learning project with a shared chat room. User authentication, private conversations, and pagination are not implemented. The setup instructions describe the current source; a successful local run has not yet been verified as part of this documentation update.

## Contributing

Ideas, bug reports, and focused improvements are welcome. Include reproduction steps for bugs and explain the purpose of a proposed change.

Built by [Devansh Mishra](https://github.com/devanshmishra865).
