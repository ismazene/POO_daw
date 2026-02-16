 # ECommerce (Java)

  Proyecto en Java para simular pagos en una tienda.

  ## Qué hace

  Permite elegir un método de pago:

  - Bizum
  - PayPal
  - Tarjeta de crédito

  Cada método valida datos y luego procesa el pago.

  ## Estructura

  - AppEcommerce.java: punto de entrada.
  - Tienda.java: gestiona el flujo de pago.
  - MetodoPago.java: clase abstracta base.
  - Bizum.java: pago por Bizum.
  - PayPal.java: pago por PayPal.
  - TarjetaCredito.java: pago por tarjeta.

  ## Resumen

  - MetodoPago es abstracta y define procesarPago(importe).
  - Bizum, PayPal y TarjetaCredito heredan de MetodoPago.
  - AppEcommerce llama a Tienda.
  - Tienda crea y usa el método de pago elegido por el usuario.
