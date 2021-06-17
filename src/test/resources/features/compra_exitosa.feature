#language: es

Característica: Compra Exitosa
  Se verificarán los datos en la orden de pago para validar compra exitosa

  @EscenarioCorrecto
  Esquema del escenario: Verificar compra
    Dado que el usuario esta logueado
    Cuando agrego producto al carro
    Entonces valido el nombre del articulo
    Y los datos de orden de compra seran "<name>" y "<cardNumber>"
      | name   | cardNumber   | country   | city   | month   | year   |
      | <name> | <cardNumber> | <country> | <city> | <month> | <year> |
    Ejemplos:
      | name   | cardNumber | country  | city  | month | year |
      | Martin | 1357924680 | Colombia | Tunja | Feb   | 2025 |

  @EscenarioFallido
  Esquema del escenario: Verificar compra
    Dado que el usuario esta logueado
    Cuando agrego producto al carro
    Entonces valido el nombre del articulo
    Y los datos de orden de compra seran "<nombrePrueba>" y "<cardNumberPrueba>"
      | name   | cardNumber   | country   | city   | month   | year   |
      | <name> | <cardNumber> | <country> | <city> | <month> | <year> |
    Ejemplos:
      | name   | cardNumber | country  | city  | month | year | nombrePrueba | cardNumberPrueba |
      | Martin | 1357924680 | Colombia | Tunja | Feb   | 2025 | Alberto      | 0864297531       |


