<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<form action="ServletOi" method="post">
			<div class="mb-3">
				<label for="exampleInputNome1" class="form-label">Nome</label> <input
					type="text" name="nome" class="form-control"
					id="exampleInputNome1" aria-describedby="nomeHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputEndereco1" class="form-label">Endereço</label> <input
					type="text" name="endereco" class="form-control"
					id="exampleInputEndereco1" aria-describedby="enderecolHelp">
			</div>
			<div class="mb-3">
				<label for="exampleInputModalidade1" class="form-label">Modalidade</label> <input
					type="text" name="modalidade" class="form-control"
					id="exampleInputModalidade1" aria-describedby="modalidadeHelp">
			</div>
			<button type="submit" class="btn btn-outline-primary">Inserir</button>
		</form>
		<h4>${msg}</h4>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
		crossorigin="anonymous"></script>
</body>
</html>