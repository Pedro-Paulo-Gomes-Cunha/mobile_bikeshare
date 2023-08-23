package com.example.kambabike10.Model;

public class Usuario {
   public int Id;
   public String Nome;
   public String login;
   public String Senha;
   public String Perfil;

   public Integer getId() {
      return Id;
   }

   public void setId(int id) {
      Id = id;
   }

   public String getNome() {
      return Nome;
   }

   public void setNome(String nome) {
      Nome = nome;
   }

   public String getLogin() {
      return login;
   }

   public void setLogin(String login) {
      this.login = login;
   }

   public String getSenha() {
      return Senha;
   }

   public void setSenha(String senha) {
      Senha = senha;
   }

   public String getPerfil() {
      return Perfil;
   }

   public void setPerfil(String perfil) {
      Perfil = perfil;
   }

   @Override
   public String toString() {
      return "Id: " + getId()
              + "\nSenha: " + getSenha()
              + "\nLogin: " + getLogin()
              + "\nPerfil: " + getPerfil()
              + "\nNome:" + getNome();

   }
}
