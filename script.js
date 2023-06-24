//carga la funcion cuando esta todos los archivos del html estan listos y obtiene la referencia de cuatro elementos del html
document.addEventListener("DOMContentLoaded", function() {
    var taskInput = document.getElementById("taskInput");
    var addTaskButton = document.getElementById("addTaskButton");
    var taskList = document.getElementById("taskList");
    var daySelect = document.getElementById("daySelect");
//se agrega un evento click, se obtiene el valor de campo de entrada "taskInput" y lo alamcena en la variable "taskText" y elimina espacios vacios 
    addTaskButton.addEventListener("click", function() {
      var taskText = taskInput.value.trim();
      var selectedDay = daySelect.value; // Obtener el día seleccionado
//agrega una nueva tarea al precionar enter       
        taskInput.addEventListener("keydown", function(event) {
          if (event.key === "Enter") {
            event.preventDefault();
            addTaskButton.click();
          }
        });
//verifica si el texto de tarea esta vacio, crea un nuevo elemento de li y un elemento de casilla de verificacion "checkbox"    
      if (taskText !== "") {
        var newTask = document.createElement("li");
        var checkbox = document.createElement("input");
        checkbox.type = "checkbox";
        newTask.appendChild(checkbox);        
//agrega una tarea como un hijo de la lista
        var taskLabel = document.createElement("label");
        taskLabel.innerText = "[" + selectedDay + "] " + taskText; // Agregar el día seleccionado al texto de la tarea
        newTask.appendChild(taskLabel);
//marca una tarea como terminada con el checked
        checkbox.addEventListener("change", function() {
          if (this.checked) {
            taskLabel.classList.add("completed");
          } else {
            taskLabel.classList.remove("completed");
          }
        });
//elimina el elemento de la lista con clic derecho
        newTask.addEventListener("contextmenu", function(e) {
          e.preventDefault();
          this.remove();
        });
//cuando se elimina una tarea deja la linea vacia
        taskList.appendChild(newTask);
        taskInput.value = "";
      }
    });
  });