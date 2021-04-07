let publicworldid= document.getElementsByTagName("h1")[1].innerText.slice(-6);
console.log("/publicWorld/like/"+publicworldid);

document.getElementById("like_button").addEventListener('click', function(){
  let xmlhttp = new XMLHttpRequest();

  // Specify details of the POST request
  xmlhttp.open("POST", "/publicWorld/like/"+publicworldid, true);
  xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

  // Define the data you’d like to send to the server
  let postData = {
   "like": 1
  };

  // Make a POST request with your data in the body of the request
  xmlhttp.send(JSON.stringify(postData));

  // Do something once the Response (Good or Bad) has been received
  xmlhttp.onreadystatechange = function(data) {
      if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
          let publicworldObject=JSON.parse(xmlhttp.responseText);
          document.getElementById("like_count").innerText=publicworldObject.likes;
      }else{

  	  }
  }

});

//post comment
document.getElementById("submit_button").addEventListener('click', function() {
  let xmlhttp = new XMLHttpRequest();

  // Specify details of the POST request
  xmlhttp.open("POST", "/publicWorld/comment/" + publicworldid, true);
  xmlhttp.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

  // Define the data you’d like to send to the server
  let commentData = {
    "comment_author": document.getElementById("comment_author_input").value,
    "comment_date": document.getElementById("comment_date_input").value,
    "comment_text": document.getElementById("comment_text_input").value
  };

  // Make a POST request with your data in the body of the request
  xmlhttp.send(JSON.stringify(commentData));

  document.getElementById("comment_author_input").value = "";
  document.getElementById("comment_date_input").value = "";
  document.getElementById("comment_text_input").value = "";

  // Do something once the Response (Good or Bad) has been received
  xmlhttp.onreadystatechange = function(data) {
    if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
      let blogObject = JSON.parse(xmlhttp.responseText);

      var newComment = document.createElement("P");
      newComment.innerText = "Author: " + blogObject.comment[blogObject.comment.length - 1].author;

      var br = document.createElement("br");
      newComment.appendChild(br);

      var newCommentDate = document.createElement("P");
      newCommentDate.innerText = "Date: " + blogObject.comment[blogObject.comment.length - 1].date;
      newComment.appendChild(newCommentDate);

      var newCommentText = document.createElement("P");
      newCommentText.innerText = blogObject.comment[blogObject.comment.length - 1].text;
      newComment.appendChild(newCommentText);

      var br2 = document.createElement("br");
      newComment.appendChild(br2);

      newComment.className = "comment collection-item teal lighten-1";

      newComment.id = "comment_";
      newComment.id += blogObject.comment.length - 1;

      document.getElementById("commentSection").appendChild(newComment);
    } else {

    }
  }

});
