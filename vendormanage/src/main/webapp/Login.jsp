<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    
    <title>Login Form</title>
  </head>
  <body>
  <nav class="navbar navbar-dark bg-dark">
		  <div class="container">
    <h5 class="text-white h4">X-workz</h5>
  </div>
		<nav aria-label="breadcrumb">
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a class="btn btn-primary"
					href="index.jsp" role="button">Home</a></li>
			
			</ol>
		</nav>
	</nav>
       <div class="container-fluid">
    <div class="d-flex justify-content-center align-items-center bg-gray" style="background-image: url('https://e0.pxfuel.com/wallpapers/796/662/desktop-wallpaper-33-best-plain-light-background.jpg'); height: 90vh; background-size: cover; width: 100%;">
        <form class="p-3 mb-2 bg-info text-black" style="width: 400px;">
            <h2 style="color: black" align="center">Login Form</h2>
            <div class="mb-3 mt-3">
                <label for="exampleInputEmail1" class="form-label">User Name</label>
                <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
            </div>
            <div class="mb-3">
                <label for="exampleInputPassword1" class="form-label">Password</label>
                <input type="password" class="form-control" id="exampleInputPassword1">
                <div id="emailHelp" class="form-text mt-3">create account! <a href="Registration.jsp" style="color: purple">Register</a></div>
            </div>
            <button type="submit" class="btn btn-success mt-3">Login</button>
        </form>
    </div>
</div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

  </body>
</html>