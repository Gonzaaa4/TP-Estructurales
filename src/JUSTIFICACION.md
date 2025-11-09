# Trabajo Práctico: Patrones Estructurales

Este documento presenta la justificación para la elección de los patrones de diseño en cada uno de los escenarios propuestos.

---

## Escenario 1: Sistema de Ensamblaje de Computadoras

Para este escenario se identificaron dos problemas distintos que fueron resueltos con dos patrones que colaboran entre sí.

### Patrón 1: COMPOSITE

* **Problema:** El sistema debía manejar tanto componentes individuales (hojas, como `CPU` o `DiscoSSD`) como componentes "compuestos" (cajas, como `Gabinete` o `PlacaMadre`), el requisito clave es que el cliente (el carrito de compras) debe poder tratar a ambos de manera uniforme, especialmente para calcular el precio total.
* **Patrón Elegido:** **Composite** (Compuesto).
* **Justificación:** La intención del patrón Composite es "componer objetos en estructuras de árbol para representar jerarquías de parte-todo, permitiendo que los clientes traten a los objetos individuales y a las composiciones de objetos de manera uniforme".
    * Esta intención **coincide perfectamente** con el problema.
    * Se creó una interfaz `Componente` con el método `getPrecio()`.
    * Las clases "hoja" (`CPU`, `MemoriaRAM`, `DiscoSSD`) implementan `getPrecio()` devolviendo su costo simple.
    * Las clases "compuestas" (`Gabinete`, `PlacaMadre`) implementan `getPrecio()` devolviendo su propio precio base *más* la suma de los `getPrecio()` de todos sus hijos.
    * Gracias a esto, el cliente final solo necesita llamar a `getPrecio()` sobre el componente de más alto nivel (ej. `Gabinete`) y obtiene el precio total sin saber cuántos componentes simples o compuestos hay dentro.

### Patrón 2: DECORATOR

* **Problema:** Se requería añadir "extras" (Garantía Extendida, Servicio de Instalación) a *cualquier* componente, ya sea simple o compuesto, estos extras modifican el precio final (uno con un porcentaje, el otro con un costo fijo) y deben poder combinarse.
* **Patrón Elegido:** **Decorator** (Decorador).
* **Justificación:** La intención del patrón Decorator es "añadir responsabilidades adicionales a un objeto de forma dinámica y transparente sin afectar a otros objetos de la misma clase".
    * Se eligió Decorator porque la alternativa (usar herencia) habría sido inviable. Crear clases como `CPUConGarantia`, `CPUConInstalacion`, `GabineteConGarantiaYInstalacion`, etc., generaría una explosión de clases.
    * Al usar Decorator, creamos "envoltorios" (`ExtraDecorator`) que implementan la misma interfaz `Componente`.
    * Cada decorador concreto (`GarantiaExtendida`, `ServicioInstalacion`) envuelve a un `Componente` (que gracias al patrón Composite, ¡podría ser un `CPU` o un `Gabinete` entero!) y añade su propia lógica de costo, delegando el cálculo base al objeto que envuelve.
    * Esto nos permite "decorar" o "envolver" un componente con tantos extras como sea necesario, cumpliendo el requisito de combinación.

---

## Escenario 2: Módulo de Generación de Reportes

* **Problema:** La generación de un reporte fiscal requería que el cliente instanciara y coordinara múltiples clases de un subsistema complejo (`ConectorDB`, `LectorDeDatos`, `ServicioWebAFIP`, `ProcesadorDeImpuestos`, `RenderizadorPDF`) en un orden específico, esto genera un **alto acoplamiento** y una **interfaz de cliente complicada**.
* **Patrón Elegido:** **Facade** (Fachada).
* **Justificación:** La intención del patrón Facade es "proporcionar una interfaz unificada y simplificada a un conjunto de interfaces de un subsistema. Facade define una interfaz de más alto nivel que hace que el subsistema sea más fácil de usar".
    * Este patrón es la solución ideal, ya que ataca directamente el problema de la complejidad.
    * Se creó la clase `ReporteFiscalFacade`, que es la única con la que interactúa el cliente.
    * Esta fachada **encapsula y oculta** toda la complejidad de orquestar el subsistema. Internamente, el Facade instancia las 5 clases y ejecuta los 6 pasos en el orden correcto.
    * El cliente final pasa de necesitar 6 pasos y conocer 5 clases, a solo instanciar el Facade y llamar a un único método (ej: `facade.generarReporte(cuit)`). Esto reduce drásticamente el acoplamiento y simplifica el uso del módulo.

---

## Escenario 3: Integración de API de Logística

* **Problema:** Nuestro sistema de E-Commerce está diseñado para una interfaz interna (`IServicioEnvio`), necesitamos integrar una nueva librería de un proveedor (`ApiLogisticaVeloz`) que es funcionalmente útil, pero su interfaz es **totalmente incompatible** con la nuestra (diferentes nombres de métodos, diferentes tipos de datos como `String` vs `int`, y diferentes objetos requeridos), no podemos modificar el código de la librería externa.
* **Patrón Elegido:** **Adapter** (Adaptador).
* **Justificación:** La intención del patrón Adapter es "convertir la interfaz de una clase en otra interfaz que los clientes esperan. Adapter permite que clases con interfaces incompatibles colaboren".
    * La descripción del patrón es una descripción literal de nuestro problema.
    * Se creó una clase `LogisticaVelozAdapter` que cumple dos funciones:
        1.  **Implementa nuestra interfaz interna:** `IServicioEnvio`.
        2.  **Envuelve (contiene) una instancia de la clase externa:** `ApiLogisticaVeloz`.
    * Esta clase actúa como un "traductor" en tiempo de ejecución. Cuando el cliente llama al método `despacharPedido(String direccion, String cp, ...)` de nuestra interfaz, el Adapter recibe esa llamada, **traduce** los datos (`String cp` a `int cp`), crea el objeto `DatosEnvio` que la API externa requiere, y finalmente llama al método `apiVeloz.enviarPaquete(datos)`.
    * De esta forma, el Adapter permite que la nueva librería externa se "enchufe" a nuestro sistema existente sin que el cliente (el E-Commerce) tenga que modificarse o siquiera saber que `ApiLogisticaVeloz` existe.