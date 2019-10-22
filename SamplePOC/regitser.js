$(document).ready(function() {

  //form validation function
  $("#registerForm").validate({
    rules: {
      username : {
        required: true,
        minlength: 3
      },
      email: {
        required: true,
        email: true
      },
      password: {
        required: true,
        minlength: 8
      },
      cnfpassword: {
        required: true,
        equalTo: "#password",
        minlength: 8 
      },
      gender: {
        required: true,
      }
    },
    messages : {
      name: {
        minlength: "Name should be at least 3 characters"
      },
      email: {
        email: "The email should be in the format: abc@gmail.com"
      },
      password: {
         minlength: 'Password must be at least 8 characters long'
      },
      gender: {
        required: "Please Choose any one"
      }
    }
  });

  
  //email check function
   $("#email").blur(function(){

       var emailVar = $(this);
       $.ajax({
         type: "POST",
          url:"http://localhost:8080/SpringPOC/emailCheck",
          data:emailVar,
           success:function(responseText){
              if(responseText == " ") { // if the response is empty from backend
                 $('#email').siblings("span").text('Sorry... Email already registered').css("color","red");
             } 
           }
        });
  });


  //form submition function
  $("#registerForm").submit(function(e) {

  e.preventDefault(); // avoid to execute the actual submit of the form.

    var form = $(this);
    var url = form.attr('action');
    $.ajax({
           type: "POST",
           url: "http://localhost:8080/SpringPOC/saveCustomer",
           data: form.serialize(), // serializes the form's elements.
           success: function(data)
           {
              $('.card').fadeOut(); // hide whole form

						 //hide the loader
						 $('.loading').fadeOut();   
						 
						//show the success message
						$('.message').html('Successfully Registered! <a href = "login.html"> Login </a>').fadeIn('slow');
           }
           
     });
  });
})