# Practica 1 - MERCADAW

## Autor

Ismael

## Objetivo de la practica

El objetivo de esta practica es desarrollar una pequena aplicacion en Java para simular una zona de clientes de un supermercado online. El programa permite:

- Generar clientes aleatorios.
- Autenticar a un cliente con usuario y contrasenya.
- Crear un pedido nuevo.
- Anadir productos al carrito.
- Calcular el importe total.
- Aplicar promociones.
- Mostrar el resumen del pedido.
- Ordenar el pedido por unidades.
- Eliminar productos del carrito como funcionalidad bonus.

## Estructura del proyecto

La practica esta resuelta en el paquete `MercaDAW` con estas clases:

- `MercaDaw`: gestiona la lista de clientes, la generacion aleatoria y la autenticacion.
- `Cliente`: almacena los datos del cliente y su pedido actual.
- `Pedido`: guarda los productos elegidos, sus cantidades y el importe total.
- `Producto`: enum con los productos disponibles y su precio.
- `AppZonaClientes`: clase principal que ejecuta el flujo de compra.

## Pasos seguidos

1. Se creo la clase principal para arrancar la aplicacion.
2. Se genero una lista de clientes aleatorios con usuario y contrasenya de 8 caracteres.
3. Se implemento la autenticacion con un maximo de 3 intentos.
4. Se creo la logica para iniciar un pedido nuevo con mapa vacio e importe a 0.
5. Se mostro el catalogo de productos a partir del enum `Producto`.
6. Se implemento la insercion de productos en el carrito usando un `Map<Producto, Integer>`.
7. Se calculo el importe total del pedido recorriendo el mapa.
8. Se programaron las promociones:
9. Promo 3x2 para productos con 3 unidades o multiplos de 3.
10. Descuento adicional del 10 por ciento sobre el total resultante.
11. Se mostro el resumen del pedido y la opcion de ordenarlo por unidades descendentes.
12. Se implemento el bonus para eliminar productos del carrito.
13. Se anadieron comentarios Javadoc en las clases y metodos principales.

## Explicacion del codigo

### Clase `MercaDaw`

Esta clase crea y almacena la lista de clientes. Tambien genera usuarios y contrasenyas aleatorias usando una cadena con letras y numeros. El metodo `autenticacion()` pide los datos por teclado y comprueba si coinciden con algun cliente de la lista.

### Clase `Cliente`

Representa a cada cliente. Guarda su usuario, contrasenya, direccion, pedido y si ya ha usado promociones. El metodo `crearPedido()` inicializa un pedido nuevo y `importePedido()` devuelve el importe actual del pedido.

### Clase `Pedido`

Usa un mapa para guardar cada producto con su cantidad. El metodo `insertarProducto()` suma unidades. `importePedido()` calcula el total sin descuentos. `aplicarPromo3x2()` recalcula el precio cobrando solo 2 de cada 3 unidades. `aplicarPromo10()` descuenta un 10 por ciento. Tambien se ha anadido `eliminarProducto()` para el bonus.

### Clase `Producto`

Es un `enum` que contiene todos los productos disponibles y su precio.

### Clase `AppZonaClientes`

Es la clase principal. Primero crea la tienda y genera los clientes. Despues autentica al usuario. Si el login es correcto, crea un pedido y permite anadir productos. Al terminar, muestra un menu para aplicar promociones, ordenar el resumen, eliminar productos o finalizar la compra.

## Pruebas realizadas

Se han probado los siguientes casos:

- Login correcto con acceso a la compra.
- Login incorrecto hasta mostrar error tras 3 intentos.
- Insercion de varios productos en el carrito.
- Intento de introducir un producto no valido.
- Calculo del importe total.
- Aplicacion de promociones una sola vez.
- Ordenacion del pedido por unidades descendentes.
- Eliminacion de productos del carrito.
- Eliminacion completa de un producto cuando su cantidad llega a 0.

## Conclusiones

Con esta practica se trabaja el uso de clases, objetos, enums, mapas, metodos, condicionales, bucles y entrada de datos por teclado. La aplicacion cumple con la funcionalidad pedida en el enunciado y anade tambien la mejora opcional de eliminar productos del carrito.
