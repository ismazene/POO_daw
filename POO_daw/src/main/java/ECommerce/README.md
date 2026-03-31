# ECommerce (Java)

Proyecto en Java que simula el pago de una tienda online aplicando herencia, clases abstractas y polimorfismo.

## Objetivo

La aplicaci?n permite al usuario elegir un m?todo de pago y completar una compra validando primero los datos necesarios de cada m?todo.

Los m?todos disponibles son:

- Bizum
- PayPal
- Tarjeta de cr?dito

## Estructura del proyecto

- `AppEcommerce.java`: punto de entrada del programa.
- `Tienda.java`: controla el flujo general del pago.
- `MetodoPago.java`: clase abstracta base de todos los m?todos de pago.
- `Bizum.java`: implementaci?n del pago con Bizum.
- `PayPal.java`: implementaci?n del pago con PayPal.
- `TarjetaCredito.java`: implementaci?n del pago con tarjeta.
- `PUML/ECommerce.puml`: diagrama UML del proyecto.

## Dise?o de la soluci?n

Se ha utilizado una clase abstracta llamada `MetodoPago` para definir el comportamiento com?n de los m?todos de pago.

Esta clase define:

- `validarDatos(Scanner teclado)`: valida los datos propios del m?todo elegido.
- `puedePagar(double importe)`: comprueba si el m?todo puede asumir el pago.
- `procesarPago(double importe)`: procesa el pago cuando todo ya es v?lido.

Cada subclase implementa su propia l?gica:

- `Bizum` valida tel?fono y PIN.
- `PayPal` valida correo y saldo disponible.
- `TarjetaCredito` valida n?mero y tipo de tarjeta.

## Flujo de ejecuci?n

La l?gica principal se encuentra en `Tienda.iniciarPago()`.

Pasos que sigue el programa:

1. Pide al usuario el m?todo de pago.
2. Crea el objeto correspondiente.
3. Valida los datos espec?ficos de ese m?todo.
4. Pide el importe una sola vez.
5. Comprueba si el pago puede realizarse.
6. Llama a `realizarPago()` solo cuando todo ha sido validado.
7. `realizarPago()` invoca `procesarPago()`.

## Explicaci?n de las clases

### AppEcommerce

Es la clase principal del programa. Su funci?n es iniciar la tienda llamando a `Tienda.iniciarPago()`.

### Tienda

Centraliza toda la l?gica del proceso de compra.

Se encarga de:

- pedir el m?todo de pago
- crear el objeto adecuado
- validar los datos
- pedir el importe
- ejecutar el pago final

### MetodoPago

Es una clase abstracta que sirve como base com?n para todos los m?todos de pago.

Gracias a esta clase se evita repetir c?digo y se facilita el uso del polimorfismo.

### Bizum

Solicita:

- n?mero de tel?fono de 9 cifras
- PIN de 6 cifras

Si ambos datos son correctos, permite procesar el pago.

### PayPal

Solicita:

- correo electr?nico con formato v?lido `@gmail.com`

Despu?s comprueba si el saldo disponible es suficiente para pagar el importe introducido.

### TarjetaCredito

Solicita:

- n?mero de tarjeta de 16 d?gitos
- tipo de tarjeta: `VISA`, `MASTERCARD` o `MAESTRO`

Si todo es correcto, procesa el pago.

## Mejoras realizadas tras la correcci?n

Se han aplicado los cambios pedidos en la revisi?n:

- toda la l?gica principal se ha movido a `iniciarPago()`
- `realizarPago()` solo se llama cuando todo ya est? validado
- `realizarPago()` ?nicamente procesa el pago
- se ha eliminado c?digo repetido entre m?todos
- ahora s? se puede llamar correctamente a `procesarPago()`
- se ha mejorado la documentaci?n con comentarios y Javadoc
- se ha actualizado el UML para reflejar el nuevo dise?o
- se han a?adido pruebas manuales al Markdown

## Pruebas manuales

### Prueba 1: Bizum correcto

Entrada:

- m?todo: `Bizum`
- tel?fono: `123456789`
- PIN: correcto
- importe: `10`

Resultado esperado:

- validaci?n correcta
- pago aceptado

### Prueba 2: Bizum incorrecto

Entrada:

- m?todo: `Bizum`
- tel?fono: `123`
- PIN: cualquiera

Resultado esperado:

- error de validaci?n
- no se procesa el pago

### Prueba 3: PayPal correcto

Entrada:

- m?todo: `PayPal`
- correo: `usuario@gmail.com`
- importe: `10`

Resultado esperado:

- correo v?lido
- pago aceptado

### Prueba 4: PayPal sin saldo

Entrada:

- m?todo: `PayPal`
- correo: `usuario@gmail.com`
- importe: `50`

Resultado esperado:

- mensaje de fondos insuficientes
- no se procesa el pago

### Prueba 5: Tarjeta correcta

Entrada:

- m?todo: `Tarjeta`
- n?mero: `1234567812345678`
- tipo: `VISA`
- importe: `25`

Resultado esperado:

- validaci?n correcta
- pago aceptado

### Prueba 6: Tarjeta incorrecta

Entrada:

- m?todo: `Tarjeta`
- n?mero: `1234`
- tipo: `VISA`

Resultado esperado:

- tarjeta no v?lida
- no se procesa el pago

## UML

El diagrama UML del proyecto est? disponible en:

- `PUML/ECommerce.puml`

## Conclusi?n

El proyecto ha sido reorganizado para ajustarse a la correcci?n recibida.

Ahora la estructura es m?s limpia, evita repetici?n de c?digo y separa mejor las responsabilidades:

- `Tienda` controla el flujo general
- cada m?todo valida solo sus propios datos
- el pago se procesa ?nicamente cuando todo es correcto
