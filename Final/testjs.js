var allQuestions = [{question: "Q1: Who came up with the theory of relativity?",
                    choices: ["Sir Isaac Newton","Nicolaus Copernicus","Albert Einstein","Ralph Waldo Emmerson"],
                    correctAnswer:2},
    {question: "Q2: Who is on the two dollar bill?",
     choices: ["Thomas Jefferson","Dwight D. Eisenhower","Benjamin Franklin","Abraham Lincoln"],
    correctAnswer:0},
    {question: "Q3: What event began on April 12, 1861?",
    choices: ["First manned flight","California became a state","American Civil War began","Declaration of Independence"],
    correctAnswer:2}];
var score=0;
var currentNumber = 0;
function createQuestion(){
    for (var i=0; i < allQuestions[this.currentNumber].choices.length;i++){
        document.forms.radioAnswers.elements.choice[i].checked = false;
    }
    var question=document.getElementById("question");
    question.innerHTML = allQuestions[this.currentNumber].question;
    var point  = document.getElementById("point");
    point.innerHTML="<span>score: "+score+"</span>";
    createChoices();
}
function createChoices(){
    for (var i = 0; i < allQuestions[this.currentNumber].choices.length; i++){
        var option=document.getElementById("label"+i);
            option.innerHTML=allQuestions[this.currentNumber].choices[i];
			
    }
	
}
function nextQuestion(){
    for (var i =0; i < allQuestions[this.currentNumber].choices.length; i++){
        if (document.forms.radioAnswers.elements.choice[i].checked == true){
            var userAnswer = document.forms.radioAnswers.elements.choice[i].value;
            if (userAnswer == allQuestions[this.currentNumber].correctAnswer){
            this.score++;
            }
        }
    }
    this.currentNumber++;
    if (this.currentNumber==allQuestions.length){ 
        showScore();       
    }
    else{
        createQuestion();
    }
}
function showScore(){
    document.forms.radioAnswers.style.display="none";
    var question=document.getElementById("question");
    question.style.display = "none";
    var elt=document.getElementById("point");
    elt.style.display = "block"; 
    var button = document.getElementById("next");
    button.style.display="none";   

}

window.onload= createQuestion();