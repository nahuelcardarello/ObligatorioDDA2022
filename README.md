# ObligatorioDDA2022
El objetivo del presente trabajo obligatorio es modelar e implementar la primera versión prototipo de un sistema de atención telefónica.
##Descripcion flujos casos de uso

###CU: Ingresar a la aplicación

1) El trabajador ingresa su número de cédula y su contraseña.
Data en inputs de texto 2) El sistema registra que ese trabajador estará atendiendo clientes en su sector, asignándole un puesto de trabajo (El primero que esté libre).
3) El sistema ejecuta directamente el caso de uso Atender llamadas (en otra interfaz de usuario)
Ejecuta metodo login, que va a pasarle las credenciales a través del controlador y fachada al sistema trabajadores, este chequea que exista un trabajador con esas credenciales. Busca un puesto libre, asigna al trabajador a este. Y finalmente se retorna el puesto, y se le pasa este puesto a ejecutarSiguienteCasoDeUso(p : Puesto) para que se instancia una nueva vista Atender Llamadas pasándole el puesto por constructor.

###C.U. Atender llamada

1)El sistema muestra el nombre completo del trabajador, el nombre del sector, el número del puesto de trabajo asignado, la cantidad de llamadas atendidas (inicialmente 0), y el tiempo promedio (en segundos) de las llamadas en ese puesto de trabajo (inicialmente 0). 2) El sistema espera una llamada entrante de un cliente.
Toda esta data se accede a través del puesto del controlador. La vista ejecuta el metodo incialixar, que llamada a inicializar del controlador y finalmente el controlador le manda a la vista el puesto junto con todos los datos por medio del metodo mostrarDatos(Puesto p).
2) El sistema espera una llamada entrante de un cliente.
Queda pendiente de evento iniciar llamada
3) Cuando un cliente llama, el sistema asigna una llamada al puesto de trabajo y muestra el mensaje “Llamada en curso...” y el nombre completo del cliente que llama. El sistema actualiza la cantidad de llamadas atendidas del puesto de trabajo y registra fecha y hora de inicio de atención de la llamada y la muestra.
Controlador por medio del método actualizar, recibe el evento iniciar llamada y recibe nuevamente el puesto, actualizando la UI mostrando datos en cliente ,y mensaje llamada en curso. 
4) El trabajador ingresa una descripción sobre la llamada.
Esto en un input de texto en la ui
 5) El trabajador habla con el cliente y luego indica que desea finalizar la llamada. 6) El sistema registra fecha y hora de fin de la llamada, la descripción, el trabajador que atendió la llamada y registra que ese puesto de atención ya no tiene una llamada en curso. El sistema muestra mensaje “Llamada finalizada...”, actualiza el tiempo promedio de las llamadas para ese puesto de trabajo y muestra la duración (*) y el costo de la llamada.

Vista le manda la descripción al controlador, controlador le manda la descripción al metodo finalizarLlamada(String descripcion) de puesto. Este actualiza llamada y etc. y dispara evento finalizar llamada, con puesto actualizado. 
 7) El caso de uso vuelve al curso normal 2)
(*) La duración de la llamada siempre se calcula como el tiempo transcurrido entre la fecha/hora de fin de la llamada y la fecha/hora de inicio de atención de la llamada. Se mide en segundos.
Cursos alternativos:
2) Si hay llamadas en espera para el sector, el sistema le asigna una llamada al puesto de trabajo y continúa el caso de uso en el curso normal 3) 4) El cliente finaliza la llamada. El caso de uso continúa en el punto 5)

