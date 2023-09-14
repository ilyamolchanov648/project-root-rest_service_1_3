package model;

public class User {
    private Long id;
    private String name;
    private String email;

    // Конструктор по умолчанию
    public User() {
    }

    // Конструктор с параметрами
    public User(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для email
    public String getEmail() {
        return email;
    }

    // Сеттер для email
    public void setEmail(String email) {
        this.email = email;
    }

    // Другие методы, если необходимо
}
