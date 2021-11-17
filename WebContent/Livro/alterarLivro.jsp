<%@page import="br.com.DTO.LivroDTO"%>
<%@page import="br.com.DAO.LivroDAO"%>
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
    
	    try {
	        LivroDTO livroDTO = new LivroDTO();
	        livroDTO.setId_livro(Integer.parseInt(request.getParameter("id")));
	        livroDTO.setNome_livro(request.getParameter("nome"));
	        
	        LivroDAO  objLivroDAO = new LivroDAO();
	        objLivroDAO.AlterarLivro(livroDTO);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	 
	    %>
</body>
</html>