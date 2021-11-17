<%@page import="br.com.DTO.LivroDTO"%>
<%@page import="br.com.DAO.LivroDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
    
    try {
        LivroDTO ObjLivroDTO = new LivroDTO();
        ObjLivroDTO.setNome_livro(request.getParameter("nome"));
        
        LivroDAO  objLivroDAO = new LivroDAO();
        objLivroDAO.CadastrarLivro(ObjLivroDTO);
		
		
	} catch (Exception e) {
		// TODO: handle exception
	}
 
    %>
</body>
</html>