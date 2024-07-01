package com.nihil.springintro.entities;

import java.io.Serializable;
import java.util.Objects;

public class User implements Serializable{
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;

    public User(){}

    public User(Long id, String name, String email, String phone, String password){
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public boolean equals(Object o){
        if(this == o) return true; // compara se é literalmente o mesmo objeto
        if(o == null || getClass() != o.getClass()) return false; // Verifica se o objeto passado é null ou de uma classe diferente
        User user = (User) o; // Faz um cast do objeto 'o' para o tipo User.
        return Objects.equals(getId(), user.getId()); // Compara os IDs dos objetos 'User' para determinar se são iguais.
    }

    @Override
    public int hashCode(){
        return Objects.hashCode(getId()); // Retorna o valor de hash do ID do objeto
    }
}
