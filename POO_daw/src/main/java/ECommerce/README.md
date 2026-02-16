 ## Diagrama de clases (versión intermedia)

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
