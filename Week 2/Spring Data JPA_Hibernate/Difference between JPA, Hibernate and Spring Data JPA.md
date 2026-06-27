# Difference between JPA, Hibernate and Spring Data JPA

## Objective

Understand the role of **JPA**, **Hibernate**, and **Spring Data JPA**, how they are related, and how they simplify database operations in Java applications.

---

# Before ORM

Before Object Relational Mapping (ORM) frameworks were introduced, developers used **JDBC (Java Database Connectivity)** to interact with relational databases.

### Traditional JDBC Workflow

```text
Java Object
      │
      ▼
Write SQL Manually
      │
      ▼
Execute SQL
      │
      ▼
Read ResultSet
      │
      ▼
Convert ResultSet → Java Object
```

### Challenges with JDBC

Developers had to:

* Write SQL queries manually.
* Open and close database connections.
* Manage transactions.
* Handle exceptions.
* Convert every database row into Java objects manually.

This process was repetitive, time-consuming, and error-prone.

---

# What is JPA?

**JPA (Java Persistence API)** is a Java **specification** (JSR 338) that defines a standard way to map Java objects to relational databases using ORM.

Think of JPA as a **rule book**. It defines **how persistence should work**, but it does **not** perform any database operations by itself.

### JPA Defines

* Entity mapping
* Primary key mapping
* Table mapping
* Relationships between entities
* Standard interfaces and annotations

### Common JPA Annotations

```java
@Entity
@Id
@Column
@OneToMany
@ManyToOne
```

> **Note:** JPA is only a specification. It requires an implementation such as Hibernate to communicate with the database.

---

# What is Hibernate?

**Hibernate** is an **ORM (Object Relational Mapping) Framework** that implements the JPA specification.

Unlike JPA, Hibernate performs the actual work of interacting with the database.

### Responsibilities of Hibernate

* Converts Java objects into SQL queries.
* Executes SQL queries.
* Maps database records back into Java objects.
* Manages sessions and transactions.
* Provides caching and lazy loading.

### Hibernate Workflow

```text
Java Object
      │
      ▼
Hibernate ORM
      │
      ▼
SQL Query
      │
      ▼
Relational Database
      │
      ▼
Result
      │
      ▼
Java Object
```

---

# Why Spring Data JPA?

Although Hibernate reduces much of the complexity compared to JDBC, developers still need to write boilerplate code for:

* Session management
* Transaction management
* CRUD operations

Example using Hibernate:

```java
Session session = sessionFactory.openSession();
Transaction tx = session.beginTransaction();

session.save(employee);

tx.commit();
session.close();
```

Managing sessions and transactions manually becomes repetitive.

**Spring Data JPA** eliminates this boilerplate code.

---

# What is Spring Data JPA?

Spring Data JPA is a **Spring Framework module** built on top of JPA (typically using Hibernate underneath).

It automatically provides implementations for common database operations.

### Repository Example

```java
public interface CountryRepository extends JpaRepository<Country, String> {

}
```

Without writing any implementation, Spring Data JPA provides:

* `save()`
* `findAll()`
* `findById()`
* `deleteById()`
* `count()`
* `existsById()`

This allows developers to focus on business logic instead of writing repetitive data-access code.

---

# Relationship Between JPA, Hibernate and Spring Data JPA

```text
                    Spring Boot
                         │
                         ▼
                Spring Data JPA
        (Simplifies Repository Layer)
                         │
                         ▼
              JPA (Specification/API)
                         │
                Implemented By
                         ▼
                 Hibernate ORM
                         │
                         ▼
                        JDBC
                         │
                         ▼
               Relational Database
```

---

# How Spring Boot Works

When a Spring Boot application starts, the following steps occur:

```text
Spring Boot
      │
      ▼
Reads application.properties
      │
      ▼
Creates Database Connection
      │
      ▼
Scans @Entity Classes
      │
      ▼
Hibernate Creates/Updates Tables
      │
      ▼
Scans Repository Interfaces
      │
      ▼
Generates Repository Implementations
      │
      ▼
Application Ready
```

---

# Project Flow

A typical Spring Boot application follows this flow:

```text
Client
   │
   ▼
Controller
   │
   ▼
Service
   │
   ▼
Repository
   │
   ▼
Hibernate
   │
   ▼
JDBC Driver
   │
   ▼
Database
```

The response travels back through the same layers in reverse order.

---

# Entity Example

```java
@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;
}
```

Hibernate maps this Java class to the corresponding database table.

---

# Repository Example

```java
public interface CountryRepository
        extends JpaRepository<Country, String> {

}
```

Spring Data JPA automatically generates implementations for methods such as:

* `save()`
* `findAll()`
* `findById()`
* `deleteById()`

No SQL needs to be written manually.

---

# Service Example

```java
@Service
public class CountryService {

    @Autowired
    private CountryRepository repository;

    @Transactional
    public List<Country> getAllCountries() {
        return repository.findAll();
    }
}
```

### Purpose of `@Transactional`

The `@Transactional` annotation automatically:

* Opens a database session.
* Begins a transaction.
* Commits the transaction if successful.
* Rolls back the transaction if an error occurs.
* Closes the session.

---

# application.properties

```properties
spring.datasource.url=jdbc:h2:mem:ormlearn
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

### Configuration Description

| Property                        | Description                                       |
| ------------------------------- | ------------------------------------------------- |
| `spring.datasource.url`         | Configures the database connection.               |
| `spring.jpa.hibernate.ddl-auto` | Automatically creates or updates database tables. |
| `spring.jpa.show-sql`           | Displays generated SQL queries in the console.    |

---

# Comparison: JPA vs Hibernate vs Spring Data JPA

| Feature                      | JPA                           | Hibernate      | Spring Data JPA      |
| ---------------------------- | ----------------------------- | -------------- | -------------------- |
| Type                         | Specification                 | ORM Framework  | Spring Module        |
| Purpose                      | Defines persistence standards | Implements JPA | Simplifies JPA usage |
| Database Access              | ❌ No                          | ✅ Yes          | ✅ Through Hibernate  |
| SQL Generation               | ❌ No                          | ✅ Yes          | Uses Hibernate       |
| Boilerplate Code             | High                          | Medium         | Very Low             |
| Repository Support           | ❌ No                          | ❌ No           | ✅ Yes                |
| CRUD Operations              | ❌ Manual                      | Manual         | Auto-generated       |
| Used Directly in Spring Boot | No                            | Sometimes      | Yes                  |

---

# Key Takeaways

* **JPA** defines the rules for object-relational mapping.
* **Hibernate** is an ORM framework that implements the JPA specification.
* **Spring Data JPA** simplifies Hibernate by automatically generating repository implementations.
* **Spring Boot** auto-configures all required components, allowing developers to focus on business logic rather than infrastructure code.

---

# Conclusion

JPA, Hibernate, and Spring Data JPA work together to simplify database interaction in Java applications.

* **JPA** provides the standard.
* **Hibernate** implements that standard and performs ORM.
* **Spring Data JPA** reduces boilerplate code and provides ready-to-use repository methods.
* **Spring Boot** automatically configures the application, making development faster and more efficient.

Together, these technologies provide a clean, scalable, and developer-friendly approach to building modern Java applications.
