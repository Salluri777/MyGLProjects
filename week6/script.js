// Js code goes here
let startButton = document.getElementById("start-button");

let submitButton = document.getElementById("submit-button")
submitButton.setAttribute("disabled", "true")
startButton.addEventListener("click", buttoneventlistener)

document.getElementById("loader-view").style.display = "none"
document.getElementById("quiz").style.display = "none";
let flag = true;
var loadvar;

async function buttoneventlistener() {

  document.getElementById("start-button").style.display = "none"
  document.getElementById("pre-quiz-instructions").style.display = "none";
  document.getElementById("loader-view").style.display = "block"

  let questionid = document.getElementById('current-question-id').value
  let loader = await fetch(`http://localhost:3000/data/${questionid}`)
  loader = await loader.json()
  console.log(loader)
  loadvar = JSON.parse(JSON.stringify(loader));
  setTimeout(optionsCreator(questionid),300)
}

function optionsCreator(questionid){
  document.getElementById("loader-view").style.display = "none"
  if(questionid == 5){
    document.getElementById("question").innerHTML = "What is the correct JavaScript syntax to change the content of the HTML element below?\n\n" + "&#60;p id=\"demo\"&#62;This is a demonstration.&#60;/p&#62";
  } else{
    document.getElementById('question').innerText = loadvar.question;
  }
  let optionsContainer = document.getElementById("options-container")
  let options = loadvar.options
  options.map((option) => {
    let optionHtml = document.createElement("div")
    optionHtml.addEventListener("click", optionEventListerner)
    optionHtml.innerText = option
    optionsContainer.appendChild(optionHtml)
  })
  document.getElementById("quiz").style.display = "block";
}


function optionEventListerner(e) {
  let submitButton = document.getElementById("submit-button")
  if(flag == true){
   flag = false 
   submitButton.disabled = false 
  }
  let children = document.getElementById("options-container").children
  for (child of children) {
    child.classList.remove('user-answer')
  }
  e.target.classList.add('user-answer')
}
document.getElementById("submit-button").addEventListener("click", submitListener)
function submitListener() {
  let i=-1
  let flag=0;
  let children = document.getElementById("options-container").children
  for (child of children) {
    i+=1

    if (loadvar.answer == i) {
      child.classList.add("correct-answer")
      
    }
    if(child.classList.contains("user-answer")){
      if(loadvar.answer != i){
        child.classList.add("wrong-answer")
      }
    }
    
  }

  document.getElementById("submit-button").disabled = true;
 }
