## ⚙️ Technologies Used

- Java 8+
- Hibernate 5.4
- MySQL 8
- Maven
- Eclipse IDE

## 🗃️ Features

- Add a new person
- Display all persons
- Find a person by ID
- Update a person’s:
  - Age
  - City
  - Email
  - Mobile number
- Delete a person by I

## ✅ Prerequisites

- **Java JDK 8 or above**
- **Apache Maven**
- **MySQL Server**
- **Eclipse IDE with Maven support**


## 📦 Database Configuration

Create a database named `hibernate_PMS` in MySQL (or it will auto-create if not exists):

```sql
CREATE DATABASE hibernate_PMS;

## Give the user name and password of your MySQL Workbench
<property name="hibernate.connection.username">root</property>
<property name="hibernate.connection.password">your-password</property>

