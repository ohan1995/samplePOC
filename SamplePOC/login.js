$(document).ready(function() {
  
  //Form Validation
  $("#loginForm").validate({
    rules: {
      email: {
        required: true,
        email: true
      },
      password: {
        required: true,
        minlength: 8
      },
    },
    messages : {
      email: {
        email: "The email should be in the format: abc@gmail.com"
      },
      password: {
         minlength: 'Password must be at least 8 characters long'
      },
    }
  });

  //Login submit Validation
   $("#loginForm").submit(function(e){
       e.preventDefault();
    var emailId = $("#email").val();
    var pass = $("#password").val();
    console.log(emailId +" "+pass );
        $.ajax({
            type:"POST",
             url:"http://localhost:8080/SpringPOC/checkLogin",
            data:{
                email:emailId,
                password:pass
             },
             success:function(response){
                if(response == " ") { // if the response is " "
                    alert("username or password incorrect")
                } else{
                    $('#loginForm').fadeOut('slow');                
                    
						 //hide the loader
						 //$('.loading').fadeOut();   
						 
						//show the success message
						$('.message').html('Successfully Logged in ! ').fadeIn('slow');
                }
            }
        })
   });
})