# Reto-Final-Demoblaze-Screenplay-Correccion-
Este reto se basa en la automatización sobre la página https://www.demoblaze.com/index.html de los procesos
Login, Seleccion de producto, verificación del producto, y verificación de la compra basandonos en los datos del 
usuario, fue realizado usando Gradle, Java, Serenity BDD y Cucumber, bajo Screenplay.

## Composición Código Fuente

| Capa| Definición |
| ------------- | ------------- |
| Tasks | Contiene las tareas que se ejecutarán en la automatización  |
| Interactions  | Contiene las interacciones que se ejecutarán en la automatización  |
| User Interfaces | Contiene los mapeos de los elementos de las diferentes interfaces |
| Models | Contiene los modelos que se usarán para la construcción de la automatización |
| Utils  | Contiene las variables independientes que son usadas dentro de la prueba |
| Exceptions | Contiene las excepciones que se pueden presentar en la prueba |
| Questions | Contiene las preguntas que se verificarán en la prueba |
| Runners | Contiene el ejecutor de la prueba automatizada |
| Steps Definitions | Contiene los pasos de ejecución de la prueba |
| Features | Contiene los escenarios en lenguaje Gherkin |

## Tasks

### IrHaciaLogin
Dirige al usuario hacia la interfaz de Login.
```java
		
public class IrHaciaLogin implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LOGIN_USER));
    }

    public static IrHaciaLogin deUsuario() {
        return instrumented(IrHaciaLogin.class);
    }
}
```
### DiligenciarCredencialesUsuario
Permite diligenciar al usuario sus datos de acceso.
```java
public class DiligenciarCredencialesUsuario implements Task {


    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(informacionRequerida.nombreUsuario).into(NOMBRE_USUARIO),
                Enter.theValue(informacionRequerida.password).into(PASSWORD_USUARIO));
    }

    public static DiligenciarCredencialesUsuario paraIngresarAPerfil() {
        return instrumented(DiligenciarCredencialesUsuario.class);
    }
}
```
### IrAPerfilDeUsuario
Dirige al usuario hacia su cuenta
```java
public class IrAPerfilDeUsuario implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BOTON_LOGIN));
    }

    public static IrAPerfilDeUsuario Registrado() {
        return instrumented(IrAPerfilDeUsuario.class);
    }
}
```
### SeleccionarProducto
Permite elegir un producto o articulo al usuario

```java
  public class SeleccionarProducto implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(SAMSUNG_GALAXY_S6));

    }

    public static SeleccionarProducto Disponible() {
        return instrumented(SeleccionarProducto.class);
    }
}
```
### AgregarAlCarrito
Permite al usuario añadir el producto que seleccionó al carrito de la tienda

```java
public class AgregarAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(AGREGAR_AL_CARRITO, isVisible()).forNoMoreThan(2).seconds(), Click.on(AGREGAR_AL_CARRITO));

    }

    public static AgregarAlCarrito deLaTienda() {
        return instrumented(AgregarAlCarrito.class);
    }
}
```
### IrAlCarrito
Dirige al usuario hacia el carrito en su cuenta

```java
   public class IrAlCarrito implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(OPCION_CARRITO));
    }

    public static IrAlCarrito DemoBlaze() {
        return instrumented(IrAlCarrito.class);
    }
}
```
### RealizarPedido
Permite realizar el pedido luego de la verificacion del articulo y dirige al usuario hacia el formulario de 
datos del pedido
```java
public class RealizarPedido implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(REALIZAR_PEDIDO,isVisible()).forNoMoreThan(2).seconds(),
                Click.on(REALIZAR_PEDIDO));

    }

    public static RealizarPedido deProductos() {
        return instrumented(RealizarPedido.class);
    }
}
```
### DiligenciarDatosPedido

Permite al usuario diligenciar los datos del pedido

```java
public class DiligenciarDatosPedido implements Task {

    private Data data;

    public DiligenciarDatosPedido(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(IngresoDatosPedido.enLosEspacios(data));
    }

    public static DiligenciarDatosPedido paraOrdenDePago(Data data) {
        return instrumented(DiligenciarDatosPedido.class, data);
    }
}
```
### GenerarOrdenDePago
Dirige al usuario hacia la interfaz de la orden de pago generada

```java
public class GenerarOrdenDePago implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(COMPRAR));
    }

    public static GenerarOrdenDePago alComprarProducto() {
        return instrumented(GenerarOrdenDePago.class);
    }
}
```
### AceptarAlerta
Acepta la alerta presentada a la hora de agregar un producto al carrito de la tienda

```java
public class AceptarAlerta implements Task {
    private WebDriver hisBrowser;

    public AceptarAlerta(WebDriver hisBrowser) {
        this.hisBrowser = hisBrowser;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriverWait wait = new WebDriverWait(hisBrowser, 10);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        alert.accept();
    }

    public static AceptarAlerta deProductoAgregado(WebDriver hisBrowser) {

        return instrumented(AceptarAlerta.class, hisBrowser);
    }
}
```

## Interactions
### IngresoDatosPedido
Escribe los datos del usuario que realiza el pedido que irán en la orden de pago
```java
public class IngresoDatosPedido implements Interaction {

    private Data data;


    public IngresoDatosPedido(Data data) {
        this.data = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(data.getName()).into(NOMBRE_PEDIDO),
                Enter.theValue(data.getCountry()).into(PAIS_PEDIDO),
                Enter.theValue(data.getCity()).into(CIUDAD_PEDIDO),
                Enter.theValue(data.getCardNumber()).into(TARJETA_CREDITO_PEDIDO),
                Enter.theValue(data.getMonth()).into(MES_PEDIDO),
                Enter.theValue(data.getYear()).into(YEAR_PEDIDO)
        );
    }

    public static IngresoDatosPedido datosPedido(Data data) {
        return instrumented(IngresoDatosPedido.class, data);
    }
}
```
## User Interfaces

### DemoBlazeHomePage
Esta clase contiene los mapeos de la página principal de DemoBlaze

```java
@DefaultUrl("https://www.demoblaze.com/index.html")
public class DemoBlazeHomePage extends PageObject {
    public static final Target LOGIN_USER = Target.the("Opcion login de usuario").located(By.id("login2"));
}
```
### CredencialesUsuarioPage
Esta clase contiene los mapeos de la interfaz de Login de usuario

```java
public class CredencialesUsuarioPage {
    public static final Target NOMBRE_USUARIO = Target.the("Espacio para nombre de usuario").located(By.id("loginusername"));
    public static final Target PASSWORD_USUARIO = Target.the("Espacio para password de usuario").located(By.id("loginpassword"));
    public static final Target BOTON_LOGIN = Target.the("Boton para realizar login").located(By.xpath("//*/button[contains(text(),'Log in')]"));
}
```
### ProductosPage
Esta clase contiene los mapeos de la interfaz de productos disponibles

```java
public class ProductosPage {
    public static final Target SAMSUNG_GALAXY_S6 = Target.the("Seleccionar Samsung Galaxy S6").located(By.xpath("//*/h4/a[contains(text(),'Samsung galaxy s6')]"));
}}
```
### SamsungGalaxyS6Page
Esta clase contiene los mapeos de la interfaz de información del producto
```java
public class SamsungGalaxyS6Page {
    public static final Target AGREGAR_AL_CARRITO = Target.the("Boton agregar al carrito").located(By.xpath("//*/a[@class=\"btn btn-success btn-lg\"]"));
    public static final Target OPCION_CARRITO = Target.the("Seleccionar opcion carrito").located(By.id("cartur"));
}
```
### CarritoPage
Esta clase contiene los mapeos de la interfaz del carrito para el usuario
```java
public class CarritoPage {
    public static final Target NOMBRE_PRODUCTO = Target.the("Nombre Producto del carrito").located(By.xpath("//*/td[contains(text(),'Sam')]"));
    public static final Target REALIZAR_PEDIDO = Target.the("Seleccionar Boton Place Order").located(By.xpath("//div[@class=\"col-lg-1\"]/button"));
}
```
### RealizarPedidoPage
Esta clase contiene los mapeos de la interfaz del formulario de los datos del usuario que realiza el pedido
```java
public class RealizarPedidoPage {
    public static final Target NOMBRE_PEDIDO = Target.the("Espacio para nombre en el pedido").located(By.xpath("//*/input[@id=\"name\"]"));
    public static final Target PAIS_PEDIDO = Target.the("Espacio para pais en el pedido").located(By.xpath("//*/input[@id=\"country\"]"));
    public static final Target CIUDAD_PEDIDO = Target.the("Espacio para ciudad en el pedido").located(By.xpath("//*/input[@id=\"city\"]"));
    public static final Target TARJETA_CREDITO_PEDIDO = Target.the("Espacio para tarjeta de credito en el pedido").located(By.xpath("//*/input[@id=\"card\"]"));
    public static final Target MES_PEDIDO = Target.the("Espacio para mes en el pedido").located(By.xpath("//*/input[@id=\"month\"]"));
    public static final Target YEAR_PEDIDO = Target.the("Espacio para year en el pedido").located(By.xpath("//*/input[@id=\"year\"]"));
    public static final Target COMPRAR = Target.the("Seleccion Boton purchase").located(By.xpath("//*/button[contains(text(),'Purchase')]"));


}
```
### OrdenDePagoPage
Esta clase contiene los mapeos de la interfaz de la orden de pago generada
```java
public class OrdenDePagoPage {
    public static final Target NUMERO_TARJETA_ORDEN = Target.the("Numero de tarjeta de la orden de pago").located(By.xpath("//*/div[@class=\"sweet-alert  showSweetAlert visible\"]/p"));
    public static final Target NOMBRE_ORDEN = Target.the("Nombre de la orden de pago").located(By.xpath("//*/div[@class=\"sweet-alert  showSweetAlert visible\"]/p"));
}
```
## Models

### Data
Esta clase crea un objeto de tipo Data con seis variables de tipo String y los getter correspondientes a cada variable
```java
public class Data {
    private String name;
    private String cardNumber;
    private String country;
    private String city;
    private String month;
    private String year;


    public Data(String name, String cardNumber, String country, String city,
                String month, String year) {

        this.name = name;
        this.cardNumber = cardNumber;
        this.country = country;
        this.city = city;
        this.month = month;
        this.year = year;

    }


    public String getName() {
        return name;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }


}
```

## Utils
### informacionRequerida 
```java
Esta clase contiene variables independientes que serán utilizadas en la prueba

public class informacionRequerida {

      public static final String nombreUsuario = "martin121314";
      public static final String password ="12345678901234";
      public static final String nombreProducto = "Samsung galaxy s6";
    }
```

### Excepciones
Esta clase contiene la definición de dos excepciones OrdenNoCorresponde y ProductoNoCorresponde que indicarán cuando los datos en la orden de pago
y el producto en el carrito no corresponda.
La excepción OrdenNoCorresponde se presentará cuando los datos "name" y "cardNumber"de la orden de pago generada al comprar el producto, 
no sean los mismos que los ingresados en formulario del pedido.
La excepcion ProductoNoCorresponde se presentará cuando el nombre del producto que se añade al carrito es diferente al producto establecido

```java
public class Excepciones extends AssertionError{
   
    public static final String OrdenNoCorresponde = "Los datos del comprador no coinciden en la orden";

  
    public static final String ProductoNoCorresponde ="El producto en el carrito no corresponde al seleccionado";

    public Excepciones(String mensaje, Throwable causa){
        super(mensaje, causa);
    }
```
## Questions
### NombreProductoCarrito
Realiza la validación del nombre del producto que es agregado al carrito y en el método que sobreescribe retorna un String
```java
public class NombreProductoCarrito implements Question<String> {
    public static Question<String> value() {
        return new NombreProductoCarrito();

    }

    @Override
    public String answeredBy(Actor actor) {
        return NOMBRE_PRODUCTO.resolveFor(actor).getText();
    }

```
### DatosOrdenDePago
Realiza la validacion de los datos (name y cardNumber) en la orden de pago generada retornando en sus metodos un string
```java
public class DatosOrdenDePago {
    public static Question<String> nombreOrden() {
        return actor -> TextContent.of(NOMBRE_ORDEN).viewedBy(actor).asString().trim().substring(55, 61);

    }

    public static Question<String> numeroTarjeta() {
        return actor -> TextContent.of(NUMERO_TARJETA_ORDEN).viewedBy(actor).asString().trim().substring(39, 49);

    }

}

```
## Runners

### CompraExitosaRunner
Realiza la ejecución de los pasos en el compra_exitosa.feature y busca los metodos en el paquete StepDefinitions
```java
@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/resources/features/compra_exitosa.feature",
        glue = "com.demoblaze.automation.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "@EscenarioCorrecto")
public class CompraExitosaRunner {
}
```
## StepDefinitions

### CompraExitosaStepDefinition
Contiene todos los pasos de la ejecucion de Compra Exitosa, ademas de la definicion del actor y el rastreo del driver del navegador
```java
public class CompraExitosaStepDefinition {
    @Managed(driver = "chrome")
    private WebDriver hisBrowser;
    private Actor usuario = Actor.named("usuario");



    @Before
    public void setUp() {
        usuario.can(BrowseTheWeb.with(hisBrowser));
        usuario.wasAbleTo(Open.browserOn(new DemoBlazeHomePage()));
    }

    @Dado("^que el usuario esta logueado$")
    public void queElUsuarioEstaLogueado() {
        usuario.attemptsTo(IrHaciaLogin.deUsuario());
        usuario.attemptsTo(DiligenciarCredencialesUsuario.paraIngresarAPerfil());
        usuario.attemptsTo(IrAPerfilDeUsuario.Registrado());
    }

    @Cuando("^agrego producto al carro$")
    public void agregoProductoAlCarro()throws InterruptedException  {
        usuario.attemptsTo(SeleccionarProducto.Disponible());
        usuario.attemptsTo(AgregarAlCarrito.deLaTienda());
        usuario.attemptsTo(AceptarAlerta.deProductoAgregado(hisBrowser));
        usuario.attemptsTo(IrAlCarrito.DemoBlaze());
    }

    @Entonces("^valido el nombre del articulo$")
    public void validoElNombreDelArticulo() {

        usuario.should(seeThat("El nombre del producto del carrito es:", NombreProductoCarrito.value(), equalTo(informacionRequerida.nombreProducto)).orComplainWith(Excepciones.class, Excepciones.ProductoNoCorresponde));

    }

    @Entonces("^los datos de orden de compra seran \"([^\"]*)\" y \"([^\"]*)\"$")
    public void losDatosDeOrdenDeCompraSeranY(String nombreEnOrden, String tarjetaOrden, List<Data> dataList) {
        usuario.attemptsTo(RealizarPedido.deProductos());
        usuario.attemptsTo(DiligenciarDatosPedido.paraOrdenDePago(dataList.get(0)));
        usuario.attemptsTo(GenerarOrdenDePago.alComprarProducto());
        usuario.should(seeThat("El nombre en la orden de compra es", DatosOrdenDePago.nombreOrden(), equalTo(nombreEnOrden)).orComplainWith(Excepciones.class, Excepciones.OrdenNoCorresponde));
        usuario.should(seeThat("El numero de la tarjeta de compra es", DatosOrdenDePago.numeroTarjeta(), equalTo(tarjetaOrden)).orComplainWith(Excepciones.class, Excepciones.OrdenNoCorresponde));


    }


}

```
## Features

### compra_exitosa.feature
Contiene dos escenarios el primero indica la prueba correcta de una compra exitosa y el segundo muestra una prueba fallida.
```gherkin
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
  Esquema del escenario: Verificación fallida
    Dado que el usuario esta logueado
    Cuando agrego producto al carro
    Entonces valido el nombre del articulo
    Y los datos de orden de compra seran "<nombrePrueba>" y "<cardNumberPrueba>"
      | name   | cardNumber   | country   | city   | month   | year   |
      | <name> | <cardNumber> | <country> | <city> | <month> | <year> |
    Ejemplos:
      | name   | cardNumber | country  | city  | month | year | nombrePrueba | cardNumberPrueba |
      | Martin | 1357924680 | Colombia | Tunja | Feb   | 2025 | Alberto      | 0864297531       |


```
