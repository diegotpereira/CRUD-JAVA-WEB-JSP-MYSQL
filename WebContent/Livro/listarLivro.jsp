<%@page import="br.com.DAO.LivroDAO"%>
<%@page import="br.com.DTO.LivroDTO"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
      try{
    	  
    	  LivroDAO livroDAO = new LivroDAO();
    	  ArrayList<LivroDTO> lista = livroDAO.PesquisarLivro();
    	  
    	  for(int num = 0; num < lista.size(); num ++) {
    		  out.print("Código: " + lista.get(num).getId_livro() + "<br>");
    		  out.print("Nome: " + lista.get(num).getNome_livro() + "<br>");
    	  }
    	  
      } catch(Exception e) {
    	  
      }
    %>
</body>
</html>