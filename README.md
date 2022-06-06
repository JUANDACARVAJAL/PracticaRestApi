# Practica de RestApi

Un proyecto donde se ejemplifica el uso del patrón screenplay


## Detalles generales de la implementación

Los tests usan tareas (tasks), 
interacciones (interactions),
preguntas (questions),

La estructura completa del proyecto es la siguiente:

````
+ model
    Clases relacionadas con el modelo de dominio y sus respectivos builder cuando es necesario
+ tasks
    Clases que representan tareas que realiza el actor a nivel de proceso de negocio
+ interacion
    Clases que representan las interacciones directas con la interfaz de usuario
+ questions
    Objetos usados para consultar acerca del estado de la aplicación

+ runners
    Clases que permiten correr los tests
+ step definitions
    Clases que mapean las líneas Gherkin a código java
+ features
    La representación de las historias en archivos cucumber
````

## Requerimientos

Para correr el proyecto es necesario lo siguiente:

Java 8 o superior.


