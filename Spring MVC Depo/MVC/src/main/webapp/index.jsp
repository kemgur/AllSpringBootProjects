<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" 
      rel="stylesheet"
      integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" 
      crossorigin="anonymous">
</head>
<body>
	<h1 class="h2 text-center m-4">Spring MVC and Spring Boot Examples</h1>
	<div class="container">
	  <form action="submit">
        <div class="mb-3">
          <label for="sayi1" class="form-label">1.Sayi</label>
          <input type="number" class="form-control" id="sayi1" name="sayi1" placeholder="1.sayiyi giriniz">
        </div>
        <div class="mb-3">
          <label for="sayi2" class="form-label">2.Sayi</label>
          <input type="number" class="form-control" id="sayi2" name="sayi2" placeholder="2.sayiyi giriniz">
        </div>
  
        <button type="submit" class="btn btn-primary">Submit</button>
     </form>
   </div>


</body>
</html>