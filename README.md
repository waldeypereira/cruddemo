# cruddemo

A simple CRUD demo using **JPA with EntityManager** in **Spring Boot**.  
This project demonstrates how to create, read, update, and delete `Student` entities using manual DAO implementation and `EntityManager`.

---

## 🛠 Technologies Used

- Java 17+
- Spring Boot 3
- Jakarta Persistence (JPA)
- H2 / MySQL / PostgreSQL (your choice)
- Maven

---

## 📂 Project Structure

com.wfrocha.cruddemo
├── CruddemoApplication.java # Spring Boot main class with CommandLineRunner
├── dao
│ ├── StudentDAO.java # Interface for DAO
│ └── StudentDAOImpl.java # Implementation using EntityManager
├── entity
│ └── Student.java # JPA Entity


---

## 🚀 Features Implemented

- Create a single `Student`  
- Create multiple `Student`s  
- Read a `Student` by ID  
- (Future) Update a `Student`  
- (Future) Delete a `Student`  

All operations are done through **DAO layer** using **EntityManager** to understand the core of JPA.

---

## 📥 How to Run

1. Clone the repository:

```bash
git clone https://github.com/yourusername/cruddemo.git
cd cruddemo
Build and run the application:

mvn spring-boot:run


Check the console to see the CRUD operations being executed.

📖 Notes

This project is for learning purposes.

Once comfortable with EntityManager, you can refactor it to use Spring Data JpaRepository for simpler CRUD.
