# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  21/22)
Autor/a: Jesús Oria Arenas   uvus:jesoriare



## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.clinico**: Paquete que contiene los records Paciciente, PacienteEstudio, Persona y el Enum TipoResidencia.
  * **fp.clinico.test**: Paquete que contiene las clases de test del las clases del paquete fp.clinico.
  * **fp.farmaceutico**: Paquete que contiene la clase medicamento y un Enum TipoMedicamento.
  * **fp.farmaceutico.test**: Paquete que contiene las clases de test del las clases del paquete fp.farmaceutico.
  * **fp.vacunas**: Paquete que contiene los records Vacunacion.
  * **fp.vacunacion.test**: Paquete que contiene las clases de test del las clases del paquete fp.vacunas.
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 



## Clases implementadas

Tipo Record: Paciente, PacienteEstudio, Persona, Vacunacino. Tipo clase: Medicamento

### Record Persona


**Propiedades**:

- nombre, de tipo String, consultable y modificable. 
- apellidos, de tipo String, consultable y modificable. 
- dni, de tipo String, consultable y modificable. 
- fechaNacimiento, de tipo LocalDate, consultable y modificable. 
- edad, de tipo Integer, propiedad derivada. 

**Restricciones**:
 
- R1: La fecha de nacimiento debe ser anterior a la fecha actual. 
- R2: El dni debe ser una cadena con ocho dígitos y seguidos de una letra. 

- 
**Criterio de igualdad**: por defecto asociado al record.
**Representación como cadena**: por defecto asociado al record.
**Orden natural**: por dni. 

### Record Paciente


**Propiedades**:

- persona, de tipo Persona.
- codigoIngreso, de tipo String, consultable y modificable. 
- fecha y hora de ingreso, de tipo LocalDate, consultable y modificable. 
- fechaIngreso, de tipo LocalDate, propiedad derivada. 
- horaIngreso, de tipo LocalDate, propiedad derivada. 

**Restricciones**:
 
- R1: La fecha y hora de ingreso debe ser anterior o igual a la fecha actual

- 
**Criterio de igualdad**: por defecto asociado al record.
**Representación como cadena**: por defecto asociado al record.


### Record PacienteEstudio


**Propiedades**:

- id, de tipo String, consultable y modificable.
- genero, de tipo String, consultable y modificable. 
- edad, de tipo Double, consultable y modificable. 
- hipertension, de tipo Boolean, consultable y modificablea. 
- enfermedad de corazón, de tipo Boolean, consultable y modificable.
- tipo de residencia, enumerado TipoResidencia.
- Factor de riesgo, de tipo Boolean, propiedad derivada. 

**Restricciones**:
 
- R1: La edad tiene que ser mayor o igual que cero y menor o igual que 130. 
- R2: El nivel medio de glucosa tiene que ser mayor o igual que cero. 

- 
**Criterio de igualdad**: por defecto asociado al record.
**Representación como cadena**: informa del id y la edad del paciente.
**Criterio de orden**: según la edad y el id. 


### Record Vacunacion


**Propiedades**:

- fecha, de tipo LocalDate, consultable y modificable.
- comunidad, de tipo String, consultable y modificable. 
- pfizer, de tipo Integer, consultable y modificable. 
- moderna, de tipo Integer, consultable y modificable. 
- janssenn, de tipo Integer, consultable y modificable.
- numero personas, de tipo Integer, propiedad consultable y modificable.
- Numero total, de tipo Integer, propiedad derivada. 

**Restricciones**:
 
- R1:La fecha de debe ser posterior al 01/02/2021


- 
**Criterio de igualdad**: por defecto asociado al record.
**Representación como cadena**: por defecto asociado al record.
**Criterio de orden**: por comunidad y en caso de igualdad por fecha. 


### Clase Medicamento


**Propiedades**:

- nombre del medicamento, de tipo String, consultable y modificable.
- tipo de medicamento, enumerado de tipo TipoMedicamento, observable
- código de la enfermedad, de tipo String, observable. 
- farmacéutica, de tipo String, observable.
- puntación, de tipo Double, observable.
- índice somático, de tipo Integer, observable.
- fecha de catálogo, de tipo LocalDate, observable y modificable.
- tratar enfermedad, de tipo Boolean. (Derivada, siendo cierta si el código de la
enfermedad coincide con un parámetro de tipo cadena que reciben como argumento
la propiedad)

**Restricciones**:
 
- R1: La puntación tiene que ser mayor estricta que cero.
- R2: El índice somático tiene que ser mayor o igual que 1000.
- R3: La fecha de catálogo tiene que ser posterior al 01/01/2015

- 
**Representación como cadena**: según el nombre del medicamento y de la farmacéutica.
**Criterio de igualdad**: por nombre del medicamento y farmacéutica.
**Orden natural**: por nombre del medicamento y en caso de igualdad por la farmacéutica. 