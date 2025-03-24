# GameStore
Game Store is a Java desktop application built with NetBeans, JPA, and MySQL, designed to help store employees register and manage customers, their gaming consoles, and requested repair or maintenance services efficiently.

# 🎮 GameTech Service Manager 

A desktop application for video game stores to manage:
- **Customer console ownership**
- **Service tracking**
- **Bi-directional client-console lookup**

## 🖥️ Core Features
### Relationship Management
- 👥 Add customers & associate consoles
- 🎮 Register consoles with owners
- 🔄 ID-based lookup (client ↔ console)

### Service Tracking
- 🔧 Log repair/maintenance services
- 📅 Track service dates
- 📋 View service history

### Database Operations
- 💾 MySQL CRUD via JDBC
- 🔍 Complex queries (joins between tables)
- 🛡️ Data validation


🎨 GUI Preview
Main Interface
Swing screenshots showing:

Customer registration form

Console association panel

Service tracking table


💡 How to Run
Import the SQL schema

Configure DBConnector.java with your MySQL credentials

Compile & execute:

bash
Copy
javac -cp mysql-connector-java.jar:. com/gamestore/Main.java
java -cp mysql-connector-java.jar:. com.gamestore.Main
🌟 Skills Demonstrated
Swing GUI development

MySQL relationship modeling (1:Many)

JDBC transaction management

MVC pattern implementation

UI/UX design for desktop apps
