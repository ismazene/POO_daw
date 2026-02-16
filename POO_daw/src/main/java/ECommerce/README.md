<h1 align="center">ECommerce - Sistema de Pagos en Java</h1>
  <p align="center">
    Proyecto académico de Programación Orientada a Objetos (POO) <br>
    Java | Consola | DAW
  </p>

  ---

  ## 👨‍💻 Sobre el proyecto

  Este proyecto simula una tienda con distintos métodos de pago en Java:

  - `Bizum`
  - `PayPal`
  - `TarjetaCredito`

  Todos heredan de una clase abstracta común (`MetodoPago`) y validan datos antes de procesar el pago.

  ---

  ## 🛠 Tecnologías

  <p>
    <img src="https://skillicons.dev/icons?i=java,git,github" />
  </p>

  ---

  ## 📂 Estructura principal

  - `AppEcommerce.java`: clase principal
  - `Tienda.java`: flujo de selección de método de pago
  - `MetodoPago.java`: clase abstracta base
  - `Bizum.java`: implementación de pago por Bizum
  - `PayPal.java`: implementación de pago por PayPal
  - `TarjetaCredito.java`: implementación de pago por tarjeta

  ---

  ## 🧩 Diagrama de clases (intermedio)

  ```mermaid
  classDiagram
  direction TB

  class AppEcommerce {
    main()
  }

  class MetodoPago {
    <<abstract>>
    procesarPago(importe)
  }

  class Bizum {
    telefono: String
    pin: int
    validarPago()
    procesarPago(importe)
  }

  class PayPal {
    cuenta: String
    saldo: double
    validarPago()
    procesarPago(importe)
  }

  class TarjetaCredito {
    nro_tarjeta: String
    tipoSeleccionado: String
    validarPago()
    validarTipo()
    procesarPago(importe)
  }

  class Tienda {
    iniciarPago()
    realizarPago()
  }

  MetodoPago <|-- Bizum
  MetodoPago <|-- PayPal
  MetodoPago <|-- TarjetaCredito

  AppEcommerce --> Tienda : inicia
  Tienda --> Bizum : usa
  Tienda --> PayPal : usa
  Tienda --> TarjetaCredito : usa

  ———

  ## 🎯 Objetivos del proyecto

  - Aplicar herencia y polimorfismo en Java
  - Modelar un flujo real de pagos en consola
  - Mejorar validaciones y estructura del código

  ———

  ## 📫 Autor

  Ismael Zeneddine
  Estudiante de DAW - España
  GitHub: https://github.com/ismazene

  ———
