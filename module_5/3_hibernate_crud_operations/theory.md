# Hibernate CRUD Operations

## Introduction to CRUD in Hibernate

CRUD represents the four basic operations performed on persistent data:
- **Create (Insert)**
- **Read (Select)**
- **Update**
- **Delete**

This guide will demonstrate how to perform these operations using different Hibernate techniques.

## Domain Model Example

Let's use a `Student` entity to illustrate CRUD operations:

```java
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "first_name")
    private String firstName;
    
    @Column(name = "last_name")
    private String lastName;
    
    @Column(name = "email")
    private String email;
    
    // Constructors
    public Student() {}
    
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
    
    // Getters and setters
    // (omitted for brevity)
}
```

## 1. Create (Insert) Operations

### Using `save()` Method
```java
public class StudentDAO {
    public Long createStudent(Student student) {
        Session session = null;
        Transaction transaction = null;
        try {
            // Open a Hibernate session
            session = HibernateUtil.getSessionFactory().openSession();
            
            // Begin transaction
            transaction = session.beginTransaction();
            
            // Save the student
            Long studentId = (Long) session.save(student);
            
            // Commit the transaction
            transaction.commit();
            
            return studentId;
        } catch (Exception e) {
            // Rollback in case of error
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return null;
        } finally {
            // Close the session
            if (session != null) {
                session.close();
            }
        }
    }
}
```

### Batch Insert
```java
public void batchInsert(List<Student> students) {
    Session session = null;
    Transaction transaction = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        for (int i = 0; i < students.size(); i++) {
            session.save(students.get(i));
            
            // Flush and clear the session periodically
            if (i % 20 == 0) {
                session.flush();
                session.clear();
            }
        }
        
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
}
```

## 2. Read (Select) Operations

### Retrieving by Primary Key
```java
public Student getStudentById(Long id) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        return session.get(Student.class, id);
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
```

### HQL (Hibernate Query Language) Queries
```java
public List<Student> getStudentsByLastName(String lastName) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        // Simple HQL query
        Query<Student> query = session.createQuery(
            "FROM Student WHERE lastName = :lastName", 
            Student.class
        );
        query.setParameter("lastName", lastName);
        return query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}

// More Complex HQL Query
public List<Student> getStudentsWithPagination(int pageNumber, int pageSize) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        Query<Student> query = session.createQuery(
            "FROM Student ORDER BY lastName", 
            Student.class
        );
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}
```

## 3. Update Operations

### Updating an Entity
```java
public void updateStudent(Long studentId, String newEmail) {
    Session session = null;
    Transaction transaction = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        // Retrieve the student
        Student student = session.get(Student.class, studentId);
        
        if (student != null) {
            // Update the email
            student.setEmail(newEmail);
            
            // Alternatively, use merge for detached entities
            // session.merge(student);
        }
        
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
}

// HQL Update
public void bulkUpdateStudentEmail(String oldDomain, String newDomain) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        
        // Bulk update using HQL
        Query<?> query = session.createQuery(
            "UPDATE Student SET email = REPLACE(email, :oldDomain, :newDomain) " +
            "WHERE email LIKE :oldDomainPattern"
        );
        query.setParameter("oldDomain", oldDomain);
        query.setParameter("newDomain", newDomain);
        query.setParameter("oldDomainPattern", "%" + oldDomain);
        
        int updatedEntities = query.executeUpdate();
        
        session.getTransaction().commit();
        System.out.println("Updated " + updatedEntities + " students");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

## 4. Delete Operations

### Deleting an Entity
```java
public void deleteStudent(Long studentId) {
    Session session = null;
    Transaction transaction = null;
    try {
        session = HibernateUtil.getSessionFactory().openSession();
        transaction = session.beginTransaction();
        
        // Retrieve the student
        Student student = session.get(Student.class, studentId);
        
        if (student != null) {
            // Delete the student
            session.delete(student);
        }
        
        transaction.commit();
    } catch (Exception e) {
        if (transaction != null) {
            transaction.rollback();
        }
        e.printStackTrace();
    } finally {
        if (session != null) {
            session.close();
        }
    }
}

// Bulk Delete using HQL
public void deletStudentsByLastName(String lastName) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        
        Query<?> query = session.createQuery(
            "DELETE FROM Student WHERE lastName = :lastName"
        );
        query.setParameter("lastName", lastName);
        
        int deletedEntities = query.executeUpdate();
        
        session.getTransaction().commit();
        System.out.println("Deleted " + deletedEntities + " students");
    } catch (Exception e) {
        e.printStackTrace();
    }
}
```

## Criteria API for Dynamic Queries

```java
public List<Student> getStudentsByCriteria(String firstName, String lastName) {
    try (Session session = HibernateUtil.getSessionFactory().openSession()) {
        // Create Criteria Builder
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<Student> criteriaQuery = criteriaBuilder.createQuery(Student.class);
        
        // Define Root
        Root<Student> root = criteriaQuery.from(Student.class);
        
        // Build Predicates
        List<Predicate> predicates = new ArrayList<>();
        
        if (firstName != null && !firstName.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + firstName + "%"));
        }
        
        if (lastName != null && !lastName.isEmpty()) {
            predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + lastName + "%"));
        }
        
        // Apply Predicates
        criteriaQuery.where(predicates.toArray(new Predicate[0]));
        
        // Execute Query
        return session.createQuery(criteriaQuery).getResultList();
    } catch (Exception e) {
        e.printStackTrace();
        return new ArrayList<>();
    }
}
```

## HQL vs SQL: Key Differences

1. **HQL is Object-Oriented**
   - Works with Java objects and their properties
   - Uses entity names instead of table names

2. **Query Syntax**
   - SQL: `SELECT * FROM students WHERE last_name = 'Doe'`
   - HQL: `FROM Student WHERE lastName = 'Doe'`

3. **Advantages of HQL**
   - Database-independent
   - Works with inheritance
   - Supports polymorphic queries

## Best Practices

1. Always use transactions
2. Close sessions properly
3. Use appropriate fetch types
4. Implement proper error handling
5. Consider using prepared statements
6. Use batch processing for large datasets

## Conclusion

Hibernate provides a powerful and flexible way to perform CRUD operations, abstracting away much of the low-level database interaction complexity. By understanding these techniques, developers can create efficient and maintainable database access layers.