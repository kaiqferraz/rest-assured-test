package org.example.model;

public class UsuarioModel {
    private String nome;
    private String email;
    private String password;
    private String administrador;

    // Construtor vazio (necessário para o Jackson)
    public UsuarioModel() {}

    // Construtor completo
    public UsuarioModel(String nome, String email, String password, String administrador) {
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.administrador = administrador;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getAdministrador() { return administrador; }
    public void setAdministrador(String administrador) { this.administrador = administrador; }
}
